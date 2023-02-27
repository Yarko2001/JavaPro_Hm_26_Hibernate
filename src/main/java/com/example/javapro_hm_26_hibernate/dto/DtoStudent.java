package com.example.javapro_hm_26_hibernate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yaroslav Dehtiar on 24.02.2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudent {

  private Integer id;
  private String name;
  private String email;

}
