package hotel;

abstract class Habitacion {
    protected String estado; // R: Reservado, L: Libre, O: Ocupado
    protected String tipo;   // S: Single, D: Double, Su: Suite, P: Presidencial

    public Habitacion(String estado, String tipo) {
        this.estado = estado;
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo + ", " + estado;
    }
}

class Simple extends Habitacion {
    public Simple(String estado) {
        super(estado, "S");
    }
}

class Doble extends Habitacion {
    public Doble(String estado) {
        super(estado, "D");
    }
}

class Suite extends Habitacion {
    public Suite(String estado) {
        super(estado, "Su");
    }
}

class Presidencial extends Habitacion {
    public Presidencial(String estado) {
        super(estado, "P");
    }
}
