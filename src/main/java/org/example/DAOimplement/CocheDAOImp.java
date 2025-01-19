package org.example.DAOimplement;

import org.example.DAO.CocheDAO;
import org.example.models.Coche;
import org.example.models.Reparacion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CocheDAOImp implements CocheDAO {
    private Session session;

    public CocheDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public void createCoche(Coche coche) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(coche);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Coche findCoche(int coche_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Coche coche = session.get(Coche.class, coche_id);
            transaction.commit();
            return coche;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Coche> findAllCoches() {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Coche> coches = session.createQuery("FROM Coche", Coche.class).list();
            transaction.commit();
            return coches;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCoche(Coche coche) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(coche);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteCoche(int coche_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Obtener el coche por ID
            Coche coche = session.get(Coche.class, coche_id);

            if (coche != null) {
                // Eliminar manualmente las reparaciones asociadas al coche
                List<Reparacion> reparaciones = coche.getReparaciones();
                if (reparaciones != null) {
                    for (Reparacion reparacion : reparaciones) {
                        session.delete(reparacion); // Eliminar cada reparación
                    }
                }

                // Eliminar el coche
                session.delete(coche);
            } else {
                System.out.println("Coche no encontrado.");
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Coche> cochesVendidosByRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        List<Coche> cochesVendidos = new ArrayList<>();
        try {
            String hql = "SELECT c FROM Venta v " +
                    "JOIN v.coches c " +
                    "WHERE v.fecha BETWEEN :fechaInicio AND :fechaFin";
            Query<Coche> query = session.createQuery(hql, Coche.class);
            query.setParameter("fechaInicio", fechaInicio);
            query.setParameter("fechaFin", fechaFin);
            cochesVendidos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cochesVendidos;
    }

    public List<Coche> cochesCompradosByCliente(int idCliente) {
        List<Coche> cochesComprados = new ArrayList<>();
        try {
            String hql = "SELECT c FROM Coche c " +
                    "JOIN c.ventas v " +
                    "WHERE v.cliente.id = :idCliente";
            Query<Coche> query = session.createQuery(hql, Coche.class);
            query.setParameter("idCliente", idCliente);
            cochesComprados = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cochesComprados;
    }


}