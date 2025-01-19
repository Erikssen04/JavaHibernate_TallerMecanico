package org.example.DAOimplement;

import org.example.DAO.UsuarioDAO;
import org.example.models.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDAOImp implements UsuarioDAO {
    private Session session;

    public UsuarioDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public void createUsuario(Usuario usuario) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Usuario findUsuario(int usuario_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, usuario_id);
            transaction.commit();
            return usuario;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Usuario> findAllUsuarios() {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Usuario> usuarios = session.createQuery("FROM Usuario", Usuario.class).list();
            transaction.commit();
            return usuarios;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(usuario);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteUsuario(int usuario_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Usuario usuario = session.get(Usuario.class, usuario_id);
            if (usuario != null) {
                session.delete(usuario);
            } else {
                System.out.println("Usuario no encontrado.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
