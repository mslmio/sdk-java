package io.mslm.emailverify;

import io.mslm.Constants;
import io.mslm.lib.Lib;
import io.mslm.lib.ReqOpts;
import okhttp3.OkHttpClient;

import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class EmailVerify {
    // Common lib class.
    Lib lib;

    public EmailVerify() {
        lib = new Lib(Constants.defaultApiKey);
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
        // Set request options to default in case not provider with the req.
        SingleVerifyReqOpts opt = new SingleVerifyReqOpts
                .Builder()
                .withReqOpts(new ReqOpts.Builder().build())
                .build();

        System.out.println("Email: "+ email);
        Map<String, String> qp = new HashMap<String, String>();
        qp.put("email", email);

        // Get data.
        URI tUrl = lib.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
        return lib.reqAndResp(tUrl, opt.getReqOpts());
   }

   public SingleVerifyResp singleVerify(String email, SingleVerifyReqOpts opts) throws Exception {
       SingleVerifyReqOpts opt = new SingleVerifyReqOpts
               .Builder()
               .withReqOpts(new ReqOpts.Builder().build())
               .build();
       if (opts != null) {
           opt = opts;
       }

       // Prepare URL.
       if (opt.getDisableUrlEncode() != null && !opt.getDisableUrlEncode()) {
           email = URLEncoder.encode(email, "UTF-8");
       }
       System.out.println("Email: "+ email);
       Map<String, String> qp = new HashMap<String, String>();
       qp.put("email", email);

       // Get data.
       URI tUrl = lib.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
       return lib.reqAndResp(tUrl, opt.getReqOpts());
   }
}
