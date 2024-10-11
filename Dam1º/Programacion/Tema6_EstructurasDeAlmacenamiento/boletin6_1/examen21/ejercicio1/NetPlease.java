package Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen21.ejercicio1;

import java.util.HashMap;

public class NetPlease {

    //Hashmap donde por cada tema, podemos acceder a las películas de ese tema
    private HashMap<String, PeliculasDeUnTema> mapPeliculas;


    public NetPlease() {
        mapPeliculas = new HashMap<String, PeliculasDeUnTema>();

    }

    public void annadirTema(String tema) throws NetPleaseException {

        tema = tema.toUpperCase();
        if (mapPeliculas.containsKey(tema)) {
            throw new NetPleaseException("Ya existe ese tema");
        }

        mapPeliculas.put(tema, new PeliculasDeUnTema(tema));
    }


    public void addPelicula(String tema, Pelicula pelicula) throws NetPleaseException {
        PeliculasDeUnTema listaPeliculasDeUnTema = mapPeliculas.get(tema);

        if (listaPeliculasDeUnTema == null) {
            throw new NetPleaseException("No existe el tema " + tema);
        }
        listaPeliculasDeUnTema.addPelicula(pelicula);
    }

    public void listadoDeTodasPeliculasDeTodosLosTemas() {

        for (PeliculasDeUnTema listaPelisTema : mapPeliculas.values()) {
            System.out.println(listaPelisTema);
        }
    }

    public void borrarPeliculaDeUnTema(String tema, String titulo) throws NetPleaseException {

        if (!mapPeliculas.containsKey(tema)) throw new NetPleaseException("No existe el tema " + tema);
        PeliculasDeUnTema p = mapPeliculas.get(tema);
        if (!p.borrar(titulo)) throw new NetPleaseException("No existe la película");
    }

/*	Programar el método temaDePelicula: Devolverá el tema de la
	película indicada o null si no se encuentra la película.*/

    public String temaDePelicula(String titulo) throws NetPleaseException {
        
        for (String t : mapPeliculas.keySet()) {
            if(mapPeliculas.get(t).buscarPeliculaPorTitulo(titulo)!=null)return t;
        }
            return null;
    }


}
