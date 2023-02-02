package com.promineotech.bookbank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBookBankDao implements BookBankDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Book> fetchBook(String bookName) {
    log.debug("DAO: bookName={}", bookName);
    
    //@formatter: off
    String sql = ""
        + "SELECT * "
        + "FROM books "
        + "WHERE book_name = :book_name";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("book_name", bookName);
    
    return jdbcTemplate.query(sql, params,
        new RowMapper<>() {

          @Override
          public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
          //@formatter: off
            return Book.builder()
                .bookPK(rs.getLong("book_pk"))
                .bookName(rs.getString("book_name"))
                .numPages(rs.getInt("num_pages"))
                .notes(rs.getString("notes"))
                .build();
          //@formatter: on  
          }});
  }

  @Override
  public List<Author> fetchAuthors(String authorName) {
   //@formatter: off
   String sql = ""
       + "SELECT * "
       + "FROM authors";
   //@formatter: on
   
   Map<String, Object> params = new HashMap<>();
   params.put("author_name", authorName);
   
   return jdbcTemplate.query(sql, params,
       new RowMapper<>() {

         @Override
         public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
         //@formatter: off
           return Author.builder()
               .authorPK(rs.getLong("author_pk"))
               .authorName(rs.getString("author_name"))
               .build();
         //@formatter: on  
         }});
  }

  @Override
  public Optional<Book> addNewBook(String bookName, int numPages, String notes) {
    //@formatter: off
    String sql = ""
        + "INSERT INTO books ("
        + "book_name, num_pages, notes"
        + ") VALUES ("
        + ":book_name, :num_pages, :notes)";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("book_name", bookName);
    params.put("num_pages", numPages);
    params.put("notes", notes);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Book.builder()
        //@formatter: off
        .bookName(bookName)
        .numPages(numPages)
        .notes(notes)
        .build());
        //@formatter: on);
  }
  
}
