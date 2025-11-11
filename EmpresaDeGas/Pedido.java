import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pedido {

    private int codigo;
    private LocalDate dataCompra;
    private LocalTime horaCompra;
    private Endereco enderecoEntrega;
    private int quantidadeBotijao;
    private float totalCompra;
    private LocalDateTime dataHoraEntrega;
    private String numeroCartao;
    private String status;

    public Pedido(int codigo, LocalDate dataCompra, LocalTime horaCompra, Endereco enderecoEntrega, int quantidadeBotijao) {
        this.codigo = codigo;
        this.dataCompra = dataCompra;
        this.horaCompra = horaCompra;
        this.enderecoEntrega = enderecoEntrega;
        this.quantidadeBotijao = quantidadeBotijao;
        this.status = "pendente";
    }

    public int getCodigo() {
        return this.codigo;
    }

    public LocalDate getDataCompra() {
        return this.dataCompra;
    }

    public Endereco getEnderecoEntrega() {
        return this.enderecoEntrega;
    }

    public LocalTime getHoraCompra() {
        return this.horaCompra;
    }

    public int getQuantidadeBotijao() {
        return this.quantidadeBotijao;
    }

    public float getTotalCompra() {
        return this.totalCompra;
    }

    public LocalDateTime getDataHoraEntrega() {
        return this.dataHoraEntrega;
    }

    public String getNumeroCartao() {
        return this.numeroCartao;
    }

    public String getStatus() {
        return this.status;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setHoraCompra(LocalTime horaCompra) {
        this.horaCompra = horaCompra;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public void setQuantidadeBotijao(int quantidadeBotijao) {
        this.quantidadeBotijao = quantidadeBotijao;
    }

    public void setDataHoraEntrega(LocalDateTime dataHoraEntrega) {
        this.dataHoraEntrega = dataHoraEntrega;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void exibirDetalhes() {
        System.out.println("---------------------------------");
        System.out.println("Pedido Cód: " + this.codigo);
        System.out.println("Status: " + this.status.toUpperCase());
        
        DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formataHora = DateTimeFormatter.ofPattern("HH:mm");
        
        System.out.println("Data/Hora da Compra: " + this.dataCompra.format(formataData) + 
                                       " às " + this.horaCompra.format(formataHora));
        
        System.out.println("Endereço de Entrega: " + 
            this.enderecoEntrega.getRua() + ", " + 
            this.enderecoEntrega.getNumero() + " - " + 
            this.enderecoEntrega.getBairro());
            
        System.out.println("Quantidade: " + this.quantidadeBotijao + " botijões");
        
        if (this.totalCompra > 0) {
            System.out.printf("Valor Total: R$ %.2f\n", this.totalCompra);
        }
        
        if (this.dataHoraEntrega != null) {
            System.out.println("Previsão de Entrega: " + 
                this.dataHoraEntrega.format(formataData) + " às " + 
                this.dataHoraEntrega.format(formataHora));
        }
        System.out.println("---------------------------------");
    }
}