package com.example.turfbooking.service;

import com.example.turfbooking.dto.CustomerDto;
import com.example.turfbooking.dto.OwnersDto;
import com.example.turfbooking.enums.Role;
import com.example.turfbooking.model.Customer;
import com.example.turfbooking.model.Owners;
import com.example.turfbooking.model.Users;
import com.example.turfbooking.repo.CustomerRepo;
import com.example.turfbooking.repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerService {
    @Autowired
    UsersRepo usersRepo;
    @Autowired
    CustomerRepo customerRepo;
    public ResponseEntity<?> addUser(CustomerDto customerDto) {
        Customer customer=new Customer();
        Users users =new Users();
        users.setEmail(customerDto.getEmail());
        users.setPassword(customerDto.getPassword());
        users.setRole(Role.OWNER);
        users.setCreated_at(LocalDate.now());
        users.setUpdated_at(LocalDate.now());
        users.setEmail_verified(false);
        users.setStatus("ACTIVE");
        usersRepo.save(users);
        customer.setUsers(users);
//        customer.setAddress(customerDto.getAddress());
//        owners.setCompanyName(customerDto.getBusinessName());
//        customer.setPhone(customerDto.getPhone());
        customerRepo.save(customer);
        return new ResponseEntity<>("successfull", HttpStatus.OK);

    }
}
