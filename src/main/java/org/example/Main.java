package org.example;

import org.example.DAOimplement.*;
import org.example.config.HibernateUtil;
import org.example.models.*;
import org.example.services.ConsultasAvanzadasManager;
import org.example.services.CrudManager;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (Session session = HibernateUtil.getSession()) {

            Scanner sc = new Scanner(System.in);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            CrudManager crudManager = new CrudManager();
            ConsultasAvanzadasManager consultasAvanzadasManager = new ConsultasAvanzadasManager();

            ClienteDAOImp clienteDAOImp = new ClienteDAOImp(session);
            CocheDAOImp cocheDAOImp = new CocheDAOImp(session);
            EmpleadoDAOImp empleadoDAOImp = new EmpleadoDAOImp(session);
            ReparacionDAOImp reparacionDAOImp = new ReparacionDAOImp(session);
            VentaDAOImp ventaDAOImp = new VentaDAOImp(session);
            UsuarioDAOImp usuarioDAOImp = new UsuarioDAOImp(session);

            int opcion;
            boolean salir = false;

            // Bateria inicial de datos
            Cliente cliente1 = new Cliente("Juan García", "juan@mail.com", "123456789");
            Cliente cliente2 = new Cliente("José Miguel", "jose@mail.com", "987654321");
            Cliente cliente3 = new Cliente("Ana López", "ana@mail.com", "1122334455");
            Cliente cliente4 = new Cliente("Laura Fernández", "laura@mail.com", "6677889900");
            Cliente cliente5 = new Cliente("Pedro Martínez", "pedro@mail.com", "5544332211");

            Coche coche1 = new Coche("Opel", "Corsa", 2020, 15000);
            Coche coche2 = new Coche("SEAT", "Ibiza", 2021, 18000);
            Coche coche3 = new Coche("Toyota", "Yaris", 2019, 14000);
            Coche coche4 = new Coche("Ford", "Focus", 2022, 20000);
            Coche coche5 = new Coche("Volkswagen", "Golf", 2021, 22000);

            Usuario usuario1 = new Usuario("maria123", "password123", null);
            Usuario usuario2 = new Usuario("paco123", "password123", null);
            Usuario usuario3 = new Usuario("ana123", "password123", null);
            Usuario usuario4 = new Usuario("laura123", "password123", null);
            Usuario usuario5 = new Usuario("pedro123", "password123", null);
            Usuario usuario6 = new Usuario("jorge123", "password123", null);
            Usuario usuario7 = new Usuario("sofia123", "password123", null);
            Usuario usuario8 = new Usuario("lucas123", "password123", null);
            Usuario usuario9 = new Usuario("miguel123", "password123", null);
            Usuario usuario10 = new Usuario("ines123", "password123", null);

            Empleado empleado1 = new Empleado("María Pérez", "Mecánica", 2000, usuario1);
            Empleado empleado2 = new Empleado("Paco Gento", "Mecánico", 1800, usuario2);
            Empleado empleado3 = new Empleado("Ana Gómez", "Mecánica", 2100, usuario3);
            Empleado empleado4 = new Empleado("Laura Ortiz", "Mecánica", 1900, usuario4);
            Empleado empleado5 = new Empleado("Pedro Sánchez", "Mecánico", 2200, usuario5);
            Empleado empleado6 = new Empleado("Jorge Ruiz", "Mecánico", 1700, usuario6);
            Empleado empleado7 = new Empleado("Sofía Ramírez", "Mecánica", 2300, usuario7);
            Empleado empleado8 = new Empleado("Lucas Martín", "Mecánico", 2400, usuario8);
            Empleado empleado9 = new Empleado("Miguel Torres", "Mecánico", 1600, usuario9);
            Empleado empleado10 = new Empleado("Inés Gutiérrez", "Mecánica", 2500, usuario10);

            Reparacion reparacion1 = new Reparacion("Cambio de pastillas de freno", LocalDate.parse("2023-01-10"), 150, coche1, empleado1);
            Reparacion reparacion2 = new Reparacion("Reemplazo de parabrisas", LocalDate.parse("2023-01-12"), 300, coche2, empleado2);
            Reparacion reparacion3 = new Reparacion("Cambio de aceite", LocalDate.parse("2023-01-15"), 80, coche3, empleado3);
            Reparacion reparacion4 = new Reparacion("Revisión general", LocalDate.parse("2023-01-20"), 200, coche4, empleado4);
            Reparacion reparacion5 = new Reparacion("Cambio de batería", LocalDate.parse("2023-01-22"), 120, coche5, empleado5);
            Reparacion reparacion6 = new Reparacion("Cambio de bujías", LocalDate.parse("2023-01-25"), 60, coche1, empleado6);
            Reparacion reparacion7 = new Reparacion("Reemplazo de radiador", LocalDate.parse("2023-01-30"), 250, coche2, empleado7);
            Reparacion reparacion8 = new Reparacion("Alineación de ruedas", LocalDate.parse("2023-02-05"), 100, coche3, empleado8);
            Reparacion reparacion9 = new Reparacion("Cambio de correas", LocalDate.parse("2023-02-10"), 180, coche4, empleado9);
            Reparacion reparacion10 = new Reparacion("Reemplazo de luces", LocalDate.parse("2023-02-15"), 90, coche5, empleado10);

            Venta venta1 = new Venta(LocalDate.parse("2023-02-20"), 16000);
            Venta venta2 = new Venta(LocalDate.parse("2023-02-25"), 18000);
            Venta venta3 = new Venta(LocalDate.parse("2023-03-01"), 20000);



            String menuPrincipal = "// ----------- TALLER MECANICO (by Eric Macià) ------------- //\n"+
                    "\n"+
                    "SELECCIONE UNA OPCIÓN VÁLIDA:\n" +
                    "1. Crear bateria inicial de datos\n" +
                    "2. Probar Operaciones CRUD\n" +
                    "3. Probar Consultas Avanzadas\n" +
                    "0. Salir del Programa\n";

            String menuCRUD = "// ----------- PRUEBA DE OPERACIONES CRUD ------------- //\n"+
                    "\n"+
                    "SELECCIONE UNA OPCIÓN VÁLIDA:\n" +
                    "1. Cliente\n" +
                    "2. Coche\n" +
                    "3. Empleado\n" +
                    "4. Reparacion\n" +
                    "5. Usuario\n" +
                    "6. Venta\n" +
                    "0. Volver al Inicio\n";

            String menuOpcionesCRUD = "// ----------- PRUEBA DE OPERACIONES CRUD ------------- //\n"+
                    "\n"+
                    "SELECCIONE UNA OPCIÓN VÁLIDA:\n" +
                    "1. Crear\n" +
                    "2. Leer\n" +
                    "3. Leer Todos\n" +
                    "4. Modificar\n" +
                    "5. Eliminar\n" +
                    "0. Volver al Inicio\n";

            String menuConsultasAvanzadas = "// ----------- PRUEBA DE CONSULTAS AVANZADAS ------------- //\n"+
                    "\n"+
                    "SELECCIONE UNA OPCIÓN VÁLIDA:\n" +
                    "1. Listar todos los coches vendidos en un rango de fechas\n" +
                    "2. Mostrar las reparaciones realizadas por un mecánico especáfico\n" +
                    "3. Obtener los coches que ha comprado un cliente particular\n" +
                    "4. Calcular el total de ingresos generados por ventas en un mes\n" +
                    "0. Volver al Inicio\n";

            while (!salir){
                System.out.println(menuPrincipal);
                opcion = sc.nextInt();

                switch(opcion){

                    case 1:

                        // -----------------------------------------------------------
                        // ----------    CREAR BATERIA INICIAL DE DATOS    -----------
                        // -----------------------------------------------------------

                        System.out.println("Creando bateria inicial de datos...\n");

                        // Crear Clientes
                        clienteDAOImp.createCliente(cliente1);
                        clienteDAOImp.createCliente(cliente2);
                        clienteDAOImp.createCliente(cliente3);
                        clienteDAOImp.createCliente(cliente4);
                        clienteDAOImp.createCliente(cliente5);

                        // Crear Coches
                        cocheDAOImp.createCoche(coche1);
                        cocheDAOImp.createCoche(coche2);
                        cocheDAOImp.createCoche(coche3);
                        cocheDAOImp.createCoche(coche4);
                        cocheDAOImp.createCoche(coche5);

                        // Crear Usuarios
                        usuarioDAOImp.createUsuario(usuario1);
                        usuarioDAOImp.createUsuario(usuario2);
                        usuarioDAOImp.createUsuario(usuario3);
                        usuarioDAOImp.createUsuario(usuario4);
                        usuarioDAOImp.createUsuario(usuario5);
                        usuarioDAOImp.createUsuario(usuario6);
                        usuarioDAOImp.createUsuario(usuario7);
                        usuarioDAOImp.createUsuario(usuario8);
                        usuarioDAOImp.createUsuario(usuario9);
                        usuarioDAOImp.createUsuario(usuario10);

                        // Crear Empleados
                        empleadoDAOImp.createEmpleado(empleado1);
                        empleadoDAOImp.createEmpleado(empleado2);
                        empleadoDAOImp.createEmpleado(empleado3);
                        empleadoDAOImp.createEmpleado(empleado4);
                        empleadoDAOImp.createEmpleado(empleado5);
                        empleadoDAOImp.createEmpleado(empleado6);
                        empleadoDAOImp.createEmpleado(empleado7);
                        empleadoDAOImp.createEmpleado(empleado8);
                        empleadoDAOImp.createEmpleado(empleado9);
                        empleadoDAOImp.createEmpleado(empleado10);

                        // Crear Reparaciones
                        reparacionDAOImp.createReparacion(reparacion1);
                        reparacionDAOImp.createReparacion(reparacion2);
                        reparacionDAOImp.createReparacion(reparacion3);
                        reparacionDAOImp.createReparacion(reparacion4);
                        reparacionDAOImp.createReparacion(reparacion5);
                        reparacionDAOImp.createReparacion(reparacion6);
                        reparacionDAOImp.createReparacion(reparacion7);
                        reparacionDAOImp.createReparacion(reparacion8);
                        reparacionDAOImp.createReparacion(reparacion9);
                        reparacionDAOImp.createReparacion(reparacion10);

                        // Crear Ventas
                        venta1.setCoches(Arrays.asList(coche1));
                        venta1.setCliente(cliente1);
                        venta1.setEmpleado(empleado1);

                        venta2.setCoches(Arrays.asList(coche2, coche3));
                        venta2.setCliente(cliente2);
                        venta2.setEmpleado(empleado2);

                        venta3.setCoches(Arrays.asList(coche4, coche5));
                        venta3.setCliente(cliente3);
                        venta3.setEmpleado(empleado3);

                        ventaDAOImp.createVenta(venta1);
                        ventaDAOImp.createVenta(venta2);
                        ventaDAOImp.createVenta(venta3);

                        // --------- MANEJO DE TABLA Cliente_Coche ---------------
                        cliente1.addCoche(coche1);
                        cliente1.addCoche(coche2);
                        clienteDAOImp.updateCliente(cliente1);
                        cliente2.addCoche(coche3);
                        cliente2.addCoche(coche4);
                        clienteDAOImp.updateCliente(cliente2);

                        coche1.addCliente(cliente1);
                        coche1.addCliente(cliente2);
                        cocheDAOImp.updateCoche(coche1);
                        coche2.addCliente(cliente1);
                        coche2.addCliente(cliente2);
                        cocheDAOImp.updateCoche(coche2);
                        coche3.addCliente(cliente3);
                        cocheDAOImp.updateCoche(coche3);

                        System.out.println("¡Datos creados exitosamente!\n");

                        break;

                    case 2:

                        // ------------------------------------------------------
                        // ------    MENU DE ENTIDADES PARA PRUEBAS CRUD   ------
                        // ------------------------------------------------------

                        System.out.println(menuCRUD);
                        int opcionMenuCrud = sc.nextInt();
                        sc.nextLine();

                        switch (opcionMenuCrud){
                            case 1:
                                crudManager.menuCrudCliente(sc,clienteDAOImp,menuOpcionesCRUD);
                                break;
                            case 2:
                                crudManager.menuCrudCoche(sc,cocheDAOImp,menuOpcionesCRUD);
                                break;
                            case 3:
                                crudManager.menuCrudEmpleado(sc,empleadoDAOImp,menuOpcionesCRUD);
                                break;
                            case 4:
                                crudManager.menuCrudReparacion(sc,reparacionDAOImp,cocheDAOImp,empleadoDAOImp,
                                        menuOpcionesCRUD, dateTimeFormatter);
                                break;
                            case 5:
                                crudManager.menuCrudUsuario(sc,usuarioDAOImp,empleadoDAOImp,menuOpcionesCRUD);
                                break;
                            case 6:
                                crudManager.menuCrudVenta(sc,ventaDAOImp,clienteDAOImp,cocheDAOImp,
                                        empleadoDAOImp,menuOpcionesCRUD, dateTimeFormatter);
                                break;
                            case 0:
                                System.out.println("Volviendo al inicio");
                                break;
                            default:
                                System.out.println("Por favor, seleccione una opción válida");
                        }

                        break;

                    case 3:

                        // ------------------------------------------------------
                        // ------------ MENÚ DE CONSULTAS AVANZADAS -------------
                        //-------------------------------------------------------

                        System.out.println(menuConsultasAvanzadas);
                        int opcionConsultasAvanzadas = sc.nextInt();
                        sc.nextLine();

                        switch (opcionConsultasAvanzadas){
                            case 1:
                                consultasAvanzadasManager.ConsultaCochesVendidosByRangoDeFechas(sc,
                                        cocheDAOImp,dateTimeFormatter);
                                break;
                            case 2:
                                consultasAvanzadasManager.ConsultaReparacionesRealizadasByMecanico(sc,
                                        reparacionDAOImp,empleadoDAOImp);
                                break;
                            case 3:
                                consultasAvanzadasManager.ConsultaCochesCompradosByCliente(sc,cocheDAOImp,clienteDAOImp);
                                break;
                            case 4:
                                consultasAvanzadasManager.ConsultaIngresosVentasByMes(sc,ventaDAOImp);
                                break;
                            case 0:
                                System.out.println("Volviendo al inicio");
                                break;
                            default:
                                System.out.println("Por favor, seleccione una opción válida");
                        }
                        break;

                    case 0:
                        salir = true;
                        System.out.println("Se ha decidido salir del programa");
                        break;
                    default:
                        System.out.println("Por favor, seleccione una opción válida");
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error, verifique que los datos proporcionados son válidos");
            e.printStackTrace();
        }
    }
}
