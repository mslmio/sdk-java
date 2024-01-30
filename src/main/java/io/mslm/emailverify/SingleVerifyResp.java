package io.mslm.emailverify;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SingleVerifyResp {
    @SerializedName("email")
    private String email;

    @SerializedName("username")
    private String username;
    @SerializedName("domain")
    private String domain;

    @SerializedName("malformed")
    private boolean malformed;

    @SerializedName("suggestion")
    private String suggestion;

    @SerializedName("status")
    private String status;

    @SerializedName("has_mailbox")
    private boolean hasMailbox;

    @SerializedName("accept_all")
    private boolean acceptAll;

    @SerializedName("disposable")
    private boolean disposable;

    @SerializedName("free")
    private boolean free;

    @SerializedName("role")
    private boolean role;

    @SerializedName("mx")
    private List<SingleVerifyRespMx> mx;

    @Override
    public String toString() {
        return "SingleVerifyResp{" + "email='" + email + '\'' + ", username='" + username + '\'' + ", domain='" + domain + '\'' + ", malformed=" + malformed + ", suggestion='" + suggestion + '\'' + ", status='" + status + '\'' + ", hasMailbox=" + hasMailbox + ", acceptAll=" + acceptAll + ", disposable=" + disposable + ", free=" + free + ", role=" + role + ", mx=" + mx + '}';
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public boolean isMalformed() {
        return malformed;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public String getStatus() {
        return status;
    }

    public boolean hasMailbox() {
        return hasMailbox;
    }

    public boolean isAcceptAll() {
        return acceptAll;
    }

    public boolean isDisposable() {
        return disposable;
    }

    public boolean isFree() {
        return free;
    }

    public boolean isRole() {
        return role;
    }

    public List<SingleVerifyRespMx> getMx() {
        return mx;
    }
}