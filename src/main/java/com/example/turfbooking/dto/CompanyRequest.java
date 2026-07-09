package com.example.turfbooking.dto;

import java.time.LocalDate;

public class CompanyRequest {
    private String companyName;
    private String email;
    private String phone;
    private LocalDate createdAt;
    private Long ownerId;

    public String getCompanyName() {
        return companyName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public String getEmail() {
        return email;
    }
}
