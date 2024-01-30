package io.mslm.otp;

import com.google.gson.Gson;
import io.mslm.lib.Lib;
import okhttp3.OkHttpClient;

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
        return lib.reqAndResp(METHOD_POST, tUrl, data.getBytes(StandardCharsets.UTF_8), opt.reqOpts, OtpSendResp.class);
    }

    public OtpSendResp sendOtp(String phone, String tmplSms, int tokenLen, int expireSeconds) throws Exception {
        OtpSendReq request = new OtpSendReq(phone, tmplSms, tokenLen, expireSeconds);
        OtpSendReqOpts opt = new OtpSendReqOpts();
        opt.reqOpts.setApiKey(lib.apiKey);
        return sendOtp(request, opt);
    }

    public OtpTokenVerifyResp verify(OtpTokenVerifyReq otpTokenVerifyReq, OtpTokenVerifyReqOpts... opts) throws Exception {
        // Prepare options.
        OtpTokenVerifyReqOpts opt = new OtpTokenVerifyReqOpts();
        if (opts.length > 0) {
            opt = opts[opts.length - 1];
            if (opt.reqOpts.getApiKey().isEmpty()) opt.reqOpts.setApiKey(lib.apiKey);
        }
        lib.prepareOpts(opt.reqOpts);
        // Prepare URL.
        Map<String, String> qp = new HashMap<>();
        URI tUrl;
        tUrl = lib.prepareUrl(VERIFY_URL_PATH, qp, opt.reqOpts);
        String data;
        data = new Gson().toJson(otpTokenVerifyReq);
        OtpTokenVerifyResp otpTokenVerifyResp = new OtpTokenVerifyResp();
        return lib.reqAndResp(METHOD_POST, tUrl, data.getBytes(), opt.reqOpts, OtpTokenVerifyResp.class);
    }

    public OtpTokenVerifyResp verify(String phone, String token) throws Exception {
        return verify(phone, token, true);
    }

    public OtpTokenVerifyResp verify(String phone, String token, Boolean consume) throws Exception {
        OtpTokenVerifyReq request = new OtpTokenVerifyReq(phone, token, consume);
        OtpTokenVerifyReqOpts opt = new OtpTokenVerifyReqOpts();
        opt.reqOpts.setApiKey(lib.apiKey);
        return verify(request, opt);
    }
}