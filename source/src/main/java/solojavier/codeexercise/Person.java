package solojavier.codeexercise;

import java.text.*;
import java.util.*;

/**
 * @author javier.cervantes
 *
 * This class represents a person.
 */
public class Person {
	
	private String 	lastName;
	private String 	firstName;
	private String 	gender;
	private Date 	dateOfBirth;
	private String 	favoriteColor;
    /* Comparators are part of the domain, which is good (instead of being in separate classes) */
	
	/**
	 * It can be used to sort persons by Gender (Female before Male), then Last Name ascending.
	 */
	static final Comparator<Person> GENDER_ORDER =
	    new Comparator<Person>() {
			public int compare(Person person1, Person person2) {
				int genderCompare = person1.getGender().compareTo(person2.getGender());
		        if (genderCompare != 0)
		            return genderCompare;
		        return (person1.getLastName().compareTo(person2.getLastName()));
			}
	};
	
	/**
	 * It can be used to sort persons by Date of Birth ascending, then Last Name ascending.
	 */
	static final Comparator<Person> DATE_ORDER =
	    new Comparator<Person>() {
			public int compare(Person person1, Person person2) {
				int dateCompare = person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
				if (dateCompare != 0)
		            return dateCompare;
		        return (person1.getLastName().compareTo(person2.getLastName()));
			}
	};

	/**
	 * It can be used to sort persons by Last Name descending.
	 */
	static final Comparator<Person> LAST_NAME_ORDER =
	    new Comparator<Person>() {
			public int compare(Person person1, Person person2) {
				return person2.getLastName().compareTo(person1.getLastName());
			}
	};

	Person(){
        /* on one hand, this will avoid nullPointers across the system. On the other hand, if you have millions
        of objects it will increment the amount of memory. A Null object pattern instead maybe?
         */
		lastName="";
		firstName="";
		gender="";
		dateOfBirth=new Date();
		favoriteColor="";
	}
	
	/**
	 * Allows to create a person by passing a list of values.
	 * To create insertOrder String you must consider: <br/>
	 * Consider the following positions:
	 * <ul>
	 * <li>lastName 		0</li>
	 * <li>fistName 		1</li>
	 * <li>gender 			2</li>
	 * <li>dateOfBirth 		3</li>
	 * <li>favoriteColor 	4</li>
	 * </ul>
	 * If elements are ordered you should use insertOrder="01234"
	 * 
	 * @param values	ArrayList<String> containing each person values
	 * @param insertOrder Contains position of elements to be inserted
	 * @param dateFormat Format used to parse dateOfBirth
	 */
	Person(ArrayList<String> values,String insertOrder,String dateFormat) throws ParseException {

		lastName = values.get(Character.getNumericValue(insertOrder.charAt(0)));
		firstName = values.get(Character.getNumericValue(insertOrder.charAt(1)));
		gender = values.get(Character.getNumericValue(insertOrder.charAt(2)));
		favoriteColor = values.get(Character.getNumericValue(insertOrder.charAt(4)));
		
		if(gender.equals("M")){
            /** Maybe an Enum or a couple of constants here for gender? */
			gender = "Male";
		}else if (gender.equals("F")){
			gender = "Female";
		}
		
        /* Putting so many sentences in a single line is potentially dangerous. How would you know for sure
        what was the problem if the program fails here? */
		dateOfBirth = (Date)new SimpleDateFormat(dateFormat).parse(values.get(Character.getNumericValue(insertOrder.charAt(3))));

	}
	
	public String toString(){
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
		return lastName + " " + firstName + " " + gender + " " + dateFormat.format( dateOfBirth ) + " " + favoriteColor;
	}
	
	public Date getDateOfBirth(){
		return dateOfBirth;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFavoriteColor() {
		return favoriteColor;
	}

	public void setFavoriteColor(String favoriteColor) {
		this.favoriteColor = favoriteColor;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLastName(){
		return lastName;
	}
	
	public String getGender(){
		return gender;
	}
}
