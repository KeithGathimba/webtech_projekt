package de.htwberlin.webtech.service;

import de.htwberlin.webtech.persistence.BookEntity;
import de.htwberlin.webtech.persistence.BookRepository;
import de.htwberlin.webtech.rest.model.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getBookEntries() {
        List<BookEntity> books = bookRepository.findAll();
        return books.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public BookEntity createBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity(
                bookDTO.title(),
                bookDTO.author(),
                bookDTO.releaseYear()
        );
        return bookRepository.save(bookEntity);
    }

    private BookDTO transformEntity(BookEntity bookEntity) {
        return new BookDTO(
                bookEntity.getId().intValue(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getReleaseYear()
        );
    }
}