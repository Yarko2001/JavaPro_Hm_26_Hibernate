package com.example.javapro_hm_26_hibernate.repository;

import com.example.javapro_hm_26_hibernate.model.Student;
import java.util.List;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
public interface StudentRepository {

  void add(Student student);

  void deleteById(int id);

  Student updateFieldByID(int id, String column, String value);

  void removeAll();

  List<Student> getAll();

  Student findById(int id);

  List<Student> findByName(String name);

}
