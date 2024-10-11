package boletin1_2;


/*7.Escribe un programa que pregunte al usuario cuál es su tipo de Pokémon favorito entre
        fuego,agua y planta.Si elige fuego,sugiere'Charmander'.Si elige agua,sugiere'Squirtle'.
        Si elige planta,sugiere'Bulbasaur'.*/

import java.util.Scanner;

public class Ejer_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean repetir = true;
        String pokemon;

        do {
            System.out.println("Dime cuál es su tipo de Pokémon favorito: Fuego, Agua o Planta.");

            pokemon = sc.nextLine();

            if (pokemon.equalsIgnoreCase("agua") || pokemon.equalsIgnoreCase("fuego") || pokemon.equalsIgnoreCase("planta")) {

                repetir = false;

            } else {
                System.out.println("Opción no reconocida, opción incorrecta.");
            }


        } while (repetir);


        if (pokemon.equalsIgnoreCase("fuego")) {
            System.out.println("Tú Pokémon es Charmander");

        } else if (pokemon.equalsIgnoreCase("agua")) {
            System.out.println("Tú Pokémon es Squirtle");

        } else if (pokemon.equalsIgnoreCase("planta")) {
            System.out.println("Tú Pokémon es Bulbasaur");

        } else {

            System.out.println("Desconozco su el Pokémon");


        }
    }
}
