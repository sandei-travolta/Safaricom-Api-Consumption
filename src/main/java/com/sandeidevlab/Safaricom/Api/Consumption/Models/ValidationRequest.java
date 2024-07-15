package com.sandeidevlab.Safaricom.Api.Consumption.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationRequest {

    private String checkoutRequestID;

    public ValidationRequest() {}
    public ValidationRequest(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }
}
