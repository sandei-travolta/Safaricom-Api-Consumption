package com.sandeidevlab.Safaricom.Api.Consumption.Services;

import com.sandeidevlab.Safaricom.Api.Consumption.Interfaces.MpesaEndPoints;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.AutenticationResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class MpesaService implements MpesaEndPoints{
    @Override
    public AutenticationResponse authenticationRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .method("GET", null)
                .addHeader("Authorization", "Basic cFJZcjZ6anEwaThMMXp6d1FETUxwWkIzeVBDa2hNc2M6UmYyMkJmWm9nMHFRR2xWOQ==")
                .build();
        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        // Check if the response content type is JSON
        String contentType = response.header("Content-Type");
        if (contentType == null || !contentType.contains("application/json")) {
            throw new IOException("Unexpected response content type: " + contentType);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String responseBody = response.body().string();

        // Log the response before parsing (for debugging)
        System.out.println("Response Body:");
        System.out.println(responseBody);

        AutenticationResponse autenticationResponse = objectMapper.readValue(responseBody, AutenticationResponse.class);
        return autenticationResponse;
    }

    @Override
    public void validation() {

    }
}
