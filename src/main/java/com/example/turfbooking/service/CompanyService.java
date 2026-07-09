package com.example.turfbooking.service;

import com.example.turfbooking.dto.CompanyRequest;
import com.example.turfbooking.model.Company;
import com.example.turfbooking.model.Owners;
import com.example.turfbooking.repo.CompanyRepo;
import com.example.turfbooking.repo.OwnersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompanyService {
    @Autowired
    OwnersRepo ownersRepo;
    @Autowired
    CompanyRepo companyRepo;
    public ResponseEntity<String> addCompany(CompanyRequest companyRequest){
        Owners owner=ownersRepo.findById(companyRequest.getOwnerId())
                .orElseThrow(() -> new RuntimeException("owner not found"));
        if(companyRepo.existByCompanyName(companyRequest.getCompanyName())){
            return new ResponseEntity<>("Company name already exist",HttpStatus.BAD_REQUEST);
        }
        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setEmail(companyRequest.getEmail());
        company.setPhone(companyRequest.getPhone());
        company.setOwners(owner);
        company.setCreatedAt(LocalDate.now());
        companyRepo.save(company);
    return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
