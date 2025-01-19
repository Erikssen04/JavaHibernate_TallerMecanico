package org.example.DAO;

import org.example.models.Reparacion;

import java.util.List;

public interface ReparacionDAO {
    // Métodos CRUD
    void createReparacion(Reparacion reparacion);
    Reparacion findReparacion(int reparacion_id);
    List<Reparacion> findAllReparaciones();
    void updateReparacion(Reparacion reparacion);
    void deleteReparacion(int reparacion_id);

    // Métodos para consultas avanzadas
    List<Reparacion> reparacionesRealizadasByMecanico(int idMecanico);
}
