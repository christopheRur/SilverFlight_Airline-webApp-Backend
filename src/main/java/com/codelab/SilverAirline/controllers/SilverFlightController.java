package com.codelab.SilverAirline.controllers;

import com.codelab.SilverAirline.entities.Flight;
import com.codelab.SilverAirline.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class SilverFlightController {

    private FlightService flightSer;

    SilverFlightController(FlightService flightService) {
        this.flightSer=flightService;
    }

    @PostMapping("/book_fli")
    public ResponseEntity<?> bookAFlight(@RequestBody Flight flight){
        try{if(flight==null){

            return ResponseEntity.badRequest().body("NoFlightAdded.");

        }
        else return new ResponseEntity<>(flightSer.bookAFlight(flight), HttpStatus.CREATED);

        }catch(Exception e){
            log.error("==>"+e.getLocalizedMessage());
            return ResponseEntity.badRequest().body("Error occurred, unable to add Flight!");
        }


    }

    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights(){
        return ResponseEntity.ok(flightSer.getFlights());
    }

    @PostMapping("/lookup_fli")
    public ResponseEntity<?> lookupFlightNumber(@RequestBody Flight flight){

        return ResponseEntity.ok(flightSer.lookupFlight(flight.getFlightNumber()));
    }

}
