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
        return bookRepository.findAll().stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public BookEntity createBook(BookDTO bookDTO) {
        BookEntity bookEntity = new BookEntity(
                bookDTO.title(),
                bookDTO.author(),
                bookDTO.releaseYear(),
                bookDTO.status()
        );
        return bookRepository.save(bookEntity);
    }

    public BookEntity updateBook(Long id, BookDTO bookDTO) {
        BookEntity bookEntity = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Buch nicht gefunden mit ID: " + id));

        bookEntity.setTitle(bookDTO.title());
        bookEntity.setAuthor(bookDTO.author());
        bookEntity.setReleaseYear(bookDTO.releaseYear());
        bookEntity.setStatus(bookDTO.status());
        return bookRepository.save(bookEntity);
    }

    public boolean deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private BookDTO transformEntity(BookEntity bookEntity) {
        return new BookDTO(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getReleaseYear(),
                bookEntity.getStatus()
        );
    }
}