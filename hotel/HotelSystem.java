package hotel;

import java.util.Scanner;

public class HotelSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static HotelManager hotelManager;

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de administración del Hotel Skyloft.");

        do {
            System.out.print("Ingrese el tamaño de la matriz del hotel (N x N): ");
            int size = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            hotelManager = HotelManager.getInstance(size);

            System.out.print("Ingrese su nombre: ");
            String nombre = scanner.nextLine();

            Usuario usuario = login(nombre);

            while (true) {
                usuario.menu();
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir la nueva línea

                if (usuario instanceof Administrador) {
                    manejarOpcionesAdministrador((Administrador) usuario, opcion);
                } else if (usuario instanceof Cliente) {
                    manejarOpcionesCliente((Cliente) usuario, opcion);
                }

                if (opcion == 5 || (usuario instanceof Cliente && opcion == 9)) {
                    break;
                }
            }

            System.out.print("¿Desea volver a ingresar al sistema? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }

        } while (true);

        System.out.println("Gracias por utilizar el sistema.");
    }

    private static Usuario login(String nombre) {
        System.out.print("¿Eres administrador? (s/n): ");
        String esAdmin = scanner.nextLine();
        if (esAdmin.equalsIgnoreCase("s")) {
            return new Administrador(nombre);
        } else {
            return new Cliente(nombre);
        }
    }
    private static void manejarOpcionesAdministrador(Administrador admin, int opcion) {
        switch (opcion) {
            case 1:
                System.out.print("Ingrese tipo de habitación (S, D, Su, P): ");
                String tipo = scanner.nextLine().trim();
                if (!tipo.equals("S") && !tipo.equals("D") && !tipo.equals("Su") && !tipo.equals("P")) {
                    System.out.println("Tipo de habitación no soportado.");
                    return;
                }
                System.out.print("Ingrese fila: ");
                int fila = scanner.nextInt();
                System.out.print("Ingrese columna: ");
                int columna = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                hotelManager.añadirHabitacion(fila, columna, new ConcreteHabitacionFactory().crearHabitacion(tipo, "L"));
                break;
            case 2:
                hotelManager.verHabitaciones();
                break;
            case 3:
                System.out.print("Ingrese fila de origen: ");
                int fromFila = scanner.nextInt();
                System.out.print("Ingrese columna de origen: ");
                int fromColumna = scanner.nextInt();
                System.out.print("Ingrese nueva fila: ");
                int toFila = scanner.nextInt();
                System.out.print("Ingrese nueva columna: ");
                int toColumna = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                hotelManager.moverHabitacion(fromFila, fromColumna, toFila, toColumna);
                break;
            case 4:
                System.out.print("Ingrese fila de la habitación a eliminar: ");
                int eliminarFila = scanner.nextInt();
                System.out.print("Ingrese columna de la habitación a eliminar: ");
                int eliminarColumna = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea
                hotelManager.eliminarHabitacion(eliminarFila, eliminarColumna);
                break;
            case 5:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    private static void manejarOpcionesCliente(Cliente cliente, int opcion) {
        switch (opcion) {
            case 1:
                hotelManager.verHabitaciones();
                break;
            case 2:
                System.out.print("Ingrese la fila de la habitación a reservar: ");
                int filaReserva = scanner.nextInt();
                System.out.print("Ingrese la columna de la habitación a reservar: ");
                int columnaReserva = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (filaReserva >= 1 && filaReserva <= hotelManager.getTamañoHotel() && columnaReserva >= 1 && columnaReserva <= hotelManager.getTamañoHotel()) {
                    Habitacion habitacionReserva = hotelManager.getHabitacion(filaReserva, columnaReserva);
                    if (habitacionReserva != null) {
                        if (habitacionReserva.getEstado().equals("Libre")) {
                            habitacionReserva.setEstado("Reservada");
                            System.out.println("Habitación reservada en (" + filaReserva + "," + columnaReserva + ")");
                        } else {
                            System.out.println("La habitación en (" + filaReserva + "," + columnaReserva + ") ya está ocupada.");
                        }
                    } else {
                        System.out.println("La habitación en (" + filaReserva + "," + columnaReserva + ") no existe.");
                    }
                } else {
                    System.out.println("Posición inválida.");
                }
                break;
            case 3:
                System.out.print("Ingrese la fila de la habitación para recibir actualizaciones: ");
                int filaActualizaciones = scanner.nextInt();
                System.out.print("Ingrese la columna de la habitación para recibir actualizaciones: ");
                int columnaActualizaciones = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (filaActualizaciones >= 1 && filaActualizaciones <= hotelManager.getTamañoHotel() && columnaActualizaciones >= 1 && columnaActualizaciones <= hotelManager.getTamañoHotel()) {
                    // Lógica para agregar la habitación a la lista de seguimiento para actualizaciones
                    System.out.println("Se recibirán actualizaciones para la habitación en (" + filaActualizaciones + "," + columnaActualizaciones + ")");
                } else {
                    System.out.println("Posición inválida.");
                }
                break;
            case 4:
                System.out.print("Ingrese la fila de la habitación para cancelar actualizaciones: ");
                int filaCancelar = scanner.nextInt();
                System.out.print("Ingrese la columna de la habitación para cancelar actualizaciones: ");
                int columnaCancelar = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (filaCancelar >= 1 && filaCancelar <= hotelManager.getTamañoHotel() && columnaCancelar >= 1 && columnaCancelar <= hotelManager.getTamañoHotel()) {
                    // Lógica para eliminar la habitación de la lista de seguimiento para actualizaciones
                    System.out.println("Se han cancelado las actualizaciones para la habitación en (" + filaCancelar + "," + columnaCancelar + ")");
                } else {
                    System.out.println("Posición inválida.");
                }
                break;
            case 5:
                System.out.print("Ingrese la fila de la habitación para hacer check-in: ");
                int filaCheckIn = scanner.nextInt();
                System.out.print("Ingrese la columna de la habitación para hacer check-in: ");
                int columnaCheckIn = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (filaCheckIn >= 1 && filaCheckIn <= hotelManager.getTamañoHotel() && columnaCheckIn >= 1 && columnaCheckIn <= hotelManager.getTamañoHotel()) {
                    Habitacion habitacionCheckIn = hotelManager.getHabitacion(filaCheckIn, columnaCheckIn);
                    if (habitacionCheckIn != null && habitacionCheckIn.getEstado().equals("Reservada")) {
                        habitacionCheckIn.setEstado("Ocupada");
                        System.out.println("Check-in realizado en la habitación en (" + filaCheckIn + "," + columnaCheckIn + ")");
                    } else {
                        System.out.println("La habitación en (" + filaCheckIn + "," + columnaCheckIn + ") no está reservada o no existe.");
                    }
                } else {
                    System.out.println("Posición inválida.");
                }
                break;

            case 6:
                System.out.print("Ingrese la fila de la habitación para hacer check-out: ");
                int filaCheckOut = scanner.nextInt();
                System.out.print("Ingrese la columna de la habitación para hacer check-out: ");
                int columnaCheckOut = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (filaCheckOut >= 1 && filaCheckOut <= hotelManager.getTamañoHotel() && columnaCheckOut >= 1 && columnaCheckOut <= hotelManager.getTamañoHotel()) {
                    Habitacion habitacionCheckOut = hotelManager.getHabitacion(filaCheckOut, columnaCheckOut);
                    if (habitacionCheckOut != null && habitacionCheckOut.getEstado().equals("Ocupada")) {
                        habitacionCheckOut.setEstado("Libre");
                        System.out.println("Check-out realizado en la habitación en (" + filaCheckOut + "," + columnaCheckOut + ")");
                    } else {
                        System.out.println("La habitación en (" + filaCheckOut + "," + columnaCheckOut + ") no está ocupada o no existe.");
                    }
                } else {
                    System.out.println("Posición inválida.");
                }
                break;

            case 7:
                System.out.println("Habitaciones reservadas:");
                for (int i = 1; i <= hotelManager.getTamañoHotel(); i++) {
                    for (int j = 1; j <= hotelManager.getTamañoHotel(); j++) {
                        Habitacion habitacion = hotelManager.getHabitacion(i, j);
                        if (habitacion != null && habitacion.getEstado().equals("Reservada")) {
                            System.out.println("Habitación en (" + i + "," + j + ")");
                        }
                    }
                }
                break;

            case 8:
                System.out.print("Ingrese la fila de la habitación para eliminar la reserva: ");
                int filaEliminarReserva = scanner.nextInt();
                System.out.print("Ingrese la columna de la habitación para eliminar la reserva: ");
                int columnaEliminarReserva = scanner.nextInt();
                scanner.nextLine(); // Consumir la nueva línea

                if (filaEliminarReserva >= 1 && filaEliminarReserva <= hotelManager.getTamañoHotel() && columnaEliminarReserva >= 1 && columnaEliminarReserva <= hotelManager.getTamañoHotel()) {
                    Habitacion habitacionEliminarReserva = hotelManager.getHabitacion(filaEliminarReserva, columnaEliminarReserva);
                    if (habitacionEliminarReserva != null && habitacionEliminarReserva.getEstado().equals("Reservada")) {
                        habitacionEliminarReserva.setEstado("Libre");
                        System.out.println("Reserva eliminada en la habitación en (" + filaEliminarReserva + "," + columnaEliminarReserva + ")");
                    } else {
                        System.out.println("La habitación en (" + filaEliminarReserva + "," + columnaEliminarReserva + ") no está reservada o no existe.");
                    }
                } else {
                    System.out.println("Posición inválida.");
                }
                break;
            case 9:
                System.out.println("Saliendo del sistema...");
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

}
