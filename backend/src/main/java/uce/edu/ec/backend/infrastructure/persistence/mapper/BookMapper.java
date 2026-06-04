package uce.edu.ec.backend.infrastructure.persistence.mapper;

import uce.edu.ec.backend.domain.model.Book;
import uce.edu.ec.backend.infrastructure.persistence.entity.BookEntity;

public class BookMapper {

    public static Book toDomain(BookEntity e) {
        return new Book(e.getId(), e.getTitle(), e.getAuthor(), e.isBorrowed());
    }

    public static BookEntity toEntity(Book b) {
        BookEntity e = new BookEntity();
        e.setId(b.getId());
        e.setTitle(b.getTitle());
        e.setAuthor(b.getAuthor());
        e.setBorrowed(b.isBorrowed());
        return e;
    }
}