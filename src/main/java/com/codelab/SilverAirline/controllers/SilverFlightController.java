package com.codelab.SilverAirline.controllers;

import com.codelab.SilverAirline.entities.Flight;
import com.codelab.SilverAirline.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SilverFlightController {

    private FlightService flightSer;

    SilverFlightController(FlightService flightService) {
        this.flightSer=flightService;
    }

    /**
     * Books the flight
     * @param flight
     * @return ResponseEntity
     */
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

    /**
     * Retrieve available flights.
     * @return responseEntity
     */
    @GetMapping("/flights")
    public ResponseEntity<List<Flight>> getAllFlights(){
        return ResponseEntity.ok(flightSer.getFlights());
    }

    /**
     *
     * @param flight
     * @return responseEntity
     */
    @PostMapping("/lookup_fli")
    public ResponseEntity<?> lookupFlightByDestinationAndOrigin(@RequestBody Flight flight){

        return ResponseEntity.ok(flightSer.lookupFlight(flight));
    }

    /***
     *  Remove flight
     * @param flight
     * @return ResponseEntity
     */
    @PostMapping("/removeBkFl")
    public ResponseEntity<?> removeFlight(@RequestBody Flight flight){

        log.info("=======>Removing flight " + flight.getDestination().isEmpty());
        if(flight.getFlightNumber().isEmpty()){
            log.info("No flight number");
            return new ResponseEntity<>("flightNumber is empty!",
                    HttpStatus.BAD_REQUEST);

        }
        else {
            flightSer.removeBookedFlight(flight);

        return new ResponseEntity<>("Flight Removed!!",HttpStatus.OK);
        }
    }

}
