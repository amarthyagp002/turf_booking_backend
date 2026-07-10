package com.example.turfbooking.repo;

import com.example.turfbooking.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourtRepo extends JpaRepository<Court,Long> {
    Optional<List<Court>> findByCompanyCompanyId(Long companyId);
}
