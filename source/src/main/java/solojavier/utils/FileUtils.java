package solojavier.utils;

import java.io.*;
import java.util.*;

/**
 * @author javier.cervantes
 *
 * This class provides basic operations to read file contents
 */
public abstract class FileUtils {
  
 /**
 * Iterates over file getting each line and storing it in a list.
 * If file is not found, returns an empty list.
 * @throws FileNotFoundException
 * 
 * @return ArrayList<String> List with lines contained in file
 */
  public static List<String> getLines(String fileName) throws FileNotFoundException{
    
  	List<String> linesList = new ArrayList<String>();
  	Scanner scanner = null;

    File file = new File(fileName);
  	scanner = new Scanner(new FileReader(file));
     
    while (scanner.hasNextLine()){
      linesList.add(scanner.nextLine());
    }
     
    scanner.close();
    return linesList;
  }

 /**
 * Reads properties file contents
 * 
 * @return Properties object with properties read
 * @throws IOException
 */
  public static Properties readPropertiesFile(String fileName) throws IOException{  
     InputStream inputStream = FileUtils.class.getResourceAsStream(fileName);  
     Properties properties = new Properties();  
     
     properties.load(inputStream);
     inputStream.close();  
     
     return properties;
  }
}