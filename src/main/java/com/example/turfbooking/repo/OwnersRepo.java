package com.example.turfbooking.repo;

import com.example.turfbooking.model.Owners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnersRepo extends JpaRepository<Owners,Long> {

}
