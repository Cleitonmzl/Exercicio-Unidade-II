public class C3 extends C1 implements I1, I2 {

    private boolean atributoC3;

    public C3() {
        super("C3 chamando C1");
        this.atributoC3 = true;
    }

    @Override
    public void metodoC1() {
        System.out.println("Metodo C1 (Sobrescrito por C3) | Atributo C1: " + getAtributoC1());
    }

    public void metodoC3() {
        System.out.println("Metodo C3 (Próprio) | Atributo C3: " + this.atributoC3);
    }

    @Override
    public void metodoI1() {
        System.out.println("C3 implementa metodoI1");
    }

    @Override
    public void metodoI2_A() {
        System.out.println("C3 implementa metodoI2_A");
    }

    @Override
    public void metodoI2_B() {
        System.out.println("C3 implementa metodoI2_B");
    }
}