package com.example.turfbooking.repo;

import com.example.turfbooking.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepo extends JpaRepository<Company,Long> {
    boolean existsByCompanyName(String companyName);

    Optional<Company> findByCompanyId(Long companyId);
}
