package com.example.turfbooking.dto;



import java.time.LocalTime;

public class CourtRequestDto {
    private Long courtId;
    private String courtName;
    private String address;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String city;
    private double pricePerHour;
    private Long companyId;

    public Long getCourtId() {
        return courtId;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getCity() {
        return city;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public String getAddress() {
        return address;
    }

    public String getCourtName() {
        return courtName;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public Long getCompanyId() {
        return companyId;
    }
}
