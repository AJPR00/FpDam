public  class B extends A{
    public B(String nombre, Object b) {
        super(nombre, b);
    }

    public void imprimirB() {
        System.out.println("imprimiendo desdeB");
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("B{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append('}').append(" SOY B").append(super.toString());
        return sb.toString();
    }
}
