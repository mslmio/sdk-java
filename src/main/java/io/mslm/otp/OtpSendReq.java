package io.mslm.otp;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class OtpSendReq {

    @SerializedName("phone")
    private String phone;
    @SerializedName("tmpl_sms")
    private String tmplSms;
    @SerializedName("token_len")
    private int tokenLen;
    @SerializedName("expire_seconds")
    private int expireSeconds;

    // Constructors
    public OtpSendReq() {
        // Default constructor
    }

    public OtpSendReq(String phone, String tmplSms, int tokenLen, int expireSeconds) {
        this.phone = phone;
        this.tmplSms = tmplSms;
        this.tokenLen = tokenLen;
        this.expireSeconds = expireSeconds;
    }

    // Getters and setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTmplSms() {
        return tmplSms;
    }

    public void setTmplSms(String tmplSms) {
        this.tmplSms = tmplSms;
    }

    public int getTokenLen() {
        return tokenLen;
    }

    public void setTokenLen(int tokenLen) {
        this.tokenLen = tokenLen;
    }

    public int getExpireSeconds() {
        return expireSeconds;
    }

    public void setExpireSeconds(int expireSeconds) {
        this.expireSeconds = expireSeconds;
    }
}