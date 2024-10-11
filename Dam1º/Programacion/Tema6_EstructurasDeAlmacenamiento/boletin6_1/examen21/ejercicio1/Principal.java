package Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen21.ejercicio1;

public class Principal {

	public static void main(String[] args) {
		
		NetPlease netPlease=new NetPlease();
		
		
		try {
			netPlease.annadirTema("COMEDIA");
			netPlease.annadirTema("ACCION");
			netPlease.annadirTema("DRAMA");
			
			netPlease.addPelicula("COMEDIA", new Pelicula("TECHO", 2019));
			netPlease.addPelicula("ACCION", new Pelicula("BAJO ", 2019));
			netPlease.addPelicula("COMEDIA", new Pelicula("BAJO ", 2019));
			netPlease.addPelicula("COMEDIA", new Pelicula("BAJO EL MISMO TECHO", 2012));
			netPlease.addPelicula("DRAMA", new Pelicula(" MISMO TECHO", 1999));

			netPlease.listadoDeTodasPeliculasDeTodosLosTemas();
			System.out.println("ssssssssssssssssss");
			System.out.println(netPlease.temaDePelicula("BAJO "));
			
		} catch (NetPleaseException e) {
			System.err.println(e.getMessage());
		}

		
	}

}
