package com.promineotech.bookbank.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.bookbank.dao.BookBankDao;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.entity.Genre;
import com.promineotech.bookbank.entity.Readers;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultBookBankService implements BookBankService {
  
  @Autowired
  private BookBankDao bookBankDao;
  
  @Transactional(readOnly = true)
  @Override
  public List<Book> fetchBook(Long bookPK) {
    log.info("The fetchBook method was called with bookPK={}", bookPK);
    
    return bookBankDao.fetchBook(bookPK);
  }

  @Override
  public List<Author> fetchAuthors(String authorName) {
    log.info("All authors were fetched");
    return bookBankDao.fetchAuthors(authorName);
  }

  @Override
  public Optional<Book> addNewBook(String bookName, int numPages, String notes, Long readerFK) {
    log.info("addNewBook adds bookName={}, numPages={}, notes={}", bookName, numPages, notes);
    return bookBankDao.addNewBook(bookName, numPages, notes, readerFK);
  }

  @Override
  public Optional<Book> updateBook(String bookName, int numPages, String notes, Long readerFK) {
    return bookBankDao.updateBook(bookName, numPages, notes, readerFK);
  }

  @Override
  public Optional<Author> addNewAuthor(String authorName) {
    log.info("addNewAuthor adds authorName={}", authorName);
    return bookBankDao.addNewAuthor(authorName);
  }

  @Override
  public Optional<Book> deleteBook( 
      Long bookPK) {
    log.info("Deletes book via bookPK={}", bookPK);
    return bookBankDao.deleteBook(bookPK);
  }

  @Override
  public List<Genre> fetchGenre(String genreName) {
    log.info("fetches genre via genreName={}", genreName);
    return bookBankDao.fetchGenre(genreName);
  }

  @Override
  public List<Book> fetchBookByGenre(Long genreFK) {
    log.info("fetches list of books give valid genreFK={}", genreFK);
    return bookBankDao.fetchBookByGenre(genreFK);
  }

  @Override
  public List<Book> fetchBookByAuthor(Long authorFK) {
    log.info("fetches list of books given valid authorFK={}", authorFK);
    return bookBankDao.fetchBookByAuthor(authorFK);
  }

  @Override
  public List<Readers> fetchReader(Long readerPK) {
    log.info("fetches readers by valid readerPK={}", readerPK);
    return bookBankDao.fetchReader(readerPK);
  }

}
