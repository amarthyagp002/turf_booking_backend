package com.example.turfbooking.model;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalTime;

@Entity
@Table(name = "court")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long courtId;
    String courtName;
    String address;
    LocalTime openingTime;
    LocalTime closingTime;
    String city;
    double pricePerHour;
    String status;
    @ManyToOne
    @JoinColumn(name ="company_id",nullable = false)
    private Company company;
    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public Long getCourtId() {
        return courtId;
    }

    public void setCourtId(Long courtId) {
        this.courtId = courtId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
