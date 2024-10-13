import javax.swing.JOptionPane;
import java.util.ArrayList;
import io.InOut;

public class UsaCliente {
    // ArrayList para armazenar os clientes
    private static final ArrayList<Cliente> clientes = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            int opcao = mostrarMenu();
            switch (opcao) {
                case 1:
                    gerarSenha();
                    break;
                case 2:
                    atendimento();
                    break;
                case 3:
                    sairDaFila();
                    break;
                case 4:
                    mostrarNaoAtendidos();
                    break;
                case 0:
                    System.exit(0);
                default:
                    mostrarMensagem("Opção inválida! Pressione Enter para continuar.");
            }
        }
    }

    // Mostrar o menu de opções
    public static int mostrarMenu() {
        return InOut.leInt("""
                Menu de Opções:
                1. Gerar senha para novo cliente
                2. Atender próximo cliente
                3. Remover cliente da fila
                4. Mostrar clientes não atendidos
                0. Sair
                Escolha uma opção e pressione Enter.""");
    }

    // Gerar senha para um novo cliente
    public static void gerarSenha() {
        String nome = InOut.leString("Digite o nome do cliente:");
        String endereco = InOut.leString("Digite o endereço do cliente:");
        Cliente cliente = new Cliente(nome);
        cliente.setEndereco(endereco);
        clientes.add(cliente);
        mostrarMensagem("Cliente adicionado: " + cliente + ". Pressione Enter para continuar.");
    }

    // Atender o próximo cliente da fila
    public static void atendimento() {
        if (clientes.isEmpty()) {
            mostrarMensagem("Nenhum cliente na fila. Pressione Enter para continuar.");
            return;
        }
        Cliente cliente = clientes.removeFirst();
        mostrarMensagem("Atendendo cliente: " + cliente + ". Pressione Enter para continuar.");
    }

    // Remover um cliente da fila
    public static void sairDaFila() {
        int senha = InOut.leInt("Digite a senha do cliente que deseja remover:");
        Cliente clienteParaRemover = null;
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

    // Mostrar todos os clientes não atendidos
    public static void mostrarNaoAtendidos() {
        if (clientes.isEmpty()) {
            InOut.leString("Nenhum cliente na fila. Pressione Enter para continuar.");
            return;
        }
        StringBuilder naoAtendidos = new StringBuilder("Clientes não atendidos:\n");
        for (Cliente cliente : clientes) {
            naoAtendidos.append(cliente).append("\n");
        }
        mostrarMensagem(naoAtendidos + "Pressione Enter para continuar.");
    }

    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }
}