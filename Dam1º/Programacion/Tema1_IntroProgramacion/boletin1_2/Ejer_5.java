package boletin1_2;


import java.util.Scanner;

/*5. Crea un pequeño programa que represente el inventario de un personaje en un videojuego.
     Declara y asigna valores a variables para elementos como monedas de oro (tipo `int`),
     nombre del arma (tipo `String`), nivel del personaje (tipo `int`), y salud actual (tipo `double`).
     Pide al usuario que ingrese el daño recibido y resta ese valor de la saludb actual. Finalmente, imprime el estado actualizado del inventario.*/
public class Ejer_5 {




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);




        int monOro = 100, nivelPers=25;
        double saludPers= 100, danosPer=0;
        String nomArma="Espada";

        System.out.printf("Estado Actual es;\n Nivel: %d \n Salud: %.2f \n Monedas: %d \n Arma: %s \n \n ",nivelPers,saludPers,monOro,nomArma);


        do {
            System.out.print("Ahora introduce daños:");

            danosPer= sc.nextDouble();



        }while (danosPer<=0);

        System.out.println();

        System.out.printf("Estado Actual es;\n Nivel: %d \n Salud: %.2f \n Monedas: %d \n Arma: %s \n \n ",nivelPers,(saludPers-danosPer),monOro,nomArma);

        if ((saludPers-danosPer)<=0){
            System.out.print("           Estas frito !!\n");
        }
    }

}
