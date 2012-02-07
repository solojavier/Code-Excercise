package solojavier.codeexercise.model;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.*;
import java.text.*;

public class PersonTests extends TestCase{

	private Properties properties;

	@Test
    public void testNewPersonCommaFile() throws ParseException  
    {
		List<String> lines = new ArrayList<String>();
		
		lines.add("Abercrombie");
		lines.add("Neil");
		lines.add("Male");
		lines.add("Tan");
		lines.add("2/13/1943");
		Person person = new Person(lines,"01243","M/dd/yyyy");		

		assertEquals(person.toString(),"Abercrombie Neil Male 2/13/1943 Tan");
    }
	
	@Test
    public void testNewPersonPipeFile() throws ParseException  
    {
		List<String> lines = new ArrayList<String>();
		
		lines.add("Smith");
		lines.add("Steve");
		lines.add("D");
		lines.add("M");
		lines.add("Red");
		lines.add("3-3-1985");
		Person person = new Person(lines,"01354","M-dd-yyyy");
		
		assertEquals(person.toString(),"Smith Steve Male 3/3/1985 Red");
    }
	
	@Test
    public void testNewPersonSpaceFile() throws ParseException  
    {
		List<String> lines = new ArrayList<String>();

		lines.add("Kournikova");
		lines.add("Anna");
		lines.add("F");
		lines.add("F");
		lines.add("6-3-1975");
		lines.add("Red");
		Person person = new Person(lines,"01345","M-dd-yyyy");
		
		assertEquals(person.toString(),"Kournikova Anna Female 6/3/1975 Red");
    }
	
	@Test
	public void testOrderPersonsGender()   
    {
		List<Person> persons = new ArrayList<Person>();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		
		person1.setGender("Male");
		person1.setLastName("person1");
		person2.setGender("Male");
		person2.setLastName("person2");
		person3.setGender("Female");
		person3.setLastName("person3");
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		Collections.sort(persons, new PersonGenderComparator());

		assertEquals(persons.get(0).getLastName(),"person3");
		assertEquals(persons.get(1).getLastName(),"person1");
		assertEquals(persons.get(2).getLastName(),"person2");
    }
	
	@Test
	public void testOrderPersonsDate()   
    {
		List<Person> persons = new ArrayList<Person>();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();
		
		person1.setDateOfBirth(new Date(300));
		person1.setLastName("person1");
		person2.setDateOfBirth(new Date(200));
		person2.setLastName("person2");
		person3.setDateOfBirth(new Date(100));
		person3.setLastName("person3");
		persons.add(person1);
		persons.add(person2);
		persons.add(person3);
		Collections.sort(persons, new PersonDateComparator());

		assertEquals(persons.get(0).getLastName(),"person3");
		assertEquals(persons.get(1).getLastName(),"person2");
		assertEquals(persons.get(2).getLastName(),"person1");
    }
	
	@Test
	public void testOrderPersonsLastName()   
    {
		List<Person> persons = new ArrayList<Person>();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();

		person1.setLastName("person1");
		person2.setLastName("person2");
		person3.setLastName("person3");
		persons.add(person3);
		persons.add(person2);
		persons.add(person1);
		Collections.sort(persons, new PersonLastNameComparator());

		assertEquals(persons.get(0).getLastName(),"person3");
		assertEquals(persons.get(1).getLastName(),"person2");
		assertEquals(persons.get(2).getLastName(),"person1");
    }
}
