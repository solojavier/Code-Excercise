package solojavier.codeexercise.model;

import java.util.Comparator;

/**
* @author javier.cervantes
* 
* This class can be used to sort persons by Last Name descending.
*/
public class PersonLastNameComparator implements Comparator<Person> {

	public int compare(Person person1, Person person2) {
		return person2.getLastName().compareTo(person1.getLastName());
	}
}