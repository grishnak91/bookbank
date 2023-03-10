package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.service.BookBankService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicBookAuthorController implements BookAuthorController {
  
  @Autowired
  private BookBankService bookBankService;

  @Override
  public List<Book> fetchBookByAuthor(Long authorFK) {
    log.info("fetches a list of books givevn a valid authorFK={}", authorFK);
    return bookBankService.fetchBookByAuthor(authorFK);
  }

}
