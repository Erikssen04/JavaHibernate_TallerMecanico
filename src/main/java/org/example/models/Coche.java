package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Coche")
public class Coche {

    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="marca", nullable = false)
    private String marca;

    @Column(name="modelo", nullable = false)
    private String modelo;

    @Column(name="año", nullable = false)
    private int anyo;

    @Column(name="precio", nullable = false)
    private double precio;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "coche", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reparacion> reparaciones;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "coches")
    private List<Venta> ventas;

    @ManyToMany(mappedBy = "coches")
    private List<Cliente> clientes;

    public Coche(){}

    public Coche(String marca, String modelo, int anyo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
        this.precio = precio;
        this.reparaciones = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnyo() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo = anyo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public void setReparaciones(List<Reparacion> reparaciones) {
        this.reparaciones = reparaciones;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void addCliente(Cliente cliente) {
        if (!this.clientes.contains(cliente)) {
            this.clientes.add(cliente);
            cliente.getCoches().add(this);
        }
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anyo=" + anyo +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coche coche = (Coche) o;
        return id == coche.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
