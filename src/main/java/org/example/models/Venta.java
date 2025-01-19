package org.example.models;

import javax.persistence.CascadeType;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Venta")
public class Venta {

    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="fecha", nullable = false)
    private LocalDate fecha;

    @Column(name="monto", nullable = false)
    private double monto;

    @ManyToOne
    @JoinColumn(name="empleado_id")
    private Empleado empleado;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name="Venta_Coche",
            joinColumns={@JoinColumn(name="venta_id")},
            inverseJoinColumns={@JoinColumn(name="coche_id")})
    private List<Coche> coches;

    public Venta(){}

    public Venta(LocalDate fecha, double monto) {
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coche) { this.coches = coche; }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", fecha='" + fecha + '\'' +
                ", monto=" + monto +
                ", empleado=" + empleado.getId() +
                ", cliente=" + cliente.getId() +

                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return id == venta.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
