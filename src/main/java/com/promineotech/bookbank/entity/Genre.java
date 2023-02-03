package com.promineotech.bookbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Genre {
  private Long genrePK;
  private String genreName;
  
  @JsonIgnore
  public Long getGenrePK() {
    return genrePK;
  }
}
