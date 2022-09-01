package learn.calorietracker.domain;

import learn.calorietracker.data.DataAccessException;
import learn.calorietracker.data.LogEntryFileRepository;
import learn.calorietracker.data.LogEntryRepository;
import learn.calorietracker.data.LogEntryRepositoryDouble;
import learn.calorietracker.models.LogEntry;
import learn.calorietracker.models.LogEntryType;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LogEntryServiceTest {
    LogEntryRepository repository = new LogEntryRepositoryDouble(); // we are using our double here
    LogEntryService service = new LogEntryService(repository); // we need our service here before we can write tests

    // CREATE
    @Test
    void shouldCreateLogEntry() throws DataAccessException {
        LogEntryResult actual = service.create(new LogEntry(
                0,
                "2022-08-21 10:00 AM",
                LogEntryType.SNACK,
                "Apple",
                50));
        // we could check the size to make sure its being updated
        // we could also check the ID

        // verify that the payload is set - make sure this isnt null
        assertNotNull(actual.getLogEntry());
        assertTrue(actual.isSuccess());

        assertEquals(99,actual.getLogEntry().getId()); // this should fail

    }

    @Test
    void shouldNotCreateNullLogEntry() throws DataAccessException {
        LogEntryResult actual = service.create(null);

        assertFalse(actual.isSuccess());
        assertNull(actual.getLogEntry());
        assertEquals("Log entry cannot be null",actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithNullLoggedOn() throws DataAccessException {
        LogEntryResult actual = service.create(new LogEntry(0,
                null,
                LogEntryType.SNACK,
                "Apple",
                50));

        assertFalse(actual.isSuccess());
        assertNull(actual.getLogEntry());
        assertEquals("LoggedOn is required", actual.getMessages().get(0));

    }

    @Test
    void shouldNotCreateWithEmptyLoggedOn() throws DataAccessException {
        LogEntryResult actual = service.create(new LogEntry(0,
                "",
                LogEntryType.SNACK,
                "Apple",
                50));

        assertFalse(actual.isSuccess());
        assertNull(actual.getLogEntry());
        assertEquals("LoggedOn is required", actual.getMessages().get(0));

    }

    @Test
    void shouldNotCreateWithInvalidCalories() throws DataAccessException {
        LogEntryResult actual = service.create(new LogEntry(0,
                "2022-08-21 10:00 AM",
                LogEntryType.SNACK,
                "Apple",
                0));

        assertFalse(actual.isSuccess());
        assertNull(actual.getLogEntry());
        assertEquals("Calories must be between 1 and 5000", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithoutLogEntryType() throws DataAccessException {
        LogEntryResult actual = service.create(new LogEntry(0,
                "2022-08-21 10:00 AM",
                null,
                "Apple",
                50));

        assertFalse(actual.isSuccess());
        assertNull(actual.getLogEntry());
        assertEquals("type is required", actual.getMessages().get(0));
    }

    @Test
    void shouldNotCreateWithoutDescription() throws DataAccessException {
        LogEntryResult actual = service.create(new LogEntry(0,
                "2022-08-21 10:00 AM",
                LogEntryType.SNACK,
                null,
                50));

        assertFalse(actual.isSuccess());
        assertNull(actual.getLogEntry());
        assertEquals("description is required", actual.getMessages().get(0));
    }

    // UPDATE
    @Test
    void shouldUpdateExistingLogEntry() throws DataAccessException {
        List<LogEntry> all = service.findAll();
        LogEntry toUpdate = all.get(0);
        toUpdate.setCalories(250);

        LogEntryResult actual = service.update(toUpdate);

        assertTrue(actual.isSuccess());
        assertEquals(0, actual.getMessages().size()); // no errors in our messages array if this was successful
    }

    @Test
    void shouldNotUpdateNullLogEntry() throws DataAccessException {
        LogEntryResult actual = service.update(null);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Log entry cannot be null", actual.getMessages().get(0));
    }

    @Test
    void shouldNotUpdateNonExistingLogEntry() throws DataAccessException {
        LogEntry logEntry = new LogEntry(0, "FAKE",LogEntryType.DINNER,"FAKE",107);
        LogEntryResult actual = service.update(logEntry);

        assertFalse(actual.isSuccess());
        assertEquals(1,actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("does not exist"));

    }

    // READ

    @Test
    void shouldFindExistingId() throws DataAccessException {
        LogEntry actual = service.findById(1);

        assertNotNull(actual);
        assertEquals(1, actual.getId());
        assertEquals("2022-01-01 9:00 AM", actual.getLoggedOn());
        assertEquals(LogEntryType.BREAKFAST, actual.getType());
        assertEquals("French Toast", actual.getDescription());
        assertEquals(500, actual.getCalories());
    }

    @Test
    void shouldNotFindNotExistingId() throws DataAccessException {
        LogEntry actual = service.findById(999);

        assertNull(actual);
    }

    // DELETE

    @Test
    void shouldDeleteExistingLogEntry() throws DataAccessException {
        LogEntryResult actual = service.deleteById(1);

        assertTrue(actual.isSuccess());
    }

    @Test
    void shouldNotDeleteNonExistingLogEntry() throws DataAccessException {
        LogEntryResult actual = service.deleteById(999);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("does not exist"));
    }


}
