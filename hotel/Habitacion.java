package hotel;

public class Habitacion {
    private String tipo;
    private String estado;

    public Habitacion(String tipo, String estado) {
        this.tipo = tipo;
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return tipo + "-" + estado;
    }
}
