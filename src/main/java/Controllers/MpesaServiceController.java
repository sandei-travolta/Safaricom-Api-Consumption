package Controllers;

import Models.AutenticationResponse;
import Services.MpesaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MpesaServiceController {
    public MpesaServiceController(MpesaService mpesaService) {
        this.mpesaService = mpesaService;
    }

    MpesaService mpesaService;

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
}
