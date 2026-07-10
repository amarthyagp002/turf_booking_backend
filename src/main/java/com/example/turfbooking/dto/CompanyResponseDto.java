package com.example.turfbooking.dto;

import com.example.turfbooking.model.Owners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class CompanyResponseDto {
    private String companyName;
    private String email;
    private String phone;
    private LocalDate createdAt;
    private String ownerName;

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
