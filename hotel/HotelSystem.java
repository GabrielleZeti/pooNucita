package hotel;

import java.util.Scanner;

public class HotelSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static HotelManager hotelManager;

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de administración del Hotel Skyloft.");
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
        // Implementar las opciones del cliente de manera similar
        // a las opciones del administrador
    }
}
