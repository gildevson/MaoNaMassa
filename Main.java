import model.Funcionario;
import service.FuncionarioService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>(List.of(
                new Funcionario("Maria", LocalDate.of(1995, 10, 15), new BigDecimal("3500.00"), "Desenvolvedor"),
                new Funcionario("João", LocalDate.of(1988, 12, 5), new BigDecimal("4500.00"), "Gerente"),
                new Funcionario("Ana", LocalDate.of(1985, 8, 10), new BigDecimal("7000.00"), "Diretor"),
                new Funcionario("Carlos", LocalDate.of(1992, 10, 20), new BigDecimal("6000.00"), "Desenvolvedor"),
                new Funcionario("Lucas", LocalDate.of(1990, 12, 30), new BigDecimal("5500.00"), "Analista")
        ));

        // 3.2 – Remover o funcionário “João”
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase("João"));

        // 3.3 – Imprimir todos os funcionários formatados
        System.out.println("Lista de funcionários:");
        funcionarios.forEach(System.out::println);

        // 3.4 – Aumentar salário em 10%
        funcionarios.forEach(f -> f.aumentarSalario(10));

        // 3.5 e 3.6 – Agrupar e imprimir funcionários por função
        System.out.println("\nFuncionários agrupados por função:");
        FuncionarioService.agruparPorFuncao(funcionarios).forEach((funcao, lista) -> {
            System.out.println(funcao + ": " + lista);
        });

        // 3.8 – Imprimir funcionários aniversariantes de Outubro e Dezembro
        System.out.println("\nFuncionários aniversariantes de Outubro e Dezembro:");
        FuncionarioService.filtrarAniversariantes(funcionarios, 10, 12).forEach(System.out::println);

        // 3.9 – Imprimir funcionário com maior idade
        Funcionario maisVelho = FuncionarioService.obterFuncionarioMaisVelho(funcionarios);
        if (maisVelho != null) {
            System.out.println("\nFuncionário mais velho:");
            System.out.println(maisVelho.getNome() + ", Idade: " + maisVelho.getIdade() + " anos");
        }

        // 3.10 – Imprimir lista de funcionários por ordem alfabética
        System.out.println("\nFuncionários ordenados por nome:");
        funcionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(System.out::println);

        // 3.11 – Imprimir total dos salários
        System.out.println("\nTotal dos salários: " + FuncionarioService.calcularTotalSalarios(funcionarios));

        // 3.12 – Imprimir quantos salários mínimos cada funcionário ganha
        double salarioMinimo = 1212.00;
        System.out.println("\nSalários mínimos por funcionário:");
        FuncionarioService.calcularSalariosMinimos(funcionarios, salarioMinimo)
                .forEach((f, qtd) -> System.out.println(f.getNome() + " ganha " + String.format("%.2f", qtd) + " salários mínimos"));
    }
}
