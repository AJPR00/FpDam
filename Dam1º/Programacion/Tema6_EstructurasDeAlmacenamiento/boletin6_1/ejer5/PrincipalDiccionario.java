package ejer5;

import java.util.List;
import java.util.Scanner;

public class PrincipalDiccionario {
	
	public static final int OPCION_SALIR = 5;
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		Diccionario diccionarioObj = new Diccionario();
		
		int opcion = 0;
		
		while (opcion != OPCION_SALIR) {
			System.out.println(menu());
			
			try {
				opcion = Integer.parseInt(sc.nextLine());
				
				switch (opcion) {
				case 1:
					opcion1(diccionarioObj);
					break;
				case 2:
					opcion2(diccionarioObj);
					break;
				case 3:
					opcion3(diccionarioObj);
					break;
				case 4:
					opcion4(diccionarioObj);
					break;
				case OPCION_SALIR:
					System.out.println("Adiós");
					break;
				default:
					System.out.println("Introduce un número del 1 al 5");
				}
			}
			catch (NumberFormatException | ExcepcionDiccionario e) {
				System.out.println("Introduce un número del 1 al 5");
			}

		}

	}
	
	public static String menu() {
		StringBuilder sb = new StringBuilder();
		sb.append("¿Qué deseas hacer?").append(System.lineSeparator())
		.append("1. Añadir palabra").append(System.lineSeparator())
		.append("2. Buscar palabra").append(System.lineSeparator())
		.append("3. Borrar palabra").append(System.lineSeparator())
		.append("4. Listado de palabras").append(System.lineSeparator())
		.append("5. Salir").append(System.lineSeparator())
		.append("Introduce un número: ");
		return sb.toString();
	}
	
	public static void opcion1(Diccionario Diccionario22) {
		
		boolean correcto = false;
		String palabra = null, significado = null;
		
		while (!correcto) {
			System.out.print("Introduce una palabra que no esté vacía: ");
			palabra = sc.nextLine();
			if (!palabra.isBlank()) {
				correcto = true;
			}
		}
		
		// Ahora recogemos el significado
		correcto = false;
		
		while (!correcto) {
			System.out.print("Introduce el significado: ");
			significado = sc.nextLine();
			if (!significado.isBlank()) {
				correcto = true;
			}
		}
		
		Diccionario22.anadirPalabra(palabra, significado);
	}
	
	public static void opcion2(Diccionario diccionario) throws ExcepcionDiccionario {
		boolean correcto = false;
		String palabra = null;
		
		while (!correcto) {
			System.out.print("Introduce la palabra a buscar: ");
			palabra = sc.nextLine();
			if (!palabra.isBlank()) {
				correcto = true;
			}
			else {
				System.out.println("La palabra no puede estar vacía");
			}
		}
		
		List<String> significados = diccionario.bucarPalabra(palabra);
		
		if (significados == null) {
			System.out.println("No encuentro la palabra. Comprueba las mayúsculas y minúsculas");
		}
		else {
			for (String significado: significados) {
				System.out.println(significado);
			}
		}
	}
	
	public static void opcion3(Diccionario Diccionario22) throws ExcepcionDiccionario {
		boolean correcto = false;
		String palabra = null;
		
		while (!correcto) {
			System.out.print("Introduce la palabra a borrar: ");
			palabra = sc.nextLine();
			if (!palabra.isBlank()) {
				correcto = true;
			}
		}
		Diccionario22.borrarPalabra(palabra);
	}
	
	public static void opcion4(Diccionario Diccionario22) throws ExcepcionDiccionario {
		System.out.print("Introduce el comienzo de la palabra: ");
		String comienzaPor = sc.nextLine().trim();
		
		List<String> claves = Diccionario22.listadoPalabras(comienzaPor);
		for (String clave: claves) {
			System.out.println(clave);
		}
	}
}
