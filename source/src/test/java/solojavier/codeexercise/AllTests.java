package solojavier.codeexercise;

import org.junit.runner.JUnitCore;
import junit.framework.Test;
import junit.framework.TestSuite;
import solojavier.codeexercise.app.*;
import solojavier.codeexercise.model.*;


public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for solojavier");
		//$JUnit-BEGIN$
		suite.addTestSuite(PersonTests.class);
		//TODO - Missing tests for app and utils
		//$JUnit-END$
		return suite;
	}
	
	public static void main(String[] args) throws Exception {                    
	       JUnitCore.main(
	         "solojavier.codeexercise.AllTests");            
	}
}