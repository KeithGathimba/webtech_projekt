package de.htwberlin.webtech.service;

import de.htwberlin.webtech.rest.model.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Service
public class BookService {

    public List<BookDTO> getBookEntries() {
        return List.of(new BookDTO(1, "Legend of Dragons", "Shakespeare", 2000),
                new BookDTO(2, "Haus am Hafen", "Tyson Gay", 2022),
                new BookDTO(3, "Tom und Jerry", "Tom Brady", 2012));
    }
}
