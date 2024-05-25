package hotel;

public class ConcreteHabitacionFactory extends HabitacionFactory {
    @Override
    public Habitacion crearHabitacion(String tipo, String estado) {
        switch (tipo) {
            case "S":
                return new Habitacion("Single", estado);
            case "D":
                return new Habitacion("Double", estado);
            case "Su":
                return new Habitacion("Suite", estado);
            case "P":
                return new Habitacion("Presidential", estado);
            default:
                throw new IllegalArgumentException("Tipo de habitación no soportado.");
        }
    }
}
