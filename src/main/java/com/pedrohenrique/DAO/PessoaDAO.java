package com.pedrohenrique.DAO;

import com.pedrohenrique.Entity.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class PessoaDAO {

    private static Map<Integer, Pessoa> pessoas;//hash map id pessoa

    static {
        pessoas = new HashMap<Integer,Pessoa>(){

            {
                put(1,new Pessoa(1,"12345678901", 20, "61988885555", "Pessoa1"));
                put(2,new Pessoa(2,"23456789012", 10, "61911112222", "Pessoa2"));
                put(3,new Pessoa(3,"34567890123", 30, "61933334444", "Pessoa3"));
                put(4,new Pessoa(4,"45678901234", 50, "61955556666", "Pessoa4"));
                put(5,new Pessoa(5,"56789012345", 60, "61977778888", "Pessoa5"));
            }

        };
    }

    public Collection<Pessoa> getAllPessoas(){
        return this.pessoas.values();
    }

    public Pessoa getPessoaID(int id){
        return this.pessoas.get(id);
    }

    public void removePessoaID(int id){
        this.pessoas.remove(id);
    }

    public void updatePessoa(Pessoa pessoa){
        Pessoa p = pessoas.get(pessoa.getId());
        p.setIdade(pessoa.getIdade());
        p.setTelefone(pessoa.getTelefone());
        p.setNome(pessoa.getNome());
        pessoas.put(pessoa.getId(),pessoa);
    }

    public void insertPessoa(Pessoa pessoa) {
       this.pessoas.put(pessoa.getId(),pessoa);

    }
}
