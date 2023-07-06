package io.mslm.emailVerify;


import java.net.URI;
import java.net.http.HttpClient;
import java.util.HashMap;
import java.util.Map;


public class Client {
   io.mslm.lib.Client c;

    public Client(String s){this.c = new io.mslm.lib.Client();}

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

    public static Client init(String apiKey) {
        Client c = new Client("433c256a5443482c812fe4c7cfe69bdd");
        c.c.setHttpClient(HttpClient.newHttpClient());
        c.c.setUserAgent("mslm/go/1.0.0");
        c.c.setApiKey(apiKey);
        return c;
    }

    public static Client initDefaults() {
        return init("");
    }

    public SingleVerifyResp singleVerify(String emailAddr, SingleVerifyReqOpts... opts) throws Exception {
        SingleVerifyReqOpts opt = opts.length > 0 ? opts[opts.length - 1] : new SingleVerifyReqOpts();
        opt.setReqOpts(c.prepareReqOpts(opt.getReqOpts()));
        Map<String, String> qp = new HashMap<String, String>();
        qp.put("email", emailAddr);
        URI tUrl = c.prepareUrl("/api/sv/v1", qp, opt.getReqOpts());
        SingleVerifyResp svResp = new SingleVerifyResp();
        c.reqAndResp("GET", tUrl, svResp, opt.getReqOpts());
        return svResp;
    }
}
