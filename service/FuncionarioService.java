package service;

import model.Funcionario;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FuncionarioService {

    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public static List<Funcionario> filtrarAniversariantes(List<Funcionario> funcionarios, int... meses) {
        List<Integer> mesesFiltro = Arrays.stream(meses).boxed().toList();
        return funcionarios.stream()
                .filter(f -> mesesFiltro.contains(f.getDataNascimento().getMonthValue()))
                .toList();
    }

    public static Funcionario obterFuncionarioMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
    }

    public static BigDecimal calcularTotalSalarios(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static Map<Funcionario, Double> calcularSalariosMinimos(List<Funcionario> funcionarios, double salarioMinimo) {
        return funcionarios.stream()
                .collect(Collectors.toMap(f -> f, f -> f.getSalario().doubleValue() / salarioMinimo));
    }
}
