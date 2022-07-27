package com.ms_email.ms_email.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms_email.ms_email.Dtos.EmailDto;
import com.ms_email.ms_email.Services.EmailServicesImpl;

@RestController
public class EmailController {
    @Autowired    
    private EmailServicesImpl emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailDto> sendingEmail(@RequestBody @Valid EmailDto emailDto){
       
        return new ResponseEntity<>(emailService.sendEmail(emailDto), HttpStatus.CREATED);
    }

}
