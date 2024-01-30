package io.mslm.emailverify;

import io.mslm.lib.Lib;
import io.mslm.lib.ReqOpts;
import okhttp3.OkHttpClient;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class EmailVerify {
    // Common lib class.
    Lib lib;

    public EmailVerify() {
        lib = new Lib();
    }

    public EmailVerify(String apiKey) {
        lib = new Lib(apiKey);
    }

    public void setHttpClient(OkHttpClient httpClient) {
        lib.setHttpClient(httpClient);
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        lib.setBaseUrl(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        lib.setUserAgent(userAgent);
    }

    public void setApiKey(String apiKey) {
        lib.setApiKey(apiKey);
    }

    public SingleVerifyResp singleVerify(String email) throws Exception {
        // Initialize req options if not provided.
        SingleVerifyReqOpts opt = new SingleVerifyReqOpts.Builder()
                .withReqOpts(new ReqOpts.Builder()
                        .withApiKey(lib.apiKey)
                        .withBaseUrl(lib.baseUrl)
                        .withHttpClient(lib.http)
                        .withUserAgent(lib.userAgent)
                        .build())
                .build();
        return singleVerify(email, opt);
    }

    public SingleVerifyResp singleVerify(String email, SingleVerifyReqOpts opts) throws Exception {
        SingleVerifyReqOpts opt = new SingleVerifyReqOpts.Builder().withReqOpts(new ReqOpts.Builder().build()).build();
        if (opts != null) {
            opt = opts;
        }

        Map<String, String> qp = new HashMap<String, String>();
        qp.put("email", email);

        // Get data.
        URI tUrl = lib.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
        return lib.reqAndResp(tUrl, opt.getReqOpts(), SingleVerifyResp.class);
    }
}