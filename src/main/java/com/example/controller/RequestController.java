package com.example.controller;


import com.example.entity.Book;
import com.example.entity.Request;
import com.example.repository.BookRepository;
import com.example.repository.RequestRepository;
import com.example.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Instant;

@Controller
@RequestMapping("/requests")
public class RequestController {

    private final RequestRepository requestRepository;
    private final StudentRepository studentRepository;
    private final BookRepository bookRepository;

    public RequestController(RequestRepository requestRepository, StudentRepository studentRepository, BookRepository bookRepository) {
        this.requestRepository = requestRepository;
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String showRequestsList(Model model) {
        model.addAttribute("requests", requestRepository.findAll());
        return "request/requests-list";
    }

    @GetMapping("/add")
    public String showAddRequestForm(Model model) {
        model.addAttribute("request", new Request());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("books", bookRepository.findBooksByAvailableTrue());
        return "request/request-add";
    }

    @PostMapping("/add")
    public String addRequest(Request request) {
        Book book = bookRepository.findById(request.getBookId()).orElseThrow();
        requestRepository.save(request
                .setBook(book)
                .setStudent(studentRepository.findById(request.getStudentId()).orElseThrow()));
        bookRepository.save(book.setAvailable(false));
        return "redirect:/requests";
    }

    @GetMapping("/close/{id}")
    public String showEditRequestForm(@PathVariable("id") Integer id) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request Id:" + id));
        request.setReturnedDate(Instant.now());
        requestRepository.save(request);
        bookRepository.save(request.getBook().setAvailable(true));
        return "redirect:/requests";
    }

    @GetMapping("/delete/{id}")
    public String deleteRequest(@PathVariable("id") Integer id) {
        Request request = requestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid request Id:" + id));
        requestRepository.delete(request);
        return "redirect:/requests";
    }
}

