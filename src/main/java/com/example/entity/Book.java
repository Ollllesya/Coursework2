package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_publication")
    private Integer yearOfPublication;

    @Column(name = "author")
    private String author;

    @Column(name = "available")
    private Boolean available;

    public Book() {
        this.available = true;
    }

    public Integer getId() {
        return id;
    }

    public Book setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public Book setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public Boolean getAvailable() {
        return available;
    }

    public Book setAvailable(Boolean available) {
        this.available = available;
        return this;
    }
}
