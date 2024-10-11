package Tema6_EstructurasDeAlmacenamiento.boletin6_1.examen21.ejercicio1;

import java.awt.geom.Line2D;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PeliculasDeUnTema {

    private String tema;
    private LinkedList<Pelicula> listaPeliculasDeUnTema;

    public PeliculasDeUnTema(String tema) {
        this.tema = tema;
        listaPeliculasDeUnTema = new LinkedList<Pelicula>();
    }

    public String getTema() {
        return this.tema;
    }

    public void addPelicula(Pelicula pelicula) throws NetPleaseException {
       /* if (!listaPeliculasDeUnTema.contains(pelicula)) {
            if (pelicula.getAnnoEstreno() <= LocalDate.now().getYear()) {
                listaPeliculasDeUnTema.add(pelicula);
            } else {
                throw new NetPleaseException("Año de estreno incorecto");
            }
        } else throw new NetPleaseException("Película y aregistrada")*/
        ;

        if (listaPeliculasDeUnTema.contains(pelicula)) throw new NetPleaseException("Película y aregistrada");
        if (pelicula.getAnnoEstreno() > LocalDate.now().getYear())
            throw new NetPleaseException("Año de estreno incorecto");
        listaPeliculasDeUnTema.add(pelicula);
    }


    public void borrarLasPeliculasDeUnAnno(int anno) throws NetPleaseException {

      /*             !!!!!!! Hay que realizarlo con ITERADOR PARA BORRAR¡¡¡¡¡¡¡¡¡¡¡¡¡¡
        El forech solo borra una pelicula con remove y al siguiente lanza una excepcion,!!hay que hacerlo con un Iterator.*/
     /*   boolean encontrado = false;
        for (Pelicula p : listaPeliculasDeUnTema) {
            if (p.getAnnoEstreno() == anno) {
                listaPeliculasDeUnTema.remove(p);
                encontrado = true;
            }
            if (!encontrado) throw new NetPleaseException("No se dispone de películas de ese año");
        }*/

        if (!listaPeliculasDeUnTema.removeIf(p -> p.getAnnoEstreno() == anno))
            throw new NetPleaseException("Pelicula ");
    }

    public void annadirOpinionAPelicula(String tituloPelicula, Opinion opinion) throws NetPleaseException {

        Pelicula p = buscarPeliculaPorTitulo(tituloPelicula);
        if (p == null) throw new NetPleaseException("Pelicula no encontrada");
        p.annadirOpinion(opinion);
    }

    public List<Pelicula> listadoDePeliculasOrdenadasPorMediaDeOpiniones() {


        return listaPeliculasDeUnTema.sort((a, b) -> Double.compare(b.mediaDeOpiniones(), a.mediaDeOpiniones())).toList();

        // return listaPeliculasDeUnTema.stream().sorted((a, b) -> Double.compare(b.mediaDeOpiniones(),a.mediaDeOpiniones())).toList();
    }


    public List<Pelicula> listaPeliculasDondeIntervieneUnActor(String actor) {
       /* List<Pelicula> listaActorIntervienePelicula = new ArrayList<>();
        for (Pelicula p : listaPeliculasDeUnTema) {
            if (p.contieneActor(actor)) listaActorIntervienePelicula.add(p);
        }
        return listaActorIntervienePelicula;*/

        return listaPeliculasDeUnTema.stream().filter(p -> p.contieneActor(actor)).toList();
    }

    public Pelicula buscarPeliculaPorTitulo(String titulo) throws NetPleaseException {
        return listaPeliculasDeUnTema.stream().filter(p1 -> p1.getTitulo().equals(titulo)).findFirst().orElse(null);
    }

    public boolean borrar(String titulo) {
        //retorna un el boolean true si contiene y lo borra. Con contentEquals especificamos de que sea exactamente el título descrito.
        return listaPeliculasDeUnTema.removeIf(pelicula -> pelicula.getTitulo().equals(titulo));
    }

    public LinkedList<Pelicula> getListaPeliculasDeUnTema() {
        return listaPeliculasDeUnTema;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tema == null) ? 0 : tema.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PeliculasDeUnTema other = (PeliculasDeUnTema) obj;
        if (tema == null) {
            if (other.tema != null)
                return false;
        } else if (!tema.equals(other.tema))
            return false;
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tema " + tema + "\n");
        for (Pelicula pelicula : listaPeliculasDeUnTema) {
            sb.append(pelicula + "\n");
        }
        return sb.toString();
    }


}
