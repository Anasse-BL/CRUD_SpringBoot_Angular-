package com.example.second_demo.configuration;

import com.example.second_demo.repositories.StudentRepository;
import com.example.second_demo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;


@Configuration
public class StudentConfig {


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

                     Student student =  new Student(
                        1L,
                        "Anasse",
                        LocalDate.now(),
                        //LocalDate.of(2022, Month.MARCH,21),
                        "baalianasse@gmail.com",
                        24
                );

                     Student student2 =  new Student(
                       2L,
                       "Laila",
                        LocalDate.now(),
                      //LocalDate.of(2022, Month.MARCH,21),
                       "baalilaila@gmail.com",
                       29
            );

                repository.saveAll(
                    List.of(student,student2)
                );
        };




    }
}
