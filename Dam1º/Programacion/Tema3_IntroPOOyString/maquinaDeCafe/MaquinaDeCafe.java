package Tema3_IntroPOOyString.maquinaDeCafe;

public class MaquinaDeCafe {

    public static final int CAPACIDAD_MAX_DEPOSITO_CAFE = 1;
    public static final int CAPACIDAD_MAX_LECHE = 1;
    public static final int CAPACIDAD_MAX_VASOS = 2;
    public static final double MONEDERO = 2;
    public static final double PRECIO_CAFE = 1;
    public static final double PRECIO_LECHE = 0.8;
    public static final double PRECIO_CAFE_CON_LECHE = 1.5;


    private int cafeRestante, lecheRestante, vasosRestantes;
    private double monedero;
    private double recaudacion;
    private boolean hayProducto=false;


    public MaquinaDeCafe() {
        rellenarDepositos();
        monedero = MONEDERO;
    }

    public int getCafeRestante() {
        return cafeRestante;
    }

    public void setCafeRestante(int cafeRestante) {
        this.cafeRestante = cafeRestante;
    }

    public int getLecheRestante() {
        return lecheRestante;
    }

    public void setLecheRestante(int lecheRestante) {
        this.lecheRestante = lecheRestante;
    }

    public int getVasosRestantes() {
        return vasosRestantes;
    }

    public void setVasosRestantes(int vasosRestantes) {
        this.vasosRestantes = vasosRestantes;
    }

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    public void rellenarDepositos() {

        cafeRestante = CAPACIDAD_MAX_DEPOSITO_CAFE;
        lecheRestante = CAPACIDAD_MAX_LECHE;
        vasosRestantes = CAPACIDAD_MAX_VASOS;
    }

    public void vaciarMonedero() {

        if (monedero > MONEDERO) {
            recaudacion += monedero - MONEDERO;
            monedero = MONEDERO;
        }


    }

    public void cargando() throws InterruptedException {

        for (int i=0;i<=8;i++){
            System.out.print(".");
            Thread.sleep(1000);
        }

    }

    public void consultarEstado() {

        System.out.println("ESTADO:" +
                "\n   # CafeRestante= " + cafeRestante +
                "\n   # LecheRestante= " + lecheRestante +
                "\n   # VasosRestantes= " + vasosRestantes +
                "\n   # Monedero= " + monedero +
                "\n   # Recaudacion= " + recaudacion + "\n");

    }

    public boolean servirCafe() throws ExceptionMaquinaCafe {
        if (CAPACIDAD_MAX_DEPOSITO_CAFE > 0 && CAPACIDAD_MAX_VASOS > 0) {
            cafeRestante--;
            vasosRestantes--;
            monedero += PRECIO_CAFE;
            hayProducto=true;
        }else{
            throw new ExceptionMaquinaCafe();
        }


        return hayProducto;
    }

    public boolean servirCafeConLeche() {

        if (CAPACIDAD_MAX_DEPOSITO_CAFE > 0 && CAPACIDAD_MAX_VASOS > 0 && CAPACIDAD_MAX_LECHE > 0) {
            cafeRestante--;
            lecheRestante--;
            vasosRestantes--;
            monedero += PRECIO_CAFE_CON_LECHE;
            hayProducto=true;
        }

        return hayProducto;

    }

    public boolean servirLeche() {

        if (CAPACIDAD_MAX_LECHE > 0 && CAPACIDAD_MAX_VASOS > 0) {
            lecheRestante--;
            vasosRestantes--;
            monedero += PRECIO_LECHE;
            hayProducto=true;
        }

        return hayProducto;
    }


}
