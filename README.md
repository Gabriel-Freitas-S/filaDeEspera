##Trabalho Java de Sistema de Fila de Clientes em Java

Este projeto implementa um sistema de fila de clientes em Java, atendendo aos seguintes requisitos:

**Classe `Cliente`:**

* **Atributos de classe:**
    * `senhaDeAtendimento` (int): Inicializado com 0.
    * `geradorDeSenha` (int): Inicializado com 1.
* **Atributos de instância:**
    * `senhaDoCliente` (int): Armazena a senha do cliente.
    * `nome` (String): Armazena o nome do cliente.
* **Métodos:**
    * **Construtor:** Recebe o nome do cliente como parâmetro e inicializa os atributos.
    * **Getters:**  `getSenhaDoCliente`, `getNome`.
    * **Setters:** `setNome`.
    * **`toString`:** Retorna uma representação em string do cliente.
    * **`proximo`:** Incrementa a senha de atendimento e retorna o seu valor.

**Classe `UsaCliente`:**

* **Funcionalidades:**
    * Exibe um menu com as opções:
        * Gerar senha
        * Atender cliente
        * Sair da fila
        * Mostrar clientes não atendidos
        * Sair do programa
    * Utiliza um `ArrayList` para armazenar os clientes na fila.
    * Implementa métodos para cada opção do menu, realizando as operações correspondentes.
    * Gerencia a fila de clientes, permitindo adicionar, remover e atender clientes.
    * Exibe informações sobre os clientes na fila.

**Como executar:**

1. Compile e execute a classe `UsaCliente`.
2. Utilize o menu interativo para realizar as operações desejadas.

**Exemplo de uso:**

1. **Gerar senha:** Digite o nome do cliente para gerar uma nova senha.
2. **Atender cliente:** Atende o próximo cliente da fila.
3. **Sair da fila:** Remove um cliente da fila a partir da sua senha.
4. **Mostrar clientes não atendidos:** Exibe a lista de clientes que ainda não foram atendidos.
5. **Sair do programa:** Encerra o programa.

**Observações:**

* O código foi desenvolvido em Java e utiliza conceitos de orientação a objetos.
* O sistema de fila de clientes é implementado utilizando um `ArrayList`.
* O programa oferece uma interface de menu interativa para o usuário.
* O código inclui comentários explicativos para facilitar a compreensão.
* Este projeto serve como base para um sistema de gerenciamento de filas de clientes, que pode ser expandido com funcionalidades adicionais.
