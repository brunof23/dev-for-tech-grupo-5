package com.example.clinicavet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "agendamento")
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    @JsonIgnoreProperties("agendamento")
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIgnoreProperties("agendamento")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "procedimento_id")
    @JsonIgnoreProperties("agendamento")
    private Procedimento procedimento;

    private LocalDate data;
    private LocalDate hora;

}
