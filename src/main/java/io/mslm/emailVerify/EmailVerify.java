package io.mslm.emailVerify;


import java.net.URI;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;


public class EmailVerify {
   io.mslm.lib.Client c;

    public EmailVerify(String s){this.c = new io.mslm.lib.Client();}

    public void setHttpClient(HttpClient httpClient) {
        c.setHttpClient(httpClient);
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        c.setBaseUrl(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        c.setUserAgent(userAgent);
    }

    public void setApiKey(String apiKey) {
        c.setApiKey(apiKey);
    }

    public static EmailVerify init(String apiKey) throws Exception {
        EmailVerify c = new EmailVerify(apiKey);
        c.c.setHttpClient(HttpClient.newHttpClient());
        c.c.setBaseUrl("https://mslm.io");
        c.c.setUserAgent("mslm/java/1.0.0");
        c.c.setApiKey(apiKey);
        return c;
    }

    public static EmailVerify initDefaults() throws Exception {
        return init("");
    }

    public SingleVerifyResp singleVerify(String emailAddr, SingleVerifyReqOpts... opts) throws Exception {
        System.out.println("Single Verify-1");
        SingleVerifyReqOpts opt = new SingleVerifyReqOpts();
        if (opts.length > 0) {
            opt = opts[opts.length-1];
        }
        System.out.println("ONE");
        System.out.printf("SET: ", opt.getReqOpts());

        opt.setReqOpts(c.prepareOpts(opt.getReqOpts()));
        opt.reqOpts = c.prepareOpts(opt.getReqOpts());
        System.out.printf("GET: ", opt.getReqOpts());
        Map<String, String> qp = new HashMap<String, String>();
        qp.put("email", emailAddr);
        URI tUrl = c.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
        SingleVerifyResp svResp = new SingleVerifyResp();
        c.reqAndResp("GET", tUrl, svResp, opt.getReqOpts());
        return svResp;
    }
}
