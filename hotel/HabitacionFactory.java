package hotel;

public abstract class HabitacionFactory {
    public abstract Habitacion crearHabitacion(String tipo, String estado);
}
