package com.daon.daon.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "gate")
public class Gate implements Serializable {

  public Gate() {}

  public Gate(Long gateNumber, String gateDescription, boolean status) {
    this.gateNumber = gateNumber;
    this.gateDescription = gateDescription;
    this.status = status;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "gate_number")
  private Long gateNumber;

  @Column(name = "gate_description")
  private String gateDescription;

  @Column(name = "status")
  private boolean status;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getGateNumber() {
    return gateNumber;
  }

  public void setGateNumber(Long gateNumber) {
    this.gateNumber = gateNumber;
  }

  public String getGateDescription() {
    return gateDescription;
  }

  public void setGateDescription(String gateDescription) {
    this.gateDescription = gateDescription;
  }

  public boolean isStatus() {
    return status;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }
}
