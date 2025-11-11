public abstract class C1 {
    
    private String atributoC1;

    public C1() {
        this.atributoC1 = "valorDefaultC1";
    }

    public C1(String atributoC1) {
        this.atributoC1 = atributoC1;
    }

    public String getAtributoC1() {
        return atributoC1;
    }

    public abstract void metodoC1();
}