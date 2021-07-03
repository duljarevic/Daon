package com.daon.daon.controllers;

import com.daon.daon.dto.GateDTO;
import com.daon.daon.model.Gate;
import com.daon.daon.service.GateService;
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
public class GateController {

  private final Logger log = LoggerFactory.getLogger(GateController.class);
  private final GateService gateService;

  public GateController(GateService gateService) {
    this.gateService = gateService;
  }

  @GetMapping("/gates")
  public ResponseEntity<List<Gate>> getAllGates() {
    try {
      log.debug("Request for getAllGates {}");
      List<Gate> result = gateService.getAllGates();
      return new ResponseEntity<>(result, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/gate/{id}")
  public ResponseEntity<Gate> getGatesById(@PathVariable("id") Long id) {
    log.debug("Request for getGatesById {}");
    Optional<Gate> result = gateService.getGatesById(id);
    if (result.isPresent()) {
      return new ResponseEntity<>(result.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/gates")
  public ResponseEntity<Gate> createGate(@RequestBody GateDTO gateDTO) {
    log.debug("Request for createGate {}", gateDTO);
    try {
      Gate result = gateService.saveGate(gateDTO);
      return new ResponseEntity<>(result, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/gate/{id}")
  public ResponseEntity<Gate> updateGate(@PathVariable("id") long id, @RequestBody GateDTO gateDTO) {
    Optional<Gate> gateData = gateService.getGatesById(id);
    if (gateData.isPresent()) {
      gateService.updateGate(gateData,gateDTO);
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/gate/{id}")
  public ResponseEntity<HttpStatus> deleteGate(@PathVariable("id") long id) {
    try {
      gateService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/gates")
  public ResponseEntity<HttpStatus> deleteAllTutorials() {
    try {
      gateService.deleteAll();
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
