package io.mslm.mslm;

import io.mslm.Constants;
import io.mslm.emailverify.EmailVerify;
import io.mslm.lib.Lib;
import okhttp3.OkHttpClient;

public class Mslm {
    // Common lib class.
    public Lib lib;

    // The Email Verify API client.
    public EmailVerify emailVerify;

    public Mslm() {
        emailVerify = new EmailVerify("");
        lib = new Lib("");
    }

    public Mslm(String apiKey) {
        emailVerify = new EmailVerify(apiKey);
        lib = new Lib(apiKey);
    }

    public void setHttpClient(OkHttpClient httpClient) {
        lib.setHttpClient(httpClient);
        emailVerify.setHttpClient(httpClient);
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        lib.setBaseUrl(baseUrlStr);
        emailVerify.setBaseUrl(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        lib.setUserAgent(userAgent);
        emailVerify.setUserAgent(userAgent);
    }

    public void setApiKey(String apiKey) {
        lib.setApiKey(apiKey);
        emailVerify.setApiKey(apiKey);
    }
}
