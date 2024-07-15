package com.sandeidevlab.Safaricom.Api.Consumption.Models;

public class KeyModel {
    private  String accessToken;
    private  long timeStamp;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
