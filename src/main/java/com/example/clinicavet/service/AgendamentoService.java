package com.example.clinicavet.service;


import com.example.clinicavet.model.Agendamento;
import com.example.clinicavet.repository.AgendamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static com.example.clinicavet.exception.ExceptionCustom.check;

import java.util.List;
import java.util.Optional;

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

    public Agendamento getAgendamentoId (Long id){

        return repository.findById(id).orElse(null);

    }

    public Agendamento updateAgd( Long id,Agendamento NewAgd){
        Optional<Agendamento> existingAgd = repository.findById(id);
        check(existingAgd.isPresent(), "Agendamento não encontrado, id inválido");
        Agendamento agend = existingAgd.get();
        BeanUtils.copyProperties(NewAgd, agend, "id");
        return repository.save(agend);

    }
    public void delete(Long id){
        Optional<Agendamento> agd = repository.findById(id);
        Agendamento del = agd.get();
        check(agd.isPresent(), "Agendamento não encontrado, id inválido");
        repository.deleteById(id);
    }






}
