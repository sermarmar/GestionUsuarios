package com.cice.GestionUsuarios.GestionUsuarios.controllers.rest;

import com.cice.GestionUsuarios.GestionUsuarios.GestionUsuarios.IGestionUsuarios;
import com.cice.GestionUsuarios.GestionUsuarios.controllers.dto.UsuarioDTO;
import com.cice.GestionUsuarios.GestionUsuarios.entity.Usuario;
import com.sun.activation.registries.LogSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("/usuario")
public class UserController {

    @Autowired
    @Qualifier("Gestion")
    IGestionUsuarios gestionUsuarios;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getStatus(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(name = "{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> recuperarUsuarioPorId(@PathVariable(value = "idUsuario") String idUsuario){
        return ResponseEntity.ok(gestionUsuarios.getusuario(1L));
    }

    @RequestMapping(name = "login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public Usuario login(@RequestBody Usuario usuario){

        //ResponseEntity<Usuario> response = new ResponseEntity<Usuario>().;

        return usuario;
    }

    @RequestMapping(name = "crearUsuario", method = RequestMethod.POST)
    public ResponseEntity<UsuarioDTO> crearUsuario(@RequestBody UsuarioDTO usuarioDTO){

        log.debug("Usuario recibido: {}", usuarioDTO.toString());

        UsuarioDTO result = gestionUsuarios.crearUsuario(usuarioDTO.getUser(), usuarioDTO.getPass());

        return ResponseEntity.ok(result);

    }
}
