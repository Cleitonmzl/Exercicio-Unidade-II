public class Endereco {
    
    private String rua;
    private int numero;
    private String bairro;

    public Endereco(String rua, int numero, String bairro) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    public String getRua() {
        return this.rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}