public class Main {
    public static void main(String[] args) {
        try {
            Motor m1=new Motor("R24","we524","5sd5sd5sds",0.97,5,14254,0.8);
            Motor m2=new Motor("55tt","232f","re54rwe89r",0.97,96,155,0.8);
            Motor m3=new Motor("343f","seer","32eed32",0.97,96,15,0.8);

            CajaDeCambio c1 = new CajaDeCambio(5,true);
            CajaDeCambio c2 = new CajaDeCambio(4,true);
            CajaDeCambio c3 = new CajaDeCambio(7,true);

            Bateria b1 = new Bateria(2000,19,95);
            Bateria b2 = new Bateria(2000,19,95);
            Bateria b3 = new Bateria(2000,19,95);

            Deposito d1=new Deposito(100,50,true);
            Deposito d2=new Deposito(100,5,true);
            Deposito d3=new Deposito(100,5,true);

            Coche ch1 = new Coche("Renaul","R25",EColores.AMARILLO,m1,c1,b1,d1);
            Coche ch2 = new Coche("Citroen","AltPrio",EColores.NEGRO,m2,c2,b2,d2);
            Coche ch3 = new Coche("Toyota","E245",EColores.BLANCO,m3,c3,b3,d3);


            ch1.arrancar();
            ch2.arrancar();
            ch3.arrancar();

            System.out.println(ch1.toString());
            System.out.println(ch2.toString());
            System.out.println(ch3.toString());

        }catch (ExcepcionCoche e){
            System.out.println(e.getMessage());
        }
    }
}