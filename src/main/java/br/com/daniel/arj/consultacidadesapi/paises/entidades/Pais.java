package br.com.daniel.arj.consultacidadesapi.paises.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pais")
@Table(name = "pais")
public class Pais {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "nome_pt")
    private String nomePortugues;

    @Column(name = "sigla")
    private String codigo;

    private Integer bacen;

    public Pais() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomePortugues() {
        return nomePortugues;
    }

    public String getCodigo() {
        return codigo;
    }

    public Integer getBacen() {
        return bacen;
    }
}






















