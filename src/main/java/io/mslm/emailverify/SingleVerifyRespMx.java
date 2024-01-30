package io.mslm.emailverify;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class SingleVerifyRespMx {
    @SerializedName("host")
    private String host;

    @SerializedName("pref")
    private int pref;

    public SingleVerifyRespMx(String s, int i) {
        host = s;
        pref = i;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        SingleVerifyRespMx that = (SingleVerifyRespMx) obj;
        return pref == that.pref && Objects.equals(host, that.host);
    }

    @Override
    public String toString() {
        return "SingleVerifyRespMx{" + "host='" + host + '\'' + ", pref=" + pref + '}';
    }

    public String getHost() {
        return host;
    }

    public int getPref() {
        return pref;
    }
}