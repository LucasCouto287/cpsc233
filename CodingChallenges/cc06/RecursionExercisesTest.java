import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class RecursionExercisesTest {
	
	

	//Check the submission file for the words "for" and "while"
	public void testCheckWords(){
		Scanner scan = null;
		try {
			scan = new Scanner (new FileInputStream("RecursionExercises.java"));
		} catch (FileNotFoundException e){
			fail("RecursionExercises.java not found");
		}
		
		while (scan.hasNext()){
			String line = scan.nextLine();
			
			if (line.contains("for") || line.contains("while")){
				fail("Found word \"for\" or \"while\": " + line);
			}
		}
		
		scan.close();
	}
	
	// Testing sumReciprocals
	
	@Test 
	public void test_sumReciprocals_negative() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing adding reciprocals starting at negative number", 0, se.sumReciprocals(-1), 0.000001);
		assertEquals("Testing adding reciprocals starting at negative number", 0, se.sumReciprocals(-2), 0.000001);
		assertEquals("Testing adding reciprocals starting at negative number", 0, se.sumReciprocals(-5), 0.000001);
		assertEquals("Testing adding reciprocals starting at negative number", 0, se.sumReciprocals(-10), 0.000001);
	}
	
	@Test 
	public void test_sumReciprocals_zero() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing adding reciprocals starting at zero", 0.0, se.sumReciprocals(0), 0.000001);
	}
	
	@Test 
	public void test_sumReciprocals_one() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing adding reciprocals starting at one", 1.0, se.sumReciprocals(1), 0.000001);
	}
	
	@Test 
	public void test_sumReciprocals_ten() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing adding the reciprocals of one to ten", 2.928968, se.sumReciprocals(10), 0.00001);
	}
	
	// Testing prodOfMultiple1
	
	@Test 
	public void test_prodOfMultiple1_negative() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing prodOfMultiple1 starting at negative number", 0, se.prodOfMultiple1(-1));
		assertEquals("Testing prodOfMultiple1 starting at negative number", 0, se.prodOfMultiple1(-2));
		assertEquals("Testing prodOfMultiple1 starting at negative number", 0, se.prodOfMultiple1(-5));
		assertEquals("Testing prodOfMultiple1 starting at negative number", 0, se.prodOfMultiple1(-10));
	}
	
	@Test 
	public void test_prodOfMultiple1_zero() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing prodOfMultiple1 starting at zero", 0, se.prodOfMultiple1(0));
	}
	
	@Test 
	public void test_prodOfMultiple1_one() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing multiplication of multiples of 3 from zero to one", 1, se.prodOfMultiple1(1));
	}
	
	@Test 
	public void test_prodOfMultiple1_three() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing multiplication of multiples of 3 from zero to three", 3, se.prodOfMultiple1(3));
	}
	
	@Test 
	public void test_prodOfMultiple1_ten() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		assertEquals("Testing multiplication of multiples of 3 from zero to ten", 162, se.prodOfMultiple1(10));
	}
	
	
	//Testing prodOfMultiple2
	
	@Test
	public void test_prodOfMultiple2_sequential() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < 10; i++){
			list.add(i);
		}
		
		assertEquals("Testing prodOfMultiple2 for {0, 1, ..., 9}.", 162, se.prodOfMultiple2(list));
		
	}
	
	@Test
	public void test_prodOfMultiple2_OnlyMult3() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++){
			list.add(i*3);
		}
		
		assertEquals("Testing prodOfMultiple2 for {0, 3, 6, ..., 15}.", 29160, se.prodOfMultiple2(list));
		
	}
	
	@Test
	public void test_prodOfMultiple2_noMultiples() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++){
			list.add(i*3 + 1);
		}
		
		assertEquals("Testing prodOfMultiple2 for {1, 4, 7, ..., 151}.", 1, se.prodOfMultiple2(list));
		
	}
	
	@Test
	public void test_prodOfMultiple2_EmptyList() {
		//Test empty lsit
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		assertEquals("Testing prodOfMultiple2 for {}.", 1, se.prodOfMultiple2(list));
		
	}
	
	@Test
	public void test_prodOfMultiple2_NullList() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing prodOfMultiple2 for null list.", 0, se.prodOfMultiple2(null));
		
	}
	
	// testing removeUppercase
	@Test
	public void test_removeUppercase_NullString() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeUppercase for null string.", null, se.removeUppercase(null));
		
	}
	
	@Test
	public void test_removeUppercase_EmptyString() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeUppercase for empty string.", "", se.removeUppercase(""));
		
	}
	
	@Test
	public void test_removeUppercase_OnlyUppercase() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeUppercase for string with uppercase letters.", "  ", se.removeUppercase("LAST CODING CHALLENGE"));
		
	}
	
	@Test
	public void test_removeUppercase_NoUppercase() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeUppercase for string with no uppercase letters.", "sqwrtyplkjhgfdszxcvbnm", se.removeUppercase("sqwrtyplkjhgfdszxcvbnm"));
		
	}
	
	@Test
	public void test_removeUpperCase_Mixedcase() {
		testCheckWords();
		RecursionExercises se = new RecursionExercises();
		
		assertEquals("Testing removeUppercase for string with mixed case.", "s is this  string with vowels?", se.removeUppercase("Is is this A string with vowels?"));
	}
	

}
