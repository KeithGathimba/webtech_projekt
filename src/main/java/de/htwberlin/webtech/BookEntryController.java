package de.htwberlin.webtech;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookEntryController {
    @GetMapping
    public List<BookEntry> getBookEntries() {
  return List.of(new BookEntry("Legend of Dragons", "Shakespeare", 2000), new BookEntry("Haus am Hafen", "Tyson Gay", 2022), new BookEntry("Tom und Jerry", "Tom Brady", 2012));
    }
}
