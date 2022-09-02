package learn.calorietracker.data;

import learn.calorietracker.models.LogEntry;
import learn.calorietracker.models.LogEntryType;

import javax.print.attribute.standard.PresentationDirection;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogEntryFileRepository implements LogEntryRepository {
    // fields
    private static final String DELIMITER = ",";
    private final String DELIMITER_REPLACEMENT = "@@@";
    private final String filePath;

    public LogEntryFileRepository(String filePath){
        this.filePath = filePath;
    }

    /// METHODS
    //READ
    @Override
    public List<LogEntry> findAll() throws DataAccessException {
        // creating a list of log entries
        List<LogEntry> result = new ArrayList<>();
        // try with resources our buffered reader
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            // skip the header line
            reader.readLine();

            // loop through our file and read each entry
            for(String line = reader.readLine(); line != null; line = reader.readLine()){
                LogEntry logEntry = lineToLogEntry(line);
                result.add(logEntry);
            }
        }catch(FileNotFoundException ex){
            // swallow this exception
            // it's okay if the file doesn't exist yet - it will get created later
        }catch(IOException ex){
            throw new DataAccessException("Could Not Open File Path: " + filePath, ex);
        }
        return result;
    }

    @Override
    public LogEntry findById(int logEntryId) throws DataAccessException {
        List<LogEntry> all = findAll();
        for(LogEntry logEntry : all){
            if(logEntry.getId() == logEntryId){
                return  logEntry;
            }
        }
        return null;
    }

    // CREATE
    @Override
    public LogEntry create(LogEntry logEntry) throws DataAccessException {
        List<LogEntry> all = findAll();
        int nextId = getNextId(all); // automatically generate the next id for us
        logEntry.setId(nextId); // set the id to the nextId
        all.add(logEntry); // add the entry to the list of entries
        writeToFile(all); // update the file
        return  logEntry;
    }

    //UPDATE
    @Override
    public boolean update(LogEntry logEntry) throws DataAccessException {
        List<LogEntry> all = findAll();
        // loop through all the entries
        for(int i = 0; i < all.size(); i++){
            // if the current index id matches the logEntry id
            if(all.get(i).getId() == logEntry.getId()){
                // update that index with the log entry provided
                all.set(i, logEntry);
                // then I want to re-write that entire array to the file
                writeToFile(all);
                // I want to return true so we know this was successful
                return true;
            }
        }
        // if I've looped through everything and was not able to update anything I am going to return false because this update was not successful
        return false;
    }

    //DELETE
    @Override
    public boolean deleteById(int logEntryId) throws DataAccessException {
        List<LogEntry> all = findAll();
        for(int i = 0; i < all.size(); i++){
            if(all.get(i).getId() == logEntryId){
                all.remove(i);
                writeToFile(all);
                return true;
            }
        }
        return false;
    }

    //HELPER METHODS

    // Replace comma with @@@ if it exists where user typed text
    private String restore(String value){
        // first argument is the thing we are checking for, second is the thing we want to replace it with if it exists
        return value.replace(DELIMITER_REPLACEMENT, DELIMITER);
    }
    private String clean(String value){
        // @@@ / ,
        return value.replace(DELIMITER, DELIMITER_REPLACEMENT);
    }


    private LogEntry lineToLogEntry(String line){
        // now that I have each line in my file I'm ready to break apart that line and turn it into an instance in my file. I want to split my line into indvidual fields - I can do that using my delimiter
        String[] fields = line.split(DELIMITER);

        // if there is not exactly 5 fields reject the entry and return null
        if(fields.length != 5){
            return null;
        }

        //assigning each filed in a line to it's place in the line and if there are commas inside of the field we are going to replace them with @@@
        LogEntry logEntry = new LogEntry(
                Integer.parseInt(fields[0]),
                restore(fields[1]),
                LogEntryType.valueOf(fields[2]),
                // here we are using restore so we are taking
                //5,2020-02-01 6:00 PM,SNACK,Apple, banana, yogurt,200 and turning it into
                //5,2020-02-01 6:00 PM,SNACK,Apple@@@ banana@@@ yogurt,200
                restore(fields[3]),
                Integer.parseInt(fields[4])
        );
        return logEntry;
        // returns 5,2020-02-01 6:00 PM,SNACK,Apple@@@ banana@@@ yogurt,200
    }
    //write to file
    private void writeToFile(List<LogEntry> logEntries) throws DataAccessException {
        try(PrintWriter writer = new PrintWriter(filePath)){
            // print the header
            writer.println("id,loggedOn,type,description,calories");

            for(LogEntry logEntry : logEntries){
                String line = logEntryToLine(logEntry);
                writer.println(line);
            }
        }catch(IOException ex){
            throw new DataAccessException("Could not write to file path" + filePath);
        }
    }

    // log entry to line
    // this method is adding a comma to our data after each piece of information
    private String logEntryToLine(LogEntry logEntry){
        // adding a comma after each field in our line
        StringBuilder buffer = new StringBuilder(100);
        buffer.append(logEntry.getId()).append(DELIMITER);
        // clean takes the @@@ and makes it a ,
        // so lines that were previously 5,2020-02-01 6:00 PM,SNACK,Apple@@@ banana@@@ yogurt@@@,200
        // get turned back into 5,2020-02-01 6:00 PM,SNACK,Apple, banana, yogurt,200
        buffer.append(clean(logEntry.getLoggedOn())).append(DELIMITER);
        buffer.append(logEntry.getType()).append(DELIMITER);
        buffer.append(clean(logEntry.getDescription())).append(DELIMITER);
        buffer.append(logEntry.getCalories()); // this is the last piece of info in the entry so no comma here
        return buffer.toString();
        // returns 5,2020-02-01 6:00 PM,SNACK,Apple, banana, yogurt,200
    }

    // get the nextId
    private int getNextId(List<LogEntry> logEntries){
        int maxId = 0;
        for(LogEntry logEntry : logEntries){
            if(maxId < logEntry.getId()){
                maxId = logEntry.getId();
            }
        }
        return maxId+1;
    }


}
