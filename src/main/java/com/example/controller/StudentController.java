package com.example.controller;


import com.example.entity.Student;
import com.example.repository.RequestRepository;
import com.example.repository.StudentRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final RequestRepository requestRepository;

    public StudentController(StudentRepository studentRepository, RequestRepository requestRepository) {
        this.studentRepository = studentRepository;
        this.requestRepository = requestRepository;
    }

    @GetMapping
    public String showStudentsList(Model model, @Param("keyword") String keyword) {
        List<Student> studentList;

        if (keyword == null) {
            studentList = studentRepository.findAll().stream().map(
                    s -> s.setActiveRequestsCount(requestRepository.countRequestByStudentAndReturnedDateIsNull(s))
            ).toList();
        } else {
            studentList = studentRepository.findByKeyword(keyword).stream().map(
                    s -> s.setActiveRequestsCount(requestRepository.countRequestByStudentAndReturnedDateIsNull(s))
            ).toList();
        }

        model.addAttribute("students", studentList);
        return "student/students-list";
    }

    @GetMapping("/add")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student/student-add";
    }

    @PostMapping("/add")
    public String addStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable("id") Integer id, Model model) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("student", student);
        return "student/edit-student";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        studentRepository.delete(student);
        return "redirect:/students";
    }
}
