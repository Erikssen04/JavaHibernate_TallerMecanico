package org.example.services;

import org.example.DAOimplement.*;
import org.example.models.Cliente;
import org.example.models.Coche;
import org.example.models.Empleado;
import org.example.models.Reparacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultasAvanzadasManager {
    public void ConsultaCochesVendidosByRangoDeFechas(Scanner sc, CocheDAOImp cocheDAOImp, DateTimeFormatter dateTimeFormatter){
        System.out.println("Introduzca fecha de inicio (YYYY-MM-DD):");
        String fechaInicio = sc.nextLine();
        LocalDate fechaInicioFormateada = LocalDate.parse(fechaInicio, dateTimeFormatter);

        System.out.println("Introduzca fecha de fin (YYYY-MM-DD):");
        String fechaFin = sc.nextLine();
        LocalDate fechaFinFormateada = LocalDate.parse(fechaFin, dateTimeFormatter);

        List<Coche> cochesVendidos = cocheDAOImp.cochesVendidosByRangoDeFechas(fechaInicioFormateada,fechaFinFormateada);
        if (!cochesVendidos.isEmpty()) {
            System.out.println("COCHES VENDIDOS ENTRE "+fechaInicio+" y "+fechaFin+":");
            for (Coche coche : cochesVendidos) {
                System.out.println(coche);
            }
        } else {
            System.out.println("No existe ninguna venta de coche registrada en el rango de fechas especificado");
        }
    }

    public void ConsultaReparacionesRealizadasByMecanico(Scanner sc, ReparacionDAOImp reparacionDAOImp, EmpleadoDAOImp empleadoDAOImp){
        System.out.println("Introduzca id del mecánico:");
        int idMecanico = sc.nextInt();

        Empleado mecanico = empleadoDAOImp.findEmpleado(idMecanico);
        if (mecanico!= null) {
            List<Reparacion> reparaciones = reparacionDAOImp.reparacionesRealizadasByMecanico(idMecanico);
            if (!reparaciones.isEmpty()) {
                System.out.println("Reparaciones realizadas por " + mecanico.getNombre());
                for (Reparacion reparacion : reparaciones) {
                    System.out.println(reparacion);
                }
            } else {
                System.out.println("No existe ninguna reparación realizada por el mecánico especificado");
            }
        } else {
            System.out.println("El mecánico especificado NO existe");
        }

    }

    public void ConsultaCochesCompradosByCliente(Scanner sc, CocheDAOImp cocheDAOImp, ClienteDAOImp clienteDAOImp){
        System.out.println("Introduzca id del cliente:");
        int idCliente = sc.nextInt();

        Cliente cliente = clienteDAOImp.findCliente(idCliente);
        if(cliente!=null){
            List<Coche> cochesComprados = cocheDAOImp.cochesCompradosByCliente(idCliente);
            if (!cochesComprados.isEmpty()) {
                System.out.println("Coches comprados por " + cliente.getNombre());
                for (Coche coche : cochesComprados) {
                    System.out.println(coche);
                }
            } else {
                System.out.println("No existe ningún coche comprado por el cliente especificado");
            }
        } else {
            System.out.println("El cliente especificado NO existe");
        }
    }

    public void ConsultaIngresosVentasByMes(Scanner sc, VentaDAOImp ventaDAOImp){
        System.out.println("Introduzca mes:");
        int mes = sc.nextInt();

        System.out.println("Introduzca año:");
        int anyo = sc.nextInt();

        double ingresosVentasByMes = ventaDAOImp.ingresosVentasByMes(mes, anyo);
        System.out.println("Ingresos por ventas del mes "+mes+" año "+anyo+": "+ingresosVentasByMes);
    }
}
