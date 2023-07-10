package io.mslm.mslm;

import io.mslm.emailVerify.EmailVerify;
import io.mslm.emailVerify.SingleVerifyReqOpts;

import java.net.http.HttpClient;

public class Mslm {
    public io.mslm.lib.Client c;
    public EmailVerify emailVerify;

    public Mslm() {
        this.c = new io.mslm.lib.Client();
        this.emailVerify = EmailVerify.initDefaults();
    }

    public Mslm(String apiKey) throws Exception {
        Mslm c = new Mslm();
        c.setEmailVerify(EmailVerify.init(apiKey));
        c.setHttpClient(HttpClient.newHttpClient());
        c.setBaseUrl("https://mslm.io");
        c.setUserAgent("mslm/java/1.0.0");
        c.setApiKey(apiKey);
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

    public void setEmailVerify(EmailVerify emailVerify) {
        this.emailVerify = emailVerify;
    }

    public void singleVerify(String emailAddr, SingleVerifyReqOpts... opts) throws Exception {
        System.out.println("Hiii..");
        emailVerify.singleVerify(emailAddr, opts);
    }
}
