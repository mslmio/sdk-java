package io.mslm.mslm;

import io.mslm.Constants;
import io.mslm.emailVerify.EmailVerify;
import io.mslm.lib.Lib;
import okhttp3.OkHttpClient;

public class Mslm {
    public Lib lib;
    public EmailVerify emailVerify;

    public Mslm() {
        emailVerify = new EmailVerify(Constants.defaultApiKey);
    }

    public Mslm(String apiKey) {
        emailVerify = new EmailVerify(apiKey);
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
