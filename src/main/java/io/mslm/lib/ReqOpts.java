package io.mslm.lib;

import okhttp3.OkHttpClient;

import java.net.URI;

public class ReqOpts {
    String apiKey;
    OkHttpClient http;
    URI baseUrl;
    String userAgent;

    public ReqOpts getReqOpts() {
        return this;
    }

    public ReqOpts() {
        this.http = new OkHttpClient();
        this.baseUrl = URI.create("https://mslm.io");
        this.userAgent = Lib.getUserAgent("mslm");
        this.apiKey = null;
    }

    public ReqOpts(OkHttpClient http, URI baseUrl, String userAgent, String apiKey) {
        this.http = http;
        this.baseUrl = baseUrl;
        this.userAgent = userAgent;
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public OkHttpClient getHttpClient() {
        return http;
    }

    public URI getBaseUrl() {
        return baseUrl;
    }

    public String getUserAgent() {
        return userAgent;
    }

    // Builder class for ReqOpts
    public static class Builder {
        private final ReqOpts opts;

        public Builder() {
            opts = new ReqOpts();
        }

        public Builder withApiKey(String apiKey) {
            opts.apiKey = apiKey;
            return this;
        }

        public Builder withHttpClient(OkHttpClient http) {
            opts.http = http;
            return this;
        }

        public Builder withBaseUrl(URI baseUrl) {
            opts.baseUrl = baseUrl;
            return this;
        }

        public Builder withUserAgent(String userAgent) {
            opts.userAgent = userAgent;
            return this;
        }

        public ReqOpts build() {
            return opts;
        }
    }
}