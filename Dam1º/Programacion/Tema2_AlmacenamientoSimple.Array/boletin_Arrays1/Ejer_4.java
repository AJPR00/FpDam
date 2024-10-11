package boletin_Arrays1;

import java.awt.font.FontRenderContext;

/*4. Soluciona el siguiente problema del anterior boletín utilizando arrays. Crea un
        programa que cree 6000 números aleatorios de 0 a 100 (usa una constante para fijar
        este número).

        Muestra:
        ● La media de los números leídos.
        ● El dígito en el que más números terminan.
        ● En qué dígitos no ha terminado ningún número.
        ● Cuántos números terminan en cada uno de los dígitos (0 .. 9).
        ● Calcula a qué % del total de números creados equivale cada elemento del
        punto anterior.
        ● Calcula también la suma total de todos los porcentajes calculados y la media
        de porcentajes para los valores contados (es decir, la suma de todos los
        porcentajes entre 6 (los valores 0, 1, 2, 3, 4 y 5))
        Prueba a cambiar el valor de la constante para crear muchos más números, como
        60.000, y hazlo de nuevo para crear muy pocos, como 20, o 100. ¿Qué ocurre con
        los porcentajes?¿Se repite cada número una cantidad de veces similar? ¿Qué
        diferencia existe entre crear pocos y muchos números?

        Ejemplo de ejecución:
        El nº 0 se ha repetido 1017 veces. Esto equivale a un 16,95%
        El nº 1 se ha repetido 990 veces. Esto equivale a un 16,50%
        El nº 2 se ha repetido 994 veces. Esto equivale a un 16,57%
        El nº 3 se ha repetido 998 veces. Esto equivale a un 16,63%
        El nº 4 se ha repetido 1017 veces. Esto equivale a un 16,95%
        El nº 5 se ha repetido 984 veces. Esto equivale a un 16,40%
        La suma de todos los porcentajes es equivalente al 100.00%. El % medio para cada
        contador es de 16,67%*/
public class Ejer_4 {
    public static void main(String[] args) {

        final int NUM_CAPACIDAD = 6000;

        int[] array6000 = new int[NUM_CAPACIDAD];
        int suma = 0;

        for (int i = 0; i <= array6000.length - 1; i++) {

            array6000[i] = (int) (Math.random() * 100);

            suma += array6000[i];

            if (array6000[i] == 0) {// AQUI ME QUEDO, NO ENTIENDO BIEN EL EJERCICIO!!!
            }

        }

        System.out.printf("La media de los números leídos es %d.", suma / NUM_CAPACIDAD);
        //System.out.printf("El dígito en el que más números terminan.");
        //  System.out.printf("En qué dígitos no ha terminado ningún número");
        //  System.out.printf("Cuántos números terminan en cada uno de los dígitos (0 .. 9)");
        //  System.out.printf("Calcula a qué % del total de números creados equivale cada elemento del punto anterior");

    }
}
