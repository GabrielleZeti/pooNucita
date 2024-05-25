package hotel;

import java.util.Scanner;

public class HotelSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static HotelManager hotelManager = HotelManager.getInstance();
    private static HabitacionFactory habitacionFactory = new ConcreteHabitacionFactory();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de administración del Hotel Skyloft.");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        Usuario usuario = login(nombre);

        while (true) {
            usuario.menu();
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la línea

            if (usuario instanceof Administrador) {
                manejarOpcionesAdministrador((Administrador) usuario, opcion);
            } else if (usuario instanceof Cliente) {
                manejarOpcionesCliente((Cliente) usuario, opcion);
            }

            if (opcion == 5 || (usuario instanceof Cliente && opcion == 9)) {
                break;
            }
        }
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
                String tipo = scanner.nextLine();
                System.out.print("Ingrese ubicación (fila,columna): ");
                String ubicacion = scanner.nextLine();
                hotelManager.añadirHabitacion(ubicacion, habitacionFactory.crearHabitacion(tipo, "L"));
                break;
            case 2:
                hotelManager.verHabitaciones();
                break;
            case 3:
                System.out.print("Ingrese ubicación de origen (fila,columna): ");
                String from = scanner.nextLine();
                System.out.print("Ingrese nueva ubicación (fila,columna): ");
                String to = scanner.nextLine();
                hotelManager.moverHabitacion(from, to);
                break;
            case 4:
                System.out.print("Ingrese ubicación de la habitación a eliminar (fila,columna): ");
                String eliminar = scanner.nextLine();
                hotelManager.eliminarHabitacion(eliminar);
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
        // Implementar las opciones del cliente de manera similar
        // a las opciones del administrador
    }
}
