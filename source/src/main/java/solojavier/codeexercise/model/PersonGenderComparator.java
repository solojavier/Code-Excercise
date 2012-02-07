package solojavier.codeexercise.model;

import java.util.Comparator;

/**
* @author javier.cervantes
* 
* This class can be used to sort persons by Gender (Female before Male), then Last Name ascending.
*/
public class PersonGenderComparator implements Comparator<Person> {	

	public int compare(Person person1, Person person2) {
		int genderCompare = person1.getGender().compareTo(person2.getGender());
        if (genderCompare != 0)
            return genderCompare;
        return (person1.getLastName().compareTo(person2.getLastName()));
	}
}