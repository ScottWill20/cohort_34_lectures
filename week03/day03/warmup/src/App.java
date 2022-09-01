import java.io.FileNotFoundException;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        SecretMessage.write("secret-message.txt", "James is a cool guy");
        // System.out.println(SecretMessage.read("secretmessage.txt"));
        // SecretMessage.read("secret-message.txt");


    }
}
