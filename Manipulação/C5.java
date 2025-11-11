public class C5 extends C2 implements I1 {
    
    private char atributoC5;

    public C5() {
        this.atributoC5 = '5';
    }

    @Override
    public void metodoC1() {
        System.out.println("Metodo C1 (Sobrescrito por C5)");
    }

    public void metodoC5() {
        System.out.println("Metodo C5 (Próprio) | Atributo C5: " + this.atributoC5);
    }

    @Override
    public void metodoI1() {
        System.out.println("C5 implementa metodoI1");
    }
}