import static org.junit.Assert.*;

import org.junit.Test;

public class CombatAircraftTest extends FormatTester{

	public static final String CLASSNAME = "CombatAircraft";

	public CombatAircraftTest() {
		super(CLASSNAME, false);
	}

	private void testClassDefinition(){
		String[] instanceVars = {"String type"};
		assertTrue("Instance variables should be private with correct name and type.", instanceVariablesArePrivate(instanceVars));

		assertTrue("Class should not have the default constructor.", noDefaultConstructor());
		assertFalse("Should not override getSpeed.", hasMethod("int getSpeed"));
		assertFalse("Should not override toString.", hasMethod("String toString"));
	}

	// Testing constructors

	@Test
	public void test_Constructor_Attack() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Attack");
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing name", "mirage", v.getName());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing origin", "FRANCE", v.getOrigin());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing speed", 300, v.getSpeed());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing type", "Attack", v.getType());
	}

	@Test
	public void test_Constructor_Interceptor() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Interceptor");
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing name", "mirage", v.getName());
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing origin", "FRANCE", v.getOrigin());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing speed", 300, v.getSpeed());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing type", "Interceptor", v.getType());
	}

	@Test
	public void test_Constructor_Fighter() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Fighter");
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing name", "mirage", v.getName());
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing origin", "FRANCE", v.getOrigin());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing speed", 300, v.getSpeed());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing type", "Fighter", v.getType());
	}

	@Test
	public void test_Constructor_InvalidType() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Other");
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing name", "mirage", v.getName());
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing origin", "FRANCE", v.getOrigin());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing speed", 300, v.getSpeed());
		assertNull("Created CombatAircraft with invalid type, expecting type to be null", v.getType());
	}


	@Test
	public void test_Constructor_nullType() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, null);
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing name", "mirage", v.getName());
		assertEquals("Created CombatAircraft with 'mirage' name 'france' origin and speed 300 - testing origin", "FRANCE", v.getOrigin());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing speed", 300, v.getSpeed());
		assertNull("Created CombatAircraft with null type, expecting type to be null", v.getType());
	}

	@Test 
	public void test_CopyConstructor_Attack() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("name1", "TEST1", 300, "Attack");
		CombatAircraft v2 = new CombatAircraft(v);
		assertEquals("Testing Copy Constructor, copying 'name1' name, 'TEST1' origin and speed 300 - testing name", "name1", v2.getName());
		assertEquals("Testing Copy Constructor, copying 'name1' name, 'TEST1' origin and speed 300 - testing origin", "TEST1", v2.getOrigin());
		assertEquals("Testing Copy Constructor, copying 'name1' name, 'TEST2' Copy Constructor' origin and speed 300 - testing speed", 300, v2.getSpeed());
		assertEquals("Created CombatAircraft with 'mirage' name, 'france' origin and speed 300 - testing type", "Attack", v2.getType());
	}

	@Test 
	public void test_CopyConstructor_null() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("NAME2", "Test2", 200, null);
		CombatAircraft v2 = new CombatAircraft(v);
		assertEquals("Testing Copy Constructor, copying 'NAME2' name 'Test2' origin and speed 200 - testing name", "name2", v2.getName());
		assertEquals("Testing Copy Constructor, copying 'NAME2' name 'Test2' origin and speed 200 - testing origin", "TEST2", v2.getOrigin());
		assertEquals("Testing Copy Constructor, copying 'NAME2' name, 'Test2' origin and speed 200 - testing speed", 200, v2.getSpeed());
		assertNull("Testing Copy Constructor with null type, expecting copy type to be null", v2.getType());
	}


	// Testing setter and getters

	@Test
	public void test_setter_and_getter_type_Attack(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, null);
		v.setType("Attack");
		assertEquals("Changed type from null to Attack", "Attack", v.getType());
	}
	
	@Test
	public void test_setter_and_getter_type_Interceptor(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Attack");
		v.setType("Interceptor");
		assertEquals("Changed type from Attack to Interceptor", "Interceptor", v.getType());
	}
	
	@Test
	public void test_setter_and_getter_type_Fighter(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Attack");
		v.setType("Fighter");
		assertEquals("Changed type from Attack", "Fighter", v.getType());
	}
	
	@Test
	public void test_setter_and_getter_type_Invalid(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Fighter");
		v.setType("Something");
		assertNull("Changed type from Fighter to some invalid type", v.getType());
	}
	
	@Test
	public void test_setter_and_getter_type_null(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Interceptor");
		v.setType(null);
		assertNull("Changed type to null", v.getType());
	}


	@Test
	public void getAircraftCategoryBySpeed_Attack() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("Saab", "Sweden", 100, "Attack");
		v.setSpeed(200);
		assertEquals("Cateory for A aircraft is B for Attack", 'B', v.getAircraftCategoryBySpeed());
		v.setSpeed(600);
		assertEquals("Cateory for B aircraft is C for Attack", 'C', v.getAircraftCategoryBySpeed());
		v.setSpeed(1000);
		assertEquals("Cateory for C aircraft is D for Attack", 'D', v.getAircraftCategoryBySpeed());
	}
	
	@Test
	public void getAircraftCategoryBySpeed_Interceptor() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("Saab", "Sweden", 100, "Interceptor");
		v.setSpeed(200);
		assertEquals("Cateory for A aircraft is D for Interceptor", 'D', v.getAircraftCategoryBySpeed());
		v.setSpeed(600);
		assertEquals("Cateory for B aircraft is A for Interceptor", 'A', v.getAircraftCategoryBySpeed());
		v.setSpeed(1000);
		assertEquals("Cateory for C aircraft is B for Interceptor", 'B', v.getAircraftCategoryBySpeed());
	}
	
	@Test
	public void getAircraftCategoryBySpeed_Fighter() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("Saab", "Sweden", 100, "Fighter");
		v.setSpeed(200);
		assertEquals("Cateory for A aircraft is B for Fighter", 'B', v.getAircraftCategoryBySpeed());
		v.setSpeed(600);
		assertEquals("Cateory for B aircraft is D for Fighter", 'D', v.getAircraftCategoryBySpeed());
		v.setSpeed(1000);
		assertEquals("Cateory for C aircraft is A for Fighter", 'A', v.getAircraftCategoryBySpeed());
	}
	
	@Test
	public void getAircraftCategoryBySpeed_nullType() {
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("Saab", "Sweden", 0, null);
		v.setSpeed(200);
		assertEquals("Category for A aircraft remains A without type", 'A', v.getAircraftCategoryBySpeed());
		v.setSpeed(600);
		assertEquals("Category for B aircraft remains B without type", 'B', v.getAircraftCategoryBySpeed());
		v.setSpeed(1000);
		assertEquals("Category for C aircraft remains C without type", 'C', v.getAircraftCategoryBySpeed());
	}


	// checking that toString uses overridden method (it is not overridden).
	@Test
	public void test_toString(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("mirage", "france", 300, "Attack");
		assertEquals("Testing toString for aircraft with mirage name, france origin and 300 speed and Attack type",
				"Name: mirage Origin: FRANCE Aircraft Category: B", v.toString());
	}

	@Test
	public void test_toString2(){
		testClassDefinition();
		CombatAircraft v = new CombatAircraft("Saab", "Sweden", 1500, "Fighter");
		assertEquals("Testing toString for aircraft with Saab name, Sweden origin and 500 speed and Fighter type",
				"Name: saab Origin: SWEDEN Aircraft Category: A", v.toString());
	}

}
