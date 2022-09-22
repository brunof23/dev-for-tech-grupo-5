package com.example.clinicavet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutor {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("tutor")
    private List<Paciente> pacientes;

    @ManyToOne(cascade=CascadeType.ALL)
    private Endereco endereco;

    @Column(nullable = false)
    private String contato;

}
