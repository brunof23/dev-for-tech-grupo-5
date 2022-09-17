package com.example.clinicavet.controller;

import com.example.clinicavet.model.Endereco;
import com.example.clinicavet.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Endereco endereco) {
        return new ResponseEntity<>(enderecoService.alterar(id, endereco), HttpStatus.OK);
    }

}
