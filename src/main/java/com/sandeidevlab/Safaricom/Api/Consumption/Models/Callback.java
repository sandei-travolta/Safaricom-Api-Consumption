package com.sandeidevlab.Safaricom.Api.Consumption.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Callback {
        @JsonProperty("TransactionType")
        private String transactionType;

        @JsonProperty("TransID")
        private String transID;

        @JsonProperty("TransTime")
        private String transTime;

        @JsonProperty("TransAmount")
        private String transAmount;

        @JsonProperty("BusinessShortCode")
        private String businessShortCode;

        @JsonProperty("BillRefNumber")
        private String billRefNumber;

        @JsonProperty("InvoiceNumber")
        private String invoiceNumber;

        @JsonProperty("OrgAccountBalance")
        private String orgAccountBalance;

        @JsonProperty("ThirdPartyTransID")
        private String thirdPartyTransID;

        @JsonProperty("MSISDN")
        private String msisdn;

        @JsonProperty("FirstName")
        private String firstName;

        @JsonProperty("MiddleName")
        private String middleName;

        @JsonProperty("LastName")
        private String lastName;

        // Getters and Setters

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getTransID() {
            return transID;
        }

        public void setTransID(String transID) {
            this.transID = transID;
        }

        public String getTransTime() {
            return transTime;
        }

        public void setTransTime(String transTime) {
            this.transTime = transTime;
        }

        public String getTransAmount() {
            return transAmount;
        }

        public void setTransAmount(String transAmount) {
            this.transAmount = transAmount;
        }

        public String getBusinessShortCode() {
            return businessShortCode;
        }

        public void setBusinessShortCode(String businessShortCode) {
            this.businessShortCode = businessShortCode;
        }

        public String getBillRefNumber() {
            return billRefNumber;
        }

        public void setBillRefNumber(String billRefNumber) {
            this.billRefNumber = billRefNumber;
        }

        public String getInvoiceNumber() {
            return invoiceNumber;
        }

        public void setInvoiceNumber(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        public String getOrgAccountBalance() {
            return orgAccountBalance;
        }

        public void setOrgAccountBalance(String orgAccountBalance) {
            this.orgAccountBalance = orgAccountBalance;
        }

        public String getThirdPartyTransID() {
            return thirdPartyTransID;
        }

        public void setThirdPartyTransID(String thirdPartyTransID) {
            this.thirdPartyTransID = thirdPartyTransID;
        }

        public String getMsisdn() {
            return msisdn;
        }

        public void setMsisdn(String msisdn) {
            this.msisdn = msisdn;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
}
