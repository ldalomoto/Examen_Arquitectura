package uce.edu.ec.backend.infrastructure.persistence.repository;

import uce.edu.ec.backend.infrastructure.persistence.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringBookRepository extends JpaRepository<BookEntity, Integer> {
    List<BookEntity> findByTitleContainingIgnoreCase(String title);
}