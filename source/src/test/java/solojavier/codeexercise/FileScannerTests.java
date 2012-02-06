package solojavier.codeexercise;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;


/* Good unit test */
public class FileScannerTests extends TestCase{

    // TODO never used
    /* Remove what you don't need */
	FileScanner pipeFileScanner;
	FileScanner spaceFileScanner;

    /* In all the test cases you are initializing an ArrayList. This could be done in the setup() method instead of each test.
     * And digging deeper, getLines() will never return an empty ArrayList :) */
	
	@Test
    public void testGetLinesCommaFile()   
    {
		FileScanner commaFileScanner = new FileScanner(InputFiles.COMMA.getPath());
		ArrayList<String> lines = new ArrayList<String>();
		
		lines = commaFileScanner.getLines();
		
		assertEquals(lines.get(0),"Abercrombie, Neil, Male, Tan, 2/13/1943");
		assertEquals(lines.get(1),"Bishop, Timothy, Male, Yellow, 4/23/1967");
		assertEquals(lines.get(2),"Kelly, Sue, Female, Pink, 7/12/1959");
    }
	
	@Test
    public void testGetLineValuesCommaFile()   
    {
		FileScanner commaFileScanner = new FileScanner(InputFiles.COMMA.getPath());	
		ArrayList<String> values = new ArrayList<String>();
		
		values = commaFileScanner.getLineValues("Abercrombie, Neil, Male, Tan, 2/13/1943", ",");
		
		assertEquals(values.get(0),"Abercrombie");
		assertEquals(values.get(1),"Neil");
		assertEquals(values.get(2),"Male");
		assertEquals(values.get(3),"Tan");
		assertEquals(values.get(4),"2/13/1943");
    }
	
	
	@Test
    public void testGetLinesPipeFile()   
    {
		ArrayList<String> lines = new ArrayList<String>();
		FileScanner pipeFileScanner = new FileScanner(InputFiles.PIPE.getPath());
		
		lines = pipeFileScanner.getLines();
		
		assertEquals(lines.get(0),"Smith | Steve | D | M | Red | 3-3-1985");
		assertEquals(lines.get(1),"Bonk | Radek | S | M | Green | 6-3-1975");
		assertEquals(lines.get(2),"Bouillon | Francis | G | M | Blue | 6-3-1975");
    }
	
	@Test
    public void testGetLineValuesPipeFile()   
    {
		ArrayList<String> values = new ArrayList<String>();
		FileScanner pipeFileScanner = new FileScanner(InputFiles.PIPE.getPath());
		
		values = pipeFileScanner.getLineValues("Smith | Steve | D | M | Red | 3-3-1985", "\\|");

		assertEquals(values.get(0),"Smith");
		assertEquals(values.get(1),"Steve");
		assertEquals(values.get(2),"D");
		assertEquals(values.get(3),"M");
		assertEquals(values.get(4),"Red");
		assertEquals(values.get(5),"3-3-1985");
    }
	
	@Test
    public void testGetLinesSpaceFile()   
    {
		ArrayList<String> lines = new ArrayList<String>();
		FileScanner spaceFileScanner = new FileScanner(InputFiles.SPACE.getPath());
		
		lines = spaceFileScanner.getLines();

		assertEquals(lines.get(0),"Kournikova Anna F F 6-3-1975 Red");
		assertEquals(lines.get(1),"Hingis Martina M F 4-2-1979 Green");
		assertEquals(lines.get(2),"Seles Monica H F 12-2-1973 Black");
    }
	
	@Test
    public void testGetLineValuesSpaceFile()   
    {
		ArrayList<String> values = new ArrayList<String>();
		FileScanner spaceFileScanner = new FileScanner(InputFiles.SPACE.getPath());
		
		values = spaceFileScanner.getLineValues("Kournikova Anna F F 6-3-1975 Red", " ");

		assertEquals(values.get(0),"Kournikova");
		assertEquals(values.get(1),"Anna");
		assertEquals(values.get(2),"F");
		assertEquals(values.get(3),"F");
		assertEquals(values.get(4),"6-3-1975");
		assertEquals(values.get(5),"Red");
    }
}
