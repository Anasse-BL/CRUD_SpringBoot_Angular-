package com.example.second_demo.controller;


import com.example.second_demo.services.StudentService;
import com.example.second_demo.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "api/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping(path = "/all")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "/add")
    public void NewStudent(@RequestBody Student student){
         studentService.addNewStudent(student);
    }


    @DeleteMapping(path = "/delete/{studentId}")
    public void DeleteStudent(@PathVariable ("studentId") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "update/{studentId}")
    public void UpdateStudent(
            @PathVariable ("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){

        studentService.updateStudent(studentId, name, email);

    }


}