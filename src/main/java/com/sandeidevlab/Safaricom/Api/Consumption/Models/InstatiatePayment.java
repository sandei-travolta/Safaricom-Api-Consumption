package com.sandeidevlab.Safaricom.Api.Consumption.Models;

public class InstatiatePayment {
    private String userId;
    private int amount;
    private String mobileNo;
    /*private OrderModel order;*/

    public InstatiatePayment(String userId, int amount, String mobileNo/*OrderModel order*/) {
        this.userId = userId;
        this.amount = amount;
        this.mobileNo=mobileNo;
        /*this.order = order;*/
    }

    public String getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    /*public OrderModel getOrder() {
        return order;
    }*/

    public String getMobileNo() {
        return mobileNo;
    }
}
