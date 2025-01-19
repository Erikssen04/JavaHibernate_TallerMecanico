package org.example.DAOimplement;

import org.example.DAO.ReparacionDAO;
import org.example.models.Reparacion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ReparacionDAOImp implements ReparacionDAO {
    private Session session;

    public ReparacionDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public void createReparacion(Reparacion reparacion) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(reparacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Reparacion findReparacion(int reparacion_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Reparacion reparacion = session.get(Reparacion.class, reparacion_id);
            transaction.commit();
            return reparacion;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Reparacion> findAllReparaciones() {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Reparacion> reparaciones = session.createQuery("FROM Reparacion", Reparacion.class).list();
            transaction.commit();
            return reparaciones;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateReparacion(Reparacion reparacion) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(reparacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteReparacion(int reparacion_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Reparacion reparacion = session.get(Reparacion.class, reparacion_id);
            if (reparacion != null) {
                session.delete(reparacion);
            } else {
                System.out.println("Reparacion no encontrada.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Reparacion> reparacionesRealizadasByMecanico(int idMecanico) {
        List<Reparacion> reparacionesRealizadas = new ArrayList<>();
        try {
            String hql = "FROM Reparacion r " +
                    "WHERE r.empleado.id = :idMecanico";
            Query<Reparacion> query = session.createQuery(hql, Reparacion.class);
            query.setParameter("idMecanico", idMecanico);
            reparacionesRealizadas = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reparacionesRealizadas;
    }
}
