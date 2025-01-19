package org.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="Cliente")
public class Cliente {

    @Id // Marca el campo como la clave de la tabla
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre", nullable = false)
    private String nombre;

    @Column(name="email", nullable = false)
    private String email;

    @Column(name="telefono", nullable = false)
    private String telefono;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Cliente_Coche",
            joinColumns={@JoinColumn(name="cliente_id")},
            inverseJoinColumns={@JoinColumn(name="coche_id")})
    private List<Coche> coches;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Venta> ventas;

    public Cliente(){};

    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.coches = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public List<Coche> getCoches() {return coches;}

    public void setCoches(List<Coche> coches) {this.coches = coches;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public void addCoche(Coche coche) {
        if (!this.coches.contains(coche)) {
            this.coches.add(coche);
            coche.getClientes().add(this);
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", coches=" + coches +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
