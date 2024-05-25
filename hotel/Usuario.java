package hotel;

abstract class Usuario {
    protected String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void menu();
}

class Administrador extends Usuario {
    public Administrador(String nombre) {
        super(nombre);
    }

    @Override
    public void menu() {
        System.out.println("Menú de Administrador:");
        System.out.println("1. Añadir Habitación");
        System.out.println("2. Ver Habitaciones");
        System.out.println("3. Mover Habitación");
        System.out.println("4. Eliminar Habitación");
        System.out.println("5. Salir");
    }
}

class Cliente extends Usuario {
    public Cliente(String nombre) {
        super(nombre);
    }

    @Override
    public void menu() {
        System.out.println("Menú de Cliente:");
        System.out.println("1. Ver Habitaciones");
        System.out.println("2. Reservar Habitación");
        System.out.println("3. Solicitar Actualizaciones");
        System.out.println("4. Cancelar Actualizaciones");
        System.out.println("5. Hacer Check-In");
        System.out.println("6. Hacer Check-Out");
        System.out.println("7. Ver Reservas");
        System.out.println("8. Eliminar Reservas");
        System.out.println("9. Salir");
    }
}
