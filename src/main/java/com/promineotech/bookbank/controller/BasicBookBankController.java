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
  public List<Book> fetchBook(Long bookPK) {
    log.info("bookPK={}", bookPK);
    return bookBankService.fetchBook(bookPK);
  }
  
  @Override
  public Optional<Book> addNewBook(String bookName, int numPages, String notes, Long readerFK) {
    log.info("New bookName={}, numPages={}, notes={}, readerFK={}", 
        bookName, numPages, notes);
    return bookBankService.addNewBook(bookName, numPages, notes, readerFK);
  }

  @Override
  public Optional<Book> updateBook(String bookName, int numPages, String notes, Long readerFK) {
    
    return bookBankService.updateBook(bookName, numPages, notes, readerFK);
  }

  @Override
  public Optional<Book> deleteBook( 
      Long bookPK) {
    log.info("Deletes book via bookPK={}", 
        bookPK);
    return bookBankService.deleteBook(bookPK);
  }

}
