package org.example.DAO;

import org.example.models.Empleado;

import java.util.List;

public interface EmpleadoDAO {

    // Métodos CRUD
    void createEmpleado(Empleado empleado);
    Empleado findEmpleado(int empleado_id);
    List<Empleado> findAllEmpleados();
    void updateEmpleado(Empleado empleado);
    void deleteEmpleado(int empleado_id);
}
