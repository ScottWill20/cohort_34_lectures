import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class sandbox {

    public static void main(String[] args) {
        BigDecimal weekendRate = new BigDecimal("100");
        BigDecimal standardRate = new BigDecimal("50");
        LocalDate start = LocalDate.of(2022,9, 10);
        LocalDate end = LocalDate.of(2022,9, 17);
        BigDecimal total = new BigDecimal("0");

        for (LocalDate date = start; date.isBefore(end); date = date.plusDays(1)) {
            System.out.println(date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    date.getDayOfWeek() == DayOfWeek.FRIDAY);

            if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                total = total.add(weekendRate);
                System.out.println(total);

            } else {
                total = total.add(standardRate);
                System.out.println(total);
            }
            // if day of week is Friday or Saturday, then total = total + weekendRate
            // else day of week is any other day, total = total + standardRate

        }






    }
}
