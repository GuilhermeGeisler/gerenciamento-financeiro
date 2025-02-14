# 💰 Sistema de Gerenciamento Financeiro

## 📖 Sobre o Projeto

Este projeto é um sistema de gerenciamento financeiro desenvolvido em **Java**, com foco em gerenciar receitas e despesas de forma simples e eficiente. O sistema permite adicionar lançamentos financeiros, consultar saldos e listar transações, além de persistir os dados em um arquivo CSV. O projeto foi criado para demonstrar boas práticas de programação, como o uso de interfaces, enums, manipulação de arquivos e organização de código.

---

## 🚀 Funcionalidades

- **Adicionar Receitas e Despesas:**  
  - O sistema permite adicionar receitas (valores positivos) e despesas (valores negativos).  
  - Exemplo: Adicionar um salário como receita ou uma conta de luz como despesa.  

- **Listar Lançamentos:**  
  - Visualize todos os lançamentos financeiros em uma lista ordenada por data.  
  - Exemplo: Listar todas as transações realizadas no mês.  

- **Consultar Saldos:**  
  - Consulte o saldo total ou o saldo até uma data específica.  
  - Exemplo: Verificar o saldo disponível até o final do mês.  

- **Persistência de Dados:**  
  - Os lançamentos são armazenados em um arquivo CSV (`lancamentos.csv`), permitindo que os dados sejam carregados e salvos entre execuções do programa.  

- **Interface Gráfica (Swing):**  
  - O sistema possui uma interface gráfica simples e intuitiva, construída com a biblioteca Swing.  
  - Exemplo: Botões para adicionar receitas/despesas e consultar saldos.  

---

## 🛠️ Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto, com uso de POO (Programação Orientada a Objetos).  
- **Swing**: Biblioteca para criação da interface gráfica.  
- **CSV**: Formato de arquivo utilizado para persistência de dados.  
- **GitHub**: Versionamento do código e hospedagem do projeto.  

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white) ![Swing](https://img.shields.io/badge/Swing-ED8B00?style=for-the-badge&logo=java&logoColor=white) ![CSV](https://img.shields.io/badge/CSV-1572B6?style=for-the-badge&logo=csv&logoColor=white) ![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)

---

## 📦 Estrutura do Projeto

O projeto está organizado da seguinte forma:  

1. **Classes Principais:**  
   - `CategoriaDespesa`: Enumeração que define categorias de despesas.  
   - `Despesa`: Subclasse de `Lancamento` que representa despesas.  
   - `LancamentoRepository`: Interface para persistência de dados.  
   - `LancamentoRepositoryImpl`: Implementação da persistência em arquivo CSV.  
   - `LancamentoService`: Interface para operações de negócio.  
   - `LancamentoServiceImpl`: Implementação das operações de negócio.  
   - `DateUtils`: Classe utilitária para manipulação de datas.  
   - `MainFrame`: Interface gráfica do sistema.  

2. **Arquivos de Dados:**  
   - `lancamentos.csv`: Arquivo CSV que armazena os lançamentos financeiros.  

3. **Recursos:**  
   - Pasta `src/`: Contém o código-fonte do projeto.  

---

## 🎯 Como Usar

1. **Clone o Repositório:**  
   - Clone o repositório para sua máquina local:  
     ```bash
     git clone https://github.com/GuilhermeGeisler/gerenciamento-financeiro
     ```

2. **Execute o Projeto:**  
   - Abra o projeto em uma IDE Java (como IntelliJ IDEA ou Eclipse).  
   - Execute a classe `MainFrame` para iniciar a interface gráfica.  

3. **Interaja com o Sistema:**  
   - Adicione receitas e despesas.  
   - Consulte saldos e liste lançamentos.  

4. **Verifique o Arquivo CSV:**  
   - Os lançamentos são armazenados no arquivo `lancamentos.csv`.  

---

## 🧑‍💻 Desenvolvedor

<table>
  <tr>
    <td align="center">
      <a href="https://www.linkedin.com/in/guilhermegeisler/">
        <img src="https://avatars.githubusercontent.com/u/53203780?s=400&u=9a85ac6d2d3c55a872ab0bafd1d38d8bd0da5cc4&v=4" width="100px;" alt="Foto do Guilherme Geisler"/><br>
        <sub>
          <b>Guilherme Geisler</b>
        </sub>
      </a>
    </td>
  </tr>
</table>

---

## 📧 Contato

Se tiver alguma dúvida, sugestão ou quiser entrar em contato, fique à vontade:  

- **LinkedIn**: [Guilherme Geisler](https://www.linkedin.com/in/guilhermegeisler/)  
- **Email**: [guilherme.sgeisler@gmail.com](mailto:guilherme.sgeisler@gmail.com)  

---

Feito com ❤️ por [Guilherme Geisler](https://www.linkedin.com/in/guilhermegeisler/).  
