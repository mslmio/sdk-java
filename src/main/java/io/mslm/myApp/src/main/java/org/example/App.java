package io.mslm.myApp.src.main.java.org.example;

import io.mslm.emailVerify.SingleVerifyReqOpts;
import io.mslm.emailVerify.SingleVerifyResp;
import io.mslm.mslm.Mslm;
import io.mslm.emailVerify.EmailVerify;


public class App
{
    public static void main( String[] args ) throws Exception {
        Mslm mslm = new Mslm("433c256a5443482c812fe4c7cfe69bdd");
        EmailVerify emailVerify = new EmailVerify("asada");
        emailVerify.singleVerify("asad");
        try {
            SingleVerifyResp resp = mslm.emailVerify.singleVerify("asadmahasg@gmail.com");
            System.out.println("Resp: " + resp);

            SingleVerifyReqOpts opts = new SingleVerifyReqOpts.Builder()
                    .withDisableUrlEncode(true)
                    .build();

            SingleVerifyResp resp1 = mslm.emailVerify.singleVerify("asadmahd@gmail.com", opts);
            System.out.println("Resp1: " + resp1.isHasMailbox());
        } catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}
