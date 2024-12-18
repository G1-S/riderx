package com.riderx.riderx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.riderx.riderx.model.Usuario;
import com.riderx.riderx.model.Veiculo;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public List<Usuario>findAllByUsuarioContainingIgnoreCase(@Param("usuario") String usuario);
	public List<Usuario>findAllByUsuario(@Param("usuario") String usuario);

}