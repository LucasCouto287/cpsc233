import static org.junit.Assert.*;

import java.io.*;
import java.util.Scanner;
import java.util.Random;

import org.junit.Test;

public class FileExercisesTest {
	
	private String getRandomFilename() {
		return "test" + (new Random()).nextInt(100000);
	}
	
	private String createFile(String text){
		String filename =  getRandomFilename() + ".txt";
		try {
			PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
			output.print(text);
			output.close();
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to (re)create file " + filename);
		}
		return filename;
	}
	
	private String createFile(double[] nums){
		String filename = getRandomFilename() + ".bin";
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
			out.writeInt(nums.length);
			for (int counter = 0; counter < nums.length; counter++) {
				out.writeDouble(nums[counter]);
			}
			out.close();		
		} catch (IOException ioe) {
			fail("Unable to set up test environment, tried to create file " + filename);
		}
		return filename;
	}

	//Test with valid files
	
	@Test
	public void test_getLastLetters_multipleLinesAndSpaces() {
		FileExercises fl = new FileExercises();
		String content = "Hello\nand\nwelcome\nTo the\nUniversity of Calgary";
		String filename = createFile(content);
		String outFilename = getRandomFilename() + ".txt";
		fl.getLastLetters(filename, outFilename);
		
		//Expected output
		String expected = "ODEOEYFY";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("testing with input file with content'Hello\nand\nwelcome\nTo the\nUniversity of Calgary'.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("testing with input file with content'Hello\nand\nwelcome\nTo the\nUniversity of Calgary'. The output file is empty.");
			}
			scan.close();
			
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("testing with input file with content'Hello\nand\nwelcome\nTo the\nUniversity of Calgary'. Cannot open the output file.");
		}
		
		File f = new File(filename);
		f.delete();
		f = new File(outFilename);
		f.delete();
	}
	
	@Test
	public void test_getLastLetters_twoWordsNoNewLines() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		String content = "Hello World";
		String inFilename = createFile(content);
		String outFilename = getRandomFilename() + ".txt";
		fl.getLastLetters(inFilename, outFilename);
		
		//Expected output
		String expected = "OD";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Testing with input file with content 'Hello World'.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("Testing with input file with content 'Hello World'.  The output file is empty.");
			}
			scan.close();
			
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Testing with input file with content 'Hello World'.  Cannot open the output file.");
		}
		
		File f = new File(inFilename);
		f.delete();
		f = new File(outFilename);
		f.delete();
	}

	//Test with input file name as null
	
	@Test
	public void test_getLastLetters_nullInputFile() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		String outFilename = getRandomFilename(); 
		fl.getLastLetters(null, outFilename);
		
		//Expected output
		String expected = "NullPointerException";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Provided null as value for input file name.  Strings don't match.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("Provided null as value for input file name.  The output file is empty.");
			}
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Provided null as value for input file name.  Cannot open the output file.");
		}
		
		File f = new File(outFilename);
		f.delete();
	}
	
	//Test with the input file doesn't exist
	
	@Test
	public void test_getLastLetters_InvalidInputFileName() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		String inFilename = getRandomFilename() + ".txt";
		String outFilename = getRandomFilename() + ".txt";
		fl.getLastLetters(inFilename, outFilename);
		
		//Expected output
		String expected = "FileNotFoundException";
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(outFilename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Called with input file name for file that does not exist.  Unexpected output file content.", expected, line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("Called with input file name for file that does not exist.  The expected output file is empty.");
			}
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Called with input file name for file that does not exist.  Expected output file does not exist.");
		}
		File f = new File(inFilename);
		f.delete();
		f = new File(outFilename);
		f.delete();
	}
	
	@Test
	public void test_wordSearch_wordNotInFile() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		String content = "This is a test\nfor counting this word\nand here and there is a few tests\nand another test";
		String inFilename = createFile(content);
		
		// run the test
		int actual = fl.wordSearch("empty", inFilename);
		int expected = -1;
		
		// verify result
		assertEquals("The word 'empty' does not appear in the file", expected, actual);
		
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_wordSearch_wordOnceInMiddleOfFile() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		String content = "This is a test\nfor counting this word\nand here and there is a few tests\nand another test";
		String inFilename = createFile(content);
		// run the test
		int actual = fl.wordSearch("word", inFilename);
		int expected = 8;
		
		// verify result
		assertEquals("The word 'word' appears at the end of the second line and is the 8th word in the file.", expected, actual);
		
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_wordSearch_wordTwiceInFile() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		// run the test
		String content = "This is a test\nfor counting this word\nand here and there is a few tests\nand another test";
		String inFilename = createFile(content);
		int actual = fl.wordSearch("is", inFilename);
		int expected = 2;
		
		// verify result
		assertEquals("The word 'is' appears twice in the file, the first time is as the second word in the file.", expected, actual);
		
		File f = new File(inFilename);
		f.delete();
	}
	
	@Test
	public void test_wordSearch_wordTwiceOnSameLine() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		// run the test
		String content = "is is a test\nfor counting this word\nand here and there is a few tests\nand another test";
		String inFilename = createFile(content);
		int actual = fl.wordSearch("is", inFilename);
		int expected = 1;
		
		// verify result
		assertEquals("The word 'is' appears twice in the file as the first and second word", expected, actual);
		
		File f = new File(inFilename);
		f.delete();
	}
	@Test
	public void test_wordSearch_invalidFileName() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		String filename = getRandomFilename() + ".txt";
		// run the test
		int actual = fl.wordSearch("is", filename);
		
		// verify result
		assertEquals("The file " + filename + " does not exist", -1, actual);

		File f = new File(filename);
		f.delete();
	}
	

	@Test
	public void test_append_validFile() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		String content = "one\n";
		String filename = createFile(content);
		
		
		// run the test
		fl.append("abc", "def", filename);
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(filename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Expected 'one' to remain on first line in file", "one", line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The file to append to has instead has all content removed.");
			}
			
			if (scan.hasNext()){
				//Read the second line in the file
				String line = scan.nextLine();
				assertEquals("Expected 'def,abc' to be added to the file", "def,abc", line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file does not have additional line that should have been appended to file.");
			}
			if (scan.hasNext()){
				fail("The file to append to had more lines than expected");
			} 
			scan.close();
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the file that should have been appended to.");
		}
		
		File f = new File(filename);
		f.delete();
	}	

	
	@Test
	public void test_append_createNewFile() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		String filename = getRandomFilename();
		// run the test
		fl.append("john","doe", filename);
		
		//Read from the output file
		try {
			//Initialize scanner
			Scanner scan = new Scanner(new FileInputStream(filename));

			if (scan.hasNext()){
				//Read the first line in the file
				String line = scan.nextLine();
				assertEquals("Expected name to append to be first line in file since the file did not exist", "doe,john", line);
			} else {
				//If there is nothing in the file, then the test fails
				fail("The output file was created as expected but not contain anything.");
			}
			
			if (scan.hasNext()){
				fail("The file to append to had more lines than expected");
			} 
			scan.close();
			
		} catch (FileNotFoundException fnfe){
			//If cannot open output file, then test fails
			fail("Cannot open the output file that should have been created for this test.");
		}
		
		File f = new File(filename);
		if (!f.delete()){
			fail("Unable to delete file created for test.  Make sure to manually delete " + filename + " to prevent further failed tests.");
		}
	}
	
	@Test
	public void test_prodNumbers_invalidFileName() {
		
		//Initialize FileExercises
		FileExercises fl = new FileExercises();
		
		String filename = getRandomFilename() + ".bin";
		
		// run the test
		try {
			fl.prodNumbers(filename);
			fail("Excpected FileNotFoundException since file provided does not exist");
		} catch (FileNotFoundException fnfe) {
			// test passes, this was expected result.
		}
		File f = new File(filename);
		f.delete();
	}
	
	@Test
	public void test_prodNumbers_oneNumInFile() {
		double[] nums = {5.56};
		String filename = createFile(nums);
		
		FileExercises fl = new FileExercises();
		
		try {
			double actual = fl.prodNumbers(filename);
			assertEquals("The file contains one number: 5.56", 5.56, actual, 0.0000001);
		} catch (FileNotFoundException fnfe) {
			fail("Unexpected FileNotFoundException since file was created and should exist");
		}
		
		File f = new File(filename);
		f.delete();
	}
	
	@Test
	public void test_prodNumbers_fiveNumsInFile() {
		double[] nums = {5.5, -1.55, 1.0, 45.5, -10.5};
		String filename = createFile(nums);
		
		FileExercises fl = new FileExercises();
		
		try {
			double actual = fl.prodNumbers(filename);
			assertEquals("The file contains five numbers: 5.56, -1.56, 1.0, 45.5, -10.5", 4072.81875, actual, 0.0000001);
		} catch (FileNotFoundException fnfe) {
			fail("Unexpected FileNotFoundException since file was created and should exist");
		}
		
		File f = new File(filename);
		f.delete();		
	}
	
	@Test
	public void test_prodNumbers_emptyFile() {
		double[] nums = {};
		String filename = createFile(nums);
		
		FileExercises fl = new FileExercises();

		try {
			double actual = fl.prodNumbers(filename);
			assertEquals("The file contains many numbers", 0.0, actual, 0.0000001);
		} catch (FileNotFoundException fnfe) {
			fail("Unexpected FileNotFoundException since file was created and should exist");
		}
		
		File f = new File(filename);
		f.delete();
	} 
}
