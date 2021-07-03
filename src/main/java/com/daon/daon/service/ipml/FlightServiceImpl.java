package com.daon.daon.service.ipml;

import com.daon.daon.dto.FlightDTO;
import com.daon.daon.model.Flight;
import com.daon.daon.model.Gate;
import com.daon.daon.repository.FlightRepository;
import com.daon.daon.service.FlightService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("FlightService")
@Transactional
public class FlightServiceImpl implements FlightService {

    private final Logger log = LoggerFactory.getLogger(FlightServiceImpl.class);
    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<Flight> getAllFlights() {
        log.debug("Service for getAllFlights {}");
        return flightRepository.findAll();
    }

    @Override
    public Optional<Flight> getFlightsById(Long id) {
        log.debug("Service for getAllFlights {}", id);
        Optional<Flight> getFlightResult = flightRepository.findById(id);
        return getFlightResult;
    }

    @Override
    public Flight saveFlight(FlightDTO flightDTO) {

        Flight result = flightRepository
            .save(new Flight(flightDTO.getFlightNumber(), flightDTO.getFlightDescription(), flightDTO.getGate()));
        return result;
    }

    @Override
    public void updateFlight(Optional<Flight> flightDataExist, FlightDTO flightDTO) {
        Flight flight = flightDataExist.get();
        flight.setFlightNumber(flightDTO.getFlightNumber());
        flight.setFlightDescription(flightDTO.getFlightDescription());
        flightRepository.save(flight);
    }

    @Override
    public void deleteById(long id) {
        flightRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        flightRepository.deleteAll();
    }

    @Override
    public Flight getFlightsByFlightNumber(Long flightNumber) {
        log.debug("Service for getFlightsByFlightNumber {}", flightNumber);
        Flight result = flightRepository.findFlightByFlightNumber(flightNumber);
        return result;
    }
}
