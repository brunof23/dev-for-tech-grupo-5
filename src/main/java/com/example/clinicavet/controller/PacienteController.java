package com.example.clinicavet.controller;

import com.example.clinicavet.model.Paciente;
import com.example.clinicavet.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(pacienteService.listar(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(pacienteService.buscar(id), HttpStatus.OK);
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> salvar(@RequestBody Paciente paciente) {
        return new ResponseEntity<>(pacienteService.salvar(paciente), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Paciente paciente) {
        return new ResponseEntity<>(pacienteService.alterar(id, paciente), HttpStatus.OK);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        pacienteService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
