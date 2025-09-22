package br.gov.sp.fatec.prova1809.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.prova1809.entity.Anotacao;
import br.gov.sp.fatec.prova1809.entity.Edicao;
import br.gov.sp.fatec.prova1809.entity.Trabalho;
import br.gov.sp.fatec.prova1809.repository.AnotacaoRepository;
import br.gov.sp.fatec.prova1809.repository.EdicaoRepository;
import br.gov.sp.fatec.prova1809.repository.TrabalhoRepository;

@Service
public class EdicaoServiceImpl implements EdicaoService{

    private EdicaoRepository edicaoRepo;
    private AnotacaoRepository anotacaoRepo;


    public EdicaoServiceImpl(EdicaoRepository edicaoRepo, AnotacaoRepository anotacaoRepo) {
        this.edicaoRepo = edicaoRepo;
        this.anotacaoRepo = anotacaoRepo;
    }

    @Override
    public List<Edicao> buscarTodos() {
        return edicaoRepo.findAll();
    }
    
    @Override
    public Edicao novaEdicao(Edicao edicao) {
        Optional<Anotacao> anotacaoOpt = anotacaoRepo.findById(edicao.getAnotacao().getId());
        if (anotacaoOpt.isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A anotação associada não existe");

        if (edicao.getImportancia() <= 0 || edicao.getImportancia() >= 4)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A importância informada está fora do range correto (0-4)");

        if (edicao.getTexto().isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O texto não foi preenchido");

        if (edicao.getTexto().chars().anyMatch(Character::isDigit))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O texto possui números em seu conteúdo");

        if (edicao.getTexto().equals(anotacaoOpt.get().getTexto()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O texto é igual ao texto atual da anotação");

        if (edicao.getData() == null)
            edicao.setData(LocalDate.now());

        edicao.setAnotacao(anotacaoOpt.get());
        
        return edicaoRepo.save(edicao);
    }

    @Override
    public List<Edicao> buscarAposDataComAssociacaoAnotacao(LocalDate data, String texto) {
        return edicaoRepo.buscarPorDataETexto(data, texto);
    }
}
