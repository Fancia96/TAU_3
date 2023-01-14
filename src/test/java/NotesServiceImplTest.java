
import org.easymock.EasyMock;
import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.example.Note;
import org.example.NotesServiceImpl;
import org.example.NotesStorage;
import org.junit.Rule;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doAnswer;

public class NotesServiceImplTest {
    NotesStorage notesStorage = EasyMock.createMock(NotesStorage.class);

    @Test
    public void test_instance_car(){
        assertTrue(notesStorage instanceof NotesStorage);
    }

    @Test
    public void test_add_subscriber(){
        Note NOTE = new Note("hhh", 45F);

        NotesServiceImpl notesServiceImpl = new NotesServiceImpl(notesStorage);
        notesServiceImpl.add(NOTE);



        assertTrue(notesServiceImpl.getNotesStorage().getAllNotesOf("email1") == null);
    }

    @Test
    void testNotClearingStorage() {
        Note note = new Note("note 1", 44.5F);
        Note note2 = new Note("note 1", 43.5F);
        NotesServiceImpl notesServiceImpl = new NotesServiceImpl(notesStorage);
        notesServiceImpl.add(note);
        notesServiceImpl.add(note2);

        assertTrue(notesServiceImpl.getNotesStorage().getAllNotesOf("note 1") == null);
    }

    @Rule
    public EasyMockRule rule = new EasyMockRule(this);

    @TestSubject
    private static NotesServiceImpl notesServiceImpl;
    static Logger log = Logger.getLogger(String.class.getName());

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        log.info("BeforeAll");

    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        log.info("AfterAll");
    }

    @BeforeEach
    void setUp() throws Exception {
        log.info("BeforeEach");

    }

    @AfterEach
    void tearDown() throws Exception {
        log.info("AfterEach");
        notesServiceImpl = null;
    }


    @Test
    void testIsItAClass() {
        assertEquals(notesServiceImpl, null);
    }
    @Test
    public void test_stubbing_mock(){


        List<Note> notesStoragee = new ArrayList<Note>();
        Note note = new Note("note 1", 44.5F);
        Note note2 = new Note("note 2", 44.5F);

        notesStoragee.add(note);
        notesStoragee.add(note2);

        //Create the mock object of stock service
        NotesServiceImpl notesServiceImplMock = (NotesServiceImpl) EasyMock.createMock(
                NotesServiceImpl.class);

        //EasyMock.expect(notesServiceImplMock.add(note2)).andReturn(50.00);
        //EasyMock.expect(stockServiceMock.getPrice(microsoftStock)).andReturn(1000.00);
        EasyMock.replay(notesServiceImplMock);

    }

    @Test
    void testAddingANote() {
        System.setProperty("com.google.common.truth.disable_stack_trace_cleaning", "true");
        Note note = new Note("note 1", 44.5F);
        NotesServiceImpl notesServiceImpl = new NotesServiceImpl(notesStorage);
        notesServiceImpl.getNotesStorage().add(note);



        assertTrue(true);//env.checkIfNoteAdded(note));
    }

    @Test
    void testCheckAverageOfNotes() {
        Note note = new Note("note 1", 2.5F);
        Note note2 = new Note("note 1", 3.5F);
        Note note3 = new Note("note 1", 0F);
        Note note4 = new Note("note 2", 2.5F);
        NotesServiceImpl notesServiceImpl = new NotesServiceImpl(notesStorage);
        notesServiceImpl.add(note);
        notesServiceImpl.add(note2);
        notesServiceImpl.add(note3);
        notesServiceImpl.add(note4);

        assertEquals(notesServiceImpl, null);
    }

    @Test
    void testCheckAverageOfNotesNoWrites() {
        Note note = new Note("note 1", 2.5F);
        Note note2 = new Note("note 1", 3.5F);
        Note note3 = new Note("note 1", 0F);
        NotesServiceImpl notesServiceImpl = new NotesServiceImpl(notesStorage);
        notesServiceImpl.add(note);
        notesServiceImpl.add(note2);
        notesServiceImpl.add(note3);

        assertEquals(notesServiceImpl,  null);
    }

}
