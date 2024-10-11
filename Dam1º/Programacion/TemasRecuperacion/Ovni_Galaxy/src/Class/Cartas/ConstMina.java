package Class.Cartas;

import ClassExcepcion.ExcepcionOvni;
import Enum.EMateriaPrima;


//Usa el DADO A parapoder minas debe de tener 10 Habitantes minimo.
public class ConstMina extends CartaConstruccion {
    // Si es de tipo Oro la unidad de minar siempre es 2
    private static final int MAX_MINAR_ORO = 2;
    private static final int MIN_HABT_MINAR = 10;

    /**
     * Coste de la carta, 1 unidad de Oro.
     */
    private static final int COSTE_CARTA = 1;
    private static final EMateriaPrima COSTE_CARTA_MATERIAL = EMateriaPrima.ORO;
    private EMateriaPrima matriaPrima;
    private int unidadExtraer;
    private int habitantesAsociado;

    public ConstMina(String nombre,int precio,EMateriaPrima matriaPrima, int unidadExtraer) throws ExcepcionOvni {
        super(nombre,precio);
        this.matriaPrima = matriaPrima;
        setUnidadExtraer(unidadExtraer);
        this.habitantesAsociado = MIN_HABT_MINAR;
    }

    public void setUnidadExtraer(int unidadExtraer) throws ExcepcionOvni {
        if (unidadExtraer<=0)
            throw new ExcepcionOvni("El valor a retirar debe de ser mayor a 0");

        if (!matriaPrima.equals(EMateriaPrima.ORO)) {
            this.unidadExtraer = unidadExtraer;
        } else {
            this.unidadExtraer = MAX_MINAR_ORO;
        }
    }

    @Override
    public void setPrecio(int precio) {
        precio=COSTE_CARTA;
        super.setPrecio(precio);
    }
}
