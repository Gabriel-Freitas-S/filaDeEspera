public class Cliente {
    // Atributos de classe: senhaDeAtendimento e geradorDeSenha
    private static int senhaDeAtendimento = 0;
    private static int geradorDeSenha = 1;

    // Atributos de instância: senhaDoCliente e nome
    private int senhaDoCliente;
    private String nome;
    private String endereco;

    // Construtor que recebe o nome e inicializa os atributos
    public Cliente(String nome) {
        this.nome = nome;
        this.endereco = endereco;
        this.senhaDoCliente = geradorDeSenha;
        geradorDeSenha++;
    }

    // Métodos gets para senhaDoCliente, nome e endereco
    public int getSenhaDoCliente() {
        return senhaDoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    // Método set para o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método toString para exibir informações do cliente
    @Override
    public String toString() {
        return "Nome: " + nome + ", Senha: " + senhaDoCliente + ", Endereco: " + endereco;
    }

    // Método proximo para incrementar e retornar a senha de atendimento
    public static int proximo() {
        senhaDeAtendimento++;
        return senhaDeAtendimento;
    }
}