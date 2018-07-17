package com.cice.GestionUsuarios.GestionUsuarios.GestionUsuarios;

import com.cice.GestionUsuarios.GestionUsuarios.controllers.dto.UsuarioDTO;
import com.cice.GestionUsuarios.GestionUsuarios.entity.Usuario;

import java.util.List;

public interface IGestionUsuarios {

    List<UsuarioDTO> listaNombre();

    UsuarioDTO crearUsuario(String user, String pass);

    UsuarioDTO getUsuario(String user, String pass);

    UsuarioDTO getusuario(Long idUsuario);

    UsuarioDTO actualizarUsuario(String nombre);

    UsuarioDTO eliminarUsuario(String nombre);

}
