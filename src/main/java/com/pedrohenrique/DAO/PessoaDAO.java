package com.pedrohenrique.DAO;

import com.pedrohenrique.Entity.Pessoa;

import java.sql.SQLException;
import java.util.Collection;

public interface PessoaDAO {
    Collection<Pessoa> getAllPessoas() throws SQLException, ClassNotFoundException;

    Pessoa getPessoaID(String CPF) throws SQLException, ClassNotFoundException;

    void removePessoaID(String CPF) throws SQLException, ClassNotFoundException;

    void updatePessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException;

    void insertPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException;
}
