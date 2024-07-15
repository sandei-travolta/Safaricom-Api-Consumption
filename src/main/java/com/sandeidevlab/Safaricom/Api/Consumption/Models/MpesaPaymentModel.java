package com.sandeidevlab.Safaricom.Api.Consumption.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Timestamp;

public class MpesaPaymentModel {
    @JsonProperty("BusinessShortCode")
    private String businessShortCode;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("Timestamp")
    private String timestamp;

    @JsonProperty("TransactionType")
    private String transactionType;

    @JsonProperty("Amount")
    private double amount;

    @JsonProperty("PartyA")
    private long partyA;

    @JsonProperty("PartyB")
    private String partyB;

    @JsonProperty("PhoneNumber")
    private long phoneNumber;

    @JsonProperty("CallBackURL")
    private String callbackURL;

    @JsonProperty("AccountReference")
    private String accountReference;

    @JsonProperty("TransactionDesc")
    private String transactionDesc;

    // Constructor
    public MpesaPaymentModel(String businessShortCode, String password, String timestamp, String transactionType,
                             double amount, long partyA, String partyB, long phoneNumber, String callbackURL,
                             String accountReference, String transactionDesc) {
        this.businessShortCode = businessShortCode;
        this.password = password;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
        this.amount = amount;
        this.partyA = partyA;
        this.partyB = partyB;
        this.phoneNumber = phoneNumber;
        this.callbackURL = callbackURL;
        this.accountReference = accountReference;
        this.transactionDesc = transactionDesc;
    }

    // toJson Method for serialization to JSON
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(this);
    }

    public String getBusinessShortCode() {
        return businessShortCode;
    }

    public String getPassword() {
        return password;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public long getPartyA() {
        return partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public String getCallbackURL() {
        return callbackURL;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    // Getters and setters (if needed) can be added as per your requirements
}
