package io.mslm.email_verify;


public class Client {
    public io.mslm.lib.Client c;

    public Client(){}

    public Client(String apiKey) {
        Client c = new Client();
        c.c = new io.mslm.lib.Client();

    }

}
