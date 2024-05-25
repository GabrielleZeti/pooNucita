package hotel;

abstract class HabitacionFactory {
    public abstract Habitacion crearHabitacion(String tipo, String estado);
}

class ConcreteHabitacionFactory extends HabitacionFactory {
    @Override
    public Habitacion crearHabitacion(String tipo, String estado) {
        switch (tipo) {
            case "S":
                return new Simple(estado);
            case "D":
                return new Doble(estado);
            case "Su":
                return new Suite(estado);
            case "P":
                return new Presidencial(estado);
            default:
                throw new IllegalArgumentException("Tipo de habitación no soportado.");
        }
    }
}
