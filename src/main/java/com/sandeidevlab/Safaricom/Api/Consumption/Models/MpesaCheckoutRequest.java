package com.sandeidevlab.Safaricom.Api.Consumption.Models;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;

public class MpesaCheckoutRequest {

        @JsonProperty("BusinessShortCode")
        private final String businessShortCode;
        @JsonProperty("Password")
        private final String password;
        @JsonProperty("Timestamp")
        private final String timestamp;
        @JsonProperty("CheckoutRequestID")
        private final String checkoutRequestID;

        // Constructor
        public MpesaCheckoutRequest(String businessShortCode, String password, String timestamp, String checkoutRequestID) {
            this.businessShortCode = businessShortCode;
            this.password = password;
            this.timestamp = timestamp;
            this.checkoutRequestID = checkoutRequestID;
        }

        // Method to convert object to JSON
        public String toJson() throws JsonProcessingException {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(this);
        }

        // toString Method
        @Override
        public String toString() {
            return "MpesaCheckoutRequest{" +
                    "businessShortCode=" + businessShortCode +
                    ", password='" + password + '\'' +
                    ", timestamp=" + timestamp +
                    ", checkoutRequestID='" + checkoutRequestID + '\'' +
                    '}';
        }

    }

