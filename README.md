# Sistema de Fila de Clientes em Java | Trabalho Liguagens de Programação

Este projeto implementa um sistema de fila de clientes em Java, utilizando interface gráfica e tratamento de exceções.

## Funcionalidades

O sistema oferece as seguintes funcionalidades:

* **Gerar senha:** Permite adicionar um novo cliente à fila, gerando uma senha única para ele.
* **Atender cliente:** Chama o próximo cliente da fila para atendimento.
* **Sair da fila:** Permite que um cliente específico saia da fila, removendo-o.
* **Mostrar clientes não atendidos:** Exibe a lista de clientes que ainda aguardam atendimento.
* **Sair do programa:** Encerra o sistema.

## Classes

O projeto é composto pelas seguintes classes:

* **`Cliente`:** Representa um cliente na fila, com atributos para nome e senha.
* **`UsaCliente`:** Contém o método principal (`main`) e a lógica para gerenciar a fila de clientes e a interação com o usuário através de menus e mensagens.
* **`InOut`:** Classe utilitária para entrada e saída de dados, fornecendo métodos para ler diferentes tipos de dados do usuário e exibir mensagens.

## Implementação

* A fila de clientes é implementada utilizando um `ArrayList`.
* A interface gráfica é implementada utilizando a classe `JOptionPane`.
* A classe `InOut` encapsula o uso da classe `JOptionPane` para leitura de dados e exibição de mensagens, facilitando o uso e tratamento de exceções.
* O sistema gera senhas sequenciais para cada novo cliente.
* As funcionalidades do sistema são acessíveis através de um menu interativo.

## Como executar

1. Compile e execute a classe `UsaCliente`.
2. Utilize o menu interativo para realizar as operações desejadas.

## Observações

* O código foi desenvolvido em Java e utiliza conceitos de orientação a objetos.
* O sistema inclui tratamento de exceções para garantir a robustez da aplicação.
* A interface gráfica facilita a interação do usuário com o sistema.
* Este projeto pode ser expandido com funcionalidades adicionais, como persistência de dados, ordenação da fila por prioridade, etc.
