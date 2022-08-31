package application.helper;

import application.inventory.Flavors;

import java.io.*;
import java.util.ArrayList;

public class ReadWriteHelper {
    //TODO - create a method that writes to a file
    public static void writeToFile(String fileName, ArrayList<Flavors> array){
        // try with resources statement
        try( // this is what we want to try
                FileWriter fileWriter = new FileWriter(fileName);
                PrintWriter writer = new PrintWriter(fileWriter);
                ){
            // if that is successful this is the we want to run
            for(Flavors f : array){
                writer.println(f); // loop through the array and print each item in that array to a file
            }

        }catch (IOException ex){ // if this is unsuccessful - this is the exception we want to catch
            ex.printStackTrace();
        }
    }

    //TODO - create a method that reads from a file
    public static String readFromFile(String fileName){
        String read = "";
        // we want to try with resources here as well
        try(
                FileReader fileReader = new FileReader(fileName);
                BufferedReader reader = new BufferedReader(fileReader);
                ){ // if this code is successful
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                if(!line.isBlank()){
                    read += line + "\n";
                }
            }

        }catch(IOException ex){
            ex.printStackTrace(); // if something goes wrong like the file doesn't exist - we want that stack trace
        }
        return read;
    }


}
