package GestionUsuarios;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("Gestion")
public class GestionUsuarios implements IGestionUsuarios{

    @Override
    public List<String> listaNombre() {
        return null;
    }

    @Override
    public boolean crearUsuario(String nombre, String surname) {
        return false;
    }

    @Override
    public boolean actualizarUsuario(String nombre) {
        return false;
    }

    @Override
    public String eliminarUsuario(String nombre) {
        return null;
    }
}
