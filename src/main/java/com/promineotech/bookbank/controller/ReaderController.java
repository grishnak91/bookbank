package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.bookbank.entity.Book;
import com.promineotech.bookbank.entity.Readers;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/readers")
@OpenAPIDefinition(info = @Info(title = "Book Collection Service"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server.")})
public interface ReaderController {
  //@formatter: off
  @Operation(
      summary = "Returns a reader",
      description = "Returns a reader given a readerPK.",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "A reader is returned",
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
              description = "No reader found with the search criteria",
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
              name = "readers", 
              allowEmptyValue = false, 
              required = false, 
              description = "1: Jordan, 2: Oscar, 3: Casey")
      }
      )
  
  @GetMapping
  @ResponseStatus(code = HttpStatus.OK)
  List<Readers> fetchReader( 
      Long readerPK);
  //@formatter: on
}

