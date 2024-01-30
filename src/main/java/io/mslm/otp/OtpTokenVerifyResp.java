package io.mslm.otp;

@SuppressWarnings("unused")
public class OtpTokenVerifyResp {
    private long code;
    private String msg;

    public OtpTokenVerifyResp() {
        // Default constructor
    }

    public OtpTokenVerifyResp(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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