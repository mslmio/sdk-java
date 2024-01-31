package io.mslm.otp;

@SuppressWarnings("unused")
public class OtpSendResp {
    private long code;
    private String msg;

    // Constructors
    public OtpSendResp() {
        // Default constructor
    }

    public OtpSendResp(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    // Getters and setters
    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}