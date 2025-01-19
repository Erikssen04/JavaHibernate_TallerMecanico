package org.example.DAOimplement;

import org.example.DAO.ClienteDAO;
import org.example.models.Cliente;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

import java.util.List;

public class ClienteDAOImp implements ClienteDAO {
    private Session session;

    public ClienteDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public void createCliente(Cliente cliente) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(cliente);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Cliente findCliente(int cliente_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, cliente_id);
            transaction.commit();
            return cliente;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cliente> findAllClientes() {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Cliente> clientes = session.createQuery("FROM Cliente", Cliente.class).list();
            transaction.commit();
            return clientes;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCliente(Cliente cliente) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(cliente);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteCliente(int cliente_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, cliente_id);
            if (cliente != null) {
                session.delete(cliente);
            } else {
                System.out.println("Cliente no encontrado.");
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
