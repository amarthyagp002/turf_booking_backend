package com.example.turfbooking.repo;

import com.example.turfbooking.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    boolean existByCompanyName(String companyName);
}
