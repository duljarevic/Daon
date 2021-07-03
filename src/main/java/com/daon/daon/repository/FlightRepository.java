package com.daon.daon.repository;

import com.daon.daon.model.Flight;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

  Flight findFlightByFlightNumber(Long flightNumber);
}
