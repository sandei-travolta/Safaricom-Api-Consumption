package com.sandeidevlab.Safaricom.Api.Consumption.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MpesaExpressBody {


    @JsonProperty("BusinessShortCode")
    private int businessShortCode;

    @JsonProperty("Password")
    private String password;
    @JsonProperty("TimeStamp")
    private String timeStamp;
    @JsonProperty("TransactionType")
    private String transactionType;
    @JsonProperty("Amount")
    private int amount;
    @JsonProperty("PartyA")
    private int partyA;
    @JsonProperty("PartyB")
    private int partyB;
    @JsonProperty("PhoneNumber")
    private int phoneNumber;
    @JsonProperty("CallBackUrl")
    private String callBackUrl;
    @JsonProperty("AccountReference")
    private String accountReference;
    @JsonProperty("TransactionDesc")
    private String transactionDesc;

    public int getBusinessShortCode() {
        return businessShortCode;
    }

    public void setBusinessShortCode(int businessShortCode) {
        this.businessShortCode = businessShortCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        transactionType = transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPartyA() {
        return partyA;
    }

    public void setPartyA(int partyA) {
        this.partyA = partyA;
    }

    public int getPartyB() {
        return partyB;
    }

    public void setPartyB(int partyB) {
        this.partyB = partyB;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    public void setTransactionDesc(String transactionDesc) {
        this.transactionDesc = transactionDesc;
    }
}
