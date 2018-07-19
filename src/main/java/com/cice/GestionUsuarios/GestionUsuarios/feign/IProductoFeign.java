package com.cice.GestionUsuarios.GestionUsuarios.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "gestion-productos")
public interface IProductoFeign {

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.DELETE)
    ResponseEntity<String> eliminarProductosByIdUsuario(Long idUsuario);

}
