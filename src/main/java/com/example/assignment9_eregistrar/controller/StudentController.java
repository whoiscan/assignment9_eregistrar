package com.example.assignment9_eregistrar.controller;

import com.example.assignment9_eregistrar.model.Student;
import com.example.assignment9_eregistrar.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/signup")
    public String signUp(Student student) {
        return "create-new-student";
    }

    @PostMapping("/add-student")
    public String addNewStudent(Student student, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            studentRepository.save(student);
            return "redirect:/";
        }
        return "create-new-student";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new Exception("Invalid user Id:" + id));
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PutMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") long id, Student student, BindingResult result, Model model) {
        if (!result.hasErrors()) {
            student.setStudentId(id);
            studentRepository.save(student);
            return "redirect:/";
        }
        student.setStudentId(id);
        return "edit-student";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(() -> new Exception("Invalid user Id:" + id));
        studentRepository.delete(student);
        return "redirect:/";
    }
}
