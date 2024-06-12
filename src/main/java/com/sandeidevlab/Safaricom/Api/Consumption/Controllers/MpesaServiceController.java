package com.sandeidevlab.Safaricom.Api.Consumption.Controllers;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.AutenticationResponse;

import com.sandeidevlab.Safaricom.Api.Consumption.Models.StkCallbackResponse;
import com.sandeidevlab.Safaricom.Api.Consumption.Services.MpesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class MpesaServiceController {


    MpesaService mpesaService=new MpesaService();

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
    @PostMapping("/callback")
    ResponseEntity<StkCallbackResponse>  callBack(@RequestBody StkCallbackResponse request){
        return ResponseEntity.ok(request);
    }
}
