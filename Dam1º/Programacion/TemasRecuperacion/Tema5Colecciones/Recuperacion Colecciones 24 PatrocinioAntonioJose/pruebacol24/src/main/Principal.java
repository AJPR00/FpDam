package main;

import exceptions.CursoException;
import model.Alumno;
import model.Curso;
import model.Materia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        System.out.println("Bienvenido al gestor de Cursos");
        Random random = new Random();
        try {

            Curso curso = new Curso("1º DAM");
            System.out.println("Curso creado: " + curso.getNombre());

            Materia materia1 = new Materia("Programación", true);
            curso.agregarMateria(materia1);

            Materia materia2 = new Materia("Bases de datos", true);
            curso.agregarMateria(materia2);

            Materia materia3 = new Materia("Sistemas", false);
            curso.agregarMateria(materia3);

            Materia materia4 = new Materia("Entornos", false);
            curso.agregarMateria(materia4);

            imprimirMaterias(curso);

            // Cogemos las dos materias optativas para matricular a los alumnos aleatoriamente
            Materia[] materias = {materia3, materia4};

            List<Alumno> alumnos = generateAlumnos(10);

            // Agregamos los alumnos al curso
            for (Alumno alumno : alumnos) {
                System.out.println(alumno);
                curso.agregarAlumno(alumno);
            }

            int i = 0;
            for (Alumno alumno : alumnos) {

                i++;

                if (i == 10) {
                    break;
                }

                Materia materia = materias[random.nextInt(materias.length)];
                curso.matricularAlumno(alumno, materia);

            }

            //Esto debe fallar porque el alumno no puede matricularse 2 veces
            try {
                System.out.println("-----------------------------");
                curso.matricularAlumno(alumnos.get(0), materia3);
            } catch (CursoException e) {
                System.out.println(e.getMessage());
            }

            //Esto debe fallar porque el alumno no puede matricularse en una materia inexistente
            try {
                System.out.println("-----------------------------");
                curso.matricularAlumno(alumnos.get(9), new Materia("Fisica", true));

            } catch (CursoException e) {
                System.out.println(e.getMessage());
            }

            //Solo con efecto de prueba, elimino el último alumno
            curso.eliminarAlumno(alumnos.get(9));


            // Ponemos nota a las materias de los alumnos
            for (Alumno alumno : alumnos) {
                for (Materia materia : alumno.getMateriasMatriculadas().keySet()) {
                    double nota = random.nextDouble() * 10;
                    curso.asignarNota(alumno, materia, nota);
                }
            }

            // Imprimimos las materias matriculadas de cada alumno
            for (Alumno alumno : alumnos) {
                System.out.println("--------------------------------------------------");
                System.out.println("Materias matriculadas de " + alumno.getNombre());
                for (Materia materia : alumno.getMateriasMatriculadas().keySet()) {
                    System.out.printf("%s:%s: %.2f\n", materia, materia.isObligatoria(), alumno.getMateriasMatriculadas().get(materia));
                }
            }

            // Imprimimos los alumnos junto al número de materias suspensas
            System.out.println("--------------------------------------------------");
            System.out.println("Alumnado y materias suspensas");
            Map<Alumno, Integer> alumnosConSuspensos = curso.getAlumnosConNumeroSuspensos();
            for (Alumno alumno : alumnosConSuspensos.keySet()) {
                System.out.printf("%s%s: %d\n", alumno.getNombre(), alumno.isRepetidor() ? " (Repetidor)" : "", alumnosConSuspensos.get(alumno));
            }

            System.out.println("--------------------------------------------------");
            System.out.println("Media de edad de los alumnos: " + curso.mediaEdad());

            System.out.println("--------------------------------------------------");
            System.out.println("Nota máxima de los alumnos repetidores en la materia Programación: " + curso.notaMaximaRepetidores(materia1));

            // Generamos ahora las faltas de asistencia
            generateFaltasDeAsistencia(curso, alumnos, 55);

            // Mostramos las faltas de los últimos 15 días
            System.out.println("--------------------------------------------------");
            System.out.println("Faltas de asistencia de los últimos 15 días");
            Map<Alumno, Integer> faltasDeAsistencia = curso.getFaltasDeAsistenciaUltimos15Dias();
            for (Alumno alumno : faltasDeAsistencia.keySet()) {
                System.out.printf("%s: %d\n", alumno.getNombre(), faltasDeAsistencia.get(alumno));
            }


        } catch (CursoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void imprimirMaterias(Curso curso) {
        System.out.println("Materias del curso: " + curso.getNombre());

        for (Materia materia : curso.getMaterias()) {
            System.out.println(materia);
        }
    }

    public static List<Alumno> generateAlumnos(int count) {
        List<Alumno> alumnos = new ArrayList<>();
        Random random = new Random();

        String[] nombres = {"Juan", "Ana", "Luis", "María", "Carlos", "Lucía", "Pedro", "Sofía", "Miguel", "Elena"};
        String[] dnis = {"12345678A", "23456789B", "34567890C", "45678901D", "56789012E",
                "67890123F", "78901234G", "89012345H", "90123456I", "01234567J"};

        LocalDate startDate = LocalDate.of(2000, 1, 1);
        LocalDate endDate = LocalDate.now();
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();

        for (int i = 0; i < count; i++) {
            String nombre = nombres[i % nombres.length];
            String dni = dnis[i % dnis.length];
            LocalDate fechaNacimiento = LocalDate.ofEpochDay(startEpochDay + random.nextInt((int) (endEpochDay - startEpochDay)));
            boolean repetidor = random.nextBoolean();

            try {
                alumnos.add(new Alumno(nombre, dni, fechaNacimiento, repetidor));
            } catch (CursoException e) {
                System.out.println(e.getMessage());
            }
        }

        return alumnos;
    }

    public static void generateFaltasDeAsistencia(Curso curso, List<Alumno> alumnos, int numeroDeFaltas) throws CursoException {
        LocalDate startDate = LocalDate.of(2023, 9, 15);
        LocalDate endDate = LocalDate.now();
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        Random random = new Random();

        for (int i = 0; i < numeroDeFaltas; i++) {
            Alumno alumno = alumnos.get(random.nextInt(alumnos.size()));
            LocalDate fechaFalta = LocalDate.ofEpochDay(startEpochDay + random.nextInt((int) (endEpochDay - startEpochDay)));
            curso.addFaltaDeAsistencia(alumno, fechaFalta);
        }
    }
}
