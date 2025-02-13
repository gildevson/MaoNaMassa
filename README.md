# 🏢 Teste Prático de Programação – Gestão de Funcionários - Mão na massa

## 📌 Descrição do Desafio

Este projeto consiste no desenvolvimento de um sistema em **Java** para gerenciar funcionários de uma indústria. O sistema deve armazenar informações sobre os funcionários, calcular aumentos salariais, organizar os dados e exibir relatórios formatados.

---

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

A **classe principal** (`Main.java`) executa as seguintes ações:

#### 2.1 – Cadastro e Manipulação de Dados
✅ Inserir todos os funcionários na mesma ordem e informações conforme a tabela.  
✅ Remover o funcionário **“João”** da lista.

#### 2.2 – Formatação e Exibição de Dados
✅ Exibir os funcionários em formato de **tabela**, garantindo:
- Datas no formato **`dd/MM/yyyy`**
- Salários formatados como **R$ 1.000,00** (ponto como separador de milhar e vírgula como decimal)
- Exibir idade de cada funcionário
- Exibir aumento de 10% no salário em uma coluna separada

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

```
📂 src/
 ┣ 📂 model/
 ┃ ┣ 📜 Pessoa.java
 ┃ ┣ 📜 Funcionario.java
 ┣ 📂 service/
 ┃ ┣ 📜 FuncionarioService.java
 ┣ 📂 util/
 ┃ ┣ 📜 Formatter.java
 ┣ 📜 Main.java
```

---

## 🛠 Tecnologias Utilizadas

- **Java 17+**
- **IntelliJ IDEA**
- **JDK 11+ ou superior**

---

## 🚀 Como Executar o Projeto

1️⃣ **Clone o repositório**
```bash
https://github.com/gildevson/MaoNaMassa.git
```
2️⃣ **Acesse o diretório**
```bash
cd teste-pratico-funcionarios
```
3️⃣ **Compile e execute o projeto**
```bash
javac -d bin src/**/*.java
java -cp bin Main
```

---

## 📊 Exemplo de Saída Formatada

```
+------------+--------------+------------+------------+-----------------+------------+------+ 
| Nome       | Nascimento   | Salário    | Sal. 10%   | Função          | Sal.Mín.   | Idade | 
+------------+--------------+------------+------------+-----------------+------------+------+ 
| Maria      | 18/10/2000   | 2.009,44   | 2.210,38   | Operador        | 1,64       | 23   |
| Caio       | 02/05/1961   | 9.836,14   | 10.819,75  | Coordenador     | 8,14       | 63   |
| Miguel     | 14/10/1988   | 19.119,88  | 21.031,87  | Diretor         | 15,75      | 36   |
| Alice      | 05/01/1995   | 2.234,68   | 2.458,15   | Recepcionista   | 1,84       | 29   |
+------------+--------------+------------+------------+-----------------+------------+------+ 
Total de Funcionários: 9
Total dos Salários: R$ 51.932,50
```

### **📌 O que esse README inclui?**
✅ Explicação clara sobre o projeto  
✅ Estrutura de diretórios  
✅ Instruções de execução  
✅ Exemplo de saída formatada

📌 Caso precise de ajustes ou melhorias, me avise! 🚀
