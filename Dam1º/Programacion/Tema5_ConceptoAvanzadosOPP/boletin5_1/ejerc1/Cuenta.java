package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc1;


public class Cuenta {
    private static final double SALDO_DEFAULT=0;
    private double saldo;
    public Cuenta() {
        this.saldo=SALDO_DEFAULT;
    }
    public Cuenta(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void ingresar(double saldoIn) throws CuentaException{
        if (saldoIn<1){
            throw new CuentaException("Debes de ingresar Saldo positivo");
        }
        this.saldo+=saldoIn;
    }


    public void retirar(double saldoIn) throws CuentaException{

        if (saldoIn<1){
            throw new CuentaException("Debes de retirar Saldo positivo");
        }
        if (saldoIn>saldo){
            throw new CuentaException("Saldo insuficiente");
        }
        this.saldo-=saldoIn;
    }

    @Override
    public String toString() {
        return "Cuenta saldo: " + saldo;
    }
}






