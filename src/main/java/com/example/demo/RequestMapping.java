package com.example.demo;

import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RequestMapping {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody() Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("added student", HttpStatus.ACCEPTED);
    }
    @GetMapping("/find By name")
        public ResponseEntity<Student> findByName(@RequestParam("name") String name){
           Student student = studentService.findByName(name);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
}

