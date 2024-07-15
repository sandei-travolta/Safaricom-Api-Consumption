package com.sandeidevlab.Safaricom.Api.Consumption.Models;

public class OrderModel {
    private long orderId;
    private String orderTittle;
    private String orderPrice;
    private String orderDate;
    private String orderDeadline;

    public OrderModel(long orderId, String orderTittle, String orderPrice, String orderDate, String orderDeadline) {
        this.orderId = orderId;
        this.orderTittle = orderTittle;
        this.orderPrice = orderPrice;
        this.orderDate = orderDate;
        this.orderDeadline = orderDeadline;
    }

    public long getOrderId() {
        return orderId;
    }

    public String getOrderTittle() {
        return orderTittle;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderDeadline() {
        return orderDeadline;
    }
}
