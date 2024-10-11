package Examen22;


public abstract class FicheroTexto extends Fichero implements Convertible {
    protected String[] contenido;

    public FicheroTexto(String nombre) {
        super(nombre);
    }

    public void addContenido(String src) {
        contenido = src.split("\\.\\s");
    }

    String leerContenido() {
        StringBuilder sb = new StringBuilder();
        for (String src : contenido) {
            sb.append(src).append("\n");
            //Era ser un avión...
        }
        return sb.toString();
    }

    @Override
    public void convertir() {
        StringBuilder sb = new StringBuilder();
        for (String src : contenido) {
            sb.append(src).append(" ");
        }
        System.out.println("Convirtiendo... " + sb.toString());
    }


    /**
     * Un String está compuesto por CHAR y cada CHAR ocupa 2 bytes (16 bits), siempre que esté en UNICODe
     *
     * src.getBytes(StandardCharsets.UTF_8).length nos devuelve el tamaño de una array de bytes
     */
    @Override
    public void tamano() {
        int tamano = 0;
        for (int i = 0; i < contenido.length; i++) {
            tamano = contenido[i].length() * 2;
            //tamano=contenido[i].getBytes(StandardCharsets.UTF_16).length;
        }
        setTamano(tamano);
    }

}
