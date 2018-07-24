package com.cice.GestionUsuarios.GestionUsuarios.controllers.rest;

import com.cice.GestionUsuarios.GestionUsuarios.GestionUsuarios.IGestionUsuarios;
import com.cice.GestionUsuarios.GestionUsuarios.controllers.dto.UsuarioDTO;
import com.cice.GestionUsuarios.GestionUsuarios.entity.Usuario;
import com.sun.activation.registries.LogSupport;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
@RestController("/")
public class UserController {

    @Autowired
    @Qualifier("Gestion")
    IGestionUsuarios gestionUsuarios;

    /*@RequestMapping(name = "/getState", method = RequestMethod.GET)
    public ResponseEntity getStatus(){
        return new ResponseEntity(HttpStatus.OK);
    }*/

    @RequestMapping(value = "usuario/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<UsuarioDTO> recuperarUsuarioPorId(@PathVariable(value = "idUsuario") String idUsuario){
        return ResponseEntity.ok(gestionUsuarios.getusuario(1L));
    }

    @RequestMapping(value = "usuario/login", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO usuario){

        UsuarioDTO response = gestionUsuarios.getUsuario(usuario.getName(), usuario.getPass());
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "usuario/crearUsuario", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Void> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {

        log.debug("Usuario recibido: {}", usuarioDTO.toString());

        UsuarioDTO result = gestionUsuarios.crearUsuario(usuarioDTO.getName(), usuarioDTO.getPass());
        String location = String.format("http://localhost:8071/usuario/%s", result.getIdUsuario());
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(new URI(location));

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/usuario/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<String> eliminarUsuarioYTodosSusProductos(@PathVariable(value = "idUsuario") Long idUsuario){
        gestionUsuarios.eliminarUsuario(idUsuario);
        return ResponseEntity.ok("Todo va bien...");
    }
}
