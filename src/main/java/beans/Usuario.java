
package beans;

public class Usuario {
    private String idusuario;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private int cedula;
    private String numerodetelefono;
    private String email;
    private String torre;
    private String apartamento;

    public Usuario(String idusuario, String contrasena, String nombre, String apellidos, int cedula, String numerodetelefono, String email, String torre, String apartamento) {
        this.idusuario = idusuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.numerodetelefono = numerodetelefono;
        this.email = email;
        this.torre = torre;
        this.apartamento = apartamento;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNumerodetelefono() {
        return numerodetelefono;
    }

    public void setNumerodetelefono(String numerodetelefono) {
        this.numerodetelefono = numerodetelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTorre() {
        return torre;
    }

    public void setTorre(String torre) {
        this.torre = torre;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", contrasena=" + contrasena + ", nombre=" + nombre + ", apellidos=" + apellidos + ", cedula=" + cedula + ", numerodetelefono=" + numerodetelefono + ", email=" + email + ", torre=" + torre + ", apartamento=" + apartamento + '}';
    }
    
   
}
