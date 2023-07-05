package io.mslm.email_verify;


import java.net.http.HttpClient;

public class Client {
    public static Client defaultClient;
    public static HttpClient defaultHttpClient = HttpClient.newHttpClient();
    public static String defaultBaseUrl = "https://mslm.io";
    public static String defaultUserAgent = "mslm/go/1.0.0";
    public static String defaultApiKey = "";

    private static io.mslm.lib.Client c;

    public Client(){}

    public static Client Init(String apiKey) throws Exception {
        Client c = new Client();
        Client.c = new io.mslm.lib.Client();
        setHttpClient(HttpClient.newBuilder().build());
        setBaseUrl(defaultBaseUrl);
        setUserAgent(defaultUserAgent);
        setApiKey(apiKey);
        return c;
    }

    public static Client initDefaults() throws Exception {
        return Init(defaultApiKey);
    }

    public static void setHttpClient(HttpClient httpClient) {
        c.setHttpClient(httpClient);
    }

    public static void setBaseUrl(String baseUrlStr) throws Exception {
        c.setBaseUrl(baseUrlStr);
    }

    public static void setUserAgent(String userAgent) {
        c.setUserAgent(userAgent);
    }

    public static void setApiKey(String apiKey) {
        c.setApiKey(apiKey);
    }
}
