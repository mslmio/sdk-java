package io.mslm.lib;

import io.mslm.Constants;
import io.mslm.emailVerify.SingleVerifyResp;
import okhttp3.*;

import com.google.gson.Gson;
import java.net.*;

import java.util.Map;

public class Lib {
    String apiKey;
    OkHttpClient http;
    URI baseUrl;
    String userAgent;

    public Lib(){
        apiKey = Constants.defaultApiKey;
        http = new OkHttpClient();
        baseUrl = URI.create(Constants.defaultBaseUrl);
        userAgent = Constants.defaultUserAgent;
    }

    public Lib(String apiKey){
        this.apiKey = apiKey;
        http = new OkHttpClient();
        baseUrl = URI.create(Constants.defaultBaseUrl);
        userAgent = Constants.defaultUserAgent;
    }

    public void setHttpClient(OkHttpClient httpClient) {this.http = httpClient;}

    public void setBaseUrl(String baseUrlStr) throws Exception {this.baseUrl = new URI(baseUrlStr);}

    public void setUserAgent(String userAgent) {this.userAgent = userAgent;}

    public void setApiKey(String apiKey) {this.apiKey = apiKey;}

    public URI prepareUrl(String urlPath, Map<String, String> qp, ReqOpts opt) throws Exception {
        URI tUrl = opt.baseUrl.resolve(urlPath);
        StringBuilder tUrlQuery = new StringBuilder();
        for (Map.Entry<String, String> entry : qp.entrySet()) {
            tUrlQuery.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        String encodedQuery = tUrlQuery.append("apikey=").append(opt.apiKey).toString();

        return new URI(
            tUrl.getScheme(),
            tUrl.getAuthority(),
            tUrl.getPath(),
            encodedQuery,
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

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();
        assert responseBody != null;
        String jsonData = responseBody.string();

        Gson gson = new Gson();
        SingleVerifyResp singleVerifyResp = gson.fromJson(jsonData, SingleVerifyResp.class);
        return  singleVerifyResp;
    }
}
