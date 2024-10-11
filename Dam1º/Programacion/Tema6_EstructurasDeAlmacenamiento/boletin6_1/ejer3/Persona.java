package ejer3;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Persona {
    private String nombre;
    private List<Mensaje> bandejaEntrada;


    public String getNombre() {
        return nombre;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
        bandejaEntrada = new ArrayList<>();
    }

    public void enviarMensaje(Persona receptor, String mensaje) throws CorreoException {
        receptor.bandejaEntrada.add(new Mensaje(this, mensaje));
    }

    public String leerMensaje() {
        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < bandejaEntrada.size(); i++) {
            mensaje.append("Mensaje ").append(i + 1).append(bandejaEntrada.get(i)).append("\n");
        }
        return mensaje.toString();
    }

    public String leerMensajesOrdenados() {
        List<Mensaje> bandejaOrdenada = new ArrayList<>(bandejaEntrada);
        bandejaOrdenada.sort(null);

        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < bandejaOrdenada.size(); i++) {
            mensaje.append("Mensaje ").append(i + 1).append(bandejaOrdenada.get(i)).append("\n");
        }
        return mensaje.toString();
    }

    public String leerMensajesAlfa() {
        List<Mensaje> bandejaOrdenada = new ArrayList<>(bandejaEntrada);

       /* Comparator<Mensaje>AlfabeticoComparator=new Comparator<Mensaje>() {
            @Override
            public int compare(Mensaje o1, Mensaje o2) {
                return o1.getRemitente().getNombre().compareTo(o2.getRemitente().getNombre());
            }
        }
        bandejaOrdenada.sort(AlfabeticoComparator);*/

        //Expresión lambda
        bandejaOrdenada.sort((a, b) -> a.getRemitente().getNombre().compareTo(b.getRemitente().getNombre()));


        StringBuilder mensaje = new StringBuilder();
        for (int i = 0; i < bandejaOrdenada.size(); i++) {
            mensaje.append("Mensaje ").append(i + 1).append(bandejaOrdenada.get(i)).append("\n");
        }
        return mensaje.toString();
    }

    public void borrerMensaje(int num) throws ExcepcionMensaje {
        try {
            bandejaEntrada.remove(num - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new ExcepcionMensaje("No encontrado");
        }
    }

    public String filtrarPorFrase(String frase) throws ExcepcionMensaje {
        StringBuilder bl = new StringBuilder();
        //Flujo
        //bandejaEntrada.stream().filter(m -> m.getTexo().contains(frase)).forEach(m -> bl.append("\n").append(m));

        bandejaEntrada.stream().map(m->m.toString());

        //Si bl esta vacio lanza una excepcion
        if (bl.isEmpty()) throw new ExcepcionMensaje("No existe el mensaje");

        return bl.toString();
    }

}

