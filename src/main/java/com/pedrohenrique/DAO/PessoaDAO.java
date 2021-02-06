package com.pedrohenrique.DAO;

import com.pedrohenrique.Entity.Pessoa;

import java.util.Collection;

public interface PessoaDAO {
    Collection<Pessoa> getAllPessoas();

    Pessoa getPessoaID(String CPF);

    void removePessoaID(String CPF);

    void updatePessoa(Pessoa pessoa);

    void insertPessoa(Pessoa pessoa);
}
