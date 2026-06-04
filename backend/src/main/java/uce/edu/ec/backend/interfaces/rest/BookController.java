package uce.edu.ec.backend.interfaces.rest;

import uce.edu.ec.backend.application.service.BookApplicationService;
import uce.edu.ec.backend.domain.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@CrossOrigin("*")
public class BookController {

    private final BookApplicationService service;

    public BookController(BookApplicationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> get(@RequestParam(defaultValue = "") String search) {
        return service.getBooks(search);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book body) {
        return ResponseEntity.status(201)
                .body(service.create(body.getTitle(), body.getAuthor()));
    }

    @PutMapping("/{id}/borrow")
    public Book toggle(@PathVariable int id) {
        return service.toggleBorrow(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}