package boletin1_7;
/*3. Realiza un programa que convierta números romanos a números en base decimal.
        Las equivalencias son las siguientes:
        M 1000
        D 500
        C 100
        L 50
        X 10
        V 5
        I 1
        Los enteros romanos se escriben de acuerdo a las siguientes reglas:
Si una letra está seguida inmediatamente por una de igual o menor valor, su valor se
suma al total acumulado. Así, XX = 20, XV = 15 y VI = 6.
Si una letra está seguida inmediatamente por una de mayor valor, su valor se
sustrae del total acumulado. Así, IV = 4, XL = 40 y CM = 900.
Por tanto, la entrada MMXIX debe devolver 2019.


 */

import java.util.Scanner;

public class Ejer_3 {

    private static final int VALOR_I = 1;
    private static final int VALOR_V = 5;
    private static final int VALOR_X = 10;
    private static final int VALOR_L = 50;
    private static final int VALOR_C = 100;
    private static final int VALOR_D = 500;
    private static final int VALOR_M = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Introduzca el número romano para convertirlo a número decimal.");
        String numRomano = sc.nextLine();
        sc.close();

        int valorDecimal = 0;
        int valorDigitoAnterior = 0;

        for (int i = 0; i < numRomano.length(); i++) {
            char digit = numRomano.charAt(i);
            int valorLetra = valorLetra(digit);

            /* FUNCIONAL
            if (i == 0) {
                valorDecimal = valorLetra;
            } else {
                if (valorDigitoAnterior >= valorLetra) {
                    valorDecimal += valorLetra;
                } else {
                    valorDecimal += valorLetra - 2 * valorDigitoAnterior;
                }
            }
            valorDigitoAnterior = valorLetra;
            */

            if (i == 0) {
                valorDigitoAnterior = valorLetra;
            } else {
                if (valorDigitoAnterior >= valorLetra) {
                    valorDecimal += valorDigitoAnterior;
                    valorDigitoAnterior = valorLetra;
                } else {
                    valorDecimal += valorLetra - valorDigitoAnterior;
                }
            }
        }

        System.out.printf("El valor introducido %s traducido a decimal es: %d", numRomano, valorDecimal);
    }

    public static int valorLetra(char c) {



        return switch (c) {
            case 'I':
                yield VALOR_I;
            case 'V':
                yield VALOR_V;
            case 'X':
                yield VALOR_X;
            case 'L':
                yield VALOR_L;
            case 'C':
                yield VALOR_C;
            case 'D':
                yield VALOR_D;
            case 'M':
                yield VALOR_M;
            default:
                yield -1;
        };
    }
}

