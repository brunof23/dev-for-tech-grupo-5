package com.example.clinicavet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
=======
import javax.persistence.*;
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tutor {

    private static final long serialVersionUID = 1L;

    @Id
<<<<<<< HEAD
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String cpf;
    private String endereco;
    private String contato;
    //pet<chave estrangeira>
=======
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private String contato;

    //@NotNull
    //pet<chave estrangeira>

    //@JoinColumn(name = "addressId", referencedColumnName = "id")
    //private Address address;
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0
}
