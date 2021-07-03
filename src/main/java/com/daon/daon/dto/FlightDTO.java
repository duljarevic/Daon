package com.daon.daon.dto;

import com.daon.daon.model.Gate;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;


@Data
public class FlightDTO {

  private Long id;
  private Long flightNumber;
  private String flightDescription;
  public Date flightDateTime;
  private Gate gate;
}
