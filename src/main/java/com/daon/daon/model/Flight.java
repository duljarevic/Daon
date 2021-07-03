package com.daon.daon.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "flight")
public class Flight implements Serializable {

  public Flight() {}

  public Flight(Long flightNumber, String flightDescription, Gate gate) {
    this.flightNumber = flightNumber;
    this.flightDescription = flightDescription;
    this.gate = gate;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "flight_number")
  private Long flightNumber;

  @Column(name = "flight_description")
  private String flightDescription;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "flight_date_time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
  public Date flightDateTime = new Date();


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "gate_id", referencedColumnName = "id")
  private Gate gate;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFlightNumber() {
    return flightNumber;
  }

  public void setFlightNumber(Long flightNumber) {
    this.flightNumber = flightNumber;
  }

  public String getFlightDescription() {
    return flightDescription;
  }

  public void setFlightDescription(String flightDescription) {
    this.flightDescription = flightDescription;
  }

  public Date getFlightDateTime() {
    return flightDateTime;
  }

  public void setFlightDateTime(Date flightDateTime) {
    this.flightDateTime = flightDateTime;
  }

  public Gate getGate() {
    return gate;
  }

  public void setGate(Gate gate) {
    this.gate = gate;
  }
}
