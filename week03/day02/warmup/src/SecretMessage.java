import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SecretMessage {

    public static void write(String line) throws IOException {
        File file = new File("secret");
        file.createNewFile();
        try (PrintWriter write = new PrintWriter())
    }

    public static void read(String line){ }

}
