package com.promineotech.bookbank.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
  private Long authorPK;
  private String authorName;
}
