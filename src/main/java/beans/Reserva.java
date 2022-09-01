package beans;

import java.sql.Date;

public class Reserva {
    private int idreserva;
    private String username;
    private Date fecha;
    private boolean hoarario;
    private int salonsocial;

    public Reserva(int idreserva, String username, Date fecha, boolean hoarario, int salonsocial) {
        this.idreserva = idreserva;
        this.username = username;
        this.fecha = fecha;
        this.hoarario = hoarario;
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

    public boolean isHoarario() {
        return hoarario;
    }

    public void setHoarario(boolean hoarario) {
        this.hoarario = hoarario;
    }

    public int getSalonsocial() {
        return salonsocial;
    }

    public void setSalonsocial(int salonsocial) {
        this.salonsocial = salonsocial;
    }

    @Override
    public String toString() {
        return "Reserva{" + "idreserva=" + idreserva + ", username=" + username + ", fecha=" + fecha + ", hoarario=" + hoarario + ", salonsocial=" + salonsocial + '}';
    }
    
}
