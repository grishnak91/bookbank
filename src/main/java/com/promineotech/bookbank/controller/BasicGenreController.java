package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bookbank.entity.Genre;
import com.promineotech.bookbank.service.BookBankService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicGenreController implements GenreController {
  
  @Autowired
  private BookBankService bookBankService;

  @Override
  public List<Genre> fetchGenre(String genreName) {
    log.info("fetches a genre via genreName={}", genreName);
    return bookBankService.fetchGenre(genreName);
  }

}
