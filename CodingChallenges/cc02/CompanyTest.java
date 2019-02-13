import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class CompanyTest {

		@Test
		public void test_ConstructorAndGetter() {
			Company c = new Company("Test Constructor and Getter");
			assertEquals("Testing constructor and getter", "Test Constructor and Getter", c.getName());
		}

		@Test
		public void test_addEmployee_addingOne() {
			Company c = new Company("Test");
			Employee m = new Employee('x',2.0);
			c.addEmployee(m);
			ArrayList<Employee> list = c.getEmployeeList();
			Employee m2 = null;

			if (list.size() > 0){
				m2 = list.get(0);
			}


			assertEquals("Company only has one employee ('x',2.0) - testing size.", 1, list.size());
			assertEquals("Company only has one employee ('x',2.0) - testing rank.", 'x', m2.getRank());
			assertEquals("Company only has one employee ('x',2.0)- testing score.", 2.0, m2.getScore(), 0.00001);
		}

		@Test
		public void test_addEmployee_addingMany() {
			Company c = new Company("Test");
			Employee m1 = new Employee('x',100);
			Employee m2 = new Employee('m',20000);
			Employee m3 = new Employee('e',5);
			Employee m4 = new Employee('u',2000);
			Employee m5 = new Employee('m',2001);
			Employee m6 = new Employee('e',49);
			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			ArrayList<Employee> list = c.getEmployeeList();

			assertEquals("Expected list of size 6 after adding 6 employees", 6, list.size());
			assertEquals("Employee 1 test - testing rank", 'x', list.get(0).getRank());
			assertEquals("Employee 2 test - testing rank", 'm', list.get(1).getRank());
			assertEquals("Employee 3 test - testing rank", 'e', list.get(2).getRank());
			assertEquals("Employee 4 test - testing rank", 'u', list.get(3).getRank());
			assertEquals("Employee 5 test - testing rank", 'm', list.get(4).getRank());
			assertEquals("Employee 6 test - testing rank", 'e', list.get(5).getRank());
		}

		@Test
		public void test_addEmployee_addingOne_EncapsulationTest() {
			Company c = new Company("Test");
			Employee m = new Employee('u',41);
			c.addEmployee(m);
			m.setRank('e');
			ArrayList<Employee> list = c.getEmployeeList();
			Employee m2 = null;

			if (list.size() > 0){
				m2 = list.get(0);
			}

			assertEquals("Company only has one employee ('u',41)- testing encapsulation (changed rank of original).", 'u', m2.getRank());

		}

		@Test
		public void test_getEmployeeList_Encapsulation() {
			Company c = new Company("Test");
			Employee m1 = new Employee('m',100);
			Employee m2 = new Employee('m',20000);
			Employee m3 = new Employee('u',5);
			Employee m4 = new Employee('e',2000);
			Employee m5 = new Employee('e',2001);
			Employee m6 = new Employee('x',49);
			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			ArrayList<Employee> list = c.getEmployeeList();

			list.get(0).setRank('e');
			list.get(1).setRank('e');
			list.get(2).setRank('e');
			list.get(3).setRank('x');
			list.get(4).setRank('u');
			list.get(5).setRank('u');

			list = c.getEmployeeList();


			assertEquals("Employee 1 test - testing rank", 'm', list.get(0).getRank());
			assertEquals("Employee 2 test - testing rank", 'm', list.get(1).getRank());
			assertEquals("Employee 3 test - testing rank", 'u', list.get(2).getRank());
			assertEquals("Employee 4 test - testing rank", 'e', list.get(3).getRank());
			assertEquals("Employee 5 test - testing rank", 'e', list.get(4).getRank());
			assertEquals("Employee 6 test - testing rank", 'x', list.get(5).getRank());

		}

		@Test
		public void test_GetBestEmployee_emptyList() {
			Company c = new Company("test");
			assertEquals("No employees added to list.", null, c.getBestEmployee());
		}

		@Test
		public void test_GetBestEmployee_OneEmployeeInCompany() {
			Company c = new Company("test");
			Employee m = new Employee('x',55);
			c.addEmployee(m);
			Employee highest = c.getBestEmployee();
			assertEquals("Company only has one employee ('x',55) - testing rank.", 'x', highest.getRank());
			assertEquals("Company only has one employee ('x',55)- testing score.", 55, highest.getScore(), 0.000001);
		}

		@Test
		public void test_GetBestEmployee_ListHasTwoEmployeesWithSameValue() {
			Company c = new Company("test");
			Employee m1 = new Employee('x',100);
			m1.updateYearsOfService();
			Employee m2 = new Employee('e',50);
			m2.updateYearsOfService();
			m2.updateYearsOfService();
			c.addEmployee(m1);
			c.addEmployee(m2);

			Employee highest = c.getBestEmployee();

			assertEquals("Company only has two employees with same value, expected to get first ('x',100) - testing rank.", 'x', highest.getRank());
			assertEquals("Company only has two employees with same value, expected to get first added ('x',100) - testing score.", 100, highest.getScore(), 0.000001);
		}

		@Test
		public void test_GetBestEmployee_highestValueInMiddle() {
			Company c = new Company("test");
			Employee m1 = new Employee('e', 6);
			m1.updateYearsOfService();
			Employee m2 = new Employee('m', 5);
			m2.updateYearsOfService();
			m2.updateYearsOfService();
			Employee m3 = new Employee('u', 1);
			m3.updateYearsOfService();
			m3.updateYearsOfService();
			m3.updateYearsOfService();

			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);

			Employee highest = c.getBestEmployee();

			assertEquals("Company has three employees with highest value in middle ('m',5) - testing rank.", 'm', highest.getRank());
			assertEquals("Company has three employees with highest value in middle ('m',5)- testing score.", 5, highest.getScore(), 0.000001);
		}

		@Test
		public void test_GetBestEmployee_LastHasHighest() {
			Company c = new Company("test");
			Employee m1 = new Employee('u', 1);
			m1.updateYearsOfService();
			m1.updateYearsOfService();
			Employee m2 = new Employee('u', 2);
			m2.updateYearsOfService();
			m2.updateYearsOfService();
			m2.updateYearsOfService();
			Employee m3 = new Employee('m', 3);
			Employee m4 = new Employee('e', 5);
			m4.updateYearsOfService();
			Employee m5 = new Employee('e', 6);
			Employee m6 = new Employee('x', 1);
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();
			m6.updateYearsOfService();

			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			Employee highest = c.getBestEmployee();

			assertEquals("Company has many employees with highest value at end ('x',1) - testing rank.", 'x', highest.getRank());
			assertEquals("Company has many employees with highest value at end ('x',1)- testing score.", 1, highest.getScore(), 0.000001);

			highest.setRank('m');
			Employee b = c.getEmployeeList().get(5);

			assertEquals("Company has many employees with highest value at end ('x',10)- testing encapsulation.", 'x', b.getRank());
		}

		@Test
		public void test_getBestEmployeeByRank_emptyList() {
			Company c = new Company("test");
			assertEquals("No employees added to list.", null, c.getBestEmployeeByRank('e'));
		}

		@Test
		public void test_getBestEmployeeByRank_noneOfrankTypeInList() {
			Company c = new Company("test");
			Employee m1 = new Employee('e', 1);
			Employee m2 = new Employee('e', 2);
			Employee m3 = new Employee('u', 3);
			Employee m4 = new Employee('e', 5);
			Employee m5 = new Employee('u', 9);
			Employee m6 = new Employee('x', 10);
			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			assertEquals("No 'w' employee in the list.", null, c.getBestEmployeeByRank('m'));
		}

		@Test
		public void test_getBestEmployeeByRank_oneOfrankTypeInList() {
			Company c = new Company("test");
			Employee m1 = new Employee('e', 10);
			Employee m2 = new Employee('x', 2);
			Employee m3 = new Employee('x', 3);
			Employee m4 = new Employee('e', 2);
			Employee m5 = new Employee('u', 9);
			Employee m6 = new Employee('m', 10);
			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			Employee best = c.getBestEmployeeByRank('m');
			assertEquals("Only 1 'm' employee in the list - testing rank.", 'm', best.getRank());
			assertEquals("Only 1 'em' employee in the list - testing score.", 10, best.getScore(), 0.000001);
		}


		@Test
		public void test_getBestEmployeeByRank_oneOfrankTypeInList_encapsulationTest() {
			Company c = new Company("test");
			Employee m1 = new Employee('e', 10);
			Employee m2 = new Employee('x', 2);
			Employee m3 = new Employee('x', 3);
			Employee m4 = new Employee('e', 2);
			Employee m5 = new Employee('u', 9);
			Employee m6 = new Employee('m', 10);
			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			Employee best = c.getBestEmployeeByRank('m');
			assertEquals("Only 1 'm' employee in the list - testing rank.", 'm', best.getRank());
			assertEquals("Only 1 'm' employee in the list - testing score.", 10, best.getScore(), 0.000001);

			best.setScore(11);
			assertEquals("Testing encapsulation - Tried to update score through object returned by method.", 10, m6.getScore(), 0.000001);
		}


		@Test
		public void test_getBestEmployeeByRank_ManyOfrankType() {
			Company c = new Company("test");
			Employee m1 = new Employee('m', 10);
			m1.updateYearsOfService();
			m1.updateYearsOfService();
			Employee m2 = new Employee('e', 2);
			m2.updateYearsOfService();
			m2.updateYearsOfService();
			m2.updateYearsOfService();
			Employee m3 = new Employee('x', 3);
			m3.updateYearsOfService();
			m3.updateYearsOfService();
			Employee m4 = new Employee('e', 5);
			m4.updateYearsOfService();
			Employee m5 = new Employee('e', 9);
			m5.updateYearsOfService();
			m5.updateYearsOfService();
			m5.updateYearsOfService();
			Employee m6 = new Employee('e', 10);
			m6.updateYearsOfService();
			m6.updateYearsOfService();

			c.addEmployee(m1);
			c.addEmployee(m2);
			c.addEmployee(m3);
			c.addEmployee(m4);
			c.addEmployee(m5);
			c.addEmployee(m6);

			Employee best = c.getBestEmployeeByRank('e');
			assertEquals("Second to last 'e' employee in the list has highest value- testing rank.", 'e', best.getRank());
			assertEquals("Second to last 'e' employee in the list has highest value - testing score.", 9, best.getScore(), 0.000001);
		}

}
