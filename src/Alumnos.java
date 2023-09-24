
import java.util.ArrayList;

public class Alumnos {
  
  private String nombre;
  private String apellido;
  private String rut;
  private ArrayList<Asistencia> asistencia;

    public Alumnos(String rut,String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = rut;
      this.asistencia = new ArrayList<>();
    }
    public Alumnos(String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = "";
      this.asistencia = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public Asistencia getAsistenciaPorDia(String dia) {
    for (Asistencia asistencia : asistencia) {
        if (asistencia.getFecha().equals(dia)) {
            return asistencia;
        }
    }
    return null; // Si no se encuentra asistencia para el día especificado
}

    public void agregarAsistencia(Asistencia asistencia) {
        this.asistencia.add(asistencia);
    }
    
}

  