package com.example.clinicavet.service;


import com.example.clinicavet.model.Agendamento;
import com.example.clinicavet.repository.AgendamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.clinicavet.exception.ExceptionCustom.check;

@Service
public class AgendamentoService {

    @Autowired
    AgendamentoRepository repository;

    public Agendamento add(Agendamento agd){
        return repository.save(agd);
    }
    public List<Agendamento> getAgendamentos (){
        return repository.findAll();
    }

    public Optional<Agendamento> getAgendamentoId (Long id){

        Optional<Agendamento> agd = repository.findById(id);
        check(!agd.isPresent(), HttpStatus.NOT_FOUND, "Agendamento não encontrado,  id inválido!");

        return agd;

    }

    public Agendamento updateAgd( Long id,Agendamento NewAgd){
        Optional<Agendamento> existingAgd = repository.findById(id);
        check(existingAgd.isPresent(), HttpStatus.NOT_FOUND, "Agendamento não encontrado, id inválido");
        Agendamento agend = existingAgd.get();
        BeanUtils.copyProperties(NewAgd, agend, "id");
        return repository.save(agend);

    }
    public void delete(Long id){
        Optional<Agendamento> agd = repository.findById(id);
        Agendamento del = agd.get();
        check(agd.isPresent(), HttpStatus.NOT_FOUND,"Agendamento não encontrado, id inválido");
        repository.deleteById(id);
    }






}
