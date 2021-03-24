package br.com.zupfy.models;

import javax.persistence.*;

@Entity
@Table(name = "bandas")
public class Banda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_banda", length = 20)
    private String nome;

    @Column(name = "ano_nascimento")
    private int nascimento;

    public Banda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNascimento() {
        return nascimento;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }
}
