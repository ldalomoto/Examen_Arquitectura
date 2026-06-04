package uce.edu.ec.backend.service;

import uce.edu.ec.backend.model.Book;
import uce.edu.ec.backend.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    // GET + SEARCH
    public List<Book> getBooks(String search, String filter) {

        List<Book> books = repository.findByTitleContainingIgnoreCase(search);

        if ("available".equalsIgnoreCase(filter)) {
            return books.stream()
                    .filter(b -> !b.isBorrowed())
                    .toList();
        }

        if ("borrowed".equalsIgnoreCase(filter)) {
            return books.stream()
                    .filter(Book::isBorrowed)
                    .toList();
        }

        return books;
    }

    // CREATE + VALIDATION + BUSINESS RULES
    public Book createBook(String title, String author) {

        if (title == null || title.trim().isEmpty()) {
            throw new RuntimeException("title is required");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new RuntimeException("author is required");
        }

        if (title.length() > 100) {
            throw new RuntimeException("title too long");
        }

        // duplicate rule
        boolean exists = repository.findByTitleContainingIgnoreCase(title)
                .stream()
                .anyMatch(b -> b.getTitle().equalsIgnoreCase(title.trim()));

        if (exists) {
            throw new RuntimeException("book already exists");
        }

        Book book = new Book();
        book.setTitle(title.trim());
        book.setAuthor(author.trim());
        book.setBorrowed(false);

        return repository.save(book);
    }

    // TOGGLE BORROW
    public Book toggleBorrow(int id) {

        Book book = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("book not found"));

        book.setBorrowed(!book.isBorrowed());

        return repository.save(book);
    }

    // DELETE
    public void delete(int id) {
        repository.deleteById(id);
    }
}