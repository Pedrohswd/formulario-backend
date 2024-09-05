package com.pedro.formulario.service;

import com.pedro.formulario.excecoes.PessoaNotFoundException;
import com.pedro.formulario.modulos.Pessoa;
import com.pedro.formulario.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa cadastrarFormulario(Pessoa pessoa){
        try {
            return pessoaRepository.save(pessoa);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cadastrar a pessoa.", e);
        }
    }

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id){
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNotFoundException(id)); // Lançando exceção personalizada
    }

    public void delete(Long id){
        if (!pessoaRepository.existsById(id)) {
            throw new PessoaNotFoundException(id);
        }
        try {
            pessoaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a pessoa com ID: " + id, e);
        }
    }
}
