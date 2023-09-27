public class Asistencia {
    private String fecha;
    private boolean estaPresente;
    private boolean estaJustificado;

    public Asistencia(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEstaPresente() {
        return estaPresente;
    }

    public void setEstaPresente(boolean estaPresente) {
        this.estaPresente = estaPresente;
    }

    public boolean isEstaJustificado() {
        return estaJustificado;
    }

    public void setEstaJustificado(boolean estaJustificado) {
        this.estaJustificado = estaJustificado;
    }
    

    
}