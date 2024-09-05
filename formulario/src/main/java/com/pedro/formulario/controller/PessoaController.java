package com.pedro.formulario.controller;

import com.pedro.formulario.modulos.Pessoa;
import com.pedro.formulario.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> cadastrarFormulario(@RequestBody Pessoa pessoa){
        Pessoa pessoaNew = pessoaService.cadastrarFormulario(pessoa);
        return ResponseEntity.ok(pessoaNew);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        pessoaService.delete(id);
    }

}
