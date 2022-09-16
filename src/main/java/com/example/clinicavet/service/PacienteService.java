package com.example.clinicavet.service;

import com.example.clinicavet.model.Paciente;
import com.example.clinicavet.repository.PacienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.clinicavet.exception.ExceptionCustom.check;
@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> listar() {
        return pacienteRepository.findAll();
    }

    public Paciente salvar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public void remover(Long id) {
        Optional<Paciente> paciente = buscar(id);
        check(!paciente.isPresent(), HttpStatus.NOT_FOUND,"Paciente não encontrado, informe um id valido!");
        pacienteRepository.deleteById(id);
    }

    public Optional<Paciente> buscar(Long id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        check(!paciente.isPresent(), HttpStatus.NOT_FOUND,"Paciente não encontrado, informe um id valido!");
        return paciente;
    }

    public Paciente alterar(Long id, Paciente newPaciente){
        Optional<Paciente> oldPaciente = pacienteRepository.findById(id);
        Paciente paciente = oldPaciente.get();
        check(!oldPaciente.isPresent(), HttpStatus.NOT_FOUND, "Paciente não encontrado, informe um id valido!");
        BeanUtils.copyProperties(newPaciente, paciente, "id");
        return pacienteRepository.save(paciente);
    }
}
