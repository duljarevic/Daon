package com.daon.daon.controllers;

import com.daon.daon.dto.FlightDTO;
import com.daon.daon.model.Flight;
import com.daon.daon.service.FlightService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FlightController {

  private final Logger log = LoggerFactory.getLogger(FlightController.class);
  private final FlightService flightService;

  public FlightController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping("/flights")
  public ResponseEntity<List<Flight>> getAllFlights() {
    try {
      log.debug("Request for getAllFlights {}");
      List<Flight> result = flightService.getAllFlights();
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/flight/{id}")
  public ResponseEntity<Flight> getFlightsById(@PathVariable("id") Long id) {
    log.debug("Request for getFlightsById {}");
    Optional<Flight> result = flightService.getFlightsById(id);
    if (result.isPresent()) {
      return new ResponseEntity<>(result.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/flights")
  public ResponseEntity<Flight> createFlight(@RequestBody FlightDTO flightDTO) {
    log.debug("Request for createFlight {}", flightDTO);
    try {
      Flight result = flightService.saveFlight(flightDTO);
      return new ResponseEntity<>(result, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/flight/{id}")
  public ResponseEntity<Flight> updateTutorial(@PathVariable("id") long id, @RequestBody FlightDTO flightDTO) {
    Optional<Flight> flightData = flightService.getFlightsById(id);
    if (flightData.isPresent()) {
      flightService.updateFlight(flightData,flightDTO);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/flight/{id}")
  public ResponseEntity<HttpStatus> deleteFlight(@PathVariable("id") long id) {
    try {
      flightService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/flights")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      flightService.deleteAll();
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
