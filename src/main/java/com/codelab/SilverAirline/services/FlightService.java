package com.codelab.SilverAirline.services;

import com.codelab.SilverAirline.entities.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {
    Flight bookAFlight(Flight flight);

    List<Flight> getFlights();

    Flight lookupFlight(Flight flight);

    void removeBookedFlight(Flight flight);

}
