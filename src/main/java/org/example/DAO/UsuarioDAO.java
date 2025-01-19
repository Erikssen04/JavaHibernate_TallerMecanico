package org.example.DAO;

import org.example.models.Usuario;

import java.util.List;

public interface UsuarioDAO {
    // Métodos CRUD
    void createUsuario(Usuario usuario);
    Usuario findUsuario(int usuario_id);
    List<Usuario> findAllUsuarios();
    void updateUsuario(Usuario usuario);
    void deleteUsuario(int usuario_id);
}
