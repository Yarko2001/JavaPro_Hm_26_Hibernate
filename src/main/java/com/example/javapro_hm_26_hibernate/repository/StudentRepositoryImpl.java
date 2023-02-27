package com.example.javapro_hm_26_hibernate.repository;

import com.example.javapro_hm_26_hibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Slf4j
@Repository
public class StudentRepositoryImpl implements StudentRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  @Transactional
  public void add(Student student) {
    log.info("calls the method 'add'");
    entityManager.persist(student);
  }

  @Override
  @Transactional
  public void deleteById(int id) {
    log.info("calls the method 'deleteById'");
    entityManager.createQuery("delete from Mark m where m.student.id = " + id).executeUpdate();
    entityManager.createQuery("delete from Student s where s.id = " + id).executeUpdate();
  }

  @Override
  @Transactional
  public Student updateFieldByID(int id, String column, String value) {
    log.info("calls the method 'updateFieldByID'");
    Query query = entityManager
        .createNativeQuery(
            "update my_university.student set " + column + "=:value where id=:studentId");
    query.setParameter("value", value);
    query.setParameter("studentId", id);
    query.executeUpdate();
    return findById(id);
  }

  @Override
  @Transactional
  public void removeAll() {
    log.info("calls the method 'removeAll'");
    entityManager.createQuery("delete from Mark m").executeUpdate();
    entityManager.createQuery("delete from Student s").executeUpdate();
  }


  @Override
  @Transactional
  public List<Student> getAll() {
    log.info("calls the method 'getAll'");
    Query query = entityManager
        .createQuery("select s from Student s");
    return query.getResultList();
  }

  @Override
  @Transactional
  public Student findById(int id) {
    log.info("calls the method 'findById'");
    Query query = entityManager
        .createQuery("select s from Student s where s.id = " + id);
    if (query == null) {
      throw new EntityNotFoundException("It doesn't exist student with this id...");
    }
    return (Student) query.getResultList().get(0);
  }

  @Override
  @Transactional
  public List<Student> findByName(String name) {
    List<Student> resultList = new ArrayList<>();
    if (name != null) {
      log.info("calls the method 'findByName'");
      Query query = entityManager
          .createQuery("select s from Student s where s.name = '" + name + "'");
      resultList = query.getResultList();
    }
    return resultList;
  }
}
