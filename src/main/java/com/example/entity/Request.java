package com.example.entity;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "request")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "creating_date")
    private Instant creatingDate;

    @Column(name = "returned_date")
    private Instant returnedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Transient
    private Integer studentId;

    @Transient
    private Integer bookId;

    public Request() {
        this.creatingDate = Instant.now();
    }

    public Integer getId() {
        return id;
    }

    public Request setId(Integer id) {
        this.id = id;
        return this;
    }

    public Instant getCreatingDate() {
        return creatingDate;
    }

    public Request setCreatingDate(Instant creatingDate) {
        this.creatingDate = creatingDate;
        return this;
    }

    public Instant getReturnedDate() {
        return returnedDate;
    }

    public Request setReturnedDate(Instant returnedDate) {
        this.returnedDate = returnedDate;
        return this;
    }

    public Book getBook() {
        return book;
    }

    public Request setBook(Book book) {
        this.book = book;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Request setStudent(Student student) {
        this.student = student;
        return this;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public Request setStudentId(Integer studentId) {
        this.studentId = studentId;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Request setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }
}
