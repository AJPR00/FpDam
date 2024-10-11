package ejer7;

import java.time.LocalTime;
import java.util.*;

public class Receta implements Comparable<Receta>{
    private String nombre;

    /**
     * int tiempo esta en minutos
     */
    private int tiempo;
    public int getTiempo() {
        return tiempo;
    }
    private Set<Ingrediente> listaIngredientes;
    private List<String> pasosReceta;


    public Receta(String nombre, int tiempo) {
        this.nombre = nombre.toUpperCase();
        try {
            setTiempo(tiempo);
        } catch (RecetaException e) {
            System.out.println(e.getMessage());
        }
        this.listaIngredientes = new HashSet<>();
        this.pasosReceta = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setTiempo(int tiempo) throws RecetaException {
        if (tiempo <= 0) throw new RecetaException("El tiempo debe de tener tiempo");
        this.tiempo = tiempo;
    }


    // Método para saber si una receta necesita un ingrediente, ojo que la entrada es un Strin y hay que comparlo con un Objeto Ingrediente
    public boolean necesitaIngrediente(String nombreIngrediente) {
        //return listaIngredientes.stream().anyMatch(i -> i.getNombre().equalsIgnoreCase(nombreIngrediente));
        for (Ingrediente i : listaIngredientes) {
            if (i.getNombre().equalsIgnoreCase(nombreIngrediente)) return true;
        }
        return false;
    }

    // Añadir un ingrediente a una receta. Si el ingrediente ya está sumará esta cantidad a lo que se necesita
    public void annadirIngrediente(Ingrediente ingredienteNuevo) throws RecetaException {
        boolean encontrado = false;
        Iterator<Ingrediente> it = listaIngredientes.iterator();
        while (it.hasNext() && !encontrado) {
            //netx() te va devolviendo las referencia de cada objeto,
            Ingrediente ingr = it.next();
            if (ingr.getNombre().equalsIgnoreCase(ingredienteNuevo.getNombre())) {
                //ingr.setCantidad(ingr.getCantidad()+ingredienteNuevo.getCantidad());
                ingr.addCanidad(ingredienteNuevo.getCantidad());
            }
            encontrado = true;
        }
        if (!encontrado) {
            listaIngredientes.add(ingredienteNuevo);
        }
    }


    // Borrar un ingrediente de una receta. También debe borrar los pasos donde se nombre ese ingrediente
    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException {
        if (!listaIngredientes.remove(ingredienteABorrar)) throw new RecetaException("No contiene el ingrediente");

        Iterator<String> it = pasosReceta.iterator();

        while (it.hasNext()) {
            //netx() te va devolviendo las referencia de cada objeto
            String pasoBorrar = it.next();

            if (pasoBorrar.contains(ingredienteABorrar.getNombre())) {
                it.remove();
            }
        }


       /* boolean encontrado = false;
        Iterator<Ingrediente> it = listaIngredientes.iterator();

        while (it.hasNext()) {
            //netx() te va devolviendo las referencia de cada objeto,sxcf
            Ingrediente ingrBorrar = it.next();
            if (ingrBorrar.getNombre().equalsIgnoreCase(ingredienteABorrar.getNombre())) {
                listaIngredientes.remove(ingrBorrar);
                pasosReceta.removeIf(p -> p.contains(ingredienteABorrar.getNombre()));
                encontrado = true;
            }
        }
        //Si el iterador al recorrer la listaIngrediente
        if (!encontrado) {
            throw new RecetaException("La receta no contiene " + ingredienteABorrar.getNombre());
        }*/
    }


    //  Método añadir un paso detrás de otro. Recibirá el texto del nuevo paso y el texto del paso detrás del cual se deberá insertar.
    public void annadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException {
        boolean encontrado = false;

        //si la ArrayLis esta vacía lanza una excepción

        if (pasosReceta.isEmpty() && pasosReceta.indexOf(pasoExistente) ==-1) throw new RecetaException("La receta no contiene ningún paso ");

        for (String paso : pasosReceta) {
            if (paso.equals(pasoExistente)) {
                pasosReceta.add(pasosReceta.lastIndexOf(paso)+1, pasoNuevo);
                encontrado = true;
            }
        }
        if (!encontrado) {
            throw new RecetaException("No hemos encontrado el paso existente ");
        }
    }


    @Override
    public int compareTo(Receta o) {
        return nombre.compareTo(o.getNombre());
    }
}
