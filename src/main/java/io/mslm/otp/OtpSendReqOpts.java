package io.mslm.otp;

import io.mslm.lib.ReqOpts;
import okhttp3.OkHttpClient;

import java.net.URI;

public class OtpSendReqOpts {
    public ReqOpts reqOpts;

    public OtpSendReqOpts() {
        //Default Constructor
        reqOpts = new ReqOpts();
    }

    public OtpSendReqOpts(OkHttpClient http, URI baseUrl, String userAgent, String apiKey) {
        reqOpts = new ReqOpts(http, baseUrl, userAgent, apiKey);
    }
}