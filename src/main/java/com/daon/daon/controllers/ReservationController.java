package com.daon.daon.controllers;

import com.daon.daon.dto.GateDTO;
import com.daon.daon.model.Flight;
import com.daon.daon.model.Gate;
import com.daon.daon.service.FlightService;
import com.daon.daon.service.GateService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ReservationController {

  private final Logger log = LoggerFactory.getLogger(ReservationController.class);

  private final FlightService flightService;
  private final GateService gateService;

  public ReservationController(FlightService flightService,
      GateService gateService) {
    this.flightService = flightService;
    this.gateService = gateService;
  }

  @GetMapping("/reservationGates/{flightNumber}")
  public ResponseEntity reservationGates(@PathVariable("flightNumber") Long flightNumber) {
    log.debug("Request for reservationGates {}");

    Flight flight = flightService.getFlightsByFlightNumber(flightNumber);
    Optional<Gate> gateData = gateService.getGatesById(flight.getGate().getId());

    if (flight.getGate().isStatus() == false) {
      GateDTO gate = new GateDTO();
      gate.setStatus(true);
      gate.setGateNumber(flight.getGate().getGateNumber());
      gate.setGateDescription(flight.getFlightDescription());
      gateService.updateGate(gateData,gate);
      return ResponseEntity
          .status(HttpStatus.OK)
          .body("The plane can land");
    } else {
      return ResponseEntity
          .status(HttpStatus.OK)
          .body("Gate is not available");
    }
  }
}
