package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.text.NumberFormat;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void aumentarSalario(double percentual) {
        this.salario = this.salario.add(this.salario.multiply(BigDecimal.valueOf(percentual / 100)));
    }

    public String getSalarioFormatado() {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return format.format(salario);
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        return super.toString() + ", Salário: " + getSalarioFormatado() + ", Função: " + funcao;
    }
}
