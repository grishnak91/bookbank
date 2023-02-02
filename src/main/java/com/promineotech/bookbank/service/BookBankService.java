package com.promineotech.bookbank.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;

public interface BookBankService {

  List<Book> fetchBook(String bookName);

  List<Author> fetchAuthors(String authorName);

  Optional<Book> addNewBook(String bookName, int numPages, String notes);

}
