package com.example.clinicavet.service;

import com.example.clinicavet.model.Endereco;
import com.example.clinicavet.repository.EnderecoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.clinicavet.exception.ExceptionCustom.check;


@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public Endereco alterar(Long id, Endereco newEndereco){
        Optional<Endereco> oldEndereco = enderecoRepository.findById(id);
        Endereco endereco = oldEndereco.get();
        check(!oldEndereco.isPresent(), HttpStatus.NOT_FOUND,"Endereço não encontrado, informe um id valido!");
        BeanUtils.copyProperties(newEndereco, endereco, "id");
        return enderecoRepository.save(endereco);
    }

}
