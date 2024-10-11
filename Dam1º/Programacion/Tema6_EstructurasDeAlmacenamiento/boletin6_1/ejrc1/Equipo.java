package Tema6_EstructurasDeAlmacenamiento.ejrc1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo {
    private String nombre;
    private Set<Alumno> alumnosList;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.alumnosList = new HashSet<>();
    }

    public void addAlumno(Alumno alumno) throws EquipoException{

        if (!(alumnosList.add(alumno))){
            throw new EquipoException("El alumno ya existe en este equipo");
        }

    }

    public void delAlumno(Alumno alumno) throws EquipoException{

        if (!(alumnosList.remove(alumno))){
            throw new EquipoException("El alumno no existe en este equipo");
        }
    }
//Todo ver ternalia
    public Alumno perteneceEquipo(Alumno alumno) {

        if (alumnosList.contains(alumno)){
            return alumno;
        }
        return null;
    }






}


