package com.Example.StudentManagement1.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Example.StudentManagement1.Entity.Students;
import com.Example.StudentManagement1.Service.StudentService;

@RestController
@CrossOrigin
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

   
    @PostMapping
    public Students addStudent(@RequestBody Students student) {
        return studentService.addStudent(student);
    }

  
    @GetMapping
    public ResponseEntity<List<Students>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<Students> getStudentById(
            @PathVariable("id") Long id) {

        Students student = studentService.getStudentById(id);

        if (student != null) {
            return ResponseEntity.ok(student);
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Students> updateStudent(
            @PathVariable("id") Long id,
            @RequestBody Students student) {

        Students updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }

        return ResponseEntity.notFound().build();
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(
            @PathVariable("id") Long id) {

        String message = studentService.deleteStudent(id);

        if (message.equals("Student deleted successfully")) {
            return ResponseEntity.ok(message);
        }

        return ResponseEntity.notFound().build();
    }
}

