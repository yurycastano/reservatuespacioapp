package beans;

public class SalonSocial {
    private int salonsocial;
    private String nombre;
    private int aforo;
    private Double precio;

    public SalonSocial(int salonsocial, String nombre) {
        this.salonsocial = salonsocial;
        this.nombre = nombre;
    }

    public SalonSocial(int salonsocial, String nombre, int aforo, Double precio) {
        this.salonsocial = salonsocial;
        this.nombre = nombre;
        this.aforo = aforo;
        this.precio = precio;
    }

    public int getSalonsocial() {
        return salonsocial;
    }

    public void setSalonsocial(int salonsocial) {
        this.salonsocial = salonsocial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "SalonSocial{" + "salonsocial=" + salonsocial + ", nombre=" + nombre + '}';
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
}
