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

    public Pessoa getPessoaID(int id){
        return this.pessoaDao.getPessoaID(id);
    }

    public void removePessoaID(int id) {
        this.pessoaDao.removePessoaID(id);
    }
    public void updatePessoa(Pessoa pessoa){
        this.pessoaDao.updatePessoa(pessoa);
    }

    public void insertPessoa(Pessoa pessoa) {
        pessoaDao.insertPessoa(pessoa);
    }
}
