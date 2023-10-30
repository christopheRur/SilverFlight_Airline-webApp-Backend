package com.codelab.SilverAirline.repository;

import com.codelab.SilverAirline.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {

    Flight findByFlightNumber(String flightNumber);

    Flight findByOrigin(String flightOrigin);

    Flight findByDestination(String flightDestination);

    Flight findByDepartureT(String flightDeparture);

    Flight findByArrivalT(String flightArrival);

    Flight findByPassengers(int flightPassengers);
}
