package org.example.DAO;

import org.example.models.Venta;

import java.util.List;

public interface VentaDAO {
    // Métodos CRUD
    void createVenta(Venta venta);
    Venta findVenta(int venta_id);
    List<Venta> findAllVentas();
    void updateVenta(Venta venta);
    void deleteVenta(int venta_id);

    // Métodos para consultas avanzadas
    double ingresosVentasByMes(int mes, int anio);
}
