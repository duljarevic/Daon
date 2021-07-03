package com.daon.daon.repository;

import com.daon.daon.model.Flight;
import com.daon.daon.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {

}
