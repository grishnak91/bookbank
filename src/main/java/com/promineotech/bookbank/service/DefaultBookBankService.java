package com.promineotech.bookbank.service;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.bookbank.dao.BookBankDao;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookBankService implements BookBankService {
  
  @Autowired
  private BookBankDao bookBankDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Book> fetchBook(String bookName) {
    log.info("The fetchBook method was called with bookName={}", bookName);
    
    if(bookName.isEmpty()) {
      String msq = String.format("No Books were found with that title", bookName);
      
      throw new NoSuchElementException();
      }
    
    return bookBankDao.fetchBook(bookName);
  }

  @Override
  public List<Author> fetchAuthors(String authorName) {
    log.info("All authors were fetched");
    return bookBankDao.fetchAuthors(authorName);
  }

  @Override
  public Optional<Book> addNewBook(String bookName, int numPages, String notes) {
    log.info("addNewBook adds bookName={}, numPages={}, notes={}", bookName, numPages, notes);
    return bookBankDao.addNewBook(bookName, numPages, notes);
  }

}
