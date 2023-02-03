package com.promineotech.bookbank.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.bookbank.entity.Readers;
import com.promineotech.bookbank.service.BookBankService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicReaderController implements ReaderController {
  
  @Autowired
  private BookBankService bookBankService;

  @Override
  public List<Readers> fetchReader(Long readerPK) {
    log.info("readerPK={}", readerPK);
    return bookBankService.fetchReader(readerPK);
  }

}
