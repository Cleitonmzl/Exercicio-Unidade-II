public class Principal {
    public static void main(String[] args) {

        System.out.println("--- Testando C2 ---");
        C2 objC2 = new C2();
        objC2.metodoC1();
        objC2.metodoC2();
        objC2.metodoC2(22);

        System.out.println("\n--- Testando C3 ---");
        C3 objC3 = new C3();
        objC3.metodoC1();
        objC3.metodoC3();
        objC3.metodoI1();
        objC3.metodoI2_A();
        objC3.metodoI2_B();

        System.out.println("\n--- Testando C4 ---");
        C4 objC4 = new C4();
        objC4.metodoC1();
        objC4.metodoC4();
        objC4.metodoC2();
        objC4.metodoC2(44);

        System.out.println("\n--- Testando C5 ---");
        C5 objC5 = new C5();
        objC5.metodoC1();
        objC5.metodoC5();
        objC5.metodoI1();
        objC5.metodoC2();
        objC5.metodoC2(55);
    }
}