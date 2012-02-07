package solojavier.codeexercise.model;

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

	public Person(){
        /* on one hand, this will avoid nullPointers across the system. On the other hand, if you have millions
        of objects it wiiill increment the amount of memory. A Null object pattern instead maybe?
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
	public Person(List<String> values,String insertOrder,String dateFormat) throws ParseException {

		lastName = values.get(Character.getNumericValue(insertOrder.charAt(0))).trim();
		firstName = values.get(Character.getNumericValue(insertOrder.charAt(1))).trim();
		gender = values.get(Character.getNumericValue(insertOrder.charAt(2))).trim();
		favoriteColor = values.get(Character.getNumericValue(insertOrder.charAt(4))).trim();
		
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
