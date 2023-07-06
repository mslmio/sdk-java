package io.mslm.emailVerify;

import java.net.http.HttpClient;

public class Init {
    static {
        try {
            DefaultClient = initDefaults();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Client DefaultClient;

    public static Client initDefaults() throws Exception {
        return init("");
    }

    public static Client init(String apiKey) throws Exception {
        Client c = new Client("433c256a5443482c812fe4c7cfe69bdd");
        c.setHttpClient(HttpClient.newHttpClient());
        c.setBaseUrl("https://mslm.io");
        c.setUserAgent("mslm/go/1.0.0");
        c.setApiKey(apiKey);
        return c;
    }
}
