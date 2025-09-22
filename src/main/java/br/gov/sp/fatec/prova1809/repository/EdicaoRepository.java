package br.gov.sp.fatec.prova1809.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.gov.sp.fatec.prova1809.entity.Edicao;

public interface EdicaoRepository extends JpaRepository<Edicao, Long>{

    @Query("SELECT e FROM Edicao e " +
       "WHERE e.data > ?1 " +
       "AND LOWER(e.anotacao.texto) LIKE LOWER(CONCAT('%', ?2, '%'))")
List<Edicao> buscarPorDataETexto(LocalDate data, String texto);

}
