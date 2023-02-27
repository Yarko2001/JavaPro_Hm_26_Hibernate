package com.example.javapro_hm_26_hibernate.service;

import com.example.javapro_hm_26_hibernate.dto.DtoStudent;
import com.example.javapro_hm_26_hibernate.enums.Status;
import com.example.javapro_hm_26_hibernate.model.Mark;
import com.example.javapro_hm_26_hibernate.model.Student;
import com.example.javapro_hm_26_hibernate.repository.MarkRepository;
import com.example.javapro_hm_26_hibernate.repository.StudentJpaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentJpaRepository studentJpaRepository;
  private final ObjectMapper objectMapper;
  private final MarkRepository markRepository;

  public DtoStudent createStudent(DtoStudent studentDto) {
    Student student = objectMapper.convertValue(studentDto, Student.class);
    studentJpaRepository.add(student);
    studentDto.setId(student.getId());
    return studentDto;
  }

  public DtoStudent addMark(int studentId, String discipline, Status status) {
    var markAdd = new Mark();
    markAdd.setDiscipline(discipline);
    markAdd.setStatus(status);
    Student student = studentJpaRepository.findById(studentId);
    markAdd.setStudent(student);
    markRepository.save(markAdd);
    return objectMapper.convertValue(student, DtoStudent.class);
  }

  public void deleteById(int id){
    studentJpaRepository.deleteById(id);
  }

  public void removeAll() {
    studentJpaRepository.removeAll();
  }

  public List<DtoStudent> getAll() {
    List<DtoStudent> resultList = new ArrayList<>();
    var queryList = studentJpaRepository.getAll();
    for (Student student : queryList) {
      resultList.add(objectMapper.convertValue(student, DtoStudent.class));
    }
    return resultList;
  }

  public DtoStudent findById(int id) {
    var query = studentJpaRepository.findById(id);
    return objectMapper.convertValue(query, DtoStudent.class);
  }

  public List<DtoStudent> findByName(String name) {
    List<DtoStudent> resultList = new ArrayList<>();
    var queryList = studentJpaRepository.findByName(name);
    for (Student student : queryList) {
      resultList.add(objectMapper.convertValue(student, DtoStudent.class));
    }
    return resultList;
  }

  public DtoStudent updateFieldByID(int id, String column, String value) {
    var studentDto = new DtoStudent();
    if(column == null || value == null) {
      return studentDto;
    }
    var student = studentJpaRepository.updateFieldByID(id, column, value);
    return objectMapper.convertValue(student, DtoStudent.class);
  }
}
