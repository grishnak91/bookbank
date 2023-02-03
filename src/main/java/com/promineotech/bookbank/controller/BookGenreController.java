package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.entity.BookGenre;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/book_genre")
@OpenAPIDefinition(info = @Info(title = "Book Collection Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface BookGenreController {
  //@formatter: off
  @Operation(
      summary = "Returns a list of Books",
      description = "Returns a list of books given a genre FK",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of books is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = BookGenre.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameter is invalid",
              content = @Content(
                  mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "No genre found with the search criteria",
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
              name = "genre_FK", 
              allowEmptyValue = false, 
              required = false, 
              description = 
              "1: Fiction, 2: Non-Fiction, 3: Thriller, 4: Espionage, 5: Sci-Fi, "
              + "6: Fantasy, 7: Adventure, 8: Psychological Thriller, 9: Mind-Bender, 10: Drama"
              )
      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Book> fetchBookByGenre( 
      Long genreFK);
  //@formatter: on
}
