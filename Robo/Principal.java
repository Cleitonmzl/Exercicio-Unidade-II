import java.util.Scanner;

public class Principal {
    public static void main(String[] args){
        
        int[][] sala = new int[20][40];
        Robo r1 = new Robo(0, 0, 1, 20, 40);
        boolean sistema = true;
        Scanner leitor = new Scanner(System.in);

        while (sistema) {

            for(int i = 0; i < sala.length; i++){
                for(int j = 0; j < sala[i].length; j++){
                    sala[i][j] = 0;
                }
            }
            
            sala[r1.getLinha()][r1.getColuna()] = 1;

            for(int i = 0; i < sala.length; i++){
                for(int j = 0; j < sala[i].length; j++){
                    System.out.print(sala[i][j] + " ");
                }
                System.out.println();
            }

            r1.mostrarPosicao();

            System.out.println("\nDigite a sua acão!");
            System.out.println("1 - Andar para frente (Cima)");
            System.out.println("2 - Andar para trás (Baixo)");
            System.out.println("3 - Andar para direita");
            System.out.println("4 - Andar para esquerda");
            System.out.println("5 - Sair do sistema");
            int escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    r1.andarFrente();
                    break;
                case 2:
                    r1.andarTras();
                    break;
                case 3:
                    r1.andarDireita();
                    break;
                case 4:
                    r1.andarEsquerda();
                    break;
                case 5:
                    System.out.println("Saindo do sistema!");
                    sistema = false;
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
        
        leitor.close();
        System.out.println("Programa encerrado.");
    }
}