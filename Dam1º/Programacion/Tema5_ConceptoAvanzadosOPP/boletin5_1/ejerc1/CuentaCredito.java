package Tema5_ConceptoAvanzadosOPP.boletin5_1.ejerc1;

public class CuentaCredito extends Cuenta {
    private static final double SALDO_CREDITO_DEFAULT = 100;
    private static final double CREDITO_MAXIMO = 300;
    private double saldoCredito;
    private final double creditoMaximo;


    public CuentaCredito() {
        this.creditoMaximo = SALDO_CREDITO_DEFAULT;
        this.saldoCredito = SALDO_CREDITO_DEFAULT;
    }

    public CuentaCredito(double saldoCredito) throws CuentaException {
        setSaldoCredito(saldoCredito);
        this.creditoMaximo = saldoCredito;
    }

    public CuentaCredito(double saldo, double saldoCredito) throws CuentaException {
        super(saldo);
        setSaldoCredito(saldoCredito);
        this.creditoMaximo = saldoCredito;
    }


    public double getSaldoCredito() {
        return saldoCredito;
    }

    private void setSaldoCredito(double saldoCredito) throws CuentaException {
        if (saldoCredito > CREDITO_MAXIMO) {
            throw new CuentaException("Has superado el límite de crédito");
        }
        if (saldoCredito < 0) {
            throw new CuentaException("No es válido el crédito");
        }
        this.saldoCredito = saldoCredito;
    }

    @Override
    public void ingresar(double saldoIn) throws CuentaException {
        if (saldoIn <= 0) {
            throw new CuentaException("Ingrese una cantidad positiva");
        }
        double diferenciaSaldo = creditoMaximo - saldoCredito;
        if (saldoCredito < creditoMaximo) {
            if (saldoIn >= diferenciaSaldo) {
                saldoCredito = creditoMaximo;
                saldoIn -= diferenciaSaldo;
            } else {
                saldoCredito += saldoIn;
                saldoIn = 0;
            }
        }
        if (saldoIn > 0) {
            super.ingresar(saldoIn);
        }
    }
    @Override
    public void retirar(double saldoOut) throws CuentaException {
        if (saldoOut > getSaldo() + saldoCredito) {
            throw new CuentaException("ha llegado al limite de su credito");
        }
        if (saldoOut <= getSaldo()) {
            super.retirar(saldoOut);
        } else {
            saldoOut -= getSaldo();
            super.retirar(getSaldo());
            this.saldoCredito -= saldoOut;
        }
    }
    @Override
    public String toString() {
        return "Saldo del Credito: " + saldoCredito;
    }
}
