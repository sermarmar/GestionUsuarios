package com.cice.GestionUsuarios.GestionUsuarios.repository;

import com.cice.GestionUsuarios.GestionUsuarios.controllers.dto.UsuarioDTO;
import com.cice.GestionUsuarios.GestionUsuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuarios WHERE name = :name AND pass = :pass", nativeQuery = true)
    Usuario findUsuarioEntityByUserAndPass(@Param("name") String user, @Param("pass") String pass);

}
