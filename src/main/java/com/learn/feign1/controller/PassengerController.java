package com.learn.feign1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.feign1.feignclient.PassengerClient;

 

@RestController
@RequestMapping(value = "/passenger")
public class PassengerController {
    private final PassengerClient passengerClient;
    
    public PassengerController (PassengerClient passengerClient) {
    	this.passengerClient = passengerClient;
    }
    @GetMapping
    public ResponseEntity readPassengerData (@RequestParam(required = false) String passengerId) {
        if (passengerId == null) {
            return ResponseEntity.ok(passengerClient.readPassengers());
        }
        return ResponseEntity.ok(passengerClient.readPassengerById(passengerId));
    }
}