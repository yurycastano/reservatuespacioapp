package beans;

import java.util.Date;

public class Reserva {
    private int idreserva;
    private String username;
    private Date fecha;
    private int horario;
    private int salonsocial;

    public Reserva(int idreserva, String username, Date fecha, int horario, int salonsocial) {
        this.idreserva = idreserva;
        this.username = username;
        this.fecha = fecha;
        this.horario = horario;
        this.salonsocial = salonsocial;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getSalonsocial() {
        return salonsocial;
    }

    public void setSalonsocial(int salonsocial) {
        this.salonsocial = salonsocial;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idreserva=" + idreserva + ", username=" + username + ", fecha=" + fecha + ", horario=" + horario + ", salonsocial=" + salonsocial + '}';
    }

}