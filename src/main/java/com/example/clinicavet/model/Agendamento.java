package com.example.clinicavet.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;




@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "agendamento")
public class Agendamento {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //	private Long id_tutor;<chave_estrangeira>
//	private Long id_pet; <chave_estrangeira>
//	private Long id_procedimento; <chave_estrangeira>
    private LocalDate data;
    private LocalDate hora;

}
