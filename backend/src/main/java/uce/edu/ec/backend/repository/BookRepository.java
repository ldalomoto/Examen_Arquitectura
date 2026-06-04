package uce.edu.ec.backend.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> findAll(String search) {
        return jdbcTemplate.queryForList(
                "SELECT * FROM books WHERE LOWER(title) LIKE ?",
                "%" + search.toLowerCase() + "%"
        );
    }

    public Map<String, Object> save(String title, String author) {
        return jdbcTemplate.queryForMap("""
            INSERT INTO books (title, author, borrowed)
            VALUES (?, ?, false)
            RETURNING *
        """, title, author);
    }

    public Map<String, Object> toggleBorrow(int id) {
        return jdbcTemplate.queryForMap("""
            UPDATE books
            SET borrowed = NOT borrowed
            WHERE id = ?
            RETURNING *
        """, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM books WHERE id = ?", id);
    }
}