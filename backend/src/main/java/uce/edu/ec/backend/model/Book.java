package uce.edu.ec.backend.model;

public class Book {
    private Integer id;
    private String title;
    private String author;
    private boolean borrowed;

    public Book() {}

    public Book(Integer id, String title, String author, boolean borrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
    }

    // getters y setters
}