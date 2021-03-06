package com.cice.GestionUsuarios.GestionUsuarios.GestionUsuarios;

import com.cice.GestionUsuarios.GestionUsuarios.controllers.dto.UsuarioDTO;
import com.cice.GestionUsuarios.GestionUsuarios.entity.Usuario;
import com.cice.GestionUsuarios.GestionUsuarios.feign.IProductoFeign;
import com.cice.GestionUsuarios.GestionUsuarios.repository.UsuarioRepository;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("Gestion")
public class GestionUsuarios implements IGestionUsuarios{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    IProductoFeign productoFeign;

    @Override
    public List<UsuarioDTO> listaNombre() {
        return null;
    }

    @Override
    public UsuarioDTO getUsuario(String user, String pass) {
        Usuario usuario = usuarioRepository.findUsuarioEntityByUserAndPass(user, pass);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario.getId(), usuario.getName(), usuario.getPass());
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO getusuario(Long idUsuario) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(idUsuario);
        UsuarioDTO usuarioDTO = null;
        if(usuarioOptional.isPresent()){
            usuarioDTO = new UsuarioDTO(usuarioOptional.get().getId(), usuarioOptional.get().getName(), usuarioOptional.get().getPass());
        }
        return usuarioDTO;
    }

    @Override
    public UsuarioDTO crearUsuario(String user, String pass) {
        Usuario usuario = new Usuario(null, user, pass);
        Usuario result = usuarioRepository.save(usuario);
        return new UsuarioDTO(result.getId(), result.getName(), result.getPass());
    }

    @Override
    public UsuarioDTO actualizarUsuario(String nombre) {
        return null;
    }

    @Override
    @HystrixCommand(fallbackMethod = "eliminarUsuarioDefault")
    public UsuarioDTO eliminarUsuario(Long idUsuario) {
        //usuarioRepository.deleteById(idUsuario);
        //productoFeign.eliminarProductosByIdUsuario(idUsuario);
        System.out.println("Todo bien");
        new RestTemplate().delete(
                "http://localhost:8765/gestion-productos/producto/{idUsuario}",
                idUsuario);
        return new UsuarioDTO();
    }
    private UsuarioDTO eliminarUsuarioDefault(){
        System.out.println("Error");
        return null;
    }

}
