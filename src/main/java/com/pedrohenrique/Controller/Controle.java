package com.pedrohenrique.Controller;

import com.pedrohenrique.Entity.Pessoa;
import com.pedrohenrique.Service.Servicos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

@RestController
@RequestMapping("/teste1")
public class Controle {

    @Autowired
    private Servicos servico;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Pessoa> getAllPessoas(){
        return servico.getAllPessoas();
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.GET) //pegar algo pelo ID
    public Pessoa getPessoaID(@PathVariable("cpf") String CPF){
        return this.servico.getPessoaID(CPF);
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.DELETE) //deletar algo pelo ID
    public void deletePessoaID(@PathVariable("cpf") String CPF){
        servico.removePessoaID(CPF);
    }

    @RequestMapping(method=RequestMethod.PUT, consumes= MediaType.APPLICATION_JSON_VALUE)//editar
    public void updatePessoa(@RequestBody Pessoa pessoa) {
        servico.updatePessoa(pessoa);
    }

    @RequestMapping(method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE) //inserir
    public void insertPessoa(@RequestBody Pessoa pessoa){
        servico.insertPessoa(pessoa);
    }


}
