public class A implements InterfazA {
    protected String nombre;
    protected Object b;

    public A(String nombre, Object b) {
        this.nombre = nombre;
        this.b = b;
    }

    public void universalA() {
        System.out.println("UniversalA");
    }

    public void imprimirA() {
        System.out.println("Imprimiendo desde A");
    }

    @Override
    public void interfazA() {
        System.out.println("interfazA");
    }


    public static void main(String[] args) {
        C c = null;
        A a = new A("Soy A", c);
        B b = new B("Soy B", a);
        c = new C("Soy C", b);


        System.out.println(a.toString());

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("A{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", b=").append(((C)b).toString());
        sb.append('}');
        return sb.toString();
    }
}
