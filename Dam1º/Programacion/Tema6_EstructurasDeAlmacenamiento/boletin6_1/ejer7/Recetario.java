package ejer7;


import javax.script.Compilable;
import java.util.*;
import java.util.stream.Stream;

public class Recetario {
    private Map<String, Receta> recetas;

    public Recetario() {
        this.recetas = new HashMap<String, Receta>();
    }

    /* Método para añadir una receta. Si ya existe una receta con ese nombre
     saltará la excepción. Ojo guarda la receta con un key NULL el HashMap lo permite */
    public void annadirReceta(Receta nuevaReceta) throws RecetaException {
        if (recetas.containsKey(nuevaReceta.getNombre())) throw new RecetaException("La receta ya existe");
        recetas.put(nuevaReceta.getNombre(), nuevaReceta);
    }

    /*    Método que devuelva un String con un listado todas las recetas ordenadas
        alfabéticamente por nombre. Por cada receta aparecerá su nombre y el
        tiempo de preparación. Si no hay recetas debe saltar la excepción.*/
    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException {
        if (recetas.isEmpty()) throw new RecetaException("El recetario no contiene recetas");
        // Nueva List solo con las keys de recetario.
        ArrayList<String> listRecetas = new ArrayList<String>(recetas.keySet());
        StringBuilder bl = new StringBuilder("Recetas:");
        //Orden natural
        Collections.sort(listRecetas);
        for (String r : listRecetas) {
            bl.append("\n").append("# ").append(r);
        }
        return bl.toString();
    }

    //Metodo mediante flujo
    public List<Receta> listaFlujoRecetasOrdenadasAlfabet() throws RecetaException {
        if (recetas.isEmpty()) throw new RecetaException("El recetario no contiene recetas");

        return recetas.values().stream().sorted().toList();
    }

    /* Método que devuelva un String con un listado de todas las
     recetas que contienen un ingrediente ordenadas de forma
     ascendente por el tiempo de preparación. Por cada receta
     aparecerá su nombre y el tiempo de preparación. Si no hay
     recetas con ese ingrediente saltará la excepción*/
    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {
        if (recetas.isEmpty()) throw new RecetaException("El recetario no contiene recetas");

        // Nueva List solo con las keys de recetario.
        ArrayList<String> listRecetas = new ArrayList<String>(recetas.keySet());
        StringBuilder bl = new StringBuilder("Recetas:");
        OrdenDuracion oD = new OrdenDuracion();
        //Orden natural
        //Collections.sort(listRecetas);
        for (String r : listRecetas) {
            bl.append("\n").append("# ").append(r);
        }
        return bl.toString();
    }

    public List<Receta> listadoFlujoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException {

        List<Receta> listaRecetas = recetas.values().stream().filter(receta -> receta.necesitaIngrediente(ingrediente)).toList();

        if (listaRecetas.isEmpty()) throw new RecetaException("El recetario no contiene recetas");

        listaRecetas.sort((a, b) -> a.getTiempo() - b.getTiempo());

        return listaRecetas;
    }
}

