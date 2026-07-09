package com.example.turfbooking.controller;

import com.example.turfbooking.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OtpController {
    @Autowired
    OtpService otpService;
    @PostMapping("/sendOtp")
    public ResponseEntity<?> sendOtp(@RequestParam String email){
        String otp=otpService.generateOtp(email);
        otpService.sendOtp(email,otp);
        return new ResponseEntity<>("data send successful", HttpStatus.OK);
    }
    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String email,@RequestParam String otp){
        boolean otpIsValid=otpService.verifyOtp(email,otp);
        if(otpIsValid){
            return "Otp verified";

        }else{
            return "Invalid otp";

        }

    }
}
