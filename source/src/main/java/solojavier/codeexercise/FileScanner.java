package solojavier.codeexercise;

import java.io.*;
import java.util.*;
import org.apache.log4j.*;

/**
 * @author javier.cervantes
 *
 * This class provides basic operations to read file contents
 */
public class FileScanner {
  
  private final File file;

  private Logger logger;
	
  public FileScanner(String fileName){ 
    logger = Logger.getRootLogger();
    file = new File(fileName);  
  }
  
 /**
 * Iterates over file getting each line and storing it in a list.
 * If file is not found, returns an empty list.
 * 
 * @return ArrayList<String> List with lines contained in file
 */
public ArrayList<String> getLines() {
    
	ArrayList<String> linesList = new ArrayList<String>();
	Scanner scanner = null;
	try{  
	  scanner = new Scanner(new FileReader(file));
      while ( scanner.hasNextLine() ){
    	  linesList.add(scanner.nextLine());
      }
      return linesList;
    }catch(FileNotFoundException e){
        /* Maybe this should just fail and let the implementer to handle this? */
    	logger.error("File not found: " + file.getName());
    	return linesList;
    }
    finally {
      /* If the scanner was never initialized, this will throw a NPE */
      scanner.close();
    }
  }
}