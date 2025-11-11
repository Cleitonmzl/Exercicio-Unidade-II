public class C2 extends C1 {

    private int atributoC2;

    public C2() {
        super("C2 chamando C1");
        this.atributoC2 = 2;
    }

    @Override
    public void metodoC1() {
        System.out.println("Metodo C1 (Sobrescrito por C2) | Atributo C1: " + getAtributoC1());
    }

    public void metodoC2() {
        System.out.println("Metodo C2 (Sobrecarga 1) | Atributo C2: " + this.atributoC2);
    }
    
    public void metodoC2(int novoValor) {
        System.out.println("Metodo C2 (Sobrecarga 2) | Novo Valor: " + novoValor);
        this.atributoC2 = novoValor;
    }
}