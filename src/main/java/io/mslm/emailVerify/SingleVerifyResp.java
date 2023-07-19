package io.mslm.emailVerify;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SingleVerifyResp {
    @SerializedName("email")
    private String email;
    private String username;
    private String domain;
    private boolean malformed;
    private String suggestion;
    private String status;
    private boolean hasMailbox;
    private boolean acceptAll;
    private boolean disposable;
    private boolean free;
    private boolean role;
    private List<SingleVerifyRespMx> mx;

    @Override
    public String toString() {
        return "SingleVerifyResp{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", domain='" + domain + '\'' +
                ", malformed=" + malformed +
                ", suggestion='" + suggestion + '\'' +
                ", status='" + status + '\'' +
                ", hasMailbox=" + hasMailbox +
                ", acceptAll=" + acceptAll +
                ", disposable=" + disposable +
                ", free=" + free +
                ", role=" + role +
                ", mx=" + mx +
                '}';
    }

//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getDomain() {
//        return domain;
//    }
//
//    public void setDomain(String domain) {
//        this.domain = domain;
//    }
//
//    public boolean isMalformed() {
//        return malformed;
//    }
//
//    public void setMalformed(boolean malformed) {
//        this.malformed = malformed;
//    }
//
//    public String getSuggestion() {
//        return suggestion;
//    }
//
//    public void setSuggestion(String suggestion) {
//        this.suggestion = suggestion;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public boolean isHasMailbox() {
//        return hasMailbox;
//    }
//
//    public void setHasMailbox(boolean hasMailbox) {
//        this.hasMailbox = hasMailbox;
//    }
//
//    public boolean isAcceptAll() {
//        return acceptAll;
//    }
//
//    public void setAcceptAll(boolean acceptAll) {
//        this.acceptAll = acceptAll;
//    }
//
//    public boolean isDisposable() {
//        return disposable;
//    }
//
//    public void setDisposable(boolean disposable) {
//        this.disposable = disposable;
//    }
//
//    public boolean isFree() {
//        return free;
//    }
//
//    public void setFree(boolean free) {
//        this.free = free;
//    }
//
//    public boolean isRole() {
//        return role;
//    }
//
//    public void setRole(boolean role) {
//        this.role = role;
//    }
//
//    public List<SingleVerifyRespMx> getMx() {
//        return mx;
//    }
//
//    public void setMx(List<SingleVerifyRespMx> mx) {
//        this.mx = mx;
//    }
}
