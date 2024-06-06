package com.sandeidevlab.Safaricom.Api.Consumption.Interfaces;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.AutenticationResponse;

import java.io.IOException;

public interface MpesaEndPoints {
   public AutenticationResponse authenticationRequest() throws IOException;

}
