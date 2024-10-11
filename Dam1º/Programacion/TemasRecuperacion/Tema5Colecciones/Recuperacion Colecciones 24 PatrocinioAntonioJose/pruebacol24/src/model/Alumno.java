package model;

import exceptions.CursoException;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;


public class Alumno {

    private static final LocalDate FECHA_MAX_EDAD = LocalDate.of(2000, 1, 1);
    private static final LocalDate FECHA_MIN_EDAD = LocalDate.now();
    private static final double NOTA_MIN = 0;
    private static final double NOTA_MAX = 10;
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private boolean repetidor;
    private Set<LocalDate> faltasAsistencia;
    private Map<Materia, Double> materiasMatriculadas;

    public Alumno(String nombre, String dni, LocalDate fechaNacimiento, boolean repetidor) throws CursoException {
        setNombre(nombre);
        setDni(dni);
        setFechaNacimiento(fechaNacimiento);
        this.repetidor = repetidor;
        this.faltasAsistencia = new HashSet<>();
        this.materiasMatriculadas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public Set<LocalDate> getFaltasAsistencia() {
        return faltasAsistencia;
    }

    public Map<Materia, Double> getMateriasMatriculadas() {
        return materiasMatriculadas;
    }


    private void setFechaNacimiento(LocalDate fechaNacimiento) throws CursoException {
        if (fechaNacimiento.isBefore(FECHA_MAX_EDAD) || fechaNacimiento.isAfter(FECHA_MIN_EDAD))
            throw new CursoException("La fecha tiene que ser porterior a " + FECHA_MAX_EDAD);

    }

    public void matricularMateria(Materia materia) throws CursoException {
        if (materiasMatriculadas.containsKey(materia))
            throw new CursoException("Ya esta inscrito");
        materiasMatriculadas.put(materia, null);
    }

    public void setNota(Materia materia, double calificacion) throws CursoException {

        if (calificacion < NOTA_MIN || calificacion > NOTA_MAX)
            throw new CursoException("Error, la nota tiene un ranga de 0 al 10");

        materiasMatriculadas.put(materia, calificacion);
    }

    public double notaMateria(Materia materia){
       return materiasMatriculadas.get(materia);
    }

    public void agregarFalta(LocalDate fecha) throws CursoException {
        if (!LocalDate.now().equals(fecha))
            throw new CursoException("La fecha tiene que ser actual");
        faltasAsistencia.add(fecha);
    }

    public void setNombre(String nombre) throws CursoException {
        if (nombre.isEmpty())
            throw new CursoException("El nombre no puede estar vacío");
        this.nombre=nombre;
    }

    public void setDni(String dni) throws CursoException {
        if (dni.isEmpty())
            throw new CursoException("El DNI no puede estar vacío");
    }

    public int getEdad() {
        // Devuelve la edad en años (sin decimales) a partir de la fecha de nacimiento
        LocalDate fechaActual = LocalDate.now();
        return Period.between(fechaNacimiento, fechaActual).getYears();
    }

    public int numeroSuspensos() {
        return (int) materiasMatriculadas.values().stream().filter(aDouble -> aDouble < 5).count();
    }
    public int numeroFaltasAsistencia() {
        return (int) faltasAsistencia.stream().count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(dni, alumno.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
       return nombre;
    }
}
