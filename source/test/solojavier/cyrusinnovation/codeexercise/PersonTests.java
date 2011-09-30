package solojavier.cyrusinnovation.codeexercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import org.junit.Test;

import junit.framework.TestCase;

public class PersonTests extends TestCase{
	
	@Test
    public void testNewPersonCommaFile()   
    {
		ArrayList<String> lines = new ArrayList<String>();
		
		lines.add("Abercrombie");
		lines.add("Neil");
		lines.add("Male");
		lines.add("Tan");
		lines.add("2/13/1943");
		Person person = new Person(lines,InputFiles.COMMA.getOrder(),InputFiles.COMMA.getDateFormat());		
		
		assertEquals(person.toString(),"Abercrombie Neil Male 2/13/1943 Tan");
    }
	
	@Test
    public void testNewPersonPipeFile()   
    {
		ArrayList<String> lines = new ArrayList<String>();
		
		lines.add("Smith");
		lines.add("Steve");
		lines.add("D");
		lines.add("M");
		lines.add("Red");
		lines.add("3-3-1985");
		Person person = new Person(lines,InputFiles.PIPE.getOrder(),InputFiles.PIPE.getDateFormat());
		
		assertEquals(person.toString(),"Smith Steve Male 3/3/1985 Red");
    }
	
	@Test
    public void testNewPersonSpaceFile()   
    {
		ArrayList<String> lines = new ArrayList<String>();

		lines.add("Kournikova");
		lines.add("Anna");
		lines.add("F");
		lines.add("F");
		lines.add("6-3-1975");
		lines.add("Red");
		Person person = new Person(lines,InputFiles.SPACE.getOrder(),InputFiles.SPACE.getDateFormat());
		
		assertEquals(person.toString(),"Kournikova Anna Female 6/3/1975 Red");
    }
	
	@Test
	public void testOrderPersonsGender()   
    {
		ArrayList<Person> persons = new ArrayList<Person>();
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
		Collections.sort(persons, Person.GENDER_ORDER);

		assertEquals(persons.get(0).getLastName(),"person3");
		assertEquals(persons.get(1).getLastName(),"person1");
		assertEquals(persons.get(2).getLastName(),"person2");
    }
	
	@Test
	public void testOrderPersonsDate()   
    {
		ArrayList<Person> persons = new ArrayList<Person>();
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
		Collections.sort(persons, Person.DATE_ORDER);

		assertEquals(persons.get(0).getLastName(),"person3");
		assertEquals(persons.get(1).getLastName(),"person2");
		assertEquals(persons.get(2).getLastName(),"person1");
    }
	
	@Test
	public void testOrderPersonsLastName()   
    {
		ArrayList<Person> persons = new ArrayList<Person>();
		Person person1 = new Person();
		Person person2 = new Person();
		Person person3 = new Person();

		person1.setLastName("person1");
		person2.setLastName("person2");
		person3.setLastName("person3");
		persons.add(person3);
		persons.add(person2);
		persons.add(person1);
		Collections.sort(persons, Person.LAST_NAME_ORDER);

		assertEquals(persons.get(0).getLastName(),"person3");
		assertEquals(persons.get(1).getLastName(),"person2");
		assertEquals(persons.get(2).getLastName(),"person1");
    }
}
