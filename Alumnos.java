
import java.util.ArrayList;

public class Alumnos {
   //atributos privados correspondientes para ingresar cada alumno y una coleccion de la clase asistencia
  private String nombre;
  private String apellido;
  private String rut;
  private ArrayList<Asistencia> asistencia;

    // sobrecarga de constructores para ingresar el alumno con o sin el apellido
    public Alumnos(String rut,String nombre, String apellido) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.rut = rut;
      this.asistencia = new ArrayList<>();
    }
    public Alumnos(String rut, String nombre) {
      this.rut = rut;
      this.nombre = nombre;
      this.asistencia = new ArrayList<>();
    }
    
    //Setters y getters para obtener y asignar el nombre, apellido y el rut del alumno ingresado
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
    
    //se obtiene la asistencia del día pedido por el usuario de la colleción de asistencia
    public Asistencia getAsistenciaPorDia(String dia) {
    for (Asistencia asistencia : asistencia) {
        if (asistencia.getFecha().equals(dia)) {
            return asistencia;
        }
    }
    return null; // Si no se encuentra asistencia para el día especificado
}
    //luego de ingresar la asistencia del alumno, se ingresará a la colección de asistencias
    public void agregarAsistencia(Asistencia asistencia) {
        this.asistencia.add(asistencia);
    }
    
}

  