package boletin1_2;
import java.util.Scanner;
public class Ejer_10 {
            public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Bienvenido al Clasificador de Hogwart");
            System.out.println("Responde a algunas preguntas para determinar a qué casa perteneces.");

            // Pregunta sobre el animal favorito
            System.out.print("¿Cuál es tu animal favorito entre gato, sapo y lechuza? ");
            String animalFavorito = sc.nextLine().toLowerCase();


            System.out.print("¿Cuál es tu color favorito entre rojo, azul, verde y amarillo? ");
            String colorFavorito = sc.nextLine().toLowerCase();

            System.out.print("¿Cuál es tu asignatura favorita entre Encantamientos, Herbología y Pociones? ");
            String asignaturaFavorita = sc.nextLine().toLowerCase();

            // Determina la casa de Hogwarts

            String casaHogwarts = determinarCasa(animalFavorito, colorFavorito, asignaturaFavorita);

            // Imprime la casa asignada
            if (casaHogwarts != null) {
                System.out.println("¡Eres un miembro de la casa " + casaHogwarts + " de Hogwarts!");
            } else {
                System.out.println("No pudimos determinar tu casa en Hogwarts.");
            }
        }

        public static String determinarCasa(String animal, String color, String asignatura) {


            if (animal.equals("gato") && color.equals("rojo") && asignatura.equals("encantamientos")) {
                return "Gryffindor";

            } else if (animal.equals("sapo") && color.equals("verde") && asignatura.equals("herbología")) {
                return "Hufflepuff";

            } else if (animal.equals("lechuza") && color.equals("azul") && asignatura.equals("pociones")) {
                return "Ravenclaw";

            } else if (animal.equals("lechuza") && color.equals("amarillo") && asignatura.equals("pociones")) {
                return "Slytherin";

            } else {
                return null; // No se pudo determinar la casa
            }
        }
    }

