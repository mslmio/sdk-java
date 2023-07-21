package io.mslm.lib;

import io.mslm.Constants;
import io.mslm.emailverify.SingleVerifyResp;
import okhttp3.*;

import com.google.gson.Gson;
import java.net.*;

import java.util.Iterator;
import java.util.Map;

public class Lib {
    String apiKey;
    OkHttpClient http;
    URI baseUrl;
    String userAgent;

    public Lib(){
        apiKey = "";
        http = new OkHttpClient();
        baseUrl = URI.create("https://mslm.io");
        userAgent = Constants.defaultUserAgent;
    }

    public Lib(String apiKey){
        this.apiKey = apiKey;
        http = new OkHttpClient();
        baseUrl = URI.create("https://mslm.io");
        userAgent = Constants.defaultUserAgent;
    }

    public void setHttpClient(OkHttpClient httpClient) {
        this.http = httpClient;}

    public void setBaseUrl(String baseUrlStr) throws Exception {
        this.baseUrl = new URI(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public URI prepareUrl(String urlPath, Map<String, String> qp, ReqOpts opt) throws Exception {
        URI tUrl = opt.baseUrl.resolve(urlPath);
        qp.put("apiKey", opt.apiKey);

        StringBuilder tUrlQuery = new StringBuilder();
        Iterator<Map.Entry<String, String>> iterator = qp.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            tUrlQuery.append(entry.getKey()).append("=").append(entry.getValue());

            // Check if there is another entry in the map
            if (iterator.hasNext()) {
                tUrlQuery.append("&");
            }
        }

        return new URI(
            tUrl.getScheme(),
            tUrl.getAuthority(),
            tUrl.getPath(),
            tUrlQuery.toString(),
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
