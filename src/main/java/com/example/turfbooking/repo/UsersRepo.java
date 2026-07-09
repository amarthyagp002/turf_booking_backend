package com.example.turfbooking.repo;

import com.example.turfbooking.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UsersRepo extends JpaRepository<Users, UUID> {

}
