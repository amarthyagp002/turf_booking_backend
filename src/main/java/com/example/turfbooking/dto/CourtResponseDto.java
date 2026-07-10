package com.example.turfbooking.dto;

import com.example.turfbooking.model.Company;

import java.time.LocalTime;

public class CourtResponseDto {
    private String courtName;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String city;
    private double pricePerHour;
    private String companyName;

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }


}
