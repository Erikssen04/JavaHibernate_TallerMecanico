package org.example.services;

import org.example.DAOimplement.*;
import org.example.models.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CrudManager {
    public void menuCrudCliente (Scanner sc, ClienteDAOImp clienteDAOImp, String menuOpcionesCRUD){

        System.out.println("Se ha seleccioonado el modelo Cliente");
        System.out.println(menuOpcionesCRUD);

        int opcionCrudCliente = sc.nextInt();
        sc.nextLine();

        switch (opcionCrudCliente){
            case 1:
                // CREATE
                System.out.println("Introduzca nombre del cliente a crear");
                String nombreCliente = sc.nextLine();

                System.out.println("Introduzca email del cliente a crear");
                String emailCliente = sc.nextLine();

                System.out.println("Introduzca teléfono del cliente a crear");
                String telefonoCliente = sc.nextLine();

                clienteDAOImp.createCliente(new Cliente(nombreCliente, emailCliente, telefonoCliente));
                System.out.println("Cliente creado exitosamente");
                break;
            case 2:
                // FIND ONE
                System.out.println("Introduzca id del cliente a buscar");
                int idCliente = sc.nextInt();
                sc.nextLine();

                Cliente clienteBuscar = clienteDAOImp.findCliente(idCliente);
                if (clienteBuscar != null) {
                    System.out.println("Cliente encontrado: " + clienteBuscar);
                } else {
                    System.out.println("Cliente no encontrado");
                }
                break;
            case 3:
                // FIND ALL
                List<Cliente> conjuntoClientes = clienteDAOImp.findAllClientes();
                if (!conjuntoClientes.isEmpty()) {
                    System.out.println("Conjunto de clientes registrados: ");
                    for (Cliente cliente : conjuntoClientes) {
                        System.out.println(cliente);
                    }
                } else {
                    System.out.println("No hay ningún cliente registrado");
                }
                break;
            case 4:
                // UPDATE
                System.out.println("Introduzca id del cliente a actualizar");
                int idClienteUpdate = sc.nextInt();
                sc.nextLine();

                Cliente clienteActualizar = clienteDAOImp.findCliente(idClienteUpdate);
                if (clienteActualizar != null) {
                    System.out.println("Cliente a actualizar: " + clienteActualizar);

                    System.out.println("Introduzca nuevo nombre del cliente");
                    String nombreClienteUpdate = sc.nextLine();

                    System.out.println("Introduzca nuevo email del cliente");
                    String emailClienteUpdate = sc.nextLine();

                    System.out.println("Introduzca nuevo teléfono del cliente");
                    String telefonoClienteUpdate = sc.nextLine();

                    clienteActualizar.setNombre(nombreClienteUpdate);
                    clienteActualizar.setEmail(emailClienteUpdate);
                    clienteActualizar.setTelefono(telefonoClienteUpdate);

                    clienteDAOImp.updateCliente(clienteActualizar);
                    System.out.println("Cliente actualizado exitosamente: " + clienteActualizar);
                } else {
                    System.out.println("Cliente no encontrado");
                }
                break;
            case 5:
                // DELETE
                System.out.println("Introduzca id del cliente a eliminar");
                int idClienteDelete = sc.nextInt();
                sc.nextLine();

                Cliente clienteEliminar = clienteDAOImp.findCliente(idClienteDelete);
                if (clienteEliminar != null) {
                    clienteDAOImp.deleteCliente(idClienteDelete);
                    System.out.println("Cliente eliminado exitosamente");
                } else {
                    System.out.println("Cliente no encontrado");
                }
                break;
            case 0:
                System.out.println("Volviendo al inicio");
                break;
            default:
                System.out.println("Por favor, seleccione una opción válida");
        }
    }

    public void menuCrudCoche (Scanner sc, CocheDAOImp cocheDAOImp, String menuOpcionesCRUD){

        System.out.println("Se ha seleccionado el modelo Coche");
        System.out.println(menuOpcionesCRUD);

        int opcionCrudCoche = sc.nextInt();
        sc.nextLine();

        switch (opcionCrudCoche) {
            case 1:
                // CREATE
                System.out.println("Introduzca marca del coche a crear:");
                String marcaCoche = sc.nextLine();

                System.out.println("Introduzca modelo del coche a crear:");
                String modeloCoche = sc.nextLine();

                System.out.println("Introduzca año del coche a crear:");
                int anyoCoche = sc.nextInt();

                System.out.println("Introduzca precio del coche a crear:");
                double precioCoche = sc.nextDouble();

                cocheDAOImp.createCoche(new Coche(marcaCoche, modeloCoche, anyoCoche, precioCoche));
                System.out.println("Coche creado exitosamente.");
                break;
            case 2:
                // FIND ONE
                System.out.println("Introduzca id del coche a buscar");
                int idCoche = sc.nextInt();
                sc.nextLine();

                Coche cocheBuscar = cocheDAOImp.findCoche(idCoche);
                if (cocheBuscar != null) {
                    System.out.println("Coche encontrado: " + cocheBuscar);
                } else {
                    System.out.println("Coche no encontrado");
                }

                break;
            case 3:
                // FIND ALL
                List<Coche> conjuntoCoches = cocheDAOImp.findAllCoches();
                if (!conjuntoCoches.isEmpty()) {
                    System.out.println("Conjunto de coches registrados:");
                    for (Coche coche : conjuntoCoches) {
                        System.out.println(coche);
                    }
                } else {
                    System.out.println("No hay ningún coche registrado.");
                }
                break;
            case 4:
                // UPDATE
                System.out.println("Introduzca id del coche a actualizar:");
                int idCocheUpdate = sc.nextInt();
                sc.nextLine();

                Coche cocheActualizar = cocheDAOImp.findCoche(idCocheUpdate);
                if (cocheActualizar != null) {
                    System.out.println("Coche a actualizar: " + cocheActualizar);

                    System.out.println("Introduzca nueva marca:");
                    cocheActualizar.setMarca(sc.nextLine());

                    System.out.println("Introduzca nuevo modelo:");
                    cocheActualizar.setModelo(sc.nextLine());

                    System.out.println("Introduzca nuevo año:");
                    cocheActualizar.setAnyo(sc.nextInt());

                    System.out.println("Introduzca nuevo precio:");
                    cocheActualizar.setPrecio(sc.nextDouble());

                    cocheDAOImp.updateCoche(cocheActualizar);
                    System.out.println("Coche actualizado exitosamente: " + cocheActualizar);
                } else {
                    System.out.println("Coche no encontrado");
                }
                break;
            case 5:
                // DELETE
                System.out.println("Introduzca id del coche a eliminar:");
                int idCocheDelete = sc.nextInt();
                Coche cocheEliminar = cocheDAOImp.findCoche(idCocheDelete);
                if (cocheEliminar != null) {
                    cocheDAOImp.deleteCoche(idCocheDelete);
                    System.out.println("Coche eliminado exitosamente.");
                } else {
                    System.out.println("Coche no encontrado.");
                }
                break;
            case 0:
                System.out.println("Volviendo al inicio");
                break;
            default:
                System.out.println("Por favor, seleccione una opción válida");
        }

    }
    public void menuCrudEmpleado(Scanner sc, EmpleadoDAOImp empleadoDAOImp, String menuOpcionesCRUD){

        System.out.println("Se ha seleccionado el modelo Empleado");
        System.out.println(menuOpcionesCRUD);

        int opcionCrudEmpleado = sc.nextInt();
        sc.nextLine();

        switch (opcionCrudEmpleado) {
            case 1:
                // CREATE
                System.out.println("Introduzca nombre del empleado a crear:");
                String nombreEmpleado = sc.nextLine();

                System.out.println("Introduzca puesto del empleado a crear:");
                String puestoEmpleado = sc.nextLine();

                System.out.println("Introduzca salario del empleado a crear:");
                double salarioEmpleado = sc.nextDouble();
                sc.nextLine();

                System.out.println("Introduzca nombre de usuario del empleado:");
                String username = sc.nextLine();

                System.out.println("Introduzca contraseña del usuario:");
                String password = sc.nextLine();

                Usuario usuario = new Usuario(username, password, null);
                Empleado nuevoEmpleado = new Empleado(nombreEmpleado, puestoEmpleado, salarioEmpleado, usuario);
                usuario.setEmpleado(nuevoEmpleado);

                empleadoDAOImp.createEmpleado(nuevoEmpleado);
                System.out.println("Empleado creado exitosamente.");
                break;
            case 2:
                // FIND ONE
                System.out.println("Introduzca id del empleado a buscar");
                int idEmpleado = sc.nextInt();
                sc.nextLine();

                Empleado empleadoBuscar = empleadoDAOImp.findEmpleado(idEmpleado);
                if (empleadoBuscar != null) {
                    System.out.println("Empleado encontrado: " + empleadoBuscar);
                } else {
                    System.out.println("Empleado no encontrado");
                }
                break;
            case 3:
                // FIND ALL
                List<Empleado> conjuntoEmpleados = empleadoDAOImp.findAllEmpleados();
                if (!conjuntoEmpleados.isEmpty()) {
                    System.out.println("Conjunto de empleados registrados:");
                    for (Empleado empleado : conjuntoEmpleados) {
                        System.out.println(empleado);
                    }
                } else {
                    System.out.println("No hay ningún empleado registrado.");
                }
                break;
            case 4:
                // UPDATE
                System.out.println("Introduzca id del empleado a actualizar:");
                int idEmpleadoUpdate = sc.nextInt();
                sc.nextLine();

                Empleado empleadoActualizar = empleadoDAOImp.findEmpleado(idEmpleadoUpdate);
                if (empleadoActualizar != null) {
                    System.out.println("Empleado a actualizar: " + empleadoActualizar);

                    System.out.println("Introduzca nuevo nombre:");
                    empleadoActualizar.setNombre(sc.nextLine());

                    System.out.println("Introduzca nuevo puesto:");
                    empleadoActualizar.setPuesto(sc.nextLine());

                    System.out.println("Introduzca nuevo salario:");
                    empleadoActualizar.setSalario(sc.nextDouble());

                    empleadoDAOImp.updateEmpleado(empleadoActualizar);
                    System.out.println("Empleado actualizado exitosamente: " + empleadoActualizar);
                } else {
                    System.out.println("Empleado no encontrado");
                }
                break;
            case 5:
                // DELETE
                System.out.println("Introduzca id del empleado a eliminar:");
                int idEmpleadoDelete = sc.nextInt();
                Empleado empleadoEliminar = empleadoDAOImp.findEmpleado(idEmpleadoDelete);
                if (empleadoEliminar != null) {
                    empleadoDAOImp.deleteEmpleado(idEmpleadoDelete);
                    System.out.println("Empleado eliminado exitosamente.");
                } else {
                    System.out.println("Empleado no encontrado.");
                }
                break;
            case 0:
                System.out.println("Volviendo al inicio");
                break;
            default:
                System.out.println("Por favor, seleccione una opción válida");
        }
    }
    public void menuCrudReparacion(Scanner sc, ReparacionDAOImp reparacionDAOImp, CocheDAOImp cocheDAOImp,
                                   EmpleadoDAOImp empleadoDAOImp, String menuOpcionesCRUD,
                                   DateTimeFormatter dateTimeFormatter){
        System.out.println("Se ha seleccionado el modelo Reparación");
        System.out.println(menuOpcionesCRUD);

        int opcionCrudReparacion = sc.nextInt();
        sc.nextLine();

        switch (opcionCrudReparacion) {
            case 1:
                // CREATE
                System.out.println("Introduzca descripción de la reparación:");
                String descripcionReparacion = sc.nextLine();

                System.out.println("Introduzca fecha de la reparación (YYYY-MM-DD):");
                String fechaReparacion = sc.nextLine();
                LocalDate fechaReparacionFormateada = LocalDate.parse(fechaReparacion, dateTimeFormatter);

                System.out.println("Introduzca costo de la reparación:");
                double costoReparacion = sc.nextDouble();

                System.out.println("Introduzca id del coche relacionado:");
                int cocheIdReparacion = sc.nextInt();

                System.out.println("Introduzca id del empleado relacionado:");
                int empleadoIdReparacion = sc.nextInt();

                Coche cocheReparacion = cocheDAOImp.findCoche(cocheIdReparacion);
                Empleado empleadoReparacion = empleadoDAOImp.findEmpleado(empleadoIdReparacion);

                Reparacion nuevaReparacion = new Reparacion(descripcionReparacion, fechaReparacionFormateada, costoReparacion, cocheReparacion, empleadoReparacion);
                reparacionDAOImp.createReparacion(nuevaReparacion);

                System.out.println("Reparación creada exitosamente.");
                break;
            case 2:
                // FIND ONE
                System.out.println("Introduzca id de la reparación a buscar");
                int idReparacion = sc.nextInt();
                sc.nextLine();

                Reparacion reparacionBuscar = reparacionDAOImp.findReparacion(idReparacion);
                if (reparacionBuscar != null) {
                    System.out.println("Reparación encontrada: " + reparacionBuscar);
                } else {
                    System.out.println("Reparación no encontrada");
                }
                break;
            case 3:
                // FIND ALL
                List<Reparacion> conjuntoReparaciones = reparacionDAOImp.findAllReparaciones();
                if (!conjuntoReparaciones.isEmpty()) {
                    System.out.println("Conjunto de reparaciones registradas:");
                    for (Reparacion reparacion : conjuntoReparaciones) {
                        System.out.println(reparacion);
                    }
                } else {
                    System.out.println("No hay ninguna reparación registrada.");
                }
                break;
            case 4:
                // UPDATE
                System.out.println("Introduzca id de la reparación a actualizar:");
                int idReparacionUpdate = sc.nextInt();
                sc.nextLine();

                Reparacion reparacionActualizar = reparacionDAOImp.findReparacion(idReparacionUpdate);
                if (reparacionActualizar != null) {
                    System.out.println("Reparación a actualizar: " + reparacionActualizar);

                    System.out.println("Introduzca nueva descripción:");
                    reparacionActualizar.setDescripcion(sc.nextLine());

                    System.out.println("Introduzca nueva fecha:");
                    String fechaReparacionActualizar = sc.nextLine();
                    LocalDate fechaReparacionActualizarFormateada = LocalDate.parse(fechaReparacionActualizar, dateTimeFormatter);
                    reparacionActualizar.setFecha(fechaReparacionActualizarFormateada);

                    System.out.println("Introduzca nuevo costo:");
                    reparacionActualizar.setCosto(sc.nextDouble());

                    reparacionDAOImp.updateReparacion(reparacionActualizar);
                    System.out.println("Reparación actualizada exitosamente: " + reparacionActualizar);
                } else {
                    System.out.println("Reparacion no encontrada");
                }
                break;
            case 5:
                // DELETE
                System.out.println("Introduzca id de la reparación a eliminar:");
                int idReparacionDelete = sc.nextInt();
                Reparacion reparacionEliminar = reparacionDAOImp.findReparacion(idReparacionDelete);
                if (reparacionEliminar != null) {
                    reparacionDAOImp.deleteReparacion(idReparacionDelete);
                    System.out.println("Reparación eliminada exitosamente.");
                } else {
                    System.out.println("Reparación no encontrada.");
                }
                break;
            case 0:
                System.out.println("Volviendo al inicio");
                break;
            default:
                System.out.println("Por favor, seleccione una opción válida");
        }
    }
    public void menuCrudUsuario(Scanner sc, UsuarioDAOImp usuarioDAOImp, EmpleadoDAOImp empleadoDAOImp,
                                String menuOpcionesCRUD){
        // --------------------- USUARIO -----------------------

        System.out.println("Se ha seleccionado el modelo Usuario");
        System.out.println(menuOpcionesCRUD);

        int opcionCrudUsuario = sc.nextInt();
        sc.nextLine();

        switch (opcionCrudUsuario) {
            case 1:
                // CREATE
                System.out.println("Introduzca nombre de usuario:");
                String usernameUsuario = sc.nextLine();

                System.out.println("Introduzca contraseña:");
                String passwordUsuario = sc.nextLine();

                System.out.println("¿Desea asociar este usuario con un empleado existente? (S/N):");
                String asociarEmpleado = sc.nextLine().toUpperCase();

                Empleado empleadoUsuario = null;
                if (asociarEmpleado.equals("S")) {
                    System.out.println("Introduzca el id del empleado:");
                    int empleadoId = sc.nextInt();
                    empleadoUsuario = empleadoDAOImp.findEmpleado(empleadoId);
                    sc.nextLine();
                    if (empleadoUsuario == null) {
                        System.out.println("Empleado no encontrado. Se creará el usuario sin asociación.");
                    }
                }

                Usuario nuevoUsuario = new Usuario(usernameUsuario, passwordUsuario, empleadoUsuario);
                usuarioDAOImp.createUsuario(nuevoUsuario);

                if (empleadoUsuario != null) {
                    empleadoUsuario.setUsuario(nuevoUsuario);
                    empleadoDAOImp.updateEmpleado(empleadoUsuario);
                }

                System.out.println("Usuario creado exitosamente.");
                break;
            case 2:
                // FIND ONE
                System.out.println("Introduzca id del usuario a buscar");
                int idUsuario = sc.nextInt();
                sc.nextLine();

                Usuario usuarioBuscar = usuarioDAOImp.findUsuario(idUsuario);
                if (usuarioBuscar != null) {
                    System.out.println("Usuario encontrado: " + usuarioBuscar);
                } else {
                    System.out.println("Usuario no encontrado");
                }
                break;
            case 3:
                // FIND ALL
                List<Usuario> conjuntoUsuarios = usuarioDAOImp.findAllUsuarios();
                if (!conjuntoUsuarios.isEmpty()) {
                    System.out.println("Conjunto de usuarios registrados:");
                    for (Usuario usuario : conjuntoUsuarios) {
                        System.out.println(usuario);
                    }
                } else {
                    System.out.println("No hay ningún usuario registrado.");
                }
                break;
            case 4:
                // UPDATE
                System.out.println("Introduzca id del usuario a actualizar:");
                int idUsuarioUpdate = sc.nextInt();
                sc.nextLine();

                Usuario usuarioActualizar = usuarioDAOImp.findUsuario(idUsuarioUpdate);
                if (usuarioActualizar != null) {
                    System.out.println("Usuario a actualizar: " + usuarioActualizar);

                    System.out.println("Introduzca nuevo nombre de usuario:");
                    usuarioActualizar.setUsername(sc.nextLine());

                    System.out.println("Introduzca nueva contraseña:");
                    usuarioActualizar.setPassword(sc.nextLine());

                    usuarioDAOImp.updateUsuario(usuarioActualizar);
                    System.out.println("Usuario actualizado exitosamente: " + usuarioActualizar);
                } else {
                    System.out.println("Usuario no encontrado");
                }
                break;
            case 5:
                // DELETE
                System.out.println("Introduzca id del usuario a eliminar:");
                int idUsuarioDelete = sc.nextInt();
                Usuario usuarioEliminar = usuarioDAOImp.findUsuario(idUsuarioDelete);
                if (usuarioEliminar != null) {
                    usuarioDAOImp.deleteUsuario(idUsuarioDelete);
                    System.out.println("Usuario eliminado exitosamente.");
                } else {
                    System.out.println("Usuario no encontrado.");
                }
                break;
            case 0:
                System.out.println("Volviendo al inicio");
                break;
            default:
                System.out.println("Por favor, seleccione una opción válida");
        }
    }
    public void menuCrudVenta(Scanner sc, VentaDAOImp ventaDAOImp, ClienteDAOImp clienteDAOImp,
                              CocheDAOImp cocheDAOImp, EmpleadoDAOImp empleadoDAOImp, String menuOpcionesCRUD,
                              DateTimeFormatter dateTimeFormatter){
        // ------------------------- VENTA -------------------------

        System.out.println("Se ha seleccionado el modelo Venta");
        System.out.println(menuOpcionesCRUD);

        int opcionCrudVenta = sc.nextInt();
        sc.nextLine();

        switch (opcionCrudVenta) {
            case 1:
                // CREATE
                System.out.println("Introduzca fecha de la venta (YYYY-MM-DD):");
                String fechaVenta = sc.nextLine();
                LocalDate fechaVentaFormateada = LocalDate.parse(fechaVenta, dateTimeFormatter);

                System.out.println("Introduzca monto de la venta:");
                double montoVenta = sc.nextDouble();

                System.out.println("Introduzca id del cliente asociado:");
                int clienteIdVenta = sc.nextInt();

                System.out.println("Introduzca id del empleado asociado:");
                int empleadoIdVenta = sc.nextInt();

                sc.nextLine();
                System.out.println("¿Cuántos coches están asociados con esta venta?");
                int numCoches = sc.nextInt();

                Cliente clienteVenta = clienteDAOImp.findCliente(clienteIdVenta);
                Empleado empleadoVenta = empleadoDAOImp.findEmpleado(empleadoIdVenta);

                if (clienteVenta == null || empleadoVenta == null) {
                    System.out.println("Cliente o empleado no encontrado. No se puede crear la venta.");
                    break;
                }

                List<Coche> cochesVenta = new ArrayList<>();
                for (int i = 0; i < numCoches; i++) {
                    System.out.println("Introduzca id del coche " + (i + 1) + ":");
                    int cocheId = sc.nextInt();
                    Coche cocheVenta = cocheDAOImp.findCoche(cocheId);
                    if (cocheVenta != null) {
                        cochesVenta.add(cocheVenta);
                    } else {
                        System.out.println("Coche con id " + cocheId + " no encontrado.");
                    }
                }

                Venta nuevaVenta = new Venta(fechaVentaFormateada, montoVenta);
                nuevaVenta.setCliente(clienteVenta);
                nuevaVenta.setEmpleado(empleadoVenta);
                nuevaVenta.setCoches(cochesVenta);

                ventaDAOImp.createVenta(nuevaVenta);
                System.out.println("Venta creada exitosamente.");
                break;
            case 2:
                // FIND ONE
                System.out.println("Introduzca id de la venta a buscar");
                int idVenta = sc.nextInt();
                sc.nextLine();

                Venta ventaBuscar = ventaDAOImp.findVenta(idVenta);
                if (ventaBuscar != null) {
                    System.out.println("Venta encontrada: " + ventaBuscar);
                } else {
                    System.out.println("Venta no encontrada");
                }
                break;
            case 3:
                // FIND ALL
                List<Venta> conjuntoVentas = ventaDAOImp.findAllVentas();
                if (!conjuntoVentas.isEmpty()) {
                    System.out.println("Conjunto de ventas registradas:");
                    for (Venta venta : conjuntoVentas) {
                        System.out.println(venta);
                    }
                } else {
                    System.out.println("No hay ninguna venta registrada.");
                }
                break;
            case 4:
                // UPDATE
                System.out.println("Introduzca id de la venta a actualizar:");
                int idVentaUpdate = sc.nextInt();
                sc.nextLine();

                Venta ventaActualizar = ventaDAOImp.findVenta(idVentaUpdate);
                if (ventaActualizar != null) {
                    System.out.println("Venta a actualizar: " + ventaActualizar);

                    System.out.println("Introduzca nueva fecha:");
                    ventaActualizar.setFecha(LocalDate.parse(sc.nextLine(), dateTimeFormatter));

                    System.out.println("Introduzca nuevo monto:");
                    ventaActualizar.setMonto(sc.nextDouble());

                    ventaDAOImp.updateVenta(ventaActualizar);
                    System.out.println("Venta actualizada exitosamente: " + ventaActualizar);
                } else {
                    System.out.println("Venta no encontrada");
                }
                break;
            case 5:
                // DELETE
                System.out.println("Introduzca id de la venta a eliminar:");
                int idVentaDelete = sc.nextInt();
                Venta ventaEliminar = ventaDAOImp.findVenta(idVentaDelete);
                if (ventaEliminar != null) {
                    ventaDAOImp.deleteVenta(idVentaDelete);
                    System.out.println("Venta eliminada exitosamente.");
                } else {
                    System.out.println("Venta no encontrada.");
                }

                break;

            case 0:
                System.out.println("Volviendo al inicio");
                break;
            default:
                System.out.println("Por favor, seleccione una opción válida");
        }

    }
}
