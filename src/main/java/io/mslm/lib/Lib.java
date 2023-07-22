package io.mslm.lib;

import io.mslm.emailverify.SingleVerifyResp;
import okhttp3.*;

import com.google.gson.Gson;
import java.net.*;

import java.util.Map;

public class Lib {
    public String apiKey;
    public OkHttpClient http;
    public URI baseUrl;
    public String userAgent;
    public static final Gson gson = new Gson();

    public Lib(){
        apiKey = "";
        http = new OkHttpClient();
        baseUrl = URI.create("https://mslm.io");
        userAgent = getUserAgent("mslm");
    }

    public Lib(String apiKey){
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

    public URI prepareUrl(String urlPath, Map<String, String> qp, ReqOpts opt) throws Exception {
        // Put the API key to the query params map.
        qp.put("apikey", opt.apiKey);

        // Parse URL using http URL builder.
        URI tUrl = opt.baseUrl.resolve(urlPath);
        HttpUrl.Builder httpUrlBuilder = new HttpUrl.Builder()
                .scheme("https")
                .host(tUrl.getHost())
                .addPathSegment(urlPath);

        // Add query params to the URL.
        for (Map.Entry<String, String> entry : qp.entrySet()) {
            httpUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
        }
        HttpUrl httpUrl = httpUrlBuilder.build();

        return new URI(
            tUrl.getScheme(),
            tUrl.getAuthority(),
            tUrl.getPath(),
            httpUrl.toString(),
            tUrl.getFragment()
        );
    }

    public SingleVerifyResp reqAndResp(
            URI tUrl,
            ReqOpts opt
    ) throws Exception {
        Request request = new Request.Builder()
                .header("User-Agent", opt.getUserAgent())
                .url(tUrl.toURL())
                .build();

        // Request and read resp body.
        Response response = http.newCall(request).execute();
        ResponseBody responseBody = response.body();
        assert responseBody != null;
        String jsonData = responseBody.string();

        // Parse JSON string data to object.
        return gson.fromJson(jsonData, SingleVerifyResp.class);
    }
}
