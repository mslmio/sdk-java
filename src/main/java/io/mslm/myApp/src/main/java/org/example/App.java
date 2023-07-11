package io.mslm.myApp.src.main.java.org.example;

import io.mslm.emailVerify.SingleVerifyReqOpts;
import io.mslm.emailVerify.SingleVerifyResp;
import io.mslm.mslm.Mslm;

import java.util.concurrent.ExecutionException;

public class App
{
    public static void main( String[] args ) throws Exception {
        Mslm mslm = new Mslm("433c256a5443482c812fe4c7cfe69bdd");
        try {
            SingleVerifyResp resp = mslm.singleVerify("asadmahasg@gmail.com");
            System.out.println("Resp: " + resp);
        } catch (Exception e){
            System.out.println(e.getMessage());
        };
    }
}
