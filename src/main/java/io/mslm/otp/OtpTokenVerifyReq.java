package io.mslm.otp;

@SuppressWarnings("unused")
public class OtpTokenVerifyReq {
    private String phone;
    private String token;
    private Boolean consume;

    // Constructors
    public OtpTokenVerifyReq() {
        // Default constructor
    }

    public OtpTokenVerifyReq(String phone, String token, Boolean consume) {
        this.phone = phone;
        this.token = token;
        this.consume = consume;
    }

    // Getters and setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getConsume() {
        return consume;
    }

    public void setConsume(Boolean consume) {
        this.consume = consume;
    }
}