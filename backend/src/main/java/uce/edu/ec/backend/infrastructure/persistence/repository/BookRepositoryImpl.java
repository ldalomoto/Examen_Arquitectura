package uce.edu.ec.backend.infrastructure.persistence.repository;

import uce.edu.ec.backend.domain.model.Book;
import uce.edu.ec.backend.domain.repository.BookRepository;
import uce.edu.ec.backend.infrastructure.persistence.mapper.BookMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final SpringBookRepository jpa;

    public BookRepositoryImpl(SpringBookRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public List<Book> findAll(String search) {
        return jpa.findByTitleContainingIgnoreCase(search)
                .stream()
                .map(BookMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> findById(int id) {
        return jpa.findById(id).map(BookMapper::toDomain);
    }

    @Override
    public Book save(Book book) {
        var saved = jpa.save(BookMapper.toEntity(book));
        return BookMapper.toDomain(saved);
    }

    @Override
    public void deleteById(int id) {
        jpa.deleteById(id);
    }
}