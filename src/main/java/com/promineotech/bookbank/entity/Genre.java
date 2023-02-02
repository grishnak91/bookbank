package com.promineotech.bookbank.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Genre {
  private Long genrePK;
  private String genreName;
}
