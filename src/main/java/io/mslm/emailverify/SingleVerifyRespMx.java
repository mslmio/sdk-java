package io.mslm.emailverify;

import com.google.gson.annotations.SerializedName;

public class SingleVerifyRespMx {
    @SerializedName("host")
    private String host;
    @SerializedName("pref")
    private int pref;

    @Override
    public String toString() {
        return "SingleVerifyRespMx{" +
                "host='" + host + '\'' +
                ", pref=" + pref +
                '}';
    }

    public String getHost() {
        return host;
    }

    public int getPref() {
        return pref;
    }
}
