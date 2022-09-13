package com.example.clinicavet.controller;

<<<<<<< HEAD
=======
import com.example.clinicavet.dto.TutorRequest;
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0
import com.example.clinicavet.model.Tutor;
import com.example.clinicavet.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======
import reactor.util.annotation.Nullable;
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0

@RestController
@RequestMapping("/tutor")
public class TutorController {

    @Autowired
    TutorService tutorService;

    @GetMapping("/listar")
<<<<<<< HEAD
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(tutorService.listar(), HttpStatus.OK);
=======
    public ResponseEntity<?> listar(@ModelAttribute(value = "tutorRequest") @Nullable TutorRequest tutorRequest) {
        return new ResponseEntity<>(tutorService.listar(tutorRequest), HttpStatus.OK);
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0
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
