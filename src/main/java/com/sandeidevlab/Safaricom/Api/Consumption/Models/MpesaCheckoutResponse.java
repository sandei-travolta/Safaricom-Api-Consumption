package com.sandeidevlab.Safaricom.Api.Consumption.Models;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MpesaCheckoutResponse {
    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("ResponseDescription")
    private String responseDescription;

    @JsonProperty("MerchantRequestID")
    private String merchantRequestID;

    @JsonProperty("CheckoutRequestID")
    private String checkoutRequestID;

    @JsonProperty("ResultCode")
    private String resultCode;

    @JsonProperty("ResultDesc")
    private String resultDesc;

    // Getters
    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public String getMerchantRequestID() {
        return merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    @Override
    public String toString() {
        return "MpesaCheckoutResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseDescription='" + responseDescription + '\'' +
                ", merchantRequestID='" + merchantRequestID + '\'' +
                ", checkoutRequestID='" + checkoutRequestID + '\'' +
                ", resultCode='" + resultCode + '\'' +
                ", resultDesc='" + resultDesc + '\'' +
                '}';
    }
}

