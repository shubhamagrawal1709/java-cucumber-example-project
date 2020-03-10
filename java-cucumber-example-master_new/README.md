# java-cucumber-example

A sample project for Cucumber and/or Selenium tests.

# Instructions

Clone the repo:

Git:
```
$ git clone git@github.com:testdouble/java-cucumber-example.git
```



## Prerequisites

In order to run browser tests, Selenium will need to be able to drive a browser
installed to your system.

(TODO after testing on Windows)

## Verify installation

## Use Maven



 In Pom.xml , we have define the System property 
 
 	<systemPropertyVariables>
<browser>chrome</browser>
 <logFilePtah>/Users/b0214198/Desktop/Script/java-cucumber-example-master_new/log.txt</logFilePtah>						
<driverPath>/Users/b0214198/Downloads/chromedriver.dmg</driverPath>
	</systemPropertyVariables>
	
	You can chnage the variables value as per your requirement.
	
	browser: need to give the type of browser name
	logFilePtah:need to give the logfilepath of your system.
	driverPath: need to give the driverpath
	
					
Open a command window and run:

    mvn test

Using Maven:

If want to execute particular tags

  mvn test -Dcucumber.options='--tags @Test1'

where @Test1 Particular Test Tag

If want to execute the whole feature file.

  mvn test -Dcucumber.options=src/test/resources/selenium/demoqa.feature


