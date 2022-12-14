package com.example.clinicavet.controller;

import com.example.clinicavet.dto.TutorRequest;
import com.example.clinicavet.model.Tutor;
import com.example.clinicavet.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.util.annotation.Nullable;

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    TutorService tutorService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar(@ModelAttribute(value = "tutorRequest") @Nullable TutorRequest tutorRequest) {
        return new ResponseEntity<>(tutorService.listar(tutorRequest), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        return new ResponseEntity<>(tutorService.buscar(id), HttpStatus.OK);
    }

    @PostMapping("/inserir")
    public ResponseEntity<?> salvar(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.salvar(tutor), HttpStatus.CREATED);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.alterar(id, tutor), HttpStatus.OK);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        tutorService.remover(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
