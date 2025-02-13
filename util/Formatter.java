package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
    public static String formatarSalario(BigDecimal salario) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return format.format(salario);
    }
}
