package br.gov.sp.fatec.prova1809.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "edi_edicao")
public class Edicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "edi_id")
    private Long id;

    @Column(name = "edi_texto_antigo")
    private String texto;

    @Column(name = "edi_justificativa")
    private String justificativa;

    @Column(name = "edi_data")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "edi_anotacao")
    private Anotacao anotacao;

    @Column(name = "edi_importancia")
    private Integer importancia;

    public Edicao() {
    }

    public Edicao(String texto, String justificativa, LocalDate data, Anotacao anotacao, Integer importancia) {
        this.texto = texto;
        this.justificativa = justificativa;
        this.data = data;
        this.anotacao = anotacao;
        this.importancia = importancia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Anotacao getAnotacao() {
        return anotacao;
    }

    public void setAnotacao(Anotacao anotacao) {
        this.anotacao = anotacao;
    }

    public Integer getImportancia() {
        return importancia;
    }

    public void setImportancia(Integer importancia) {
        this.importancia = importancia;
    }
}
