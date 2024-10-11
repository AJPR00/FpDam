package Class.Cartas;
import ClassExcepcion.ExcepcionOvni;
import Enum.EMateriaPrima;

/* Los escudos por defecto tienen 20 puntos de defensa, a los que habrá que sumar los puntos
   resultantes de lanzar el DADO A.*/
public class ConstEcudoProtector extends CartaConstruccion{
    private static final int PUNTO_DEFENSA=20;
    private static final int HABITANTES_ESCUDO=15;
    /**
     * Coste de la carta, 5 unidades de Oro.
     */
    private static final int COSTE_CARTA = 5;
    private static final EMateriaPrima TIPO_MATERIAL = EMateriaPrima.ORO;
    private int puntoDefensa;
    private int habitanteEScudo;

    public ConstEcudoProtector(String nombre, int precio) {
        super(nombre, precio);
        this.puntoDefensa = PUNTO_DEFENSA;
        this.habitanteEScudo = HABITANTES_ESCUDO;
    }

    public void setPuntoDefensa(int puntoDefensa) throws ExcepcionOvni {
        if (puntoDefensa<=0)throw new ExcepcionOvni("La defensa debe de ser mayor a 0");
        this.puntoDefensa = puntoDefensa;
    }

    @Override
    public String getNombre() {
        return null;
    }

    @Override
    public int getPrecio() {
        return 0;
    }

    @Override
    public void setPrecio(int precio) {
        precio=COSTE_CARTA;
        super.setPrecio(precio);
    }
}
