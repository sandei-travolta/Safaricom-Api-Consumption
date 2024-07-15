package com.sandeidevlab.Safaricom.Api.Consumption.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sandeidevlab.Safaricom.Api.Consumption.Helpers.MpesaUtils;
import com.sandeidevlab.Safaricom.Api.Consumption.Interfaces.PaymentInterfaces;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.MpesaCheckoutRequest;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.MpesaCheckoutResponse;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.MpesaPaymentModel;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.MpesaResponse;
import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
public class InsatiatePaymentService implements PaymentInterfaces {
    @Autowired
    private final Dotenv dotenv;
    @Autowired
    private final MpesaUtils mpesaUtils=new MpesaUtils();

    public InsatiatePaymentService(Dotenv dotenv) {
        this.dotenv = dotenv;
    }

    @Override
    public MpesaResponse iniatePayment(int amount, String mobileNo)throws IOException {
        ///Get auth-token and use it as bearer token
        String authKey = new MpesaService(dotenv).getKey();
        String shortCode = dotenv.get("SHORT-CODE");
        long formattedNo = Long.parseLong(mobileNo);
        ////System.out.println("Auth Key: " + authKey);

        // Create payment model
        MpesaPaymentModel paymentModel = new MpesaPaymentModel(
                dotenv.get("SHORT-CODE"),
                mpesaUtils.encodeBase64(dotenv.get("SHORT-CODE"),dotenv.get("PASS-KEY")),
                mpesaUtils.getFormattedTimestamp(),
                "CustomerPayBillOnline",
                amount,
                254792406400L,
                shortCode,
                formattedNo,
                dotenv.get("CALLBACK-URL"),
                "PLANET SAVER",
                "Payment of x"
        );
        System.out.println(paymentModel.getBusinessShortCode());
        String jsonBody = paymentModel.toJson();
        System.out.println("Request JSON: " + jsonBody);

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonBody);
        Request request = new Request.Builder()
                .url(dotenv.get("PAYMENT-URL"))
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + authKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                System.out.println("HTTP error code: " + response.code());
                System.out.println("HTTP error code: " + response.body().string());
                return null;
            }

            String responseBody = response.body().string();
            System.out.println("Response JSON: " + responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            MpesaResponse mpesaResponse = objectMapper.readValue(responseBody, MpesaResponse.class);
            System.out.println(mpesaResponse.getCustomerMessage());
            return mpesaResponse;
            // Assuming paymentStatus is a method that checks the status based on mpesaResponse
            /*boolean isSuccessful = paymentStatus(mpesaResponse.getCheckoutRequestID());
            if (isSuccessful) {
                System.out.println("Payment successful.");
                return true;
            } else {
                System.out.println("Payment not successful.");
                return false;
            }*/
        } catch (IOException e) {
            System.err.println("Error during HTTP request: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public MpesaCheckoutResponse paymentStatus(String transactionCode) throws IOException {
        int shortCode=Integer.parseInt(dotenv.get("SHORT-CODE"));
        String authKey = new MpesaService(dotenv).getKey();
        MpesaCheckoutRequest mpesaCheckoutRequest=new MpesaCheckoutRequest(
                dotenv.get("SHORT-CODE"),
                mpesaUtils.encodeBase64(dotenv.get("SHORT-CODE"),dotenv.get("PASS-KEY")),
                mpesaUtils.getFormattedTimestamp(),
                transactionCode
        );
        String jsonBody=mpesaCheckoutRequest.toJson();
        System.out.println(jsonBody);
        OkHttpClient client=new OkHttpClient();
        RequestBody body =RequestBody.create(MediaType.parse("application/json"), jsonBody);
        Request request=new Request.Builder()
                .url(dotenv.get("QUERY-URL"))
                .method("POST",body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer "+authKey)
                .build();
        Response response=client.newCall(request).execute();
        if (!response.isSuccessful()){
            System.out.println(response.body().string());
            return null;
        }
        ObjectMapper objectMapper=new ObjectMapper();
        String respnseBody=response.body().string();
        MpesaCheckoutResponse mpesaCheckoutResponse=objectMapper.readValue(respnseBody,MpesaCheckoutResponse.class);
        System.out.println(respnseBody);

        return mpesaCheckoutResponse;
    }
}
