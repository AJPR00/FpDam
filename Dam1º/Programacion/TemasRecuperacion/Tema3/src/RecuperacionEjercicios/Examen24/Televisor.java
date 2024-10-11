package RecuperacionEjercicios.Examen24;

public class Televisor {
    private Pixel[][] imagen;
    private int width;
    private int height;
    private boolean defectuoso;
    private double colorPromedio;
    private String conexionSoportado;
    private String protocoloSoportado;

    public Televisor(int width, int height, String conexionSoportado, String protocoloSoportado) {
        this.width = width;
        this.height = height;
        this.conexionSoportado = conexionSoportado;
        this.protocoloSoportado = protocoloSoportado;
    }

    public void setImagen(String[][] imagen) {
        Pixel[][] imgRGB = new Pixel[imagen.length][];
        for (int i = 0; i < imagen.length; i++) {
            imgRGB[i] = new Pixel[imagen[i].length];
            for (int j = 0; j < imagen[i].length; j++) {
                try {
                    imgRGB[i][j] = new Pixel(Integer.parseInt(imagen[i][j].substring(1), 16));
                } catch (NumberFormatException e) {
                    System.err.println("Error al convertir el valor hexadecimal: " + imagen[i][j]);
                    // Manejo adicional del error, como asignar un valor predeterminado
                    imgRGB[i][j] = new Pixel(0);  // Ejemplo de valor predeterminado
                }
            }
        }
        this.imagen = imgRGB;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isDefectuoso() {
        return defectuoso;
    }

    public String getColorPromedio() {
        int contador = 0;
        for (int i = 0; i < this.imagen.length; i++) {
            for (int j = 0; j < this.imagen[i].length; j++) {
                contador = contador + this.imagen[i][j].getColor();
            }
        }
        String colorPromedio = Integer.toHexString(contador / (height * width));

        return "#"+colorPromedio;

    }

    public void setColorPromedio(double colorPromedio) {
        this.colorPromedio = colorPromedio;
    }

    public String conectar(Dispositivo dispoitivo) throws DispositivoNoCompatibleException {
        String[] conecTV = conexionSoportado.split(" ");
        String[] conecDispo = dispoitivo.getConexion().split(" ");
        String conex = null;

        String[] proTv = protocoloSoportado.split(" ");
        String[] proDsipo = dispoitivo.getProtocolo().split(" ");
        String protocolo = null;

        boolean encontrado = false;


        for (int i = 0; i < conecTV.length && !encontrado; i++) {
            for (int j = 0; j < conecDispo.length; j++) {
                if (conecTV[i].equalsIgnoreCase(conecDispo[j])) {
                    conex = conecTV[i];
                    encontrado = true;
                }
            }
        }
        encontrado = false;
        for (int i = 0; i < proTv.length && !encontrado; i++) {
            for (int j = 0; j < proDsipo.length; j++) {
                if (proTv[i].equalsIgnoreCase(proDsipo[j])) {
                    protocolo = proTv[i];
                    encontrado = true;
                }
            }
        }

        if (conex == null)
            throw new DispositivoNoCompatibleException("El dispositivo " + dispoitivo.getNombre() + " no tiene ningún conexión compatible");
        if (protocolo == null)
            throw new DispositivoNoCompatibleException("El dispositivo " + dispoitivo.getNombre() + " no tiene ningún protocolo compatible");


        /*if (!conexionSoportado.todispoitivo.getConexion()))
        throw new DispositivoNoCompatibleException("El dispositivo " + dispoitivo.getNombre() + " no tiene ningún conexión compatible");
        if (!protocoloSoportado.contains(dispoitivo.getProtocolo()))
            throw new DispositivoNoCompatibleException("El dispositivo " + dispoitivo.getNombre() + " no tiene ningún protocolo compatible");*/

        return "Dispositivo " + dispoitivo.getNombre() + " conectado en el puerto " + conex + " usando el protocolo " + protocolo;

    }
}
