package com.promineotech.bookbank.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookGenre {
  private Long bookFK;
  private Long genreFK;
}
