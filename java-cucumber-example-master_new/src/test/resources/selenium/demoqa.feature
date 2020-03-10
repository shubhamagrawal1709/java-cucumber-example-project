Feature: Todo Lists

	@Test1
	Scenario Outline: Perform Test1 Objective
	    Given Open the given "<url>" 
		Then I click on resizable button
		Then I Resize the Text Area to x and y cordinates
        | 250        | 170 |
         |350         | 220 |
         |410         | 220 |
	
		
		Examples:
		|url|
		|https://demoqa.com/|
		
		
	@Test2
	Scenario Outline: Perform Test1 Objective
	    Given Open the given "<url>"
	    Then I click on Droppable Button
	    Then Perform Drag and Drag
	    Then Dropee Box should have text "Dropped!"
		
		Examples:
		|url|
		|https://demoqa.com/|
		