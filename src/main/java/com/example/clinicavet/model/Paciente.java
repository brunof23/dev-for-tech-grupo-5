package com.example.clinicavet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Paciente {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomePet;
    @ManyToOne
    @JoinColumn(name = "tutor_id")
    @JsonIgnoreProperties("paciente")
    private Tutor tutor;
    private String raca;
    private String peso;
    private String idade;

}
