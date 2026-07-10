package com.example.turfbooking.controller;

import com.example.turfbooking.dto.CustomerDto;
import com.example.turfbooking.dto.OwnersDto;
import com.example.turfbooking.service.CustomerService;
import com.example.turfbooking.service.OwnersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PostMapping()
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto){
        return customerService.addCustomer(customerDto);
    }

}
