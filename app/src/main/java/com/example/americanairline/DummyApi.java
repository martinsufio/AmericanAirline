package com.example.americanairline;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DummyApi {
    boolean sendRequest() throws IOException {
        // Create URL
        URL githubEndpoint = null;
        try {
            githubEndpoint = new URL("https://api.github.com/");
            HttpsURLConnection myConnection =
                    (HttpsURLConnection) githubEndpoint.openConnection();
            myConnection.getContent();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

// Create connection
        return true;
    }
}
