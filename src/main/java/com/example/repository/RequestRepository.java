package com.example.repository;

import com.example.entity.Request;
import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {

    @Query(value = """
            SELECT r FROM Request r LEFT JOIN FETCH r.book LEFT JOIN FETCH r.student
            """
    )
    List<Request> findAll();

    int countRequestByStudentAndReturnedDateIsNull(Student student);
}
