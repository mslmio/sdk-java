package src.main.java.lib;

import java.net.URL;
import java.net.http.HttpClient;

import javax.naming.Context;

public class Req {
    public class ReqOpts {
        // Override the configured HTTP client just for this request.
        HttpClient Http;

        // Override the configured base URL just for this request.
        URL BaseUrl;

        // Override the configured user-agent just for this request.
        String UserAgent;

        // Override the configured API key just for this request.
        String ApiKey;

        // Context to use for this request.
        //
        // Defaults to `context.Background()`.
        Context Context;
    }
}
