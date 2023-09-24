import java.io.*;
import java.util.*;

public class asistenciaColegio{
    
    private static asistenciaColegio instance;
    private static ArrayList<Cursos> arrayCursos; // Supongo que tienes una clase Cursos para representar los cursos

    // Constructor privado para evitar la creación de instancias desde fuera de la clase.
    private asistenciaColegio() {
        arrayCursos = new ArrayList<>();
    }

    // Método para obtener la instancia única de asistenciaColegio.
    public static asistenciaColegio getInstance() {
        if (instance == null) {
            instance = new asistenciaColegio();
        }
        return instance;
    }

    
    public static void agregarCurso(String nombre) throws IOException {
        Cursos cursoaux = new Cursos(nombre,0);
        arrayCursos.add(cursoaux);
    }

    public static void inicializarDatos() throws FileNotFoundException {
        // Ruta al archivo CSV
        String userDir = System.getProperty("user.dir");
        String rutaCSV = userDir + "/src/datos.csv";

        // Crear una instancia de la clase CSV
        CSV csv = new CSV(rutaCSV);

        try {
            // Omitir la primera línea (encabezados)
            csv.firstLine(); // Leer y descartar la primera línea

            String line;
            Cursos curso = null; // Variable para rastrear el curso actual

            while ((line = csv.nextLine()) != null) {
                // Procesar cada línea del archivo CSV aquí
                // Puedes obtener datos utilizando csv.get_csvField(field, line)

                // Ejemplo: Obtener nombre del curso y cantidad de alumnos
                String nombreCurso = csv.get_csvField(0, line);

                // Verificar si el curso actual es diferente al curso en la línea actual
                if (curso == null || !curso.getNombre().equals(nombreCurso)) {
                    // Crear un nuevo curso si es diferente
                    if (curso != null) {
                        arrayCursos.add(curso); // Agregar el curso anterior a la lista
                    }
                    int cantidadAlumnos = Integer.parseInt(csv.get_csvField(1, line));
                    curso = new Cursos(nombreCurso, cantidadAlumnos);
                }

                // Agregar alumnos al curso
                String rut = csv.get_csvField(2, line);
                String nombreAlumno = csv.get_csvField(3, line);
                String apellidoAlumno = csv.get_csvField(4, line);

                Alumnos alumno = new Alumnos(rut, nombreAlumno, apellidoAlumno);
                curso.agregarAlumno(alumno);
            }

            // Agregar el último curso a la lista
            if (curso != null) {
                arrayCursos.add(curso);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                csv.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void guardarAlSalir() throws IOException {
            // Ruta relativa al archivo CSV (desde el directorio de trabajo)
            String userDir = System.getProperty("user.dir");
            String rutaCSV = userDir + "/src/datos.csv";

            // Crear un nuevo archivo temporal para escribir los datos actualizados
            String rutaCSVTmp = userDir + "/src/datos_temp.csv";
            File archivoCSV = new File(rutaCSV);
            File archivoCSVTmp = new File(rutaCSVTmp);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoCSVTmp))) {
                // Escribir la primera línea de encabezados en el archivo temporal
                writer.write("Nombre del Curso,Cantidad de Alumnos,Rut,Nombre Alumno,Apellido Alumno");
                writer.newLine();

                // Iterar sobre los cursos y sus alumnos para escribir los datos en el archivo temporal
                for (Cursos curso : arrayCursos) {
                    for (Alumnos alumno : curso.obtenerCopiaAlumnos().values()) {
                        writer.write(curso.getNombre() + "," + curso.getCantidadAlumnos() + ","
                                + alumno.getRut() + "," + alumno.getNombre() + "," + alumno.getApellido());
                        writer.newLine();
                    }
                }
            }

            // Reemplazar el archivo original con el archivo temporal
            archivoCSV.delete();
            archivoCSVTmp.renameTo(archivoCSV);
        }
    
