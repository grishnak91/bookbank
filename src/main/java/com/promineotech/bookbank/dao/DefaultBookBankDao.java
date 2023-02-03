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
import com.promineotech.bookbank.entity.Genre;
import com.promineotech.bookbank.entity.Readers;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultBookBankDao implements BookBankDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;

  @Override
  public List<Book> fetchBook(Long bookPK) {
    log.debug("DAO: bookPK={}", bookPK);
    
    //@formatter: off
    String sql = ""
        + "SELECT * "
        + "FROM books "
        + "WHERE book_pk = :book_pk";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("book_pk", bookPK);
    
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
                .readerFK(rs.getLong("reader_fk"))
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
  public Optional<Book> addNewBook(String bookName, int numPages, String notes, Long readerFK) {
    //@formatter: off
    String sql = ""
        + "INSERT INTO books ("
        + "book_name, num_pages, notes, reader_fk"
        + ") VALUES ("
        + ":book_name, :num_pages, :notes, :reader_fk)";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("book_name", bookName);
    params.put("num_pages", numPages);
    params.put("notes", notes);
    params.put("reader_fk", readerFK);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Book.builder()
        //@formatter: off
        .bookName(bookName)
        .numPages(numPages)
        .notes(notes)
        .readerFK(readerFK)
        .build());
        //@formatter: on);
  }

  @Override
  public Optional<Book> updateBook(String bookName, int numPages, String notes, Long readerFK) {
    //@formatter: off
    String sql = ""
        + "UPDATE books "
        + "SET book_name = :book_name, num_pages = :num_pages, notes = :notes "
        + "WHERE (book_name = :book_name)";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("book_name", bookName);
    params.put("num_pages", numPages);
    params.put("notes", notes);
    params.put("reader_fk", readerFK);
    
    jdbcTemplate.update(sql, params);
    return Optional.ofNullable(Book.builder()
        //@formatter:off
        .bookName(bookName)
        .numPages(numPages)
        .notes(notes)
        .readerFK(readerFK)
        .build());
        //@formatter: on
  }

  @Override
  public Optional<Author> addNewAuthor(String authorName) {
      //@formatter: off
      String sql = ""
          + "INSERT INTO authors ("
          + "author_name"
          + ") VALUES ("
          + ":author_name)";
      //@formatter: on
      
      Map<String, Object> params = new HashMap<>();
      params.put("author_name", authorName);
      
      jdbcTemplate.update(sql, params);
      return Optional.ofNullable(Author.builder()
          //@formatter: off
          .authorName(authorName)
          .build());
          //@formatter: on);
    }

  @Override
  public Optional<Book> deleteBook( 
      Long bookPK) {
    //formatter: off
    String sql = ""
        + "DELETE FROM books "
        + "WHERE book_pk = :book_pk";
    //formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("book_pk", bookPK);
    
    jdbcTemplate.update(sql, params);
    
    return Optional.ofNullable(Book.builder()
        //@formatter: off
        .bookPK(bookPK)
        .build());
        //formatter: on
  }

  @Override
  public List<Genre> fetchGenre(Long genrePK) {
    
    //@formatter: off
    String sql = ""
        + "SELECT * "
        + "FROM genres "
        + "WHERE genre_pk = :genre_pk";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("genre_pk", genrePK);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
      //@formatter: off
        return Genre.builder()
            .genrePK(rs.getLong("genre_pk"))
            .genreName(rs.getString("genre_name"))
            .build();
      //@formatter: on  
      }});
  
    }

  @Override
  public List<Book> fetchBookByGenre(Long genreFK) {
    log.info("fetches list of books given valid genrePK={}", genreFK);
    
    //@formatter: off
    String sql = ""
        + "SELECT DISTINCT book_pk, book_name, num_pages, notes, reader_fk "
        + "FROM books "
        + "JOIN book_genre ON book_genre.book_fk = books.book_pk "
        + "JOIN genres ON book_genre.genre_fk = genres.genre_pk "
        + "WHERE book_genre.genre_fk = :genre_fk";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("genre_fk", genreFK);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter: off
        return Book.builder()
            .bookName(rs.getString("book_name"))
            .numPages(rs.getInt("num_pages"))
            .notes(rs.getString("notes"))
            .readerFK(rs.getLong("reader_fk"))
            .build();
        //@formatter: on
      }
      
    });
  }

  @Override
  public List<Book> fetchBookByAuthor(Long authorFK) {
    log.info("fetches list of books given valid authorPK={}", authorFK);
    
    //@formatter: off
    String sql = ""
        + "SELECT DISTINCT book_pk, book_name, num_pages, notes, reader_fk "
        + "FROM books "
        + "JOIN book_author ON book_author.book_fk = books.book_pk "
        + "JOIN authors ON book_author.author_fk = authors.author_pk "
        + "WHERE book_author.author_fk = :author_fk";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("author_fk", authorFK);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter: off
        return Book.builder()
            .bookName(rs.getString("book_name"))
            .numPages(rs.getInt("num_pages"))
            .notes(rs.getString("notes"))
            .readerFK(rs.getLong("reader_fk"))
            .build();
        //@formatter: on
      }
      
    });
    
  }

  @Override
  public List<Readers> fetchReader(Long readerPK) {
    log.info("fetches readers by valid readerPK={}", readerPK);
    
    //@formatter: off
    String sql = ""
        + "SELECT * "
        + "FROM readers "
        + "WHERE reader_pk = :reader_pk";
    //@formatter: on
    
    Map<String, Object> params = new HashMap<>();
    params.put("reader_pk", readerPK);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Readers mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter: off
        return Readers.builder()
            .readerName(rs.getString("reader_name"))
            .numBooksRead(rs.getLong("num_books_read"))
            .build();
        //@formatter: on
      }
    });
  }
  }
  
