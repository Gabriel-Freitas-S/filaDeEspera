public class Cliente {
    // Atributos de classe: geradorDeSenha e senhaDeAtendimento
    private static int geradorDeSenha = 1;
    private static int senhaDeAtendimento = 0; 

    // Atributos de instância: senhaDoCliente e nome
    private final int senhaDoCliente; 
    private String nome; 

    /**
     * Construtor da classe Cliente.
     * 
     * @param nome O nome do cliente.
     */
    public Cliente(String nome) {
        this.nome = nome;
        this.senhaDoCliente = geradorDeSenha++; // Atribui a próxima senha e incrementa o gerador
    }

    // Métodos getters para senhaDoCliente e nome
    public int getSenhaDoCliente() {
        return senhaDoCliente;
    }

    public String getNome() {
        return nome;
    }
    
    // Método set para atribuir o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método proximo() para incrementar e retornar a senha de atendimento.
     * 
     * @return A próxima senha de atendimento.
     */
    public static int proximo() {
        senhaDeAtendimento++;
        return senhaDeAtendimento;
    }

    /**
     * Método toString para exibir informações do cliente.
     * 
     * @return Uma string contendo o nome e senha do cliente.
     */
    @Override
    public String toString() {
        return "Nome: " + nome + ", Senha: " + senhaDoCliente;
    }
}
