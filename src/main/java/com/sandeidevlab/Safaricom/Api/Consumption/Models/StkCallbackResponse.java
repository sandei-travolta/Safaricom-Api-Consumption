package com.sandeidevlab.Safaricom.Api.Consumption.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class StkCallbackResponse {

    @JsonProperty("Body")
    private Body body;

    // Getters and Setters
    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public static class Body {

        @JsonProperty("stkCallback")
        private StkCallback stkCallback;

        // Getters and Setters
        public StkCallback getStkCallback() {
            return stkCallback;
        }

        public void setStkCallback(StkCallback stkCallback) {
            this.stkCallback = stkCallback;
        }
    }

    public static class StkCallback {

        @JsonProperty("MerchantRequestID")
        private String merchantRequestID;

        @JsonProperty("CheckoutRequestID")
        private String checkoutRequestID;

        @JsonProperty("ResultCode")
        private int resultCode;

        @JsonProperty("ResultDesc")
        private String resultDesc;

        @JsonProperty("CallbackMetadata")
        private CallbackMetadata callbackMetadata;

        // Getters and Setters
        public String getMerchantRequestID() {
            return merchantRequestID;
        }

        public void setMerchantRequestID(String merchantRequestID) {
            this.merchantRequestID = merchantRequestID;
        }

        public String getCheckoutRequestID() {
            return checkoutRequestID;
        }

        public void setCheckoutRequestID(String checkoutRequestID) {
            this.checkoutRequestID = checkoutRequestID;
        }

        public int getResultCode() {
            return resultCode;
        }

        public void setResultCode(int resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultDesc() {
            return resultDesc;
        }

        public void setResultDesc(String resultDesc) {
            this.resultDesc = resultDesc;
        }

        public CallbackMetadata getCallbackMetadata() {
            return callbackMetadata;
        }

        public void setCallbackMetadata(CallbackMetadata callbackMetadata) {
            this.callbackMetadata = callbackMetadata;
        }
    }

    public static class CallbackMetadata {

        @JsonProperty("Item")
        private List<Item> items;

        // Getters and Setters
        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    public static class Item {

        @JsonProperty("Name")
        private String name;

        @JsonProperty("Value")
        private Object value;

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }
}
