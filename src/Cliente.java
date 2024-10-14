public class Cliente {

    // Atributos de classe: geradorDeSenha 
    private static int geradorDeSenha = 1; 

    // Atributos de instância: senhaDoCliente, nome e endereco
    private final int senhaDoCliente; // Senha do cliente, gerada automaticamente e imutável
    private final String nome; // Nome do cliente, imutável após a criação
    private String endereco; // Endereço do cliente

    /**
     * Construtor da classe Cliente.
     * 
     * @param nome O nome do cliente.
     */
    public Cliente(String nome) {
        this.nome = nome;
        this.senhaDoCliente = geradorDeSenha++; // Atribui a próxima senha disponível e incrementa o gerador
    }

    // Métodos getters para senhaDoCliente e nome 
    public int getSenhaDoCliente() {
        return senhaDoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    // Método setter para o endereço
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Método toString para exibir informações do cliente.
     * 
     * @return Uma string contendo o nome, senha e endereço do cliente.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + ", Senha: " + senhaDoCliente + ", Endereco: " + endereco;
    }
}
