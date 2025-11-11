public class Robo {
    
    private int linha;
    private int coluna;
    private int passo;
    
    private final int maxLinha;
    private final int maxColuna;

    public Robo(int linhaInicial, int colunaInicial, int passo, int totalLinhas, int totalColunas) {
        this.linha = linhaInicial;
        this.coluna = colunaInicial;
        this.passo = passo;
        this.maxLinha = totalLinhas - 1;
        this.maxColuna = totalColunas - 1;
    }

    public int getLinha() {
        return this.linha;
    }

    public int getColuna() {
        return this.coluna;
    }

    public void mostrarPosicao() {
        System.out.println("============================");
        System.out.println("Posição atual: (" + this.linha + ", " + this.coluna + ")");
        System.out.println("============================");
    }

    public void andarFrente() {
        int proximaLinha = this.linha - this.passo;

        if (proximaLinha < 0) {
            this.linha = 0;
            System.out.println("================================");
            System.out.println("Não pode mais andar para frente!");
            System.out.println("================================");
        } else {
            this.linha = proximaLinha;
        }
    }

    public void andarTras() {
        int proximaLinha = this.linha + this.passo;
        
        if (proximaLinha > this.maxLinha) {
            this.linha = this.maxLinha;
            System.out.println("================================");
            System.out.println("Não pode mais andar para trás!");
            System.out.println("================================");
        } else {
            this.linha = proximaLinha;
        }
    }

    public void andarDireita() {
        int proximaColuna = this.coluna + this.passo;

        if (proximaColuna > this.maxColuna) {
            this.coluna = this.maxColuna;
            System.out.println("================================");
            System.out.println("Não pode mais andar para direita!");
            System.out.println("================================");
        } else {
            this.coluna = proximaColuna;
        }
    }

    public void andarEsquerda() {
        int proximaColuna = this.coluna - this.passo;

        if (proximaColuna < 0) {
            this.coluna = 0;
            System.out.println("================================");
            System.out.println("Não pode mais andar para esquerda!");
            System.out.println("================================");
        } else {
            this.coluna = proximaColuna;
        }
    }
}