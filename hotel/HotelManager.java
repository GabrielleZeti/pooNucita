package hotel;

import java.util.HashMap;
import java.util.Map;

class HotelManager {
    private static HotelManager instance;
    private Map<String, Habitacion> habitaciones;

    private HotelManager() {
        habitaciones = new HashMap<>();
    }

    public static synchronized HotelManager getInstance() {
        if (instance == null) {
            instance = new HotelManager();
        }
        return instance;
    }

    public void añadirHabitacion(String key, Habitacion habitacion) {
        habitaciones.put(key, habitacion);
    }

    public Habitacion obtenerHabitacion(String key) {
        return habitaciones.get(key);
    }

    public void moverHabitacion(String fromKey, String toKey) {
        Habitacion habitacion = habitaciones.remove(fromKey);
        if (habitacion != null) {
            habitaciones.put(toKey, habitacion);
        }
    }

    public void eliminarHabitacion(String key) {
        habitaciones.remove(key);
    }

    public void verHabitaciones() {
        habitaciones.forEach((key, habitacion) -> {
            System.out.println("Ubicación: " + key + " - " + habitacion);
        });
    }
}
