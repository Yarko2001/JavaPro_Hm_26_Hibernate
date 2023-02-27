package com.example.javapro_hm_26_hibernate.repository;

import com.example.javapro_hm_26_hibernate.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Repository
public interface StudentJpaRepository extends JpaRepository<Student,Integer>,StudentRepository {

}
