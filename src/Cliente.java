public class Cliente {
    // Atributos de classe: senhaDeAtendimento e geradorDeSenha
    private static int geradorDeSenha = 1;

    // Atributos de instância: senhaDoCliente e nome
    private final int senhaDoCliente;
    private final String nome;
    private String endereco;

    // Construtor que recebe o nome e inicializa os atributos
    public Cliente(String nome) {
        this.nome = nome;
        this.senhaDoCliente = geradorDeSenha;
        geradorDeSenha++;
    }

    // Métodos gets para senhaDoCliente, nome e endereco
    public int getSenhaDoCliente() {
        return senhaDoCliente;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método toString para exibir informações do cliente
    @Override
    public String toString() {
        return "Nome: " + nome + ", Senha: " + senhaDoCliente + ", Endereco: " + endereco;
    }
}