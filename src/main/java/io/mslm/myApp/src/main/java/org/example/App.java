package io.mslm.myApp.src.main.java.org.example;

import io.mslm.emailVerify.SingleVerifyReqOpts;
import io.mslm.emailVerify.SingleVerifyResp;
import io.mslm.lib.ReqOpts;
import io.mslm.mslm.Mslm;
import io.mslm.emailVerify.EmailVerify;
import okhttp3.OkHttpClient;


public class App
{
    public static void main( String[] args ) throws Exception {
        Mslm mslm = new Mslm("433c256a5443482c812fe4c7cfe69bdd");
        try {
            SingleVerifyReqOpts singleVerifyReqOpts = new SingleVerifyReqOpts.Builder()
                    .withReqOpts(new ReqOpts.Builder()
                            .withApiKey("your-api-key")
                            .withHttpClient(new OkHttpClient())
                            .withUserAgent("custom-user-agent")
                            .build())
                    .withDisableUrlEncode(true)
                    .build();

            SingleVerifyResp resp1 = mslm.emailVerify.singleVerify("asadmahd@gmail.com", singleVerifyReqOpts);
            System.out.println("Resp1: " + resp1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}
