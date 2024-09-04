package com.upc.parte1_avance2.dtos;

import com.upc.parte1_avance2.entities.Perfil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String username;
    private Perfil perfil;
    private LocalDate createdAt;

}
