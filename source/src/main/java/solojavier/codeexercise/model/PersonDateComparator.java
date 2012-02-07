package solojavier.codeexercise.model;

import java.util.Comparator;

/**
* @author javier.cervantes
* 
* This class can be used to sort persons by Date of Birth ascending, then Last Name ascending.
*/
public class PersonDateComparator implements Comparator<Person> {
	
	public int compare(Person person1, Person person2) {
		int dateCompare = person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
		if (dateCompare != 0)
            return dateCompare;
        return (person1.getLastName().compareTo(person2.getLastName()));
	}
}