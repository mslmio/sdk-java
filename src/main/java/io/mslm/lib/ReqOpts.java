package io.mslm.lib;

import java.net.URI;
import java.net.http.HttpClient;

import javax.naming.Context;

public class ReqOpts {
     // Override the configured HTTP client just for this request.
     public HttpClient http;

     // Override the configured base URL just for this request.
     public URI baseUrl;

     // Override the configured user-agent just for this request.
     public String userAgent;

     // Override the configured API key just for this request.
     public String apiKey;

    // Context to use for this request.
    //
    // Defaults to `context.Background()`.
    public Context context;

    public ReqOpts() {}

    public ReqOpts(HttpClient http, URI baseUrl, String userAgent, String apiKey, Context context) {
        this.http = http;
        this.baseUrl = baseUrl;
        this.userAgent = userAgent;
        this.apiKey = apiKey;
        this.context = context;
    }

    public String getUserAgent() {return userAgent;}
}
