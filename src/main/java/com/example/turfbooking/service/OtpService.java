package com.example.turfbooking.service;

import com.example.turfbooking.model.Otp;
import com.example.turfbooking.model.OtpGenerator;
import com.example.turfbooking.repo.OtpRepo;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OtpService {
    @Autowired
    OtpRepo otpRepo;
    @Autowired
    JavaMailSender mailSender;
    public String generateOtp(String email){
        String otpVal=OtpGenerator.generateOtp();
        Otp otp=otpRepo.findByEmail(email).orElse(new Otp());
        otp.setEmail(email);
        otp.setOtp(otpVal);
        otp.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otp.setValid(false);
        otpRepo.save(otp);
        return otpVal;
    }
    public void sendOtp(String to,String otp){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject("OTP Verification");
        msg.setText("Your Otp is: " + otp);
        mailSender.send(msg);
    }
    public boolean verifyOtp(String email,String otp){
        Optional<Otp> dbOtp=otpRepo.findByEmail(email);
        if(dbOtp.isEmpty()){
            return false;
        }
        if(dbOtp.get().getExpiryTime().isBefore(LocalDateTime.now())){
            return false;
        }
        if(!otp.equals(dbOtp.get().getOtp())){
            return false;
        }
        dbOtp.get().setValid(true);
        otpRepo.save(dbOtp.get());
        return true;
    }

}
