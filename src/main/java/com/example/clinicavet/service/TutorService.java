package com.example.clinicavet.service;

import com.example.clinicavet.model.Tutor;
import com.example.clinicavet.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

    public List<Tutor> listar() {
        return tutorRepository.findAll();
    }

    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void remover(Long id) {
        tutorRepository.deleteById(id);
    }

    public Optional<Tutor> buscar(Long id) {
        return tutorRepository.findById(id);
    }

    public Tutor alterar(Long id, Tutor newTutor){
        Optional<Tutor> oldTutor = tutorRepository.findById(id);
        Tutor tutor = oldTutor.get();
        BeanUtils.copyProperties(newTutor, tutor, "id");
        return tutorRepository.save(tutor);
    }

}
