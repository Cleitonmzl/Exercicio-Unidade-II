import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Principal {

    private ArrayList<Pedido> listaPedidos;
    private Scanner scanner;
    private static int proximoCodigo = 1;

    private static final float PRECO_BOTIJAO = 110.0f;

    public Principal() {
        this.listaPedidos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Principal app = new Principal();
        app.exibirMenu();
    }

    public void exibirMenu() {
        int op;

        while (true) {
            System.out.println("\n--- Sistema de Entrega de Gás 24h ---");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Confirmar entrega");
            System.out.println("3. Ver pedidos confirmados");
            System.out.println("4. Ver pedidos entregues");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            try {
                op = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida, digite um número!");
                continue;
            }

            switch (op) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    confirmarEntrega();
                    break;
                case 3:
                    verStatus("confirmado");
                    break;
                case 4:
                    verStatus("entregue");
                    break;
                case 0:
                    System.out.println("Saindo do sistema!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void fazerPedido() {
        System.out.println("\n--- Fazer Novo Pedido ---");

        try {
            System.out.println("Por favor, informe o endereço de entrega:");
            System.out.print("Rua: ");
            String rua = scanner.nextLine();
            System.out.print("Número: ");
            int numero = Integer.parseInt(scanner.nextLine());
            System.out.print("Bairro: ");
            String bairro = scanner.nextLine();

            Endereco endEntrega = new Endereco(rua, numero, bairro);

            System.out.print("Quantidade de botijões: ");
            int qtd = Integer.parseInt(scanner.nextLine());

            LocalDate dataCompra = LocalDate.now();
            LocalTime horaCompra = LocalTime.now();

            Pedido novoPedido = new Pedido(proximoCodigo, dataCompra, horaCompra, endEntrega, qtd);

            System.out.println("\n--- Resumo do Pedido (Cód: " + novoPedido.getCodigo() + ") ---");
            novoPedido.exibirDetalhes();

            System.out.print("\nConfirma os dados? (1: Sim, 2: Alterar Endereço): ");
            int escolha = Integer.parseInt(scanner.nextLine());

            if (escolha == 2) {
                System.out.println("Informe o NOVO endereço:");
                System.out.print("Rua: ");
                String novaRua = scanner.nextLine();
                System.out.print("Número: ");
                int novoNum = Integer.parseInt(scanner.nextLine());
                System.out.print("Bairro: ");
                String novoBairro = scanner.nextLine();
                
                Endereco novoEnd = new Endereco(novaRua, novoNum, novoBairro);
                novoPedido.setEnderecoEntrega(novoEnd);

                System.out.println("Endereço alterado! Revise o pedido:");
                novoPedido.exibirDetalhes();
            }

            System.out.print("Confirme a quantidade de botijões (atual: " + novoPedido.getQuantidadeBotijao() + "): ");
            int qtdConfirmada = Integer.parseInt(scanner.nextLine());
            novoPedido.setQuantidadeBotijao(qtdConfirmada);


            System.out.println("\n--- Calculando Total e Entrega ---");
            System.out.printf("Preço unitário do botijão: R$ %.2f\n", PRECO_BOTIJAO);
            
            float total = novoPedido.getQuantidadeBotijao() * PRECO_BOTIJAO;
            novoPedido.setTotalCompra(total);
            System.out.printf("Total da Compra: R$ %.2f\n", total);

            LocalDateTime dataHoraCompra = LocalDateTime.of(dataCompra, horaCompra);
            LocalDateTime dataHoraEntrega = dataHoraCompra.plusHours(2);
            novoPedido.setDataHoraEntrega(dataHoraEntrega);
            
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy 'às' HH:mm");
            System.out.println("Previsão de Entrega: " + dataHoraEntrega.format(formatador));

            System.out.println("\n--- Pagamento ---");
            System.out.print("Digite o número do cartão de crédito: ");
            String cartao = scanner.nextLine();
            novoPedido.setNumeroCartao(cartao);

            novoPedido.setStatus("confirmado");

            this.listaPedidos.add(novoPedido);

            System.out.println("\n===============================================");
            System.out.println("PEDIDO " + novoPedido.getCodigo() + " CONFIRMADO COM SUCESSO!");
            System.out.println("===============================================");
            
            proximoCodigo++;

        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Você deveria digitar um número.");
            System.out.println("O pedido foi cancelado. Por favor, tente novamente.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            System.out.println("O pedido foi cancelado.");
        }
    }

    private void confirmarEntrega() {
        System.out.println("\n--- Confirmar Entrega de Pedido ---");
        System.out.print("Digite o código do pedido que foi entregue: ");

        try {
            int codigoBusca = Integer.parseInt(scanner.nextLine());

            Pedido pedidoEncontrado = null;

            for (Pedido p : this.listaPedidos) {
                if (p.getCodigo() == codigoBusca) {
                    pedidoEncontrado = p;
                    break;
                }
            }

            if (pedidoEncontrado != null) {
                pedidoEncontrado.setStatus("entregue");
                System.out.println("Status do pedido " + codigoBusca + " alterado para 'entregue'.");
            } else {
                System.out.println("Pedido não localizado.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Erro: Código inválido. Digite apenas números.");
        }
    }

    private void verStatus(String statusParaVer) {
        System.out.println("\n--- Lista de Pedidos com status: " + statusParaVer.toUpperCase() + " ---");

        boolean encontrou = false;

        for (Pedido p : this.listaPedidos) {
            
            if (p.getStatus().equals(statusParaVer)) {
                
                p.exibirDetalhes();
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum pedido encontrado com este status.");
        }
    }
}