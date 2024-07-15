package com.sandeidevlab.Safaricom.Api.Consumption.Interfaces;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.MpesaCheckoutResponse;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.MpesaResponse;

import java.io.IOException;

public interface PaymentInterfaces {
    public MpesaResponse iniatePayment(int amount, String mobileNo) throws IOException;
    public MpesaCheckoutResponse paymentStatus(String transactionCode) throws IOException;
}
