package com.daon.daon.service;


import com.daon.daon.dto.FlightDTO;
import com.daon.daon.model.Flight;
import java.util.List;
import java.util.Optional;

public interface FlightService {

  List<Flight> getAllFlights();
  Optional<Flight> getFlightsById(Long id);
  Flight saveFlight(FlightDTO flightDTO);
  void updateFlight(Optional<Flight> flightData, FlightDTO flightDTO);
  void deleteById(long id);
  void deleteAll();
  Flight getFlightsByFlightNumber(Long flightNumber);
}
