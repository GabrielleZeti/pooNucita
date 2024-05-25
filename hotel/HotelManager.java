package hotel;

public class HotelManager {
    private static HotelManager instance;
    private Habitacion[][] habitaciones;
    private int tamañoHotel;

    private HotelManager(int size) {
        tamañoHotel = size;
        habitaciones = new Habitacion[size + 1][size + 1]; // Aumentar en 1 el tamaño para comenzar desde 1
    }

    public static synchronized HotelManager getInstance(int size) {
        if (instance == null) {
            instance = new HotelManager(size);
        }
        return instance;
    }

    public int getTamañoHotel() {
        return tamañoHotel;
    }

    public Habitacion getHabitacion(int fila, int columna) {
        if (fila >= 1 && fila <= tamañoHotel && columna >= 1 && columna <= tamañoHotel) {
            return habitaciones[fila][columna];
        } else {
            return null;
        }
    }

    public void añadirHabitacion(int fila, int columna, Habitacion habitacion) {
        if (fila >= 1 && fila < habitaciones.length && columna >= 1 && columna < habitaciones[0].length) {
            if (habitaciones[fila][columna] == null) {
                habitaciones[fila][columna] = habitacion;
                System.out.println("Habitación añadida en (" + fila + "," + columna + ")");
            } else {
                System.out.println("El espacio en (" + fila + "," + columna + ") ya está ocupado.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public void verHabitaciones() {
        for (int i = 1; i < habitaciones.length; i++) {
            for (int j = 1; j < habitaciones[0].length; j++) {
                Habitacion hab = habitaciones[i][j];
                if (hab == null) {
                    System.out.print("Libre  ");
                } else {
                    System.out.print(hab + "  ");
                }
            }
            System.out.println();
        }
    }

    public void moverHabitacion(int fromFila, int fromColumna, int toFila, int toColumna) {
        if (fromFila >= 1 && fromFila < habitaciones.length && fromColumna >= 1 && fromColumna < habitaciones[0].length &&
                toFila >= 1 && toFila < habitaciones.length && toColumna >= 1 && toColumna < habitaciones[0].length) {
            if (habitaciones[fromFila][fromColumna] != null && habitaciones[toFila][toColumna] == null) {
                habitaciones[toFila][toColumna] = habitaciones[fromFila][fromColumna];
                habitaciones[fromFila][fromColumna] = null;
                System.out.println("Habitación movida a (" + toFila + "," + toColumna + ")");
            } else {
                System.out.println("Movimiento no válido.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }

    public void eliminarHabitacion(int fila, int columna) {
        if (fila >= 1 && fila < habitaciones.length && columna >= 1 && columna < habitaciones[0].length) {
            if (habitaciones[fila][columna] != null) {
                habitaciones[fila][columna] = null;
                System.out.println("Habitación eliminada en (" + fila + "," + columna + ")");
            } else {
                System.out.println("No hay habitación en (" + fila + "," + columna + ") para eliminar.");
            }
        } else {
            System.out.println("Posición inválida.");
        }
    }
}
