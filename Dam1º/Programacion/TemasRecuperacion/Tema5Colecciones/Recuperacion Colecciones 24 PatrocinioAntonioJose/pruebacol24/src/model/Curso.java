package model;

import exceptions.CursoException;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Curso {
    private String nombre;
    private Set<Alumno> alumnos;
    private Set<Materia> materias;

    public Curso(String nombre) throws CursoException {
        setNombre(nombre);
        this.alumnos = new HashSet<>();
        this.materias = new HashSet<>();
    }

    public void agregarAlumno(Alumno alumno) {
        this.alumnos.add(alumno);
    }

    public void agregarMateria(Materia materia) {
        this.materias.add(materia);
    }

    public Set<Alumno> getAlumnos() {
        return this.alumnos;
    }

    public Set<Materia> getMaterias() {
        return this.materias;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) throws CursoException {
        if (nombre.isEmpty())
            throw new CursoException("El nombre no puede estar vacío");
        this.nombre = nombre;
    }

    public void matricularAlumno(Alumno alumno, Materia materiaOptativa) throws CursoException {
        // Si encuetra solo una materia Optativa(!isObligatoria) lanza la excepcion.
        if (!materias.contains(materiaOptativa))
            throw new CursoException("El alumno no puede matricularse en una materia inexistente");

        if (alumno.getMateriasMatriculadas().containsKey(materiaOptativa))
            throw new CursoException("El alumno ya está matriculado en la materia de "+materiaOptativa.getNombre());

        if (!materiaOptativa.isObligatoria())
            if (alumno.getMateriasMatriculadas().keySet().stream().filter(materia -> !materia.isObligatoria()).count() > 1)
                throw new CursoException("Ya dispone de una Optativa");

        alumno.matricularMateria(materiaOptativa);
    }


    public void asignarNota(Alumno alumno, Materia materia, double calificacion) throws CursoException {
        if (!alumnos.contains(alumno))
            throw new CursoException("El alumno no esta en las lista");

        if (!materias.contains(materia))
            throw new CursoException("La mateira no esta en las lista");

        alumno.setNota(materia, calificacion);

    }

    public Map<Alumno, Integer> getAlumnosConNumeroSuspensos() {
        Map<Alumno, Integer> mapNumeroSuspensos = new HashMap<>();

        for (Alumno alumno : alumnos) {
            mapNumeroSuspensos.put(alumno, alumno.numeroSuspensos());
        }
        return mapNumeroSuspensos;
    }

    public double mediaEdad() {
        // Calcula la media mediate .average() y si contiene nada devuelve un 0
        return alumnos.stream().mapToInt(Alumno::getEdad).average().orElse(0);
    }


    public double notaMaximaRepetidores(Materia materia) {
        return alumnos.stream().filter(Alumno::isRepetidor).mapToDouble(alumnos -> alumnos.notaMateria(materia)).max().orElse(0);
    }

    public void eliminarAlumno(Alumno alumno) {
        this.alumnos.remove(alumno);
    }

    public void addFaltaDeAsistencia(Alumno alumno, LocalDate fecha) throws CursoException {
        alumno.agregarFalta(fecha);
    }

    public Map<Alumno, Integer> getFaltasDeAsistenciaUltimos15Dias() {
        Map<Alumno, Integer> mapNumeroFaltas = new HashMap<>();

        for (Alumno alumno : alumnos) {
            mapNumeroFaltas.put(alumno, alumno.numeroFaltasAsistencia());
        }
        return mapNumeroFaltas;

    }
}
