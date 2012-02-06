package solojavier.codeexercise;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class FileScannerTests extends TestCase{

	ArrayList<String> values;

	/*Needs refactor to avoid use of the file system
	@Test
    public void testGetLinesCommaFile()   
    {
		FileScanner commaFileScanner = new FileScanner(InputFiles.COMMA.getPath());
		
		values = commaFileScanner.getLines();
		
		assertEquals(values.get(0),"Abercrombie, Neil, Male, Tan, 2/13/1943");
		assertEquals(values.get(1),"Bishop, Timothy, Male, Yellow, 4/23/1967");
		assertEquals(values.get(2),"Kelly, Sue, Female, Pink, 7/12/1959");
    }*/
	
	@Test
    public void testGetLineValuesCommaFile()   
    {
		
		values = FileScanner.getLineValues("Abercrombie, Neil, Male, Tan, 2/13/1943", ",");
		
		assertEquals(values.get(0),"Abercrombie");
		assertEquals(values.get(1),"Neil");
		assertEquals(values.get(2),"Male");
		assertEquals(values.get(3),"Tan");
		assertEquals(values.get(4),"2/13/1943");
    }
	
	/*Needs refactor to avoid use of the file system
	@Test
    public void testGetLinesPipeFile()   
    {
		FileScanner pipeFileScanner = new FileScanner(InputFiles.PIPE.getPath());
		
		values = pipeFileScanner.getLines();
		
		assertEquals(values.get(0),"Smith | Steve | D | M | Red | 3-3-1985");
		assertEquals(values.get(1),"Bonk | Radek | S | M | Green | 6-3-1975");
		assertEquals(values.get(2),"Bouillon | Francis | G | M | Blue | 6-3-1975");
    }
	*/

	@Test
    public void testGetLineValuesPipeFile()   
    {
		values = FileScanner.getLineValues("Smith | Steve | D | M | Red | 3-3-1985", "\\|");

		assertEquals(values.get(0),"Smith");
		assertEquals(values.get(1),"Steve");
		assertEquals(values.get(2),"D");
		assertEquals(values.get(3),"M");
		assertEquals(values.get(4),"Red");
		assertEquals(values.get(5),"3-3-1985");
    }
	
	/*Needs refactor to avoid use of the file system
	@Test
    public void testGetLinesSpaceFile()   
    {
		FileScanner spaceFileScanner = new FileScanner(InputFiles.SPACE.getPath());
		
		values = spaceFileScanner.getLines();

		assertEquals(values.get(0),"Kournikova Anna F F 6-3-1975 Red");
		assertEquals(values.get(1),"Hingis Martina M F 4-2-1979 Green");
		assertEquals(values.get(2),"Seles Monica H F 12-2-1973 Black");
    }
	*/
	
	@Test
    public void testGetLineValuesSpaceFile()   
    {		
		values = FileScanner.getLineValues("Kournikova Anna F F 6-3-1975 Red", " ");

		assertEquals(values.get(0),"Kournikova");
		assertEquals(values.get(1),"Anna");
		assertEquals(values.get(2),"F");
		assertEquals(values.get(3),"F");
		assertEquals(values.get(4),"6-3-1975");
		assertEquals(values.get(5),"Red");
    }
}
