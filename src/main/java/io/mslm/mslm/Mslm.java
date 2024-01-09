package io.mslm.mslm;

import io.mslm.emailverify.EmailVerify;
import io.mslm.emailverify.SingleVerifyResp;
import io.mslm.lib.Lib;
import io.mslm.otp.*;
import okhttp3.OkHttpClient;

import java.util.Scanner;

public class Mslm {
    // Common lib class.
    public Lib lib;

    // The Email Verify API client.
    public EmailVerify emailVerify;

    public Otp otp;

    public Mslm() {
        emailVerify = new EmailVerify();
        otp = new Otp();
        lib = new Lib();
    }

    public Mslm(String apiKey) {
        emailVerify = new EmailVerify(apiKey);
        otp = new Otp(apiKey);
        lib = new Lib(apiKey);
    }

    public void setHttpClient(OkHttpClient httpClient) {
        lib.setHttpClient(httpClient);
        emailVerify.setHttpClient(httpClient);

        otp.setHttpClient(httpClient);
    }

    public void setBaseUrl(String baseUrlStr) throws Exception {
        lib.setBaseUrl(baseUrlStr);
        emailVerify.setBaseUrl(baseUrlStr);
        otp.setBaseUrl(baseUrlStr);
    }

    public void setUserAgent(String userAgent) {
        lib.setUserAgent(userAgent);
        emailVerify.setUserAgent(userAgent);
        otp.setUserAgent(userAgent);
    }

    public void setApiKey(String apiKey) {
        lib.setApiKey(apiKey);
        emailVerify.setApiKey(apiKey);
        otp.setApiKey(apiKey);
    }


    public static void main(String[] args) {
        Mslm mslm = new Mslm();
        mslm.testOtpSend();
        mslm.testOtpVerify();
    }

    private void testOtpSend() {
        Mslm mslm = new Mslm("");
        try {
            OtpSendResp response = mslm.otp.sendOtp("+923404448919", "Your OTP is", 6, 60);
            if (response.getCode() == 1000) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
                System.out.println(response.getMsg());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void testOtpVerify() {
        Mslm mslm = new Mslm("");
        try {
            String code = new Scanner(System.in).nextLine();
            OtpTokenVerifyResp response = mslm.otp.verify("+923404448919", code);
            if (response.getCode() == 1000) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
                System.out.println(response.getMsg());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void testEmailVerify() {
        Mslm mslm = new Mslm("YOUR_API_KEY");
        try {
            SingleVerifyResp response = mslm.emailVerify.singleVerify("user@example.com");
            System.out.println("Success Response: " + response.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            throw new RuntimeException(e);
        }
    }

    private void otpSendTest() {
        Otp otp = new Otp("Your_API_KEY");
        try {
            OtpSendResp response = otp.sendOtp("+123456789", "Your OTP is", 6, 60);
            if (response.getCode() == 1000) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
                System.out.println(response.getMsg());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void otpVerifyTest() {
        Otp otp = new Otp("Your_API_KEY");
        try {
            OtpTokenVerifyResp response = otp.verify("+123456789", "12345");
            if (response.getCode() == 1000) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
                System.out.println(response.getMsg());

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void emailVerifyTest() {
        EmailVerify emailVerify = new EmailVerify("YOUR_API_KEY");
        try {
            SingleVerifyResp response = emailVerify.singleVerify("user@example.com");
            System.out.println("Success Response: " + response.toString());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

            throw new RuntimeException(e);
        }


    }
}
