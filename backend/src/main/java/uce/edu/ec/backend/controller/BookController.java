package uce.edu.ec.backend.controller;

import uce.edu.ec.backend.model.Book;
import uce.edu.ec.backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Book>> getBooks(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "all") String filter
    ) {
        return ResponseEntity.ok(service.getBooks(search, filter));
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book body) {
        return ResponseEntity.status(201)
                .body(service.createBook(body.getTitle(), body.getAuthor()));
    }

    // TOGGLE BORROW
    @PutMapping("/{id}/borrow")
    public ResponseEntity<Book> toggle(@PathVariable int id) {
        return ResponseEntity.ok(service.toggleBorrow(id));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}