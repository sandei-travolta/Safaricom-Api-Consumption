package com.sandeidevlab.Safaricom.Api.Consumption.Interfaces;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.AutenticationResponse;
import org.apache.catalina.authenticator.SpnegoAuthenticator;

import java.io.IOException;

public interface MpesaEndPoints {
   public AutenticationResponse authenticationRequest() throws IOException;

   void saveKey(String key, int timestap);

   public Boolean isValid();
   public String getKey() throws IOException;

}
