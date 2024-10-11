package boletin_Arrays1;
import java.util.Scanner;

class Ejer_Array1 {

	public static void main(String[] args) {
		int[] numerosArray;
		int contador = 0;
		numerosArray = new int[9];
		Scanner sc = new Scanner(System.in);

		// Pedir al usuario que ingrese 9 números
		for (int i = 0; i < numerosArray.length; i++) {
			System.out.print("Ingrese un número: ");
			numerosArray[i] = sc.nextInt();
		}

		// Sumar los números en índices pares del array
		for (int i = 0; i < numerosArray.length; i += 2) {
			contador += numerosArray[i];
		}

		System.out.println("La suma de los números en índices pares es: " + contador);
	}
}

