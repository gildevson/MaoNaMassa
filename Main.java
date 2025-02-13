import model.Funcionario;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>(List.of(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
                new Funcionario("Helena", LocalDate.of(1996, 12, 2), new BigDecimal("2799.93"), "Gerente")
        ));

        // Removendo João
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        // Aumentar salário em 10%
        funcionarios.forEach(f -> f.aumentarSalario(10));

        // Ordenar lista de funcionários por nome (Ordem alfabética)
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));

        // Encontrar funcionário com maior idade
        Funcionario funcionarioMaisVelho = encontrarFuncionarioMaisVelho(funcionarios);

        // Imprimir tabela de funcionários
        imprimirTabela(funcionarios);

        // Imprimir funcionários que fazem aniversário em outubro e dezembro
        imprimirAniversariantes(funcionarios);

        // Imprimir funcionários agrupados por função
        imprimirFuncionariosPorFuncao(funcionarios);

        // Imprimir funcionário mais velho
        System.out.println("\nFuncionário com maior idade:");
        System.out.printf("Nome: %s, Idade: %d anos%n", funcionarioMaisVelho.getNome(), calcularIdade(funcionarioMaisVelho.getDataNascimento()));
    }

    public static void imprimirFuncionariosPorFuncao(List<Funcionario> funcionarios) {
        System.out.println("\nFuncionários agrupados por função:");

        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.printf(" - %s (Salário: %s)%n", f.getNome(), f.getSalarioFormatado()));
        });
    }

    public static Funcionario encontrarFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento)) // O mais velho tem a data mais antiga
                .orElseThrow(() -> new NoSuchElementException("Nenhum funcionário encontrado"));
    }

    public static int calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public static void imprimirAniversariantes(List<Funcionario> funcionarios) {
        System.out.println("\nFuncionários que fazem aniversário em outubro (10) e dezembro (12):");

        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonth() == Month.OCTOBER || f.getDataNascimento().getMonth() == Month.DECEMBER)
                .forEach(f -> System.out.printf("Nome: %s, Data de Nascimento: %s%n",
                        f.getNome(), f.getDataNascimentoFormatada()));
    }

    public static void imprimirTabela(List<Funcionario> funcionarios) {
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        BigDecimal totalSalarios = BigDecimal.ZERO;

        String formato = "| %-10s | %-12s | %-10s | %-10s | %-15s | %-8s |%n";

        System.out.println("+------------+--------------+------------+------------+-----------------+------------+");
        System.out.printf("| %-10s | %-12s | %-10s | %-10s | %-15s | %-8s |%n",
                "Nome", "Nascimento", "Salário", "Sal. 10%", "Função", "Sal.Mín.");
        System.out.println("+------------+--------------+------------+------------+-----------------+------------+");

        for (Funcionario f : funcionarios) {
            BigDecimal salarioAjustado = f.getSalario();
            BigDecimal salarioOriginal = salarioAjustado.divide(BigDecimal.valueOf(1.1), RoundingMode.HALF_UP);
            BigDecimal qtdSalariosMinimos = salarioAjustado.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            totalSalarios = totalSalarios.add(f.getSalario());

            System.out.printf(formato,
                    f.getNome(),
                    f.getDataNascimentoFormatada(),
                    String.format("%,.2f", salarioOriginal),
                    String.format("%,.2f", salarioAjustado),
                    f.getFuncao(),
                    qtdSalariosMinimos);
        }

        System.out.println("+------------+--------------+------------+------------+-----------------+------------+");
        System.out.printf("| %-44s | %-8s |%n", "Total de Funcionários: " + funcionarios.size(), "");
        System.out.printf("| %-44s | %-8s |%n", "Total dos Salários: R$ " + String.format("%,.2f", totalSalarios), "");
        System.out.println("+----------------------------------------------------------+");
    }
}
