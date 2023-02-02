package com.promineotech.bookbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class BookbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookbankApplication.class, args);
	}

}
