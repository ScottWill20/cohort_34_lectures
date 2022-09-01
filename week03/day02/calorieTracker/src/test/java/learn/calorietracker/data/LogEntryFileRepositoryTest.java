package learn.calorietracker.data;

import learn.calorietracker.models.LogEntry;
import learn.calorietracker.models.LogEntryType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogEntryFileRepositoryTest {

    private static final String SEED_FILE_PATH = "./data/log-entries-seed.csv";
    private static final String TEST_FILE_PATH = "./data/log-entries-test.csv";

    // create a new file repository
    private final LogEntryFileRepository repository = new LogEntryFileRepository(TEST_FILE_PATH);

    // I need to set up my tests so that there is a known good state
    @BeforeEach
    public void setUp() throws IOException {
        Path seedPath = Paths.get(SEED_FILE_PATH);
        Path testPath = Paths.get(TEST_FILE_PATH);
        // before we run each test we want to replace what's in the test file with the seed data - resetting our data to a known good state
        Files.copy(seedPath, testPath, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void shouldFindAll() throws DataAccessException {
        List<LogEntry> actual = repository.findAll();
        assertEquals(3, actual.size());

        LogEntry logEntry = actual.get(0);
        assertEquals(1, logEntry.getId());
        assertEquals("2020-01-01 9:00 AM", logEntry.getLoggedOn());
        assertEquals(LogEntryType.BREAKFAST, logEntry.getType());
        assertEquals("Scrambled eggs", logEntry.getDescription());
        assertEquals(210, logEntry.getCalories());

    }

    // should find by id
    @Test
    public void shouldFindById() throws DataAccessException {
        LogEntry actual = repository.findById(1);

        // we want to do this first because if it's null we can't go any further
        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals("2020-01-01 9:00 AM", actual.getLoggedOn());
        assertEquals(LogEntryType.BREAKFAST, actual.getType());
        assertEquals("Scrambled eggs", actual.getDescription());
        assertEquals(210, actual.getCalories());
    }

    // should not find unknown id
    @Test
    public void shouldNotFindUnknownId() throws DataAccessException {
        LogEntry actual = repository.findById(9999);
        assertNull(actual);
    }

    //should create
    @Test
    public void shouldCreate() throws DataAccessException {
        LogEntry logEntry = new LogEntry(0, "2022-05-04 1:00 PM", LogEntryType.LUNCH, "Tuna melt", 350);
        LogEntry actual = repository.create(logEntry);
        assertEquals(4, actual.getId());
        List<LogEntry> all = repository.findAll();
        assertEquals(4, all.size());

        LogEntry idThree = all.get(2);
        assertEquals(3, idThree.getId());
        assertEquals("2020-01-01 6:00 PM", idThree.getLoggedOn());
        assertEquals(LogEntryType.DINNER, idThree.getType());
        assertEquals("Steak", idThree.getDescription());
        assertEquals(1000, idThree.getCalories());

        LogEntry newEntry = all.get(3);
        assertEquals(4, newEntry.getId());
        assertEquals("2022-05-04 1:00 PM", newEntry.getLoggedOn());
        assertEquals(LogEntryType.LUNCH, newEntry.getType());
        assertEquals("Tuna melt", newEntry.getDescription());
        assertEquals(350, newEntry.getCalories());
    }

    // should create with commas
    @Test
    public void shouldCreateWithCommas() throws DataAccessException {
        LogEntry logEntry = new LogEntry(
                0,
                "2020-02-01, 6:00 PM",
                LogEntryType.SNACK,
                "Apple, Orange",
                200);

        LogEntry actual = repository.create(logEntry);

        assertEquals(4, actual.getId());

        List<LogEntry> all = repository.findAll();

        assertEquals(4, all.size());

        // assert that the first record has the expected values
        // 1,2020-01-01 9:00 AM,BREAKFAST,Scrambled eggs,210
        LogEntry newLogEntry = all.get(3);
        assertEquals(4, newLogEntry.getId());
        assertEquals("2020-02-01, 6:00 PM", newLogEntry.getLoggedOn());
        assertEquals(LogEntryType.SNACK, newLogEntry.getType());
        assertEquals("Apple, Orange", newLogEntry.getDescription());
        assertEquals(200, newLogEntry.getCalories());
    }
    // should update
    @Test
    public void shouldUpdate() throws DataAccessException {
        LogEntry logEntry = repository.findById(1);
        logEntry.setType(LogEntryType.SNACK);
        logEntry.setDescription("Cake");
        logEntry.setCalories(500);

        boolean result = repository.update(logEntry);

        assertTrue(result);

        logEntry = repository.findById(1);

        assertNotNull(logEntry);
        // assert that the record has the expected values
        // 1,2020-01-01 9:00 AM,BREAKFAST,Scrambled eggs,210
        assertEquals(1, logEntry.getId());
        assertEquals("2020-01-01 9:00 AM", logEntry.getLoggedOn());
        assertEquals(LogEntryType.SNACK, logEntry.getType());
        assertEquals("Cake", logEntry.getDescription());
        assertEquals(500, logEntry.getCalories());
    }
    // should not update unknown id
    @Test
    public void shouldNotUpdateUnknownId() throws DataAccessException {
        LogEntry logEntry = new LogEntry(
                99999,
                "",
                LogEntryType.BREAKFAST,
                "",
                1000);

        boolean result = repository.update(logEntry);

        assertFalse(result);
    }

    // should delete
    @Test
    public void shouldDelete() throws DataAccessException {
        boolean result = repository.deleteById(1);

        assertTrue(result);

        List<LogEntry> all = repository.findAll();

        assertEquals(2, all.size());

        LogEntry logEntry = repository.findById(1);

        assertNull(logEntry);
    }


    // should not delete unknown id

    @Test
    public void shouldNotDeleteUnknownId() throws DataAccessException {
        boolean result = repository.deleteById(99999);

        assertFalse(result);
    }



}// this closes the test class