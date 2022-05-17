package ifsp.projeto.lp3.model;

import java.util.Date;

public class Pessoa {
    private Integer nome;
    private Date nascimento;

    public Pessoa(Integer nome, Date nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Pessoa(Integer nome) {
        this.nome = nome;
    }
    public Integer getNome() {
        return nome;
    }
    public void setNome(Integer nome) {
        this.nome = nome;
    }
}