package com.daon.daon.service.ipml;

import com.daon.daon.dto.GateDTO;
import com.daon.daon.model.Gate;
import com.daon.daon.repository.GateRepository;
import com.daon.daon.service.GateService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("GateService")
@Transactional
public class GateServiceImpl implements GateService {

    private final Logger log = LoggerFactory.getLogger(GateServiceImpl.class);
    private final GateRepository gateRepository;

    public GateServiceImpl(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    @Override
    public List<Gate> getAllGates() {
        log.debug("Service for getAllGates {}");
        return gateRepository.findAll();
    }

    @Override
    public Optional<Gate> getGatesById(Long id) {
        log.debug("Service for getAllGates {}", id);
        Optional<Gate> getGateResult = gateRepository.findById(id);
        return getGateResult;
    }

    @Override
    public Gate saveGate(GateDTO gateDTO) {
        Gate result = gateRepository
            .save(new Gate(gateDTO.getGateNumber(), gateDTO.getGateDescription(), gateDTO.isStatus()));
        return result;
    }

    @Override
    public void updateGate(Optional<Gate> gateDataExist, GateDTO gateDTO) {
        Gate gate = gateDataExist.get();
        gate.setGateNumber(gateDTO.getGateNumber());
        gate.setGateDescription(gateDTO.getGateDescription());
        gate.setStatus(gateDTO.isStatus());
        gateRepository.save(gate);
    }

    @Override
    public void deleteById(long id) {
        gateRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        gateRepository.deleteAll();
    }
}
