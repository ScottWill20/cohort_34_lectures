import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class SalaryCalculator {

    public BigDecimal calculateGrossSalary(int salary, LocalDate startDate) {
        if (startDate.get(ChronoField.DAY_OF_MONTH) != 1) throw new IllegalAccessException("Error: Date must be first of the month",ex)
    }


}
