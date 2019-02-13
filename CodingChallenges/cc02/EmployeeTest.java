import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	// Testing constructors
	
		@Test
		public void testConstructor_validRank_score0(){
			Employee c = new Employee('e',0);
			assertEquals("Constructed Employee('e',0) - testing rank", 'e', c.getRank());
			assertEquals("Constructed Employee(e,0) - testing score", 0.0, c.getScore(), 0.000001);
			
			c = new Employee('m',0);
			assertEquals("Constructed Employee('m',0) - testing rank", 'm', c.getRank());
			assertEquals("Constructed Employee('m',0) - testing score", 0.0, c.getScore(), 0.000001);

			c = new Employee('u',0);
			assertEquals("Constructed Employee('u',0) - testing rank", 'u', c.getRank());
			assertEquals("Constructed Employee('u',0) - testing score", 0.0, c.getScore(), 0.000001);
			
			c = new Employee('x',0);
			assertEquals("Constructed Employee('x',0) - testing rank", 'x', c.getRank());
			assertEquals("Constructed Employee('x',0) - testing score", 0.0, c.getScore(), 0.000001);
		}

		@Test
		public void testConstructor_invalidRank_score0(){
			Employee c = new Employee('t',0);
			assertEquals("Constructed Employee('t',0) - testing rank", 'e', c.getRank());
			assertEquals("Constructed Employee('t',0) - testing score", 0.0, c.getScore(), 0.000001);			
			
			c = new Employee('E',0);
			assertEquals("Constructed Employee('E',0) - testing rank", 'e', c.getRank());
			assertEquals("Constructed Employee(E,0) - testing score", 0.0, c.getScore(), 0.000001);
			
			c = new Employee('h',0);
			assertEquals("Constructed Employee('h',0) - testing rank", 'e', c.getRank());
			assertEquals("Constructed Employee('h',0) - testing score", 0.0, c.getScore(), 0.000001);

			c = new Employee('q',0);
			assertEquals("Constructed Employee('q',0) - testing rank", 'e', c.getRank());
			assertEquals("Constructed Employee('q',0) - testing score", 0.0, c.getScore(), 0.000001);
		}

		@Test
		public void testConstructor_scoreNegative(){
			Employee c = new Employee('x',-1);
			assertEquals("Constructed Employee('x',-1) - testing rank", 'x', c.getRank());
			assertEquals("Constructed Employee('x',-1) - testing score", 1.0, c.getScore(), 0.000001);						
		}

		@Test
		public void testConstructor_scorePositive(){
			Employee c = new Employee('u',55.0);
			assertEquals("Constructed Employee('u',55) - testing rank", 'u', c.getRank());
			assertEquals("Constructed Employee('u',55) - testing score", 55.0, c.getScore(), 0.000001);						
		}

		@Test
		public void testConstructor_scoreLarge(){
			Employee c = new Employee('m',69346.7);
			assertEquals("Constructed Employee('m',69346.7) - testing rank", 'm', c.getRank());
			assertEquals("Constructed Employee('m',69346.7) - testing score", 69346.7, c.getScore(), 0.000001);						
		}
		
		@Test
		public void testCopyConstructor(){
			Employee p = new Employee('e',56);
			Employee p2 = new Employee(p);
			assertEquals("Copied player with rank 'e' and score 56 - testing rank", 'e', p2.getRank());
			assertEquals("Copied player with rank 'e' and score 56 - testing score", 56.0, p2.getScore(), 0.000001);
		}

		@Test
		public void testCopyConstructor2(){
			Employee p = new Employee('x',200);
			Employee p2 = new Employee(p);
			assertEquals("Copied player with rank 'x' and score 200 - testing rank", 'x', p2.getRank());
			assertEquals("Copied player with rank 'x' and score 200 - testing score", 200, p2.getScore(), 0.000001);
		}

		// Testing setter and getters
		
		@Test
		public void test_setter_and_getter_rank_invalid(){
			Employee c = new Employee('g',0);
			c.setRank('a');
			assertEquals("a, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('b');
			assertEquals("b, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('c');
			assertEquals("c, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('f');
			assertEquals("c, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('i');
			assertEquals("i, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('H');
			assertEquals("H, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('k');
			assertEquals("k, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('.');
			assertEquals("., is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('D');
			assertEquals("D, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('$');
			assertEquals("$, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('-');
			assertEquals("-, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('q');
			assertEquals("q, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('r');
			assertEquals("r, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('T');
			assertEquals("T, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('W');
			assertEquals("W, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('y');
			assertEquals("y, is not valid, expected default of e", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('z');
			assertEquals("z, is not valid, expected default of e", 'e', c.getRank());
		}
		
		@Test
		public void test_setter_and_getter_rank_valid(){
			Employee c = new Employee('x',0);
			c.setRank('e');
			assertEquals("e valid rank.", 'e', c.getRank());
			c = new Employee('g',0);
			c.setRank('x');
			assertEquals("x valid rank.", 'x', c.getRank());
			c = new Employee('g',0);
			c.setRank('u');
			assertEquals("u valid rank.", 'u', c.getRank());
			c = new Employee('g',0);
			c.setRank('m');
			assertEquals("m valid rank.", 'm', c.getRank());
		}
		
		@Test
		public void test_getter_and_setter_score_zero() {
			Employee c = new Employee('x',20.0);
			c.setScore(0.0);
			assertEquals("Updating from positive score to 0.", 0.0, c.getScore(), 0.00001);
		}

		@Test
		public void test_getter_and_setter_score_negative() {
			Employee c = new Employee('o',0);
			c.setScore(30.0);
			c.setScore(-1.0);
			assertEquals("Trying to update score by negative number should default to 1.0.", 1.0, c.getScore(),0.000001);
		}
		
		@Test
		public void test_getValue_Zero() {
			Employee c = new Employee('e',0);
			assertEquals("Value for zero score and zero years of service is 0", 0.0, c.getValue(), 0.00001);
			c.setScore(5);
			assertEquals("Value for score 5 and zero years of service is 0", 0.0, c.getValue(), 0.00001);
			c.setScore(20);
			assertEquals("Value for score 20 and zero years of service is 0", 0.0, c.getValue(), 0.00001);

		}

		@Test
		public void test_getValue_oneYearOfService() {
			Employee c = new Employee('h',0.5);
			c.updateYearsOfService();
			assertEquals("Value for 0.5 score and one year of service is the score itself.", 0.5, c.getValue(), 0.00001);
			c.setScore(35);
			assertEquals("Value for score 35 and one year of service is the score itself.", 35, c.getValue(), 0.00001);
			c.setScore(54);
			assertEquals("Value for score 54 and one year of service is the score itself.", 54, c.getValue(), 0.00001);
		}

		@Test
		public void test_getValue_twoYearsOfService() {
			Employee c = new Employee('w',1.1);
			c.updateYearsOfService();
			c.updateYearsOfService();
			assertEquals("Value for score 1.1 and two years of service is 2.2", 2.2, c.getValue(), 0.00001);
			c.setScore(100.0);
			assertEquals("Value for score 100.0 and two years of service is 200.0", 200.0, c.getValue(), 0.00001);
			c.setScore(9998);
			assertEquals("Value for score 9998and two years of service is 19996", 19996.0, c.getValue(), 0.00001);
		}
		
		@Test
		public void test_updateYearsOfService_Default() {
			Employee c = new Employee('w',1.1);
			assertEquals("Without updates, expecting years of service to be zero.", 0, c.getYearsOfService());
		}

		@Test
		public void test_updateYearsOfService_OneCallToUpdate() {
			Employee c = new Employee('w',1.1);
			c.updateYearsOfService();
			assertEquals("With one update, expecting years of service to be 1.", 1, c.getYearsOfService());
		}

		@Test
		public void test_updateYearsOfService_MultipleCallsToUpdate() {
			Employee c = new Employee('w',1.1);
			c.updateYearsOfService();
			c.updateYearsOfService();
			c.updateYearsOfService();
			c.updateYearsOfService();
			c.updateYearsOfService();
			assertEquals("With five updates, expecting years of service to be 5.", 5, c.getYearsOfService());
		}

}
