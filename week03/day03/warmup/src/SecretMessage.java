import java.io.*;

public class SecretMessage {

    public static void write(String fileName, String line) throws IOException {
        File file = new File(fileName);
        file.createNewFile();
        FileWriter fileWriter = new FileWriter(fileName, true);
        PrintWriter writer = new PrintWriter(fileWriter);

        writer.println(line);
    }

    public static void read(String fileName) throws FileNotFoundException {
        // we want to try with resources here as well
        try(
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
        ){ // if this code is successful
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                if(!line.isBlank()){
                    System.out.println(line);
                }
            }

        }catch(IOException ex){
            ex.printStackTrace(); // if something goes wrong like the file doesn't exist - we want that stack trace
        }
    }

    }


