package beans;

public class SalonSocial {
    private int salonsocial;
    private String nombre;

    public SalonSocial(int salonsocial, String nombre) {
        this.salonsocial = salonsocial;
        this.nombre = nombre;
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
    
    
}
