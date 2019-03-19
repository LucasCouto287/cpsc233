import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;

public class CreditHistoryTest {
    // test constructors
    @Test
    public void test_numOfRatings() {
        int expected = 3;
        CreditHistory ch = new CreditHistory();
        ch.addRating(3);
        ArrayList<Integer> actual = ch.getRatings();
        int actualValue = 0;
        if (actual.size() > 0) {
            actualValue = new Integer(actual.get(0));
        }
        assertEquals("Expected rating queue size to be 1", 1, actual.size(), 0.00001);
        assertEquals("bla bla bla", expected, actualValue, 0.00001);
    }

    @Test
    public void test_numOfRatings_1() {
        int expected = 2;
        CreditHistory ch = new CreditHistory();
        ch.addRating(1);
        ch.addRating(3);
        assertEquals("Expected rating queue size to be 2", expected, ch.numOfRatings(), 0.00001);
    }

    @Test
    public void test_addRating_incorrect() {
        int expected = 2;
        CreditHistory ch = new CreditHistory();
        ch.addRating(-4);
        ch.addRating(-3);
        ch.addRating(-6);
        assertEquals("Expected rating queue size to remain the same when trying to add an incorrect rating", expected,
                ch.numOfRatings(), 0.00001);
    }

    @Test
    public void test_trimRatings() {
        CreditHistory ch = new CreditHistory();
        ch.addRating(1);
        ch.addRating(2);
        ch.addRating(3);
        ch.addRating(1);
        ch.addRating(2);
        ch.addRating(3);
        ch.addRating(1);
        ch.addRating(2);
        ch.addRating(3);
        ch.addRating(1); // 10th rating
        ch.addRating(2);
        ch.addRating(3); // "new" 10th rating after trimming
        int expectedSize = 10;
        ch.trimRatings();
        assertEquals("Expected queue sizze to be ten after trimming", expectedSize, ch.numOfRatings(), 0.00001);
        // assertEquals("Expected first element in queue (after trimming) to be the 3rd
        // element added to queue before trimmning", , ch.numOfRatings(), 0.00001);
    }

    @Test
    public void test_trimRatings_2() {
        CreditHistory ch = new CreditHistory();
        ch.addRating(2);
        ch.addRating(3);
        ch.addRating(5);
        ch.addRating(1);
        ch.addRating(2);
        ch.addRating(3);
        ch.addRating(1);
        ch.addRating(2);
        ch.addRating(3);
        ch.addRating(1); // 10th rating
        ch.addRating(2);
        ch.addRating(3); // "new" 10th rating after trimming
        int expectedSize = 10;
        ch.trimRatings();
        assertEquals("Expected queue sizze to be ten after trimming", expectedSize, ch.numOfRatings(), 0.00001);
        // assertEquals("Expected first element in queue (after trimming) to be the 3rd
        // element added to queue before trimmning", , ch.numOfRatings(), 0.00001);
    }
}