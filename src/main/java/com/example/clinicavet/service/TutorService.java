package com.example.clinicavet.service;

<<<<<<< HEAD
=======
import com.example.clinicavet.dto.TutorRequest;
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0
import com.example.clinicavet.model.Tutor;
import com.example.clinicavet.repository.TutorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.data.domain.Example;
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.clinicavet.exception.ExceptionCustom.check;


@Service
public class TutorService {

    @Autowired
    TutorRepository tutorRepository;

<<<<<<< HEAD
    public List<Tutor> listar() {
        return tutorRepository.findAll();
=======
    public List<Tutor> listar(TutorRequest tutorRequest) {

        Tutor tutor = new Tutor();
        tutor.setNome(tutorRequest.getNome());
        tutor.setCpf(tutorRequest.getCpf());
        tutor.setContato(tutorRequest.getContato());

        return tutorRepository.findAll(Example.of(tutor));
>>>>>>> 88dd87e348127999f2325fbeed26326a9f9facc0
    }

    public Tutor salvar(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    public void remover(Long id) {
        Optional<Tutor> tutor = buscar(id);
        check(!tutor.isPresent(), "Tutor não encontrado, informe um id valido!");
        tutorRepository.deleteById(id);
    }

    public Optional<Tutor> buscar(Long id) {
        Optional<Tutor> tutor = tutorRepository.findById(id);
        check(!tutor.isPresent(), "Tutor não encontrado, informe um id valido!");
        return tutor;
    }

    public Tutor alterar(Long id, Tutor newTutor){
        Optional<Tutor> oldTutor = tutorRepository.findById(id);
        Tutor tutor = oldTutor.get();
        check(oldTutor.isPresent(), "Tutor não encontrado, informe um id valido!");
        BeanUtils.copyProperties(newTutor, tutor, "id");
        return tutorRepository.save(tutor);
    }

}
