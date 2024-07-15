package com.sandeidevlab.Safaricom.Api.Consumption.Controllers;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.AutenticationResponse;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.InstatiatePayment;
import com.sandeidevlab.Safaricom.Api.Consumption.Models.StkCallbackResponse;
import com.sandeidevlab.Safaricom.Api.Consumption.Services.InsatiatePaymentService;
import com.sandeidevlab.Safaricom.Api.Consumption.Services.MpesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MpesaServiceController {

    @Autowired
    private final MpesaService mpesaService;
    @Autowired
    private final InsatiatePaymentService instatiatePaymentService;

    public MpesaServiceController(MpesaService mpesaService, InsatiatePaymentService instatiatePaymentService) {
        this.mpesaService = mpesaService;
        this.instatiatePaymentService = instatiatePaymentService;
    }

    @GetMapping("/authentication")
    ResponseEntity<AutenticationResponse> authennticationController(){
        try {
            AutenticationResponse autenticationResponse=mpesaService.authenticationRequest();
            return ResponseEntity.ok(autenticationResponse);
        }catch (IOException e){
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
    @GetMapping("/test")
    String testing(){
        return "works";
    }
    @PostMapping("/testcallback")
    String testingCallBack(@RequestBody StkCallbackResponse request){
        return "works";
    }
    @PostMapping("/callback")
    ResponseEntity<StkCallbackResponse>  callBack(@RequestBody StkCallbackResponse request){
        return ResponseEntity.ok(request);
    }
    @PostMapping("payment")
    ResponseEntity instatiatePayment(@RequestBody InstatiatePayment instatiatePayment){
        try {
            boolean isSuccessfull=instatiatePaymentService.iniatePayment(instatiatePayment.getAmount(),instatiatePayment.getMobileNo());
            if(!isSuccessfull){
                return ResponseEntity.status(500).build();
            }
            return ResponseEntity.ok().build();
        }
        catch (IOException e){
            return ResponseEntity.status(500).build();
        }
    }
}
