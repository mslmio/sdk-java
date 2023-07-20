package io.mslm.myapp.src.main.java.org.example;

import io.mslm.emailverify.SingleVerifyResp;
import io.mslm.mslm.Mslm;

public class App
{
    public static void main( String[] args ) throws Exception {
        Mslm mslm = new Mslm("fcb13bc6-95ec-43cf-9374-388581682d40");
        try {
//            SingleVerifyReqOpts singleVerifyReqOpts = new SingleVerifyReqOpts.Builder()
//                    .withReqOpts(new ReqOpts.Builder()
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
