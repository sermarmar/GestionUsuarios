package controllers;

import GestionUsuarios.IGestionUsuarios;
import entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/usuario")
public class UserController {

    @Autowired
    @Qualifier("Gestion")
    IGestionUsuarios gestionUsuarios;

    public ResponseEntity getStatus(){
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody Usuario usuario){
        System.out.println(usuario.getName());
    }

}
