package com.promineotech.bookbank.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.service.BookBankService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicBookBankController implements BookBankController {
  
  @Autowired
  private BookBankService bookBankService;

  @Override
  public List<Book> fetchBook(String bookName) {
    log.info("bookName={}", bookName);
    return bookBankService.fetchBook(bookName);
  }
  
  @Override
  public Optional<Book> addNewBook(String bookName, int numPages, String notes) {
    log.info("New bookName={}, numPages={}, notes={}", bookName, numPages, notes);
    return bookBankService.addNewBook(bookName, numPages, notes);
  }

}
