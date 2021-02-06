package com.pedrohenrique.DAO;

import com.pedrohenrique.Entity.Pessoa;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FKPessoa")
public class FakeDataPessoa implements PessoaDAO {

    private static Map<String, Pessoa> pessoas;//hash map id pessoa

    static {
        pessoas = new HashMap<String,Pessoa>(){

            {
                put("12345678901",new Pessoa("12345678901", 20, "61988885555", "Pessoa1"));
                put("23456789012",new Pessoa("23456789012", 10, "61911112222", "Pessoa2"));
                put("34567890123",new Pessoa("34567890123", 30, "61933334444", "Pessoa3"));
                put("45678901234",new Pessoa("45678901234", 50, "61955556666", "Pessoa4"));
                put("56789012345",new Pessoa("56789012345", 60, "61977778888", "Pessoa5"));
            }
        };
    }

    @Override
    public Collection<Pessoa> getAllPessoas(){
        return this.pessoas.values();
    }

    @Override
    public Pessoa getPessoaID(String CPF){
        return this.pessoas.get(CPF);
    }

    @Override
    public void removePessoaID(String CPF){
        this.pessoas.remove(CPF);
    }

    @Override
    public void updatePessoa(Pessoa pessoa){
        Pessoa p = pessoas.get(pessoa.getCPF());
        p.setIdade(pessoa.getIdade());
        p.setTelefone(pessoa.getTelefone());
        p.setNome(pessoa.getNome());
        pessoas.put(pessoa.getCPF(),pessoa);
    }

    @Override
    public void insertPessoa(Pessoa pessoa) {
       this.pessoas.put(pessoa.getCPF(),pessoa);

    }
}