    public static void eliminarCurso(String nombreCursoEliminar) throws IOException {
        for (int i = 0; i < arrayCursos.size(); i++) {
            Cursos cursoaux = arrayCursos.get(i);
            if (cursoaux.getNombre().equals(nombreCursoEliminar)) {
                arrayCursos.remove(i);
                System.out.println("Curso eliminado: " + nombreCursoEliminar);
                return;
            } else {
                System.out.println("No se encontró el curso: " + nombreCursoEliminar);
            }
        }
    }

    public static void agregarAlumnos(String nombreCurso, String rut, String nombre, String apellido) throws IOException {
        
        for (Cursos cursoAux : arrayCursos) {
            if (cursoAux.getNombre().equals(nombreCurso)) {
                cursoAux.agregarAlumno(rut, nombre, apellido);
            }
        }
        System.out.println("No se encontró el curso: " + nombreCurso);
    }

    public static void pasarAsistenciaEnUnCurso(String nombreCurso, BufferedReader lector,String fecha) throws IOException {
        for (int i = 0; i < arrayCursos.size(); i++) {
            Cursos cursoAux = arrayCursos.get(i);
            if (cursoAux.getNombre().equals(nombreCurso)) {
                cursoAux.pasarAsistenciaEnUnCurso(lector,fecha);
            }
        }
        System.out.println("No se encontró el curso: " + nombreCurso);
    }

    public static void mostrarTodosLosCursos() {
        for (Cursos curso : arrayCursos) {
            curso.mostrarInfoCurso();
        }
    }

    public static void mostrarAlumnosDeUnCurso(String nombreCursoVer) {
        for (Cursos curso : arrayCursos) {
            if (curso.getNombre().equals(nombreCursoVer)) {
            curso.mostrarAlumnos();
            }
        }
        System.out.println("No se encontró el curso: " + nombreCursoVer);
    }
    
    public static void mostrarAsistenciaCurso(String nombreCurso, String fecha) {
        Cursos cursoEncontrado = null;
        // Buscar el curso por nombre
        for (Cursos curso : arrayCursos) {
            if (curso.getNombre().equals(nombreCurso)) {
                cursoEncontrado = curso;
                break;
            }
        }
        if (cursoEncontrado != null) {
            // El curso fue encontrado, ahora intentamos obtener la asistencia para la fecha especificada
            cursoEncontrado.asistenciaCurso(fecha);
        } else {
            System.out.println("No se encontró el curso: " + nombreCurso);
        }
    }
    
    public static ArrayList<Cursos> obtenerCopiaCursos() {
        // Crear una copia del ArrayList de cursos
        ArrayList<Cursos> copiaCursos = new ArrayList<>(arrayCursos);
        return copiaCursos;
    }
    
    public static ArrayList<Cursos> buscarCursosPorPorcentaje(String fecha, double cotaInferior, double cotaSuperior) {
        ArrayList<Cursos> cursosEnRango = new ArrayList<>();

        for (Cursos curso : arrayCursos) {
            double porcentaje = curso.calcularPorcentajeAsistencia(fecha);

            if (porcentaje >= cotaInferior && porcentaje <= cotaSuperior) {
                cursosEnRango.add(curso);
            }
        }

        return cursosEnRango;
    }
    
    public static Alumnos obtenerAlumno(String nombreCurso, String rutAlumno) {
        for (Cursos curso : arrayCursos) {
            if (curso.getNombre().equals(nombreCurso)) {
                // Buscar al alumno en el curso
                Alumnos alumno = curso.obtenerAlumnoPorRut(rutAlumno);
                if (alumno != null) {
                    return alumno; // Se encontró el alumno en el curso
                } else {
                    System.out.println("No se encontró el alumno con RUT: " + rutAlumno + " en el curso: " + nombreCurso);
                    return null; // No se encontró el alumno en el curso
                }
            }
        }
        System.out.println("No se encontró el curso: " + nombreCurso);
        return null; // No se encontró el curso
    }
    
    public static Cursos buscarCursoNombre(String nombreCurso) {
        for (Cursos curso : arrayCursos) {
            if (curso.getNombre().equals(nombreCurso)) {
                return curso; // Devuelve el curso si lo encuentra
            }
        }
        System.out.println("No se encontró el curso: " + nombreCurso);
        return null; // Retorna null si no se encuentra el curso
    }
    
   
}