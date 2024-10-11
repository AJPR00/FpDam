package Tema3_IntroPOOyString.Examenes.examenOPPenCasa.Examen;

public class Televisor {


    private int altura;

    private int anchura;
    private String protocolos;

    private String conexiones;
    private Pixel[][] panel;

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }

    public Televisor(int altura, int anchura, String protocolos, String conexiones) {
        this.altura = altura;
        this.anchura = anchura;
        this.protocolos = protocolos;
        this.conexiones = conexiones;
        panel = new Pixel[altura][anchura];
        inicializarPanel();
    }

    public void inicializarPanel() {

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                double r = Math.random();
                panel[i][j] = new Pixel(r <= 0.03);

            }
        }

    }

    public boolean isDefectuoso() {

        int cont = 0;
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                if (panel[i][j].isDefectuoso()) {

                    cont++;
                }
            }
        }
        return cont >= altura * anchura * 0.03;
    }

    public void setImagen(String[][] imagen) {

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {


                int rojo = Integer.parseInt(imagen[i][j].substring(1, 3), 16);
                int verde = Integer.parseInt(imagen[i][j].substring(3, 5), 16);
                int azul = Integer.parseInt(imagen[i][j].substring(5, 7), 16);

                panel[i][j].setRojo(rojo);
                panel[i][j].setVerde(verde);
                panel[i][j].setAzul(azul);
            }
        }
    }

    public String getColorPromedio() {

        long rojo = 0;
        long verde = 0;
        long azul = 0;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {

                rojo += panel[i][j].getRojo();
                verde += panel[i][j].getVerde();
                azul += panel[i][j].getAzul();

            }
        }
        int colorPromedioRojo = (int) (rojo / (altura * anchura));
        int colorPromedioVerde = (int) (verde / (altura * anchura));
        int colorPromedioAzul = (int) (azul / (altura * anchura));

        return String.format("%02%02x%02x", colorPromedioRojo, colorPromedioVerde, colorPromedioAzul);

    }

    public String conectar(Dispositivo dispositivo) throws DispositivoNoCompatibleException {

        String[] conexionesTv = conexiones.split(" ");
        String[] conexionesDispoitivos = dispositivo.getConexiones().split(" ");
        String conexeionesUtilizadas=null;

        for (int i = 0; i < conexionesTv.length && conexeionesUtilizadas == null; i++) {
            for (int j = 0; j < conexionesDispoitivos.length && conexeionesUtilizadas == null; j++) {

                if (conexionesTv[i].equals(conexionesDispoitivos[i])) {
                    conexeionesUtilizadas = conexionesDispoitivos[i];

                }

            }

        }

        if (conexeionesUtilizadas == null) {

            throw new DispositivoNoCompatibleException("El dispositivo" + dispositivo.getNombre() + "no tiene conexiones compatibles");
        }

        String[] protocolosTv = conexiones.split(" ");
        String[] protocolosDispoitivos = dispositivo.getProtocolos().split(" ");
        String protocolosUtilizadas=null;

        for (int i = 0; i < protocolosTv.length && protocolosUtilizadas == null; i++) {
            for (int j = 0; j < protocolosDispoitivos.length && protocolosUtilizadas == null; j++) {

                if (protocolosTv[i].equals(protocolosDispoitivos[i])) {
                    protocolosUtilizadas = protocolosDispoitivos[i];

                }

            }

        }

        if (protocolosUtilizadas == null) {

            throw new DispositivoNoCompatibleException("El dispositivo" + dispositivo.getNombre() + "no tiene nungun protocolo compatible");
        }
        return String.format("Dispositivo %s conectado en el %s usalndo el protocolo %s",dispositivo.getNombre(),conexeionesUtilizadas,protocolosUtilizadas);
    }
}
