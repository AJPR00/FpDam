package ejer1.Class;

import Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen23.Equipo;
import ejer1.Excepcion.ExcepcionEquipos;

import java.util.HashSet;
import java.util.Set;

public class Principal {
    public static void main(String[] args) {

        Equipo equipo1 = new Equipo("Salamanca");
        Equipo equipo2 = new Equipo("Union");

        Equipo equipoStart = new Equipo("Start Union Salamanca");



            equipo1.addAlumno(new Alumno("Juan Pérez", "12345678A"));
            equipo1.addAlumno(new Alumno("Mario García", "23456789B"));
            equipo1.addAlumno(new Alumno("Pedro Rodríguez", "34567890C"));
            equipo1.addAlumno(new Alumno("Lauren Martínez", "45678901D"));
            equipo1.addAlumno(new Alumno("Carlos López", "56789012E"));
            equipo1.delAlumno(new Alumno("Carlos López", "56789012E"));
            equipo1.addAlumno(new Alumno("Ance Sánchez", "67890123F"));
            equipo1.addAlumno(new Alumno("Miguel Fernández", "78901234G"));
            equipo1.addAlumno(new Alumno("Serafin Ramírez", "89012345H"));
            equipo1.addAlumno(new Alumno("David Torres", "90123456I"));
            equipo1.addAlumno(new Alumno("Elenor Gómez", "01234567J"));
            equipo1.addAlumno(new Alumno("Serafin Ramírez", "89012345H"));

            equipo2.addAlumno(new Alumno("Juan Pérez", "12345678A"));
            equipo2.addAlumno(new Alumno("David Torres", "90123456I"));
            equipo2.addAlumno(new Alumno("Potro Rodríguez", "34567890C"));
            equipo2.addAlumno(new Alumno("Lauren Martínez", "45678901D"));
            equipo2.addAlumno(new Alumno("Carlos", "56789012E"));
            equipo2.addAlumno(new Alumno("Ana", "67890123F"));
            equipo2.addAlumno(new Alumno("Fernández", "78901234G"));
            equipo2.addAlumno(new Alumno("Sofía", "89012345H"));
            equipo2.addAlumno(new Alumno("Elenor Gómez", "01234567J"));
            equipo2.addAlumno(new Alumno("Miguel Fernández", "78901234G"));
            equipo2.addAlumno(new Alumno("Raminro", "2548579H"));


        System.out.println("***********************************" + equipo1.getNombreEquipo() + "***********************************");
        equipo1.viewLista();
        System.out.println("Total inscrito: "+equipo1.getListaAlumno().size());

        System.out.println("***********************************" + equipo2.getNombreEquipo() + "***********************************");
        equipo2.viewLista();
        System.out.println("Total inscrito: "+equipo2.getListaAlumno().size());


        Equipo unionEquipo= equipo1.unirEquipo(equipo2);
        unionEquipo.unirEquipo(equipo1);

        System.out.println("***********************************" + unionEquipo.getNombreEquipo() + "***********************************");
        unionEquipo.viewLista();
        System.out.println("Total inscrito: "+unionEquipo.getListaAlumno().size());


        System.out.println("*************************************************** Juega en los dos equipos *******************************************");
        equipoStart.setListaAlumno(equipo1.interseccionEquipo(equipo2));
        equipoStart.viewLista();
        System.out.println("Total inscrito: "+equipoStart.getListaAlumno().size());


        Equipo otro=equipo2;
        otro.viewLista();
    }
}
