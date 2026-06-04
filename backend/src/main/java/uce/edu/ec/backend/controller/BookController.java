package uce.edu.ec.backend.controller;

import uce.edu.ec.backend.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getBooks(
            @RequestParam(defaultValue = "") String search,
            @RequestParam(defaultValue = "all") String filter
    ) {
        return ResponseEntity.ok(service.getBooks(search, filter));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Map<String, String> body) {
        return ResponseEntity.status(201)
                .body(service.createBook(body.get("title"), body.get("author")));
    }

    @PutMapping("/{id}/borrow")
    public ResponseEntity<?> toggle(@PathVariable int id) {
        return ResponseEntity.ok(service.toggleBorrow(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}