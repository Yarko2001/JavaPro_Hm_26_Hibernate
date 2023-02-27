package com.example.javapro_hm_26_hibernate.dto;

import com.example.javapro_hm_26_hibernate.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoMark {

  private Integer id;
  private DtoStudent student;
  private String discipline;
  private Status status;

}
