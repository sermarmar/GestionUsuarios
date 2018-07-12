package GestionUsuarios;

import java.util.List;

public interface IGestionUsuarios {

    List<String> listaNombre();

    boolean crearUsuario(String nombre, String surname);

    boolean actualizarUsuario(String nombre);

    String eliminarUsuario(String nombre);

}
