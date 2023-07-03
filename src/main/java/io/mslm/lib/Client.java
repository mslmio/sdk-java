package io.mslm.lib;


import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Client {
    // HTTP client used for making requests.
     public HttpClient http;

    // Base URL for API requests.
    public URL baseUrl;

    // User-agent used when communicating with the API. 
    public String userAgent;

    // The API key used for authentication & authorization.
    public String apiKey;

    public Client(String apiKey)
    {
        this.apiKey = apiKey;
    }

    void SetHttpClient(HttpClient httpClient) {
        this.http = httpClient;
    }

    void SetBaseUrl(String baseUrlStr) throws Exception
    {
        try {
            URL baseUrl = new URL(baseUrlStr);
            this.baseUrl = baseUrl;
            return;
        } catch (Exception e) {
            throw e;
        }
    }

    void SetUserAgent(String userAgent) {this.userAgent = userAgent;}

    void SetApiKey(String apiKey) {this.apiKey = apiKey;}

    URI PrepareUrl(String urlPath, Map<String, String> qp, ReqOpts opt) throws Exception {
        StringBuilder queryString = new StringBuilder();
        for (Map.Entry<String, String> entry : qp.entrySet())
        {
            String encodedVal = URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8.toString());
            queryString.append(entry.getKey()).append("=").append(encodedVal).append("&");
        }

        // Remove the trailing "&" if any.
        if (queryString.length() > 0)
        {
            queryString.setLength(queryString.length()-1);
        }

        URI uri = new URI(urlPath+"?"+queryString.toString());

        return  uri;
    }

    void ReqAndResp(String method, URI tUrl, ReqOpts opt) throws IOException, InterruptedException {
        HttpRequest.Builder reqBuilder = HttpRequest.newBuilder(tUrl)
                .method(method, HttpRequest.BodyPublishers.noBody())
                .header("User-Agent", opt.getUserAgent());

//        if (opt.getContext() != null)
//        {
//            reqBuilder.timeout(opt.getContext());
//        }

        HttpRequest request = reqBuilder.build();
        HttpResponse<InputStream> response = http.send(request, HttpResponse.BodyHandlers.ofInputStream());

        // Read body.
        InputStream respBody = response.body();
        byte[] bodyBytes = respBody.readAllBytes();

        // Need a library to convert this or to decode this
//        jsonDecode(bodyBytes, respData);
    }
}
