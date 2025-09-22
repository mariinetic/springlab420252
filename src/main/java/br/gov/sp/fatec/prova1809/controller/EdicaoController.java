package br.gov.sp.fatec.prova1809.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.prova1809.entity.Edicao;
import br.gov.sp.fatec.prova1809.entity.Trabalho;
import br.gov.sp.fatec.prova1809.service.EdicaoService;
import br.gov.sp.fatec.prova1809.service.TrabalhoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/edicao")
public class EdicaoController {

    private EdicaoService service;

    public EdicaoController(EdicaoService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Edicao>> buscarAposDataComAssociacaoAnotacao () {
        List<Edicao> result = service.buscarTodos();
        return new ResponseEntity<List<Edicao>>(result, HttpStatus.OK);                                                                            
    }

    @PostMapping()
    public ResponseEntity<Edicao> novaEdicao(@RequestBody Edicao edicao) {
        Edicao result = service.novaEdicao(edicao);
        return new ResponseEntity<Edicao>(result, HttpStatus.CREATED);                                                                           
    }

    @GetMapping(value="/buscarAposDataComAssociacaoAnotacao")
    public ResponseEntity<List<Edicao>> buscarAposDataComAssociacaoAnotacao (@RequestParam("data") LocalDate data, 
                                                                            @RequestParam("textoAnotacao") String texto) {

        List<Edicao> result = service.buscarAposDataComAssociacaoAnotacao(data, texto);
        return new ResponseEntity<List<Edicao>>(result, HttpStatus.OK);                                                                            
    }
}
