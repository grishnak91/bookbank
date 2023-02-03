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
  public List<Genre> fetchGenre(Long genrePK) {
    log.info("fetches a genre via genrePK={}", genrePK);
    return bookBankService.fetchGenre(genrePK);
  }

}
