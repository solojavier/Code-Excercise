package solojavier.codeexercise;

import java.io.*;
import java.util.*;
import java.text.*;
import org.apache.log4j.*;

/**
 * @author javier.cervantes
 *
 * Program that builds a master list of people from three data files, 
 * then prints it to console, sorted in three different ways.
 * 
 */
public class CodeExercise {

    /* This should be externalized so that it can be configurable without recompiling*/
	public static final String outputFile = "output_files\\model_output.txt";

	private Logger logger;

	public CodeExercise(){
		logger = Logger.getRootLogger();
	}
	
	public static void main (String args[]) throws ParseException {
		new CodeExercise().run();
	}
	
	/**
	 * Entry point for the application. Iterates over defined "InputFiles"
	 * to get the persons listed and add them to a persons list.
	 * Finally it outputs the list of persons in outputFile.
	 * 
	 * @see InputFiles
	 */
	public void run() throws ParseException {
	
		List<Person> persons = new ArrayList<Person>();
		
		for (InputFiles file : InputFiles.values()) {
			
			FileScanner scanner = new FileScanner(file.getPath());
			ArrayList<String> lines = scanner.getLines();
			
			for(String line : lines){
				List<String> values =  Arrays.asList(line.split(file.getDelimiter()));
				persons.add(new Person(values,file.getOrder(),file.getDateFormat()));			
			}
		}
		writeOutputFile(persons);
		logger.info("Done.");
	}
	
	/**
	 * Takes the list of persons and outputs them in file
	 * sorted them in 3 different ways defined in Person class.
	 * 
	 * @see Person
	 * @param persons list of persons to write in file
	 */
	public void writeOutputFile(List<Person> persons){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
		    out.write("Output 1:\n");
			Collections.sort(persons, Person.GENDER_ORDER);
			for (Person person : persons){
				out.write(person.toString()+"\n");
			}
			out.write("\n");
			out.write("Output 2:\n");
			Collections.sort(persons, Person.DATE_ORDER);
			for (Person person : persons){
				out.write(person.toString()+"\n");
			}
			out.write("\n");
			out.write("Output 3:\n");
			Collections.sort(persons, Person.LAST_NAME_ORDER);
			for (Person person : persons){
				out.write(person.toString()+"\n");
			}
			out.write("\n");
			out.close();
		} catch (IOException e) {
			logger.error("Error writting output file");
		}
	}
}
