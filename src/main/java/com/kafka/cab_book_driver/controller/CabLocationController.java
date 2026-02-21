package com.kafka.cab_book_driver.controller;

import com.kafka.cab_book_driver.entity.Location;
import com.kafka.cab_book_driver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/location")
public class CabLocationController {

    @Autowired
    private CabLocationService cabLocationService;

    @PutMapping
    public ResponseEntity<Map<String, String>> updateLocation() throws InterruptedException {
        int range = 5;
        while(range > 0){
            cabLocationService.updateLocation(Math.random() + " , " + Math.random());
            range--;
        }
        return new ResponseEntity<>(Map.of("message", "Location updated!"), HttpStatus.OK);
    }

    @PutMapping("/save")
    public ResponseEntity<Map<String, String>> destinationReached(@RequestBody Location location){
        cabLocationService.saveDestination(location);
        return new ResponseEntity<>(Map.of("message", "Destination saved!"), HttpStatus.OK);
    }
}
