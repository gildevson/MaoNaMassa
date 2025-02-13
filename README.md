# 🏢 Teste Prático de Programação – Gestão de Funcionários

## 📌 Descrição do Desafio

Este projeto consiste no desenvolvimento de um sistema em **Java** para gerenciar funcionários de uma indústria. O sistema deve armazenar informações sobre os funcionários, calcular aumentos salariais, organizar os dados e exibir relatórios formatados.

## 📋 Requisitos do Sistema

### 📌 1. Estrutura de Classes

O sistema deve conter as seguintes classes:

- **Classe `Pessoa`**
    - Atributos:
        - `nome` (String) – Nome do funcionário.
        - `dataNascimento` (LocalDate) – Data de nascimento.

- **Classe `Funcionario`** (extende `Pessoa`)
    - Atributos:
        - `salario` (BigDecimal) – Salário do funcionário.
        - `funcao` (String) – Cargo exercido.

### 📌 2. Funcionalidades

A **classe principal** (`Main.java`) deve executar as seguintes ações:

#### 2.1 – Cadastro e Manipulação de Dados
✅ Inserir todos os funcionários na mesma ordem e informações conforme a tabela.  
✅ Remover o funcionário **“João”** da lista.

#### 2.2 – Formatação e Exibição de Dados
✅ Exibir os funcionários em formato de **tabela**, garantindo:
- Datas no formato **`dd/MM/yyyy`**
- Salários formatados como **R$ 1.000,00** (ponto como separador de milhar e vírgula como decimal)

#### 2.3 – Cálculos e Operações
✅ Aplicar um **aumento salarial de 10%** e atualizar os valores na lista.

#### 2.4 – Relatórios
✅ **Agrupar funcionários por função** e exibir em um **Map**, onde:
- **Chave** = Função
- **Valor** = Lista de funcionários pertencentes àquela função

✅ Exibir os funcionários que fazem **aniversário em outubro (10) e dezembro (12)**.  
✅ Determinar o funcionário com a **maior idade** e imprimir seu nome e idade.  
✅ Exibir a **lista de funcionários ordenada alfabeticamente**.  
✅ Calcular e exibir o **total de salários** de todos os funcionários.  
✅ Mostrar **quantos salários mínimos** cada funcionário recebe (considerando **R$ 1.212,00** como salário mínimo).

---

## 🏗 Estrutura do Projeto

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **Maven/Gradle** *(opcional)*
- **IntelliJ IDEA / Eclipse** *(IDE recomendada)*
- **JDK 11+ ou superior**

---

## 🚀 Como Executar o Projeto

1️⃣ **Clone o repositório**
```bash
https://github.com/gildevson/MaoNaMassa.git


cd teste-pratico-funcionarios

javac -d bin src/**/*.java
java -cp bin Main

### **📌 O que esse README inclui?**
✅ Explicação clara sobre o projeto  
✅ Estrutura de diretórios  
✅ Instruções de execução  
✅ Exemplo de saída formatada  

Esse **Markdown** deixará seu projeto bem **documentado e profissional**. Quer ajustes ou melhorias? 