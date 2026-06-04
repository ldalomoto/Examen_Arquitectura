package uce.edu.ec.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class SpaghettiController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // GET
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getBooks(
            @RequestParam(required = false, defaultValue = "") String search,
            @RequestParam(required = false, defaultValue = "all") String filter
    ) {

        String sql = "SELECT * FROM books WHERE LOWER(title) LIKE ?";

        List<Map<String, Object>> books = jdbcTemplate.queryForList(
                sql,
                "%" + search.toLowerCase() + "%"
        );

        return ResponseEntity.ok(books);
    }

    // CREATE
    @PostMapping
    public ResponseEntity<?> createBook(@RequestBody Map<String, String> body) {

        String title = body.get("title");
        String author = body.get("author");

        // validación sigue aquí (espagueti intacto)

        String insert = """
            INSERT INTO books (title, author, borrowed)
            VALUES (?, ?, false)
            RETURNING id, title, author, borrowed
        """;

        Map<String, Object> newBook = jdbcTemplate.queryForMap(
                insert,
                title,
                author
        );

        return ResponseEntity.status(201).body(newBook);
    }

    // TOGGLE BORROW
    @PutMapping("/{id}/borrow")
    public ResponseEntity<?> toggleBorrow(@PathVariable int id) {

        String sql = """
            UPDATE books
            SET borrowed = NOT borrowed
            WHERE id = ?
            RETURNING *
        """;

        Map<String, Object> updated = jdbcTemplate.queryForMap(sql, id);
        return ResponseEntity.ok(updated);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {

        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
        return ResponseEntity.ok("Deleted successfully");
    }
}