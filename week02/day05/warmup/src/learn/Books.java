package learn;

public class Books {

    private final String title;
    private final String firstName;
    private final String lastName;
    private final String category;

    public Books(String title, String firstName, String lastName, String category) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCategory() {
        return category;
    }



}
