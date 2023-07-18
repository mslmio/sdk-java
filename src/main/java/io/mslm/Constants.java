package io.mslm;


import io.mslm.mslm.Mslm;
import okhttp3.OkHttpClient;

public class Constants {
    public static final Mslm defaultClient;

    static {
        try {
            defaultClient = new Mslm();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static final OkHttpClient defaultHttpClient = new OkHttpClient();
    public static final String defaultBaseUrl = "http://localhost:1786";
    public static final String defaultUserAgent  = "mslm/java/1.0.0";
    public static final String defaultApiKey     = "";
}
