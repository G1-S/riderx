package com.riderx.riderx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.riderx.riderx.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}