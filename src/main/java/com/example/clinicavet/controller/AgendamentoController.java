package com.example.clinicavet.controller;


import com.example.clinicavet.model.Agendamento;
import com.example.clinicavet.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoService agdService;

    @PostMapping("/inserir")
    public ResponseEntity<?> Add (@RequestBody Agendamento agd){
        return new ResponseEntity<>(agdService.add(agd), HttpStatus.CREATED);
    }

    @GetMapping("/listar")
    public ResponseEntity<?>Lista(){
        return new ResponseEntity<>(agdService.getAgendamentos(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> selecionarAgd (@PathVariable Long id){
        return new ResponseEntity<>(agdService.getAgendamentoId(id), HttpStatus.OK);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?>atualizar(@PathVariable Long id, @RequestBody Agendamento agd){
                return new ResponseEntity<>(agdService.updateAgd(id, agd), HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<?>excluir(@PathVariable Long id){
        agdService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
