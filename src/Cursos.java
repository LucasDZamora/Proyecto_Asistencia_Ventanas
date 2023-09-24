import java.io.BufferedReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;

public class Cursos {
  
  private String nombre;
  private int cantidadAlumnos;
  private HashMap<String, Alumnos> alumnos;
  
  public Cursos(String nombre, int cantidadAlumnos) {
    this.nombre = nombre;
    this.cantidadAlumnos = cantidadAlumnos;
    alumnos = new HashMap<>();
  }
  
  public Cursos(String nombre) {
    this.nombre = nombre;
    this.cantidadAlumnos = 0;
    alumnos = new HashMap<>();
  }
  
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  
  public int getCantidadAlumnos() {
    return cantidadAlumnos;
  }
  public void setCantidadAlumnos(int cantidadAlumnos) {
    this.cantidadAlumnos = cantidadAlumnos;
  }

  public void agregarAlumno(String nombre, String rut) {
    Alumnos alumno = new Alumnos(nombre, rut);
    alumnos.put(rut, alumno);
  }

  public void agregarAlumno(Alumnos alumno) {
    alumnos.put(alumno.getRut(), alumno);
  }

    public void pasarAsistenciaEnUnCurso(BufferedReader lector,String fecha) throws IOException {
    System.out.println("Asistencia para el curso: " + nombre);


    for (Alumnos alumno : alumnos.values()) {
        System.out.println("Asistencia para el alumno " + alumno.getNombre() + " " + alumno.getApellido() + " (RUT: " + alumno.getRut() + "):");

        // Pregunta por la asistencia
        System.out.println("Seleccione la asistencia para el alumno:");
        System.out.println("1. Presente");
        System.out.println("2. Ausente");
        System.out.println("3. Justificado");
        System.out.print("Opción: ");
        int opcionAsistencia = Integer.parseInt(lector.readLine());

        Asistencia asistencia = new Asistencia(fecha);
        switch (opcionAsistencia) {
            case 1:
                asistencia.setEstaPresente(true);
                break;
            case 2:
                asistencia.setEstaPresente(false);
                break;
            case 3:
                asistencia.setEstaJustificado(true);
                break;
            default:
                System.out.println("Opción no válida. Se registrará como ausente.");
                break;
        }

        alumno.agregarAsistencia(asistencia);
    }

    System.out.println("Asistencia registrada para el curso: " + nombre);
}
public void mostrarInfoCurso() {
        System.out.println("Curso: " + nombre);
        System.out.println("Cantidad de Alumnos: " + alumnos.size());
    }

   public void mostrarAlumnos() {
        System.out.println("Alumnos en el curso " + nombre + ":");
        for (Alumnos alumno : alumnos.values()) {
            System.out.println("- Nombre: " + alumno.getNombre() + " Apellido: " + alumno.getApellido() + " Rut: " + alumno.getRut());
        }
    }

    public void agregarAlumno(String rut, String nombre, String apellido) {
        Alumnos nuevoAlumno = new Alumnos(rut, nombre, apellido);

        if (alumnos.containsKey(rut)) {
            System.out.println("El alumno ya existe.");
            return;
        }
        alumnos.put(rut, nuevoAlumno);

        // Incrementar la cantidad de alumnos
        cantidadAlumnos++;

        System.out.println("Alumno agregado al curso: " + this.nombre);
    }
    public void asistenciaCurso(String dia) {
        int presentes = 0;
        int ausentes = 0;

        for (Alumnos alumno : alumnos.values()) {
            // Obtener la asistencia del alumno para el día especificado
            Asistencia asistencia = alumno.getAsistenciaPorDia(dia);

            if (asistencia != null) {
                if (asistencia.isEstaPresente()) {
                    presentes++;
                } else {
                    ausentes++;
                }
            }
        }

        int totalAlumnos = alumnos.size();
        double porcentajePresentes = (double) presentes / totalAlumnos * 100;
        double porcentajeAusentes = (double) ausentes / totalAlumnos * 100;

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Asistencia para el día " + dia + " en el curso " + nombre);
        System.out.println("Presentes: " + presentes + " (" + df.format(porcentajePresentes) + "%)");
        System.out.println("Ausentes: " + ausentes + " (" + df.format(porcentajeAusentes) + "%)");
    }
    
    public HashMap<String, Alumnos> obtenerCopiaAlumnos() {
        // Crea una nueva copia del HashMap de alumnos
        HashMap<String, Alumnos> copiaAlumnos = new HashMap<>(alumnos);
        return copiaAlumnos;
    }
    public double calcularPorcentajeAsistencia(String fecha) {
        int totalAlumnos = alumnos.size();
        int asistentes = 0;

        for (Alumnos alumno : alumnos.values()) {
            Asistencia asistencia = alumno.getAsistenciaPorDia(fecha);
            if (asistencia != null && asistencia.isEstaPresente()) {
                asistentes++;
            }
        }

        if (totalAlumnos == 0) {
            return 0.0; // Evitar división por cero
        }

        return ((double) asistentes / totalAlumnos) * 100.0;
    }
    public Alumnos obtenerAlumnoPorRut(String rutAlumno) {
        return alumnos.get(rutAlumno);
    }
    public void eliminarAlumno(String rutAlumno) {
        if (alumnos.containsKey(rutAlumno)) {
            alumnos.remove(rutAlumno);

            // Decrementar la cantidad de alumnos
            cantidadAlumnos--;

            System.out.println("Alumno con Rut " + rutAlumno + " eliminado del curso " + nombre);
        } else {
            System.out.println("No se encontró al alumno con Rut " + rutAlumno + " en el curso " + nombre);
        }
    }
    

}