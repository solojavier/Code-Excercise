Code Test
====================

This exercise will provide with an initial gauge of Java skills, and more importantly, overall software development ability. It's not meant to be long or tricky or complicated. It's not timed, so you can take as long as you need.

This is the [code test webpage](http://cyrusinnovation.com/code_test).

Repo has the following structure:

	* /bin: 			: Executable jar with required files
	* /source			: Source code
	* /doc 				: Javadoc files source code and bin used only to run the application. 

To compile project, go to /source and use this command(*1):

	mvn package

It will generate Code-Exercise-1.0.jar file under source/target, copy it to /bin folder and you can run jar using this command:

	java -jar Code-Exercise-1.0.jar

It print in console message "Done." and output_files/model_output.txt will be generated. If error occurs it will be printed in console.

To run tests, go to /source and use this command(*1):

	mvn test -Dtest=AllTests


(*1) You will require [Maven](http://maven.apache.org/) installed on your enviroment.