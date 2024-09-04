package com.upc.parte1_avance2.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PerfilDTO {
    private Long id;
    private String description;
    private String phoneNumber;
}
