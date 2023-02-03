package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bookbank.entity.Genre;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/genres")
@OpenAPIDefinition(info = @Info(title = "Book Collection Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface GenreController {
  
  //@formatter: off
  @Operation(
      summary = "Returns a Genre",
      description = "Returns a genre given a genreName.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A genre is returned",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = Genre.class))),
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
              name = "genrePK", 
              allowEmptyValue = false, 
              required = false, 
              description = "1-10")
      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Genre> fetchGenre( 
      Long genrePK);
  //@formatter: on
}
