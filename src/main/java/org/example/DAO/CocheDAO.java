package org.example.DAO;

import org.example.models.Coche;

import java.util.List;

public interface CocheDAO {

    // Métodos CRUD
    void createCoche(Coche coche);
    Coche findCoche(int coche_id);
    List<Coche> findAllCoches();
    void updateCoche(Coche coche);
    void deleteCoche(int coche_id);

}
