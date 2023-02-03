package com.promineotech.bookbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Readers {
  private Long readerPK;
  private String readerName;
  private Long numBooksRead;
  
  @JsonIgnore
  public Long getReaderPK() {
    return readerPK;
  }
}
