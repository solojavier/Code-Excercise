package solojavier.codeexercise;

import java.io.*;
import java.util.*;
import java.text.*;
import solojavier.utils.*;
import org.apache.log4j.*;

/**
 * @author javier.cervantes
 *
 * Program that builds a master list of people from three data files, 
 * then prints it to console, sorted in three different ways.
 * 
 */
public class CodeExercise {

	private static final String PROP_FILE = "/codeexercise.properties";

	private Properties properties;
	private Logger logger;

	public CodeExercise(){
		logger = Logger.getRootLogger();
		try{
			properties = FileUtils.readPropertiesFile(PROP_FILE);
		}catch (IOException e){
			logger.error("Problem occureed loading properties file: "+PROP_FILE);
		}
		
	}
	
	public static void main (String args[]) {
		new CodeExercise().run();
	}
	
	/**
	 * Entry point for the application. Iterates over defined "InputFiles"
	 * to get the persons listed and add them to a persons list.
	 * Finally it outputs the list of persons in outputFile.
	 * 
	 * @see InputFiles
	 */
	public void run() {
	
		List<Person> persons = new ArrayList<Person>();
		String inputPath = properties.getProperty("input.path");
		String[] filename = properties.getProperty("input.files").split(" ");
		String[] delimiter = properties.getProperty("input.delimiter").split(" ");
		String[] dateFormat = properties.getProperty("input.dateformat").split(" ");
		String[] order = properties.getProperty("input.order").split(" ");

		for(int i=0; i<filename.length;i++){
			try{
				List<String> lines = FileUtils.getLines(inputPath+"/"+filename[i]);
			
				for(String line : lines){
					//TODO - Al hacer el split, falta hacer un trim a cada valor (de momento se encuentra en person)
					List<String> values =  Arrays.asList(line.split(delimiter[i]));
					persons.add(new Person(values,order[i],dateFormat[i]));			
				}
			}catch(FileNotFoundException e){
				logger.error("File not found was skipped: "+inputPath);
			}catch (ParseException e){
				logger.error("There was an error parsing dates in file: "+inputPath);
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
			String outputFile = properties.getProperty("output.file");
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
