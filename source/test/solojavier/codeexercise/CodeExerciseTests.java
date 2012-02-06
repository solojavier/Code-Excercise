package solojavier.codeexercise;

import java.io.File;

import junit.framework.TestCase;
import junitx.framework.FileAssert;
import org.junit.Test;

import solojavier.codeexercise.CodeExercise;

public class CodeExerciseTests extends TestCase
{	
    @Test
    public void testOuputFile()   
    {
    	File expected_output = new File("output_files\\expected_output.txt"); 
    	File model_output = new File("output_files\\model_output.txt"); 
    	
    	new CodeExercise().run();
    	
    	FileAssert.assertEquals( expected_output, model_output );
    }
}