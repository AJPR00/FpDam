package Class;

public class Principal {

    public static Dado dado4A = new Dado(4, 2);
    public static Dado dado12B = new Dado(12, 1);
    public static Dado dado6C = new Dado(6, 10);

    public static void main(String[] args) {
        System.out.println("dado4: " + dado4A.lanzar());
        System.out.println("dado6: " + dado6C.lanzar());
        System.out.println("dado12: " + dado12B.lanzar());

    }

}


