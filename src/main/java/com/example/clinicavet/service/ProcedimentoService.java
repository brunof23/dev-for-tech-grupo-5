package com.example.clinicavet.service;

import com.example.clinicavet.model.Procedimento;
import com.example.clinicavet.repository.ProcedimentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.clinicavet.exception.ExceptionCustom.check;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    public Procedimento create(Procedimento procedimento){
        return procedimentoRepository.save(procedimento);
    }

    public List<Procedimento> findAll() {
        return procedimentoRepository.findAll();
    }

    public Optional<Procedimento> findById(Long id) {
        Optional<Procedimento> procedimento = procedimentoRepository.findById(id);
        check(procedimento.isEmpty(), HttpStatus.NOT_FOUND, "Procedimento não encontrado, informe um id valido!");
        return procedimento;
    }

    public Procedimento alterar(Long id, Procedimento procedimento){
        Optional<Procedimento> procedimentoOptional = findById(id);
        Procedimento novoProcedimento = procedimentoOptional.get();
        BeanUtils.copyProperties(procedimento, novoProcedimento, "id");
        return procedimentoRepository.save(novoProcedimento);
    }


    public void delete(Long id) {
        Optional<Procedimento> procedimento = findById(id);
        procedimentoRepository.deleteById(procedimento.get().getId());
    }
}
