package com.example.turfbooking.controller;

import com.example.turfbooking.dto.CourtRequestDto;
import com.example.turfbooking.dto.CourtResponseDto;
import com.example.turfbooking.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("courts")
public class CourtController {
    @Autowired
    CourtService courtService;
    @PostMapping()
    public ResponseEntity<?> addCourt(@RequestBody CourtRequestDto courtRequestDto){
        return courtService.addCourt(courtRequestDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourt(@PathVariable Long id){
        return courtService.deleteCourt(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourt(@PathVariable Long id){
        return courtService.getCourt(id);
    }
    @GetMapping
    public ResponseEntity<List<CourtResponseDto>> getCourts(){
        return courtService.getCourts();
    }
    @GetMapping("/{comapnyId}/companies")
    public ResponseEntity<?> getCourtByCompanyId(@PathVariable Long companyId){
        return courtService.getCourtByCompanyId(companyId);
    }


}
