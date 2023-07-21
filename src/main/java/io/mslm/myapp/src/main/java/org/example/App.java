package io.mslm.myapp.src.main.java.org.example;

import io.mslm.Constants;
import io.mslm.emailverify.SingleVerifyResp;
import io.mslm.mslm.Mslm;

public class App
{
    public static void main( String[] args ) throws Exception {
        Mslm mslm = new Mslm();
        try {
//            SingleVerifyReqOpts singleVerifyReqOpts = new SingleVerifyReqOpts.Builder()
//                    .withReqlOpts(new ReqOpts.Builder()
//                            .withApiKey("your-api-key")
//                            .withHttpClient(new OkHttpClient())
//                            .withUserAgent("custom-user-agent")
//                            .build())
//                    .withDisableUrlEncode(true)
//                    .build();

            SingleVerifyResp resp1 = mslm.emailVerify.singleVerify("asadasghar39@gmail.com");
            System.out.println("Resp1: " + resp1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}
