package com.pedrohenrique.Service;

import com.pedrohenrique.DAO.FakeDataPessoa;
import com.pedrohenrique.DAO.PGSQLPessoa;
import com.pedrohenrique.Entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;

@Service
public class Servicos {

    @Autowired

    @Qualifier("PostgreSQLPessoa")
    private PGSQLPessoa pessoaDao;

    public Collection<Pessoa> getAllPessoas() throws SQLException, ClassNotFoundException {
        return pessoaDao.getAllPessoas();
    }

    public Pessoa getPessoaID(String CPF) throws SQLException, ClassNotFoundException {
        return this.pessoaDao.getPessoaID(CPF);
    }

    public void removePessoaID(String CPF) throws SQLException, ClassNotFoundException {
        this.pessoaDao.removePessoaID(CPF);
    }

    public void updatePessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        this.pessoaDao.updatePessoa(pessoa);
    }

    public void insertPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        pessoaDao.insertPessoa(pessoa);
    }
}
