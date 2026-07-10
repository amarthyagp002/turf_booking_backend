package com.example.turfbooking.service;

import com.example.turfbooking.dto.OwnersDto;
import com.example.turfbooking.enums.Role;
import com.example.turfbooking.model.Owners;
import com.example.turfbooking.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.turfbooking.repo.OwnersRepo;
import com.example.turfbooking.repo.UsersRepo;

import java.time.LocalDate;

@Service
public class OwnersService {

    @Autowired
    OwnersRepo ownersRepo;
    @Autowired
    UsersRepo usersRepo;
    public ResponseEntity<?> addOwner(OwnersDto ownersDto) {
        Users users=new Users();
        Owners owners=new Owners();
        users.setEmail(ownersDto.getEmail());
        users.setPassword(ownersDto.getPassword());
        users.setRole(Role.OWNER);
        users.setCreated_at(LocalDate.now());
        users.setUpdated_at(LocalDate.now());
        users.setEmail_verified(false);
        users.setStatus("ACTIVE");
        usersRepo.save(users);
        owners.setUsers(users);
        owners.setAddress(ownersDto.getAddress());
        owners.setOwnerName(ownersDto.getBusinessName());
        owners.setPhone(ownersDto.getPhone());
        ownersRepo.save(owners);
        return new ResponseEntity<>("successfull", HttpStatus.OK);

    }
}
