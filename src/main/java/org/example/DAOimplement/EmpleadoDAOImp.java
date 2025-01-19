package org.example.DAOimplement;

import org.example.DAO.EmpleadoDAO;
import org.example.models.Empleado;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmpleadoDAOImp implements EmpleadoDAO {
    private Session session;

    public EmpleadoDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public void createEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Empleado findEmpleado(int empleado_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Empleado empleado = session.get(Empleado.class, empleado_id);
            transaction.commit();
            return empleado;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Empleado> findAllEmpleados() {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Empleado> empleados = session.createQuery("FROM Empleado", Empleado.class).list();
            transaction.commit();
            return empleados;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmpleado(Empleado empleado) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(empleado);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteEmpleado(int empleado_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Empleado empleado = session.get(Empleado.class, empleado_id);
            if (empleado != null) {
                session.delete(empleado);
            } else {
                System.out.println("Empleado no encontrado.");
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

