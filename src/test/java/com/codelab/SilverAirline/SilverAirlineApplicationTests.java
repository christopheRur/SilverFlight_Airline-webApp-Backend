package com.codelab.SilverAirline;

import com.codelab.SilverAirline.controllers.SilverFlightController;
import com.codelab.SilverAirline.entities.Flight;
import com.codelab.SilverAirline.repository.FlightRepo;
import com.codelab.SilverAirline.services.FlightService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class SilverAirlineApplicationTests {

	@Mock
	private Flight flight;

	@Mock
	private FlightRepo flightRepo;

	@Mock
	private FlightService flightService;

	@InjectMocks
	private SilverFlightController controller;

	private Flight dummyTicket= new Flight();

	{
		dummyTicket.setDestination("dummyDestination");
		dummyTicket.setOrigin("dummyOrigin");
		dummyTicket.setPassengers(3);
	}
	@Test
	void contextLoads() {
	}

	@Test
	public void testBookFlight(){

		Mockito.when(flightService.bookAFlight(dummyTicket)).thenReturn(new Flight());
		ResponseEntity<?> response = controller.bookAFlight(flightService.bookAFlight(dummyTicket));

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
	}
	@Test
	public void testLookUpFlight(){

		Mockito.when(flightService.lookupFlight((dummyTicket))).thenReturn(dummyTicket);
		ResponseEntity<?> response = controller.lookupFlightByDestinationAndOrigin(flightService.lookupFlight(dummyTicket));

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testGetFlights(){
		ArrayList<Flight> flightList = new ArrayList<Flight>();
		flightList.add(dummyTicket);

		Mockito.when(flightService.getFlights()).thenReturn(flightList);
		ResponseEntity<?> response = controller.getAllFlights();

		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void testRemoveFlight(){

		flightService.removeBookedFlight(dummyTicket);
		verify(flightService).removeBookedFlight(dummyTicket);
		verify(flightService, times(1)).removeBookedFlight(dummyTicket);

	}


}
