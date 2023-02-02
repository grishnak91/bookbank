package com.promineotech.bookbank.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;

public interface BookBankDao {

  List<Book> fetchBook(String bookName);

  List<Author> fetchAuthors(String authorName);

  Optional<Book> addNewBook(String bookName, int numPages, String notes);

}
