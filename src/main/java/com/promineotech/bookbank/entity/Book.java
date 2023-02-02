package com.promineotech.bookbank.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
  private Long bookPK;
  public String bookName;
  public int numPages;
  public String notes;
  
  @JsonIgnore
  public Long getBookPK() {
    return bookPK;
  }
}