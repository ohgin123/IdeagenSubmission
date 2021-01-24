# IdeagenSubmission
Around 5 hours
Basically what my code does is. 
1)Seperate Bracket Token and Numerics Token into one array and Operators involving outer most value(Outermost Brackets and Numerics not in bracket) is stored in different Array 
2) Processing the inner most Bracket Values and then Propagating to upper most Bracket Values 
3)Once Value propagated up. Just take the "outer most" token and perform arithmatic operations using Operators involving outer most value 
4) Rest is explained in code

To create jar file and unit tests
Run mvn clean package
cd target
java -jar calculator-0.0.1-SNAPSHOT.jar

To deploy to eclipse
Run mvn clean package
mvn eclipse:eclipse
Use Eclipse to add project as maven project

errors will be looged into error.txt

Main Class: Calculator
Change main function to test functionality

Unit test in src/test/java
Mock is not included yet. In order to implement Mock, Need to change class to include a constructor that will take in CalculatorService class.
We can then mock CalculatorService functions to return the expected output to those calculator service functions given the input
