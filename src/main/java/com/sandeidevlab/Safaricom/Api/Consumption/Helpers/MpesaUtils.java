package com.sandeidevlab.Safaricom.Api.Consumption.Helpers;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MpesaUtils {
    public String encodeBase64(String shortCode,String passKey,String timeStamp){
        String combinedString=shortCode+passKey+timeStamp;
        byte[] encodeBytes= Base64.getEncoder().encode(combinedString.getBytes(StandardCharsets.UTF_8));
        return new String(encodeBytes,StandardCharsets.UTF_8);
    }
}
