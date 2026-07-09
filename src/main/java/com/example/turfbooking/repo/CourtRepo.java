package com.example.turfbooking.repo;

import com.example.turfbooking.model.Court;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourtRepo extends JpaRepository<Court,Long> {
}
