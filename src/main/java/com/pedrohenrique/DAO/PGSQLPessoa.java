package com.pedrohenrique.DAO;

import com.pedrohenrique.Entity.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
@Qualifier("PostgreSQLPessoa")
public class PGSQLPessoa implements PessoaDAO{



    @Override
    public Collection<Pessoa> getAllPessoas() {
        return null;
    }

    @Override
    public Pessoa getPessoaID(String CPF) {
        return null;
    }

    @Override
    public void removePessoaID(String CPF) {

    }

    @Override
    public void updatePessoa(Pessoa pessoa) {

    }

    @Override
    public void insertPessoa(Pessoa pessoa) {

    }
}
