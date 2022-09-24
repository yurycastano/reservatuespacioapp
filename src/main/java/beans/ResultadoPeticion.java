package beans;

/**
 *
 * @author yuri9
 */
public class ResultadoPeticion {
    private boolean resultado;
    private String mensaje;

    public ResultadoPeticion() {
    }

    public ResultadoPeticion(boolean resultado, String mensaje) {
        this.resultado = resultado;
        this.mensaje = mensaje;
    }
    
    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "ResultadoPeticion{" + "resultado=" + resultado + ", mensaje=" + mensaje + '}';
    }
}
