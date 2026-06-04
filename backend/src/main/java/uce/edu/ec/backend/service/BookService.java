package uce.edu.ec.backend.service;

import uce.edu.ec.backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, Object>> getBooks(String search, String filter) {
        return repository.findAll(search);
    }

    public Map<String, Object> createBook(String title, String author) {

        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("title required");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new RuntimeException("author required");
        }

        return repository.save(title, author);
    }

    public Map<String, Object> toggleBorrow(int id) {
        return repository.toggleBorrow(id);
    }

    public void delete(int id) {
        repository.delete(id);
    }
}