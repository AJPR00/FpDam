package Examen22;

public class FicheroImagen extends Fichero {
    private byte[] contenido;
    private EFormato formato;

    public FicheroImagen(String nombre, EFormato formato) {
        super(nombre);
        this.formato = formato;
    }

    @Override
    public void tamano() {
        setTamano(contenido.length);
    }

    /**
     * System.arraycopy(origen, posición donde empieza acopiar del origen, destino, posición donde empezar aguardar, cuantas posiciones copiar del destino)
     */
    @Override
    public void addContenido(String s) {
        byte[] newArrayAmpliada = new byte[s.getBytes().length + contenido.length];

        System.arraycopy(s.getBytes(), 0, newArrayAmpliada, 0, s.getBytes().length);
        System.arraycopy(contenido, 0, newArrayAmpliada, s.getBytes().length,contenido.length);

        contenido=newArrayAmpliada;
        tamano();
    }

    public void imprimir(String s) {
        for (byte h : contenido) {
            System.out.println(h);
        }
    }
}