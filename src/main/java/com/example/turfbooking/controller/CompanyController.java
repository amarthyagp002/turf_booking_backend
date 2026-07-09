package com.example.turfbooking.controller;

import com.example.turfbooking.dto.CompanyRequest;
import com.example.turfbooking.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping("/add")
    public ResponseEntity<String > addCompany(@RequestBody CompanyRequest companyRequest){
        return companyService.addCompany(companyRequest);
    }
}
