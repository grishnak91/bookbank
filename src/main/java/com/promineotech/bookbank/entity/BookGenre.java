package com.promineotech.bookbank.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookGenre {
  private Book bookPK;
  private Genre genrePK;
}
