package io.mslm.otp;

import io.mslm.lib.Lib;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class Otp {

    final String SEND_URL_PATH = "/api/otp/v1/send";
    final String VERIFY_URL_PATH = "/api/otp/v1/token_verify";
    final String METHOD_POST = "POST";
    private final Lib lib;

    public Otp() {
        this.lib = new Lib();
    }

    public Otp(String apiKey) {
        this.lib = new Lib();
        lib.apiKey = apiKey;
    }

    public void setHttpClient(OkHttpClient httpClient) {
        lib.http = httpClient;
    }

    public void setBaseUrl(String baseUrl) throws Exception {
        lib.setBaseUrl(baseUrl);
    }

    public void setUserAgent(String userAgent) {
        lib.userAgent = userAgent;
    }

    public void setApiKey(String apiKey) {
        lib.apiKey = apiKey;
    }


    public OtpSendResp sendOtp(OtpSendReq otpSendReq, OtpSendReqOpts... opts) throws Exception {
        // Prepare options.
        OtpSendReqOpts opt = new OtpSendReqOpts();
        if (opts.length > 0) {
            opt = opts[opts.length - 1];
        }
        opt.reqOpts = lib.prepareOpts(opt.reqOpts);
        // Prepare URL.
        Map<String, String> qp = new HashMap<>();
        URI tUrl;
        tUrl = lib.prepareUrl(SEND_URL_PATH, qp, opt.reqOpts);
        String data;
        data = new Gson().toJson(otpSendReq);
        OtpSendResp otpSendResp = new OtpSendResp();
        lib.reqAndResp(METHOD_POST, tUrl, data.getBytes(StandardCharsets.UTF_8), opt.reqOpts);
        return otpSendResp;
    }


    public OtpTokenVerifyResp verify(OtpTokenVerifyReq otpTokenVerifyReq, OtpTokenVerifyReqOpts... opts) throws Exception {
        // Prepare options.
        OtpTokenVerifyReqOpts opt = new OtpTokenVerifyReqOpts();
        if (opts.length > 0) {
            opt = opts[opts.length - 1];
        }
        lib.prepareOpts(opt.reqOpts);
        // Prepare URL.
        Map<String, String> qp = new HashMap<>();
        URI tUrl;
        tUrl = lib.prepareUrl(VERIFY_URL_PATH, qp, opt.reqOpts);
        String data;
        data = new Gson().toJson(otpTokenVerifyReq);
        OtpTokenVerifyResp otpTokenVerifyResp = new OtpTokenVerifyResp();
        lib.reqAndResp(METHOD_POST, tUrl, data.getBytes(), opt.reqOpts);
        return otpTokenVerifyResp;
    }


}

