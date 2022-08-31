package learn.calorietracker.data;

public class DataAccessException  extends Exception {
    public DataAccessException(String message) {
        super(message); // we are inheriting this from Exception
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}
