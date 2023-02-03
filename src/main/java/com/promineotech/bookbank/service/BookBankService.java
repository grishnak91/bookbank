package com.promineotech.bookbank.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.entity.Genre;
import com.promineotech.bookbank.entity.Readers;

public interface BookBankService {

  List<Book> fetchBook(Long bookPK);

  List<Author> fetchAuthors(String authorName);

  Optional<Book> addNewBook(String bookName, int numPages, String notes, Long readerFK);

  Optional<Book> updateBook(String bookName, int numPages, String notes, Long readerFK);

  Optional<Author> addNewAuthor(String authorName);

  Optional<Book> deleteBook(Long bookPK);

  List<Genre> fetchGenre(Long genrePK);

  List<Book> fetchBookByGenre(Long genreFK);

  List<Book> fetchBookByAuthor(Long authorFK);

  List<Readers> fetchReader(Long readerPK); 

}
