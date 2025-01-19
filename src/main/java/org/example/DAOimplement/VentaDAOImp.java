package org.example.DAOimplement;

import org.example.DAO.VentaDAO;
import org.example.models.Venta;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.*;

import java.util.List;

public class VentaDAOImp implements VentaDAO {
    private Session session;

    public VentaDAOImp(Session session) {
        this.session = session;
    }

    @Override
    public void createVenta(Venta venta) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(venta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Venta findVenta(int venta_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Venta venta = session.get(Venta.class, venta_id);
            transaction.commit();
            return venta;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Venta> findAllVentas() {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List<Venta> ventas = session.createQuery("FROM Venta", Venta.class).list();
            transaction.commit();
            return ventas;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateVenta(Venta venta) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(venta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteVenta(int venta_id) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Venta venta = session.get(Venta.class, venta_id);
            if (venta != null) {
                session.delete(venta);
            } else {
                System.out.println("Venta no encontrada.");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public double ingresosVentasByMes(int mes, int anio) {
        double ingresosPorVentas = 0;
        try {
            String hql = "SELECT SUM(v.monto) FROM Venta v " +
                    "WHERE MONTH(v.fecha) = :mes AND YEAR(v.fecha) = :anio";
            Query<Double> query = session.createQuery(hql, Double.class);
            query.setParameter("mes", mes);
            query.setParameter("anio", anio);
            ingresosPorVentas = query.getSingleResult() != null ? query.getSingleResult() : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingresosPorVentas;
    }
}

