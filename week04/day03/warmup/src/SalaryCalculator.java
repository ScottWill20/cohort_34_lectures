import java.math.BigDecimal;
import java.time.LocalDate;

public class SalaryCalculator {
    BigDecimal salary;
    LocalDate startDate;

    public SalaryCalculator(BigDecimal salary, LocalDate startDate) {
        this.salary = salary;
        this.startDate = startDate;
    }

    public SalaryCalculator() {}

    public BigDecimal calculateGross() {
        double percentRaise = 0.03;
        
    }


}
