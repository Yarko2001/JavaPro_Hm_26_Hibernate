package com.example.javapro_hm_26_hibernate;

import com.example.javapro_hm_26_hibernate.dto.DtoStudent;
import com.example.javapro_hm_26_hibernate.enums.Status;
import com.example.javapro_hm_26_hibernate.service.StudentService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@SpringBootApplication
public class JavaProHm26HibernateApplication {

  private final StudentService studentService;

  @Autowired
  public JavaProHm26HibernateApplication(
      StudentService studentService) {
    this.studentService = studentService;
  }

  public static void main(String[] args) {
    SpringApplication.run(JavaProHm26HibernateApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void init() {
    studentService.removeAll();

    var firstDtoStudent = new DtoStudent(null, "Henry", "henry_ford@gmail.com");
    firstDtoStudent = studentService.createStudent(firstDtoStudent);
    studentService.addMark(firstDtoStudent.getId(), "Biology", Status.FAILURE);
    studentService.addMark(firstDtoStudent.getId(), "English", Status.BAD);
    studentService.addMark(firstDtoStudent.getId(), "Math", Status.EXCELLENT);

    var secondDtoStudent = new DtoStudent(null, "William", "william1998@gmail.com");
    secondDtoStudent = studentService.createStudent(secondDtoStudent);
    studentService.addMark(secondDtoStudent.getId(), "Biology", Status.EXCELLENT);
    studentService.addMark(secondDtoStudent.getId(), "English", Status.FAILURE);
    studentService.addMark(secondDtoStudent.getId(), "Math", Status.GOOD);

    var thirdDtoStudent = new DtoStudent(null, "Sergio", "sergio_ramos@gmail.com");
    thirdDtoStudent = studentService.createStudent(thirdDtoStudent);
    studentService.addMark(thirdDtoStudent.getId(), "Biology", Status.GOOD);
    studentService.addMark(thirdDtoStudent.getId(), "English", Status.EXCELLENT);
    studentService.addMark(thirdDtoStudent.getId(), "Math", Status.EXCELLENT);

    var fourthDtoStudent = new DtoStudent(null, "Mishael", "mishael2001@gmail.com");
    fourthDtoStudent = studentService.createStudent(fourthDtoStudent);
    studentService.addMark(fourthDtoStudent.getId(), "Biology", Status.GOOD);
    studentService.addMark(fourthDtoStudent.getId(), "English", Status.EXCELLENT);
    studentService.addMark(fourthDtoStudent.getId(), "Math", Status.EXCELLENT);

    log.info(studentService.getAll().toString());

    log.info(studentService.findById(thirdDtoStudent.getId()).toString());

    log.info("{}: {}", "Deleting student with ID", secondDtoStudent.getId());
    studentService.deleteById(secondDtoStudent.getId());

    studentService.updateFieldByID(thirdDtoStudent.getId(), "email", "777@hotmail");

    List<DtoStudent> henry = studentService.findByName("Henry");
    log.info(henry.toString());


  }
}
