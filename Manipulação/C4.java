public class C4 extends C2 {

    private double atributoC4;

    public C4() {
        this.atributoC4 = 4.4;
    }

    @Override
    public void metodoC1() {
        System.out.println("Metodo C1 (Sobrescrito por C4)");
    }

    public void metodoC4() {
        System.out.println("Metodo C4 (Próprio) | Atributo C4: " + this.atributoC4);
    }
}