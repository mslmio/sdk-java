package io.mslm.lib;

import io.mslm.Constants;
import okhttp3.OkHttpClient;
import java.net.URI;

public class ReqOpts {
    String apiKey;
    OkHttpClient http;
    URI baseUrl;
    String userAgent;

    public ReqOpts() {
        this.http = Constants.defaultHttpClient;
        this.baseUrl = URI.create(Constants.defaultBaseUrl);
        this.userAgent = Constants.defaultUserAgent;
        this.apiKey = Constants.defaultApiKey;
    }

    public ReqOpts(OkHttpClient http, URI baseUrl, String userAgent, String apiKey) {
        this.http = http;
        this.baseUrl = baseUrl;
        this.userAgent = userAgent;
        this.apiKey = apiKey;
    }

    public String getApiKey(){return apiKey;}

    public OkHttpClient getHttpClient() {return http;}

    public URI getBaseUrl(){return baseUrl;}

    public String getUserAgent() {return userAgent;}
}
