public class Reserva {
    private String identificador;
    private String fecha;
    private String nombreReservante;

    public Reserva() {
    }
    public Reserva(String identificador, String fecha, String nombreReservante) {
        this.identificador = identificador;
        this.fecha = fecha;
        this.nombreReservante = nombreReservante;
    }

    public String getIdentificador() {
        return identificador;
    }
    public String getFecha() {
        return fecha;
    }
    public String getNombreReservante() {
        return nombreReservante;
    }

    @Override
    public String toString() {
        return "Reserva [ID: " + identificador + ", Fecha: " + fecha + ", Reservante: " + nombreReservante + "]";
    }
}