package br.gov.sp.fatec.prova1809.service;

import java.util.List;

import br.gov.sp.fatec.prova1809.entity.Trabalho;

public interface TrabalhoService {

    public List<Trabalho> buscarTodos();

    public Trabalho novoTrabalho(Trabalho trabalho);

    public List<Trabalho> buscarPorTituloENomeUsuario(String titulo, String nomeUsuario);
    
}
