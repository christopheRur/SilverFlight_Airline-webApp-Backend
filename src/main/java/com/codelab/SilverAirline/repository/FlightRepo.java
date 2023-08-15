package com.codelab.SilverAirline.repository;

import com.codelab.SilverAirline.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {

    Flight findByFlightNumber(String flightNumber);
}
