package lib;

import java.net.*;
import java.net.http.HttpClient;

public class Client {
    // HTTP client used for making requests.
    HttpClient Http;

    // Base URL for API requests.
    URL BaseUrl;

    // User-agent used when communicating with the API. 
    String UserAgent;

    // The API key used for authentication & authorization.
    String ApiKey;

    void SetHttpClient(HttpClient httpClient) {
        Http = httpClient;
    }

    void SetBaseUrl(String baseUrlStr) throws Exception{
        try {
            URL baseUrl = new URL(baseUrlStr);
            BaseUrl = baseUrl;
            return;
        } catch (MalformedURLException e) {
            throw e;
        }
    }

    void SetUserAgent(String userAgent) {
        UserAgent = userAgent;
    }

    void SetApiKey(String apiKey) {
        ApiKey = apiKey;
    }
}
