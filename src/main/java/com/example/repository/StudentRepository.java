package com.example.repository;

import com.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("""
            select s from Student s
            where s.firstName like %:keyword% 
            or s.lastName like %:keyword%
            """)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
