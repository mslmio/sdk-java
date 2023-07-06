package io.mslm.mslm;

import io.mslm.emailVerify.SingleVerifyReqOpts;

import java.io.IOException;
import java.net.http.HttpClient;

public class Client {
    private io.mslm.lib.Client c;
    private io.mslm.emailVerify.Client emailVerify;

    public Client() {
        this.c = new io.mslm.lib.Client();
        this.emailVerify = io.mslm.emailVerify.Client.initDefaults();
    }

    public static Client init(String apiKey) throws Exception {
        Client c = new Client();
        c.setEmailVerify(io.mslm.emailVerify.Client.init(apiKey));
        c.setHttpClient(HttpClient.newHttpClient());
        c.setBaseUrl("https://mslm.io");
        c.setUserAgent("mslm/go/1.0.0");
        c.setApiKey(apiKey);
        return c;
    }

    public static Client initDefaults() throws Exception {
        return init("");
    }

    public void setHttpClient(HttpClient httpClient) {
        c.setHttpClient(httpClient);
        emailVerify.setHttpClient(httpClient);
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        c.setBaseUrl(baseUrlStr);
        emailVerify.setBaseUrl(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        c.setUserAgent(userAgent);
        emailVerify.setUserAgent(userAgent);
    }

    public void setApiKey(String apiKey) {
        c.setApiKey(apiKey);
        emailVerify.setApiKey(apiKey);
    }

    public void setEmailVerify(io.mslm.emailVerify.Client emailVerify) {
        this.emailVerify = emailVerify;
    }

    public void singleVerify(String emailAddr, SingleVerifyReqOpts... opts) throws Exception {
        emailVerify.singleVerify(emailAddr, opts);
    }
}
