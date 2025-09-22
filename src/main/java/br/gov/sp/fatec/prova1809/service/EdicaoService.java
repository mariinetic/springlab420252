package br.gov.sp.fatec.prova1809.service;

import java.time.LocalDate;
import java.util.List;

import br.gov.sp.fatec.prova1809.entity.Edicao;
import br.gov.sp.fatec.prova1809.entity.Trabalho;

public interface EdicaoService {
    public Edicao novaEdicao(Edicao edicao);

    public List<Edicao> buscarTodos();

    public List<Edicao> buscarAposDataComAssociacaoAnotacao(LocalDate data, String texto);
}
