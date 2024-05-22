package com.projetofinal.demo.modelos;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String peso;
    private Integer estoque = 0;
    private Double precocusto = 0.00;
    private Double precovenda = 0.00;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPrecocusto() {
        return precocusto;
    }

    public void setPrecocusto(Double precocusto) {
        this.precocusto = precocusto;
    }

    public Double getPrecovenda() {
        return precovenda;
    }

    public void setPrecovenda(Double precovenda) {
        this.precovenda = precovenda;
    }
}
