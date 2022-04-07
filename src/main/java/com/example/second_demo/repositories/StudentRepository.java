package com.example.second_demo.repositories;

import com.example.second_demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {


    @Query("SELECT s FROM Student s WHERE s.email=?2")
    Optional<Student> findStudentByEmail(String email);
}
