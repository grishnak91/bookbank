package com.promineotech.bookbank.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bookbank.entity.Author;
import com.promineotech.bookbank.entity.Book;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/books")
@OpenAPIDefinition(info = @Info(title = "Book Collection Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface BookBankController {
  //@formatter: off
  @Operation(
      summary = "Returns a Book",
      description = "Returns a book given a Title.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A book is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Book.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No book found with the search criteria",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(
                  mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "bookName", 
              allowEmptyValue = false, 
              required = false, 
              description = "The book Title (i.e., 'The Lion, The Witch, and The Wardrobe')")
      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Book> fetchBook(
      @Length(max = 130)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) 
      String bookName);
  //@formatter: on
  
  
  // @formatter: off
  @Operation(
      summary = "Create a new book",
      description = "Returns the created book",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "The created book is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Book.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "a book component was not found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "bookName",  
              required = true, 
              description = "Title"),
          @Parameter(
              name = "number of pages",
              required = true,
              description = "number of pages"),
          @Parameter(
              name = "notes",
              required = false,
              description = "optional sysnopsis")
      }
     )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Book> addNewBook(
      @RequestParam(required = true)
      String bookName,
      @RequestParam(required = true)
      int numPages,
      @RequestParam(required = true)
      String notes);
  //@formatter: on

}
