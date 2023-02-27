package com.example.javapro_hm_26_hibernate.model;

import com.example.javapro_hm_26_hibernate.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Table(schema = "my_university")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Mark {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "fk_student_id", nullable = false)
  private Student student;
  private String discipline;
  @Enumerated(EnumType.STRING)
  private Status status;

}
