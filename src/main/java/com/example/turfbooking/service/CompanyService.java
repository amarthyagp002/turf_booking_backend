package com.example.turfbooking.service;

import com.example.turfbooking.dto.CompanyRequest;
import com.example.turfbooking.dto.CompanyResponseDto;
import com.example.turfbooking.model.Company;
import com.example.turfbooking.model.Court;
import com.example.turfbooking.model.Owners;
import com.example.turfbooking.repo.CompanyRepo;
import com.example.turfbooking.repo.OwnersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    OwnersRepo ownersRepo;
    @Autowired
    CompanyRepo companyRepo;
    public ResponseEntity<String> addCompany(CompanyRequest companyRequest){
        Owners owner=ownersRepo.findById(companyRequest.getOwnerId())
                .orElseThrow(() -> new RuntimeException("owner not found"));
        if(companyRepo.existsByCompanyName(companyRequest.getCompanyName())){
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

    public ResponseEntity<List<CompanyResponseDto>> getCompanies() {
        List<Company> companies=companyRepo.findAll();
        List<CompanyResponseDto> cm = new ArrayList<>();
        for(Company com:companies){
            CompanyResponseDto c= new CompanyResponseDto();
            c.setCompanyName(com.getCompanyName());
            c.setOwnerName(com.getOwners().getOwnerName());
            c.setEmail(com.getEmail());
            c.setPhone(com.getPhone());
            cm.add(c);
        }
        return new ResponseEntity<>(cm,HttpStatus.OK);
    }
    public ResponseEntity<String> deleteCompany(Long id){
        Company company=companyRepo.findById(id).orElseThrow(()->new RuntimeException("Company not found"));
        companyRepo.delete(company);
        return new ResponseEntity<>("Successfully deleted",HttpStatus.OK);
    }
}
