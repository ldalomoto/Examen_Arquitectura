package uce.edu.ec.backend.domain.model;

public class Book {

    private Integer id;
    private String title;
    private String author;
    private boolean borrowed;

    public Book(Integer id, String title, String author, boolean borrowed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.borrowed = borrowed;
    }

    public void toggleBorrow() {
        this.borrowed = !this.borrowed;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
}