import javax.swing.JOptionPane;
import java.util.ArrayList;
import io.InOut;

public class UsaCliente {
    // Lista de clientes
    private static final ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        // Loop principal do programa que mantém o menu ativo até o usuário escolher
        // sair
        while (true) {
            int opcao = mostrarMenu(); // Exibe o menu e lê a opção do usuário
            switch (opcao) {
                case 1:
                    // Adiciona novo cliente com senha
                    gerarSenha();
                    break;
                case 2:
                    // Realiza atendimento do próximo cliente
                    atendimento();
                    break;
                case 3:
                    // Remove um cliente da fila pela senha
                    sairDaFila();
                    break;
                case 4:
                    // Exibe todos os clientes que ainda não foram atendidos
                    mostrarNaoAtendidos();
                    break;
                case 5:
                    // Encerra o programa
                    System.exit(0);
                default:
                    // Mensagem para opção inválida
                    mostrarMensagem("Opção inválida! Pressione Enter para continuar.");
            }
        }
    }

    // Exibe o menu de opções para o usuário
    public static int mostrarMenu() {
        return InOut.leInt("""
                Menu de Opções:
                1. Gerar senha
                2. Atendimento
                3. Sair da fila
                4. Mostrar todos os clientes não atendidos
                5. Sair do programa

                Escolha uma opção e pressione Enter.""");
    }

    // Adiciona um novo cliente e gera sua senha
    public static void gerarSenha() {
        String nome = InOut.leString("Digite o nome do cliente:");
        Cliente cliente = new Cliente(nome);
        clientes.add(cliente);
        mostrarMensagem("Cliente adicionado: " + cliente + ". Pressione Enter para continuar.");
    }

    // Realiza o atendimento do cliente com a primeira senha na fila
    public static void atendimento() {
        if (clientes.isEmpty()) {
            mostrarMensagem("Nenhum cliente na fila. Pressione Enter para continuar.");
            return;
        }

        int senhaAtual = Cliente.proximo(); // Obtém a próxima senha da classe Cliente

        Cliente clienteAtendido = null;
        // Procura pelo cliente com a senha atual na lista
        for (Cliente cliente : clientes) {
            if (cliente.getSenhaDoCliente() == senhaAtual) {
                clienteAtendido = cliente;
                break;
            }
        }

        if (clienteAtendido != null) {
            // Exibe o nome do cliente atendido e sua senha
            JOptionPane.showMessageDialog(null, "Atendendo cliente: " + clienteAtendido.getNome() +
                    " (Senha: " + senhaAtual + ")", "Atendimento", JOptionPane.INFORMATION_MESSAGE);

            // Remove o cliente atendido da lista
            clientes.remove(clienteAtendido);
        } else {
            mostrarMensagem("Nenhum cliente com a senha " + senhaAtual + ". Indo para o próximo cliente.");
            atendimento();
        }
    }

    // Remove um cliente específico da fila com base em sua senha
    public static void sairDaFila() {
        int senha = InOut.leInt("Digite a senha do cliente que deseja remover:");
        Cliente clienteParaRemover = null;
        // Procura pelo cliente com a senha informada na lista
        for (Cliente cliente : clientes) {
            if (cliente.getSenhaDoCliente() == senha) {
                clienteParaRemover = cliente;
                break;
            }
        }
        if (clienteParaRemover != null) {
            clientes.remove(clienteParaRemover);
            mostrarMensagem("Cliente removido: " + clienteParaRemover + ". Pressione Enter para continuar.");
        } else {
            mostrarMensagem("Cliente não encontrado. Pressione Enter para continuar.");
        }
    }

    // Exibe lista de clientes que ainda não foram atendidos
    public static void mostrarNaoAtendidos() {
        if (clientes.isEmpty()) {
            mostrarMensagem("Nenhum cliente na fila. Pressione Enter para continuar.");
            return;
        }
        StringBuilder naoAtendidos = new StringBuilder("Clientes não atendidos:\n");
        // Constrói a lista de clientes não atendidos para exibir
        for (Cliente cliente : clientes) {
            naoAtendidos.append(cliente).append("\n");
        }
        mostrarMensagem(naoAtendidos + "Pressione Enter para continuar.");
    }

    // Utilizado para exibir mensagens ao usuário
    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}
