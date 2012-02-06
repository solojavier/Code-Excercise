package solojavier.codeexercise;

import org.junit.runner.JUnitCore;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for solojavier");
		//$JUnit-BEGIN$
		suite.addTestSuite(FileScannerTests.class);
		suite.addTestSuite(PersonTests.class);
		//$JUnit-END$
		return suite;
	}
	
	public static void main(String[] args) throws Exception {                    
	       JUnitCore.main(
	         "solojavier.codeexercise.AllTests");            
	}
}