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
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/authors")
@OpenAPIDefinition(info = @Info(title = "Book Collection Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface AuthorController {
  //@formatter: off
  @Operation(
      summary = "Returns a list of authors",
      description = "Returns a list of authors.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A list of authors is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Author.class))),
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
              name = "authorName", 
              allowEmptyValue = false, 
              required = false, 
              description = "Type anything to get list of authors")
      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Author> fetchAuthors(
      @Length(max = 130)
      @Pattern(regexp = "[\\w\\s]*")
      @RequestParam(required = false) 
      String authorName);
  //@formatter: on
  
  
  // @formatter: off
  @Operation(
      summary = "Create a new Author",
      description = "Returns the created Author",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "The created author is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Author.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "404", 
              description = "an author component was not found with the input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An unplanned error occurred",
              content = @Content(mediaType = "application/json"))
      },
      parameters = {
          @Parameter(
              name = "authorName",  
              required = true, 
              description = "Title")
      }
     )
  
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  Optional<Author> addNewAuthor(
      @RequestParam(required = true)
      String authorName);
  //@formatter: on
}
