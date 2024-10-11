package Examen22;

public class FicheroTextoFormateado extends FicheroTexto implements Analizable {
    private String tipoFuente;
    private String color;
    private int tamnoFuente;

    public FicheroTextoFormateado(String nombre,String tipoFuente, String color, int tamnoFuente) {
        super(nombre);
        this.tipoFuente = tipoFuente;
        this.color = color;
        this.tamnoFuente = tamnoFuente;
    }


    @Override
    public void analizando() {
        System.out.println("Analizando " + getNombre());
    }
}
