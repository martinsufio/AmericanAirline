package com.example.americanairline;

import static org.junit.Assert.*;

import com.google.gson.Gson;
import com.mastercard.developer.oauth.OAuth;
import com.mastercard.developer.signers.HttpsUrlConnectionSigner;
import com.mastercard.developer.utils.AuthenticationUtils;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;

import javax.net.ssl.HttpsURLConnection;

public class DummyApiTest {

    @Test
    public void sendRequest() {

        try{
            // Create URL
            PrivateKey signingKey = AuthenticationUtils.loadSigningKey(
                    "C:\\Users\\ufiom\\AndroidStudioProjects\\AmericanAirline\\app\\src\\main\\java\\com\\example\\americanairline\\American_Airlines-sandbox.p12",
                    "keyalias",
                    "keystorepassword");
            String consumerKey = "4BGMDBUyd5xMNuhE84124ZzsgHTUmzz5Dj-qKNsQa8eb5e3b!cbde0baeacab43aaaf637327c044ee550000000000000000";

//            Charset charset = StandardCharsets.UTF_8;
//
//
            URL url = new URL("https://sandbox.api.mastercard.com/merchant-id/v2/merchant-ids?merchant_id=DOLIUMPTYLTDWELSHPOOLWA&type=ExactMatch");
//
//            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
//            con.setRequestMethod("GET");
//            con.setRequestProperty("Content-Type", "application/json; charset=" + charset.name());
//            HttpsUrlConnectionSigner signer = new HttpsUrlConnectionSigner(charset, consumerKey, signingKey);
//            signer.sign(con, "{}");
//
//            con.getResponseMessage();

            Charset charset = StandardCharsets.UTF_8;
            String payload = "{\"foo\":\"bar\"}";

            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json; charset=" + charset.name());

            HttpsUrlConnectionSigner signer = new HttpsUrlConnectionSigner(charset, consumerKey, signingKey);
            signer.sign(con, payload);


            String message = con.getResponseMessage();
            System.out.println(message);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line+"\n");
            }
            br.close();
            Responsepayload responsepayload = new Gson().fromJson(sb.toString(), Responsepayload.class);
            System.out.println(responsepayload.getMessage());
            System.out.printf(responsepayload.getReturnedMerchants().get(0).getAddress().getLine1());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}