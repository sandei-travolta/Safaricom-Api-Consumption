package com.sandeidevlab.Safaricom.Api.Consumption.Helpers;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

@Service
public class MpesaUtils {
    public String encodeBase64(String shortCode,String passKey){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        // Convert formatted string back to LocalDateTime
        String formattedString = localDateTime.format(formatter);
        String combinedString=shortCode+passKey+formattedString;
        byte[] encodeBytes= Base64.getEncoder().encode(combinedString.getBytes(StandardCharsets.UTF_8));
        return new String(encodeBytes,StandardCharsets.UTF_8);
    }
    public static String getFormattedTimestamp() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

        // Format the LocalDateTime to the desired string format
        String formattedString = localDateTime.format(formatter);

        // Convert formatted string back to LocalDateTime
        LocalDateTime parsedDateTime = LocalDateTime.parse(formattedString, formatter);

        // Convert LocalDateTime to Timestamp
        Timestamp timestamp = Timestamp.valueOf(parsedDateTime);

        // Return formatted timestamp as a string
        return formattedString;
    }

}
