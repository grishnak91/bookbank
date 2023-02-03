package com.promineotech.bookbank.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookAuthor {
  private Book bookFK;
  private Author authorFK;
}
