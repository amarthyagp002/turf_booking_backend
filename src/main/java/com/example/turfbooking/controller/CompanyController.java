package com.example.turfbooking.controller;

import com.example.turfbooking.dto.CompanyRequest;
import com.example.turfbooking.dto.CompanyResponseDto;
import com.example.turfbooking.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    CompanyService companyService;
    @PostMapping()
    public ResponseEntity<String > addCompany(@RequestBody CompanyRequest companyRequest){
        return companyService.addCompany(companyRequest);
    }
    @GetMapping()
    public ResponseEntity<List<CompanyResponseDto>> getComapanies(){
        return companyService.getCompanies();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        return companyService.deleteCompany(id);
    }
}
