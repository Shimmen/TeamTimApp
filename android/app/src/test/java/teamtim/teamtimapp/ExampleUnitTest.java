package teamtim.teamtimapp;

import org.junit.Test;

import java.util.List;

import teamtim.teamtimapp.database.DatabaseInterface;
import teamtim.teamtimapp.database.MockDatabase;
import teamtim.teamtimapp.database.WordDifficulty;
import teamtim.teamtimapp.database.WordQuestion;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testDatabaseInterface() throws Exception {
        DatabaseInterface dbase = new MockDatabase();
        List<WordQuestion> questions = dbase.getQuestions("Frukt", -1);
        assertTrue(questions.size() == 5);
        questions = dbase.getQuestions("Djur", 3);
        assertTrue(questions.size() == 3);

        questions = dbase.getQuestions(WordDifficulty.EASY, "Djur", -1);
        boolean isEasy = true;
        for (WordQuestion q : questions) {
            if (q.getDifficulty() != WordDifficulty.EASY)
                isEasy = false;
        }
        assertTrue(isEasy);


        for (int i = 0; i < 5; i++) {
            System.out.println(dbase.getQuestions("Djur", 1).get(0).getWord());
        }
    }
}