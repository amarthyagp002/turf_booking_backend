package com.example.turfbooking.service;

import com.example.turfbooking.dto.CourtRequestDto;
import com.example.turfbooking.dto.CourtResponseDto;
import com.example.turfbooking.model.Company;
import com.example.turfbooking.model.Court;
import com.example.turfbooking.repo.CompanyRepo;
import com.example.turfbooking.repo.CourtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourtService {
    @Autowired
    CompanyRepo companyRepo;
    @Autowired
    CourtRepo courtRepo;
    public ResponseEntity<?> addCourt(CourtRequestDto courtRequestDto) {
        Company company=companyRepo.findById(courtRequestDto.getCompanyId())
                .orElseThrow(()->new RuntimeException("Company not found"));
        Court court =new Court();
        court.setCompany(company);
        court.setCourtName(company.getCompanyName());
        court.setAddress(courtRequestDto.getAddress());
        court.setCity(courtRequestDto.getCity());
        court.setCourtName(courtRequestDto.getCourtName());
        court.setOpeningTime(court.getOpeningTime());
        court.setClosingTime(courtRequestDto.getClosingTime());
        court.setPricePerHour(courtRequestDto.getPricePerHour());
        courtRepo.save(court);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<?> deleteCourt(Long id) {
        Court court=courtRepo.findById(id).orElseThrow(()->new RuntimeException("Court not found"));
        courtRepo.delete(court);
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }
    public ResponseEntity<CourtResponseDto> getCourt(Long id){
        Court court=courtRepo.findById(id).orElseThrow(()->new RuntimeException("Court not found"));
        CourtResponseDto courtResponseDto = new CourtResponseDto();
        courtResponseDto.setAddress(court.getAddress());
        courtResponseDto.setCity(court.getCity());
        courtResponseDto.setClosingTime(court.getClosingTime());
        courtResponseDto.setOpeningTime(court.getOpeningTime());
        courtResponseDto.setCourtName(court.getCourtName());
        courtResponseDto.setCompanyName(court.getCompany().getCompanyName());
        courtResponseDto.setPricePerHour(court.getPricePerHour());
        return new ResponseEntity<>(courtResponseDto,HttpStatus.OK);
    }

    public ResponseEntity<List<CourtResponseDto>> getCourts() {
        List<Court> courts = courtRepo.findAll();
        List<CourtResponseDto> courtsResponses = new ArrayList<>();
        for(Court court:courts){
            CourtResponseDto courtResponse = new CourtResponseDto();
            courtResponse.setCourtName(court.getCourtName());
            courtResponse.setCity(court.getCity());
            courtResponse.setClosingTime(court.getClosingTime());
            courtResponse.setOpeningTime(court.getOpeningTime());
            courtResponse.setPricePerHour(court.getPricePerHour());
            courtResponse.setCompanyName(court.getCompany().getCompanyName());
            courtsResponses.add(courtResponse);
        }
        return new ResponseEntity<>(courtsResponses,HttpStatus.OK);


    }

    public ResponseEntity<List<CourtResponseDto>> getCourtByCompanyId(Long companyId) {
        Company company=companyRepo.findById(companyId).orElseThrow(()->new RuntimeException("Company not found"));
        Optional<List<Court>> courts=courtRepo.findByCompanyCompanyId(companyId);
        List<CourtResponseDto> courtResponseDtos =new ArrayList<>();
        for(Court c: courts.get()){
            CourtResponseDto cr = new CourtResponseDto();
            cr.setCompanyName(c.getCompany().getCompanyName());
            cr.setPricePerHour(c.getPricePerHour());
            cr.setOpeningTime(c.getOpeningTime());
            cr.setClosingTime(c.getClosingTime());
            cr.setCity(c.getCity());
            cr.setCourtName(c.getCourtName());
            cr.setAddress(c.getAddress());
            courtResponseDtos.add(cr);
        }
        return new ResponseEntity<>(courtResponseDtos,HttpStatus.OK);
    }
}
