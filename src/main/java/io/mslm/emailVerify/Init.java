package io.mslm.emailVerify;

import java.net.http.HttpClient;

public class Init {
    static {
        try {
            defaultEmailVerify = initDefaults();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static EmailVerify defaultEmailVerify;

    public static EmailVerify initDefaults() throws Exception {
        return init("");
    }

    public static EmailVerify init(String apiKey) throws Exception {
        EmailVerify c = new EmailVerify("433c256a5443482c812fe4c7cfe69bdd");
        c.setHttpClient(HttpClient.newHttpClient());
        c.setBaseUrl("https://mslm.io");
        c.setUserAgent("mslm/go/1.0.0");
        c.setApiKey(apiKey);
        return c;
    }
}
