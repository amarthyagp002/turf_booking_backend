package com.example.turfbooking.controller;

import com.example.turfbooking.dto.OwnersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.turfbooking.service.OwnersService;
//AuthController
//POST /auth/login
//
//        OwnerController
//POST /owners/register
//POST /owners/courts
//PUT  /owners/courts/{id}
//
//CustomerController
//POST /customers/register
//POST /bookings
//
//        AdminController
//GET /users
//DELETE /users/{id}


@RestController
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    OwnersService ownersService;
    @PostMapping("/add")
    public ResponseEntity<?> addOwner(@RequestBody OwnersDto ownersDto){
        return ownersService.addOwner(ownersDto);
    }


}
