package io.mslm.lib;


import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Client {
    // HTTP client used for making requests.
     public HttpClient http;

    // Base URL for API requests.
    public URI baseUrl;

    // User-agent used when communicating with the API. 
    public String userAgent;

    // The API key used for authentication & authorization.
    public String apiKey;

    public  Client(){}

    public Client(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.http = httpClient;
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        this.baseUrl = new URI(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {this.userAgent = userAgent;}

    public void setApiKey(String apiKey) {this.apiKey = apiKey;}

    public ReqOpts prepareOpts(ReqOpts opt) {
        System.out.println("prepareReqOpts");
        if (opt == null) {
            return new ReqOpts();
        }

        HttpClient httpC = this.http;
        if (opt.http != null) {
            httpC = opt.http;
        }

        System.out.println("BaseUrl");
        System.out.println(this.baseUrl.toString());
        URI baseUrl = this.baseUrl;
        System.out.println(this.baseUrl.toString());
        if (opt.baseUrl != null) {
            baseUrl = opt.baseUrl;
        }

        String userAgent = this.userAgent;
        if (opt.userAgent != null) {
            userAgent = opt.userAgent;
        }

        String apiKey = this.apiKey;
        if (opt.apiKey != null) {
            apiKey = opt.apiKey;
        }

        /*Context ctx = opt.context;
        if (opt.context == null) {
            ctx =
        }*/

        ReqOpts reqOpts = new ReqOpts(httpC, baseUrl, userAgent, apiKey, null);
        return  reqOpts;
    }

    public URI prepareUrl(String urlPath, Map<String, String> qp, ReqOpts opt) throws Exception {
        System.out.println("prepareUrl");
        URI tUrl = opt.baseUrl.resolve(urlPath);
        StringBuilder tUrlQuery = new StringBuilder();
        for (Map.Entry<String, String> entry : qp.entrySet()) {
            tUrlQuery.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        tUrlQuery.append("apikey=").append(opt.apiKey);
        String encodedQuery = tUrlQuery.toString();

        return new URI(tUrl.getScheme(), tUrl.getAuthority(), tUrl.getPath(), encodedQuery, tUrl.getFragment());
    }

    public HttpResponse<String> reqAndResp(String method, URI tUrl, Object respData, ReqOpts opt) throws IOException, InterruptedException {
        System.out.println("reqAndResp");
        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder(tUrl)
                .method(method, HttpRequest.BodyPublishers.noBody())
                .header("User-Agent", opt.getUserAgent());

        HttpRequest request = reqBuilder.build();
        HttpResponse<byte[]> response = opt.http.send(request, HttpResponse.BodyHandlers.ofByteArray());
        byte[] respBody = response.body();

//        ((HttpResponse) respData).setBody(respBody);
        //
        //
        // How to send data back to respData from respBody.
        return null;
    }
}
