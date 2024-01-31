package io.mslm.mslm;

import io.mslm.emailverify.EmailVerify;
import io.mslm.lib.Lib;
import io.mslm.otp.Otp;
import okhttp3.OkHttpClient;

public class Mslm {
    // Common lib class.
    public Lib lib;

    // The Email Verify API client.
    public EmailVerify emailVerify;

    public Otp otp;

    public Mslm() {
        emailVerify = new EmailVerify();
        otp = new Otp();
        lib = new Lib();
    }

    public Mslm(String apiKey) {
        emailVerify = new EmailVerify(apiKey);
        otp = new Otp(apiKey);
        lib = new Lib(apiKey);
    }

    public void setHttpClient(OkHttpClient httpClient) {
        lib.setHttpClient(httpClient);
        emailVerify.setHttpClient(httpClient);
        otp.setHttpClient(httpClient);
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        lib.setBaseUrl(baseUrlStr);
        emailVerify.setBaseUrl(baseUrlStr);
        otp.setBaseUrl(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        lib.setUserAgent(userAgent);
        emailVerify.setUserAgent(userAgent);
        otp.setUserAgent(userAgent);
    }

    public void setApiKey(String apiKey) {
        lib.setApiKey(apiKey);
        emailVerify.setApiKey(apiKey);
        otp.setApiKey(apiKey);
    }
}