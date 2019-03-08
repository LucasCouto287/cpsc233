import static org.junit.Assert.*;
import org.junit.Test;

public class AircraftTest extends FormatTester{

	public static final String CLASSNAME = "Aircraft";

	public AircraftTest() {
		super(CLASSNAME, false);
	}

	private void testClassDefinition(){
		String[] instanceVars = {"String name", "String origin", "int speed"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
	}

		// Testing constructors

		@Test
		public void test_Constructor_EmptyStringAnd0() {
			Aircraft v = new Aircraft("","", 0);
			assertEquals("Created Aircraft with empty name, empty origin and speed 0 - testing name", "", v.getName());
			assertEquals("Created Aircraft with empty name, empty origin and speed 0 - testing origin", "", v.getOrigin());
			assertEquals("Created Aircraft with empty name, empty origin and speed 0 - testing speed", 0, v.getSpeed());
		}

		@Test
		public void test_Constructor_AllLowerCaseAnd300() {
			Aircraft v = new Aircraft("mirage", "france", 300);
			assertEquals("Created Aircraft with 'mirage' name 'france' origin and speed 300 - testing name", "mirage", v.getName());
			assertEquals("Created Aircraft with 'mirage' name 'france' origin and speed 300 - testing origin", "FRANCE", v.getOrigin());
			assertEquals("Created Aircraft with 'mirage' name, 'france' origin and speed 300 - testing speed", 300, v.getSpeed());
		}

		@Test
		public void test_Constructor_AllUpperCaseAndNegative() {
			Aircraft v = new Aircraft("SAAB", "SWEDEN", -1);
			assertEquals("Created Aircraft with 'SAAB' name, 'SWEDEN' origin and speed -1 - testing name", "saab", v.getName());
			assertEquals("Created Aircraft with 'SAAB' name, 'SWEDEN' origin and speed -1 - testing origin", "SWEDEN", v.getOrigin());
			assertEquals("Created Aircraft with 'SAAB' name, 'SWEDEN' origin and speed -1 - testing speed", 0, v.getSpeed());
		}

		@Test
		public void test_Constructor_MixedCase() {
			Aircraft v = new Aircraft("Mirage", "France", 350);
			assertEquals("Created Aircraft with 'Mirage' name, 'France' origin and speed 350 - testing name", "mirage", v.getName());
			assertEquals("Created Aircraft with 'Mirage' name, 'France' origin and speed 350 - testing origin", "FRANCE", v.getOrigin());
			assertEquals("Created Aircraft with 'Mirage' name, 'France' origin and speed 350 - testing speed", 350, v.getSpeed());
		}

		@Test
		public void test_CopyConstructor() {
			Aircraft v = new Aircraft("name1", "TEST1", 100);
			Aircraft v2 = new Aircraft(v);
			assertEquals("Testing Copy Constructor, copying 'name1' name, 'TEST1' origin and speed 100 - testing name", "name1", v2.getName());
			assertEquals("Testing Copy Constructor, copying 'name1' name, 'TEST1' origin and speed 100 - testing origin", "TEST1", v2.getOrigin());
			assertEquals("Testing Copy Constructor, copying 'name1' name, 'TEST1' Copy Constructor' origin and speed 100 - testing speed", 100, v2.getSpeed());
		}

		@Test
		public void test_CopyConstructor2() {
			Aircraft v = new Aircraft("NAME2", "Test2", 200);
			Aircraft v2 = new Aircraft(v);
			assertEquals("Testing Copy Constructor, copying 'NAME2' name 'Test2' origin and speed 200 - testing name", "name2", v2.getName());
			assertEquals("Testing Copy Constructor, copying 'NAME2' name 'Test2' origin and speed 200 - testing origin", "TEST2", v2.getOrigin());
			assertEquals("Testing Copy Constructor, copying 'NAME2' name, 'Test2' origin and speed 200 - testing speed", 200, v2.getSpeed());
		}



	// Testing setter and getters

		@Test
		public void test_setter_and_getter_origin_emptyString(){
			Aircraft v = new Aircraft("Test", "TestEmptyString", 700);
			v.setOrigin("");
			assertEquals("Set origin to empty string", "", v.getOrigin());
		}

		@Test
		public void test_setter_and_getter_origin_allLowerCase(){
			Aircraft v = new Aircraft("Test", "TestAllLowerCase", 200);
			v.setOrigin("france");
			assertEquals("Set origin to 'france'", "FRANCE", v.getOrigin());
		}

		@Test
		public void test_setter_and_getter_origin_allUpperCase(){
			Aircraft v = new Aircraft("Test", "TestAllUpperCase", 140);
			v.setOrigin("USA");
			assertEquals("Set origin to 'USA'", "USA", v.getOrigin());
		}

		@Test
		public void test_setter_and_getter_origin_MixedCase(){
			Aircraft v = new Aircraft("Test", "TestMixedCase", 100);
			v.setOrigin("Germany");
			assertEquals("Set origin to 'GERMANY'", "GERMANY", v.getOrigin());
		}

		@Test
		public void test_setter_and_getter_name_emptyString(){
			Aircraft v = new Aircraft("TestEmptyString", "TestEmptyString", 700);
			v.setName("");
			assertEquals("Set name to empty string", "", v.getName());
		}

		@Test
		public void test_setter_and_getter_name_allLowerCase(){
			Aircraft v = new Aircraft("TestAllLowerCase", "TestAllLowerCase", 200);
			v.setName("cobra");
			assertEquals("Set name to 'cobra'", "cobra", v.getName());
		}

		@Test
		public void test_setter_and_getter_name_allUpperCase(){
			Aircraft v = new Aircraft("TestAllUpperCase", "TestAllUpperCase", 140);
			v.setName("COBRA");
			assertEquals("Set name to 'COBRA'", "cobra", v.getName());
		}

		@Test
		public void test_setter_and_getter_name_MixedCase(){
			Aircraft v = new Aircraft("TestMixedCase", "TestMixedCase", 100);
			v.setName("Fighting Falcon");
			assertEquals("Set name to 'Fighting Falcon'", "fighting falcon", v.getName());
		}

		@Test
		public void test_setter_and_getter_speed_three_hundard() {
			Aircraft v = new Aircraft("testone", "TestOneSpeed", 500);
			v.setSpeed(300);
			assertEquals("Set speed to three hundard.", 300, v.getSpeed());
		}

		@Test
		public void test_setter_and_getter_speed_four_fifty() {
			Aircraft v = new Aircraft("TestTen", "TestTenSpeed", 170);
			v.setSpeed(450);
			assertEquals("Set speed to four hundard and fifty.", 450, v.getSpeed());
		}

		@Test
		public void test_setter_and_getter_speed_negative() {
			Aircraft v = new Aircraft("TestNegative", "TestNegativeSpeed", 375);
			v.setSpeed(-1);
			assertEquals("Set speed to a negative number that was initialized to 375.", 375, v.getSpeed());
		}

		@Test
		public void test_getAircraftCategoryBySpeed_A() {
			Aircraft v = new Aircraft("name", "origin", 0);
			v.setSpeed(450);
			assertEquals("Category for speed 450 is A", 'A', v.getAircraftCategoryBySpeed());

		}

		@Test
		public void test_getAircraftCategoryBySpeed_B() {
			Aircraft v = new Aircraft("name", "origin", 0);
			v.setSpeed(551);
			assertEquals("Category for speed 550 is B", 'B', v.getAircraftCategoryBySpeed());
			v.setSpeed(749);
			assertEquals("Category for speed 749 is B", 'B', v.getAircraftCategoryBySpeed());

		}

		@Test
		public void test_getAircraftCategoryBySpeed_C() {
			Aircraft v = new Aircraft("name", "origin", 0);
			v.setSpeed(800);
			assertEquals("Category for speed 800 is C", 'C', v.getAircraftCategoryBySpeed());
			v.setSpeed(2000);
			assertEquals("Category for speed 2000 is C", 'C', v.getAircraftCategoryBySpeed());
		}

		@Test
		public void test_toString(){
		testClassDefinition();
		Aircraft v = new Aircraft("mirage", "france", 300);
		assertEquals("Testing toString for Aircraft with mirage name, france country and 300 speed",
				"Name: mirage Origin: FRANCE Aircraft Category: A", v.toString());
		}

		@Test
		public void test_toString2(){
		testClassDefinition();
		Aircraft v = new Aircraft("saab", "Sweden", 2000);
		assertEquals("Testing toString for Aircraft with saab name, Sweden country and 2000 speed",
				"Name: saab Origin: SWEDEN Aircraft Category: C", v.toString());
		}

	}
