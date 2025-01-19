package org.example.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Reparacion")
public class Reparacion {

    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="descripcion", nullable = false)
    private String descripcion;

    @Column(name="fecha", nullable = false)
    private LocalDate fecha;

    @Column(name="costo", nullable = false)
    private double costo;

    @ManyToOne
    @JoinColumn(name="empleado_id")
    private Empleado empleado;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="coche_id")
    private Coche coche;

    public Reparacion(){}

    public Reparacion(String descripcion, LocalDate fecha, double costo, Coche coche, Empleado empleado) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.costo = costo;
        this.coche = coche;
        this.empleado = empleado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Coche getCoche() {
        return coche;
    }

    public void setCoche(Coche coche) {
        this.coche = coche;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", costo=" + costo +
                ", coche=" + coche +
                ", empleado=" + empleado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reparacion that = (Reparacion) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
