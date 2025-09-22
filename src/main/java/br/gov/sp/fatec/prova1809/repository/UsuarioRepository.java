package br.gov.sp.fatec.prova1809.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.prova1809.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
