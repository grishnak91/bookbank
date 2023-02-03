package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.entity.BookAuthor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/book_author")
@OpenAPIDefinition(info = @Info(title = "Book Collection Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface BookAuthorController {
  //@formatter: off
  @Operation(
      summary = "Returns a list of Books",
      description = "Returns a list of books given an author FK",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of books is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = BookAuthor.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No author found with the search criteria",
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
              name = "author_FK", 
              allowEmptyValue = false, 
              required = false, 
              description = 
              "1: C.S. Lewis, 2: Tom Clancy, 3: Robert Ludlum, "
              + "4: Haruki Murakami, 5: Ursula Le Guinn, 6: Neil Gaiman"
              + " 7: Terry Pratchett"
              )
      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Book> fetchBookByAuthor( 
      Long authorFK);
  //@formatter: on
}
