package com.pedrohenrique.DAO;

import com.pedrohenrique.Entity.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Iterator;


@Repository
@Qualifier("PostgreSQLPessoa")
public class PGSQLPessoa implements PessoaDAO{

    private Connection connect;

    public PGSQLPessoa() throws SQLException, ClassNotFoundException {//conecta no banco direto
        connect = Connect.openConnection();
    }

    @Override
    public ArrayList<Pessoa> getAllPessoas() throws SQLException, ClassNotFoundException { //retorna todas as pessoas

        ArrayList<Pessoa> colecaoPessoa = new ArrayList<Pessoa>();

        connect = Connect.openConnection();
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM public.\"Pessoas\"");
        ResultSet rs = statement.executeQuery();

        while(rs.next()){
            Pessoa pessoa = new Pessoa(rs.getString("CPF"), rs.getInt("Idade"), rs.getString("Telefone"), rs.getString("Nome"));
            colecaoPessoa.add(pessoa);
        }


        return colecaoPessoa;
    }

    @Override
    public Pessoa getPessoaID(String CPF) throws SQLException, ClassNotFoundException { //retorna uma única pessoa
        connect = Connect.openConnection();
        PreparedStatement statement = connect.prepareStatement("SELECT * FROM public.\"Pessoas\" WHERE \"CPF\" = ?");

        statement.setString(1,CPF);

        ResultSet rs = statement.executeQuery();

        Pessoa p = new Pessoa();
        while(rs.next()){
            p.setCPF(rs.getString("CPF"));
            p.setNome(rs.getString("Nome"));
            p.setTelefone(rs.getString("Telefone"));
            p.setIdade(rs.getInt("Idade"));
        }


        return p;
    }

    @Override
    public void removePessoaID(String CPF) throws SQLException, ClassNotFoundException {//remove uma pessoa, não retorna nada
        connect = Connect.openConnection();
        PreparedStatement statement = connect.prepareStatement("DELETE FROM public.\"Pessoas\" WHERE \"CPF\" = ?");

        statement.setString(1,CPF);

        ResultSet rs = statement.executeQuery();

    }

    @Override
    public void updatePessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        connect = Connect.openConnection();
        PreparedStatement statement = connect.prepareStatement("UPDATE public.\"Pessoas\" SET \"Nome\" = ?, \"Telefone\" = ?, \"Idade\" = ? WHERE \"CPF\" = ?");

        statement.setString(1,pessoa.getNome());
        statement.setString(2,pessoa.getTelefone());
        statement.setInt(3,pessoa.getIdade());
        statement.setString(4,pessoa.getCPF());

        ResultSet rs = statement.executeQuery();
    }

    @Override
    public void insertPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException {
        connect = Connect.openConnection();
        PreparedStatement statement = connect.prepareStatement("INSERT INTO public.\"Pessoas\"(\"CPF\", \"Nome\",\"Telefone\",\"Idade\") VALUES (?,?,?,?)");

        statement.setString(1,pessoa.getCPF());
        statement.setString(2,pessoa.getNome());
        statement.setString(3,pessoa.getTelefone());
        statement.setInt(4,pessoa.getIdade());

        ResultSet rs = statement.executeQuery();
    }
}
