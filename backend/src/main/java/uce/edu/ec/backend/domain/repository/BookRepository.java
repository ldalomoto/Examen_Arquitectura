package uce.edu.ec.backend.domain.repository;

import uce.edu.ec.backend.domain.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    List<Book> findAll(String search);
    Optional<Book> findById(int id);
    Book save(Book book);
    void deleteById(int id);
}