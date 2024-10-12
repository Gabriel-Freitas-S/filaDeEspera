import java.util.ArrayList;
import java.util.Scanner;

public class UsaCliente {
    // ArrayList para armazenar os clientes
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static int ultimoAtendido = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        // Loop principal do menu
        do {
            mostrarMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha pendente
            switch (opcao) {
                case 1:
                    // Gerar senha para novo cliente
                    gerarSenha(scanner);
                    break;
                case 2:
                    // Atender o próximo cliente da fila
                    atendimento();
                    break;
                case 3:
                    // Remover cliente da fila
                    sairDaFila(scanner);
                    break;
                case 4:
                    // Mostrar todos os clientes não atendidos
                    mostrarNaoAtendidos();
                    break;
                case 5:
                    // Sair do programa
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    // Tratar opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    // Mostrar o menu de opções
    public static void mostrarMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Gerar senha");
        System.out.println("2 – Atendimento");
        System.out.println("3 – Sair da fila");
        System.out.println("4 – Mostrar todos os clientes não atendidos");
        System.out.println("5 – Sair do programa");
        System.out.print("Escolha uma opção: ");
    }

    // Gerar senha para um novo cliente
    public static void gerarSenha(Scanner scanner) {
        System.out.print("Digite o nome do cliente: ");
        String nome = scanner.nextLine();
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        System.out.println("Nome: " + cliente.getNome() + ", Senha: " + cliente.getSenhaDoCliente());
    }

    // Atender o próximo cliente da fila
    public static void atendimento() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes na fila para atendimento.");
            return;
        }

        boolean clienteAtendido = false;
        while (!clienteAtendido && !clientes.isEmpty()) {
            int senhaAtual = Cliente.proximo();
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getSenhaDoCliente() == senhaAtual) {
                    Cliente cliente = clientes.remove(i);
                    System.out.println("Atendendo cliente: Senha: " + cliente.getSenhaDoCliente() + ", Nome: " + cliente.getNome());
                    clienteAtendido = true;
                    break;
                }
            }
            if (!clienteAtendido) {
                System.out.println("Nenhum cliente com a senha " + senhaAtual + ". Verificando a próxima senha.");
            }
        }
    }

    // Remover um cliente da fila
    public static void sairDaFila(Scanner scanner) {
        System.out.print("Digite a senha do cliente: ");
        int senha = scanner.nextInt();
        boolean clienteRemovido = false;

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getSenhaDoCliente() == senha) {
                clientes.remove(i);
                System.out.println("A senha " + senha + " foi removida.");
                clienteRemovido = true;
                break;
            }
        }
        if (!clienteRemovido) {
            System.out.println("A senha " + senha + " não foi encontrada.");
        }
    }

    // Mostrar todos os clientes não atendidos
    public static void mostrarNaoAtendidos() {
        if (clientes.isEmpty()) {
            System.out.println("Não há clientes não atendidos.");
        } else {
            System.out.println("Clientes não atendidos:");
            for (Cliente cliente : clientes) {
                System.out.println("Senha: " + cliente.getSenhaDoCliente() + ", Nome: " + cliente.getNome());
            }
        }
    }
}