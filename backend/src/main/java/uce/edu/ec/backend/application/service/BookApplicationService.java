package uce.edu.ec.backend.application.service;

import uce.edu.ec.backend.domain.model.Book;
import uce.edu.ec.backend.domain.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookApplicationService {

    private final BookRepository repository;

    public BookApplicationService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getBooks(String search) {
        return repository.findAll(search);
    }

    public Book create(String title, String author) {

        if (title == null || title.isBlank()) {
            throw new RuntimeException("title required");
        }

        if (author == null || author.isBlank()) {
            throw new RuntimeException("author required");
        }

        Book book = new Book(null, title, author, false);
        return repository.save(book);
    }

    public Book toggleBorrow(int id) {
        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));

        book.toggleBorrow();

        return repository.save(book);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}