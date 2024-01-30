package io.mslm.lib;

import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.URI;
import java.util.Map;

public class Lib {
    public String apiKey;
    public OkHttpClient http;
    public URI baseUrl;
    public String userAgent;
    public static final Gson gson = new Gson();

    public Lib() {
        apiKey = "";
        http = new OkHttpClient();
        baseUrl = URI.create("https://mslm.io");
        userAgent = getUserAgent("mslm");
    }

    public Lib(String apiKey) {
        this.apiKey = apiKey;
        http = new OkHttpClient();
        baseUrl = URI.create("https://mslm.io");
        userAgent = getUserAgent("mslm");
    }

    public void setHttpClient(OkHttpClient httpClient) {
        this.http = httpClient;
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        this.baseUrl = new URI(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public static String getUserAgent(String pkg) {
        return pkg + "/java/1.0.0";
    }

    public ReqOpts prepareOpts(ReqOpts opt) {
        if (opt == null) {
            return new ReqOpts();
        }

        // Prepare HTTP client
        OkHttpClient httpC = http;
        if (opt.getHttpClient() != null) {
            httpC = opt.getHttpClient();
        }

        // Prepare base URL
        URI baseUrl = this.baseUrl;
        if (opt.getBaseUrl() != null) {
            baseUrl = opt.getBaseUrl();
        }

        // Prepare user-agent
        String userAgent = this.userAgent;
        if (opt.getUserAgent() != null) {
            userAgent = opt.getUserAgent();
        }

        // Prepare API key
        String apiKey = this.apiKey;
        if (opt.getApiKey() != null) {
            apiKey = opt.getApiKey();
        }

        return new ReqOpts(httpC, baseUrl, userAgent, apiKey);
    }

    public URI prepareUrl(String urlPath, Map<String, String> qp, ReqOpts opt) throws Exception {
        // Put the API key to the query params map.
        qp.put("apikey", opt.apiKey);

        // Parse URL using http URL builder.
        URI tUrl = opt.baseUrl.resolve(urlPath);
        HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder().scheme("https").host(tUrl.getHost()).addPathSegment(urlPath);

        // Add query params to the URL.
        for (Map.Entry<String, String> entry : qp.entrySet()) {
            httpUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl httpUrl = httpUrlBuilder.build();

        return new URI(tUrl.getScheme(), tUrl.getAuthority(), tUrl.getPath(), httpUrl.query(), tUrl.getFragment());
    }

    public <T> T reqAndResp(URI tUrl, ReqOpts opt, Class<T> responseType) throws IOException {
        Request request = buildRequest(null, tUrl, null, opt);
        return executeRequest(request, responseType);
    }

    public <T> T reqAndResp(String method, URI tUrl, byte[] data, ReqOpts opt, Class<T> responseType) throws IOException {
        Request request = buildRequest(method, tUrl, data, opt);
        return executeRequest(request, responseType);
    }

    private Request buildRequest(@Nullable String method, URI tUrl, @Nullable byte[] data, ReqOpts opt) {
        Request.Builder builder = new Request.Builder().header("User-Agent", opt.getUserAgent()).url(tUrl.toString());
        if (method != null && data != null) builder.method(method, RequestBody.create(data));
        return builder.build();
    }

    private <T> T executeRequest(Request request, Class<T> responseType) throws IOException {
        try (Response response = http.newCall(request).execute()) {
            assert response.body() != null;
            return gson.fromJson(response.body().string(), responseType);
        }
    }
}