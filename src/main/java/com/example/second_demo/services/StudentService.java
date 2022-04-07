package com.example.second_demo.services;
import com.example.second_demo.repositories.StudentRepository;
import com.example.second_demo.entities.Student;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Data
@Getter
@Setter
@Component
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();

    }

    public void addNewStudent(Student student) {

//        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
//
//        if (studentOptional.isPresent()){
//            throw new IllegalStateException("Email Taken");
//        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }


    @Transactional
    public void updateStudent(Long studentId, String name, String email){

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "entities with id" + studentId + "does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)){
            student.setName(name);

        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)){
            Optional<Student> studentOptional = studentRepository
                    .findStudentByEmail(email);
            if (studentOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            student.setEmail(email);
        }

    }
}
