package com.example.clinicavet.controller;

import com.example.clinicavet.model.Procedimento;
import com.example.clinicavet.service.ProcedimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RequestMapping("/procedimentos")
@RestController
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;

    @PostMapping
    public ResponseEntity<Procedimento> create(@RequestBody Procedimento procedimento){
        Procedimento procedimentoSalvo = procedimentoService.create(procedimento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(procedimentoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<Procedimento>> findAll(){
        List<Procedimento> procedimentos = procedimentoService.findAll();
        return ResponseEntity.ok(procedimentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Procedimento>> findById(@PathVariable Long id){
        Optional<Procedimento> procedimento = procedimentoService.findById(id);
        return ResponseEntity.ok(procedimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Procedimento> update(@PathVariable Long id, @RequestBody Procedimento procedimento){
        Procedimento novoProcedimento = procedimentoService.alterar(id, procedimento);
        return ResponseEntity.ok(novoProcedimento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        procedimentoService.delete(id);
    }
}
