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

    public String getApiKey() {
        return apiKey;
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
        private ReqOpts opts;

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
