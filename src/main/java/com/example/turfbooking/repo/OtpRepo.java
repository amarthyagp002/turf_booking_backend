package com.example.turfbooking.repo;

import com.example.turfbooking.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface OtpRepo extends JpaRepository<Otp, UUID> {
    Optional<Otp> findByEmail(String email);
}
