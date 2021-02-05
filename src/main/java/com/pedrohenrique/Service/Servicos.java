package com.pedrohenrique.Service;

import com.pedrohenrique.DAO.PessoaDAO;
import com.pedrohenrique.Entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Servicos {

    @Autowired
    private PessoaDAO pessoaDao;

    public Collection<Pessoa> getAllPessoas(){
        return pessoaDao.getAllPessoas();
    }

    public Pessoa getPessoaID(String CPF){
        return this.pessoaDao.getPessoaID(CPF);
    }

    public void removePessoaID(String CPF) {
        this.pessoaDao.removePessoaID(CPF);
    }
    public void updatePessoa(Pessoa pessoa){
        this.pessoaDao.updatePessoa(pessoa);
    }

    public void insertPessoa(Pessoa pessoa) {
        pessoaDao.insertPessoa(pessoa);
    }
}
