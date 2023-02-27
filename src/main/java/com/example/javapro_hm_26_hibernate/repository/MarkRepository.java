package com.example.javapro_hm_26_hibernate.repository;

import com.example.javapro_hm_26_hibernate.model.Mark;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Repository
public interface MarkRepository extends CrudRepository<Mark,Integer> {

}
