package com.daon.daon.service;


import com.daon.daon.dto.GateDTO;
import com.daon.daon.model.Gate;
import java.util.List;
import java.util.Optional;

public interface GateService {

  List<Gate> getAllGates();
  Optional<Gate> getGatesById(Long id);
  Gate saveGate(GateDTO gateDTO);
  void updateGate(Optional<Gate> gateData, GateDTO gateDTO);
  void deleteById(long id);
  void deleteAll();
}
