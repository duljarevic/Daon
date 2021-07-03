package com.daon.daon.dto;

import java.sql.Date;
import lombok.Data;


@Data
public class GateDTO {

  private Long id;
  private Long gateNumber;
  private String gateDescription;
  private boolean status;
}
