package io.mslm.emailVerify;


import io.mslm.Constants;
import io.mslm.lib.Lib;
import io.mslm.lib.ReqOpts;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class EmailVerify {
   Lib lib;

   public EmailVerify() {
       lib = new Lib(Constants.defaultApiKey);
   }

   public EmailVerify(String apiKey) {
       lib = new Lib(apiKey);
   }

   public void setHttpClient(OkHttpClient httpClient) {lib.setHttpClient(httpClient);}

   public void setBaseUrl(String baseUrlStr) throws Exception {lib.setBaseUrl(baseUrlStr);}

   public void setUserAgent(String userAgent) {lib.setUserAgent(userAgent);}

   public void setApiKey(String apiKey) {lib.setApiKey(apiKey);}

   public SingleVerifyResp singleVerify(String emailAddr) throws Exception {
       SingleVerifyReqOpts opt = new SingleVerifyReqOpts.Builder().build();
       opt.setReqOpts(lib.prepareOpts(opt.getReqOpts()));

       Map<String, String> qp = new HashMap<String, String>();
       qp.put("email", emailAddr);

       URI tUrl = lib.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
       SingleVerifyResp svResp = lib.reqAndResp("GET", tUrl, opt.getReqOpts());
       return svResp;
   }

   public SingleVerifyResp singleVerify(String emailAddr, SingleVerifyReqOpts opts) throws Exception {
       SingleVerifyReqOpts opt = new SingleVerifyReqOpts.Builder().build(); // Default options
       if (opts != null) {
           opt = opts;
       }
       opt.setReqOpts(lib.prepareOpts(opt.getReqOpts()));

       if (opt.getDisableUrlEncode() != null && !opt.getDisableUrlEncode()) {
           emailAddr = URLEncoder.encode(emailAddr, "UTF-8");
       }

        Map<String, String> qp = new HashMap<String, String>();
        qp.put("email", emailAddr);

        URI tUrl = lib.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
        SingleVerifyResp svResp = lib.reqAndResp("GET", tUrl, opt.getReqOpts());
        return svResp;
   }

}
