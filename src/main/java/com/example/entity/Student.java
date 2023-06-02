package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "student_card")
    private String studentCard;

    @Transient
    private int activeRequestsCount;

    public Integer getId() {
        return id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getStudentCard() {
        return studentCard;
    }

    public Student setStudentCard(String studentCard) {
        this.studentCard = studentCard;
        return this;
    }

    public int getActiveRequestsCount() {
        return activeRequestsCount;
    }

    public Student setActiveRequestsCount(int activeRequestsCount) {
        this.activeRequestsCount = activeRequestsCount;
        return this;
    }
}
