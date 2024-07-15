package com.sandeidevlab.Safaricom.Api.Consumption.Services;

import com.sandeidevlab.Safaricom.Api.Consumption.Interfaces.MpesaEndPoints;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.AutenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.KeyModel;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;

@Service
public class MpesaService implements MpesaEndPoints {
    private final Dotenv dotenv;
    private KeyModel keyModel = new KeyModel();

    @Autowired
    public MpesaService(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    @Override
    public AutenticationResponse authenticationRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url(dotenv.get("AUTH-URL"))
                .get()
                .addHeader("Authorization", "Basic " + dotenv.get("AUTH-HEADER"))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        String contentType = response.header("Content-Type");
        if (contentType == null || !contentType.contains("application/json")) {
            throw new IOException("Unexpected response content type: " + contentType);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = response.body().string();

        AutenticationResponse autenticationResponse = objectMapper.readValue(responseBody, AutenticationResponse.class);
        keyModel.setAccessToken(autenticationResponse.getAccessToken());
        keyModel.setTimeStamp(Instant.now().getEpochSecond() + Long.parseLong(autenticationResponse.getExpiresIn()));
        return autenticationResponse;
    }

    @Override
    public void saveKey(String key,int timestamp) {
        keyModel.setAccessToken(key);
        keyModel.setTimeStamp(timestamp);
    }

    @Override
    public Boolean isValid() {
        String accessToken = keyModel.getAccessToken();
        long currentTimeStamp = Instant.now().getEpochSecond();

        if (accessToken != null) {
            long tokenExpiryTime = keyModel.getTimeStamp();
            if (currentTimeStamp < tokenExpiryTime) {
                return true;
            } else {
                try {
                    authenticationRequest();
                    return true;
                } catch (IOException e) {
                    System.err.println("Failed to re-authenticate: " + e.getMessage());
                }
            }
        }
        return false;
    }

    @Override
    public String getKey() throws IOException {
        if (keyModel.getAccessToken()!=null){
            ///System.out.println("key not null"+keyModel.getAccessToken());
            if (isValid()){
                return keyModel.getAccessToken();
            }
            else {
                authenticationRequest();
                ///System.out.println(keyModel.getAccessToken());
            }
        }
        else{
            authenticationRequest();
            ///System.out.println("key null requested for one"+keyModel.getAccessToken());
        }
        return keyModel.getAccessToken();
    }
}
