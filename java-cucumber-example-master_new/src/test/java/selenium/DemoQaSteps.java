package selenium;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import Support.Browser;
import Utility.Util;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DemoQaSteps {

	//public static WebDriver driver1;
	
	public static EventFiringWebDriver eventhandlerdriver;
	
	public static String logFilePtah = System.getProperty("logFilePtah");
	

	/*@After
	public void quitBrowser() {
		eventhandlerdriver.quit();
	}
	*/
	
	@Before
	public void createLogFile() throws IOException {

		File file = new File(logFilePtah);
		if(file.exists()){
	    	   file.delete();
	    	   file.createNewFile();
	    	}
	}
	
	


	@Given("^Open the given \"([^\"]*)\"$")
	public void open_the_given(String arg1) throws Throwable {
		eventhandlerdriver = Browser.launch();
		eventhandlerdriver.navigate().to(arg1);
	}

	@Then("^I click on resizable button$")
	public void i_click_on_resizable_button() throws Throwable {
		eventhandlerdriver.findElement(By.linkText("Resizable")).click();

	}

	@Then("^I Resize the Text Area to x and y cordinates$")
	public void i_Resize_the_Text_Area_to_x_and_y_cordinates(DataTable arg1) throws Throwable {
		//String logFilePtah = System.getProperty("logFilePtah");
		//File file = new File(logFilePtah);
		//FileWriter writer = new FileWriter(file);
		List<List<String>> data = arg1.raw();
		int i = 1;
		for (List<String> list : data) {
			Iterator<String> iterator = list.iterator();
			String x_cordinates = iterator.next();
			String y_cordinates = iterator.next();
			//resizeListenere(x_cordinates, y_cordinates, writer, i);
			resizeListenere(x_cordinates, y_cordinates, i);
			i++;

		}
		//writer.close();

	}

	
	//public void resizeListenere(String x, String y, FileWriter writer, int number) throws IOException {

		
		public void resizeListenere(String x, String y, int number) throws IOException {
		WebElement textArea = eventhandlerdriver.findElement(By.xpath("//*[@id='resizable']"));
		JavascriptExecutor js = (JavascriptExecutor) eventhandlerdriver;
		//String data = "WIDTH:253px;HEIGHT:170px;";
		
		String data = "WIDTH:"+x+"px;HEIGHT:"+y+"px;";
		System.out.println(data);
		String s2 = "arguments[0].setAttribute('style','" + data + "');";
		js.executeScript(s2, textArea);
		//Util.logListenere(writer, number, textArea);

	}


	
	@Then("^I click on Droppable Button$")
	public void i_click_on_Droppable_Button() throws Throwable {
		eventhandlerdriver.findElement(By.linkText("Droppable")).click();

	}

	@Then("^Perform Drag and Drag$")
	public void perform_Drag_and_Drag() throws Throwable {
		
		// It is always advisable to Maximize the window before performing DragNDrop action 
		eventhandlerdriver.manage().window().maximize();
		 
		eventhandlerdriver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		WebElement from = eventhandlerdriver.findElement(By.id("draggable"));  
		  
		//WebElement to which the above object is dropped  
		WebElement to = eventhandlerdriver.findElement(By.id("droppable"));  
		   
		//Creating object of Actions class to build composite actions  
		Actions act = new Actions(eventhandlerdriver);  
		   
		//Performing the drag and drop action  
		act.dragAndDrop(from,to).build().perform();   
	}
	
	
	@Then("^Dropee Box should have text \"([^\"]*)\"$")
	public void dropee_Box_should_have_text(String arg1) throws Throwable {
		WebElement dropee = eventhandlerdriver.findElement(By.id("droppable"));  
		Assert.assertTrue(dropee.getText().equals(arg1));
		WebElement to = eventhandlerdriver.findElement(By.id("droppable"));
		Actions act = new Actions(eventhandlerdriver);  
		act.dragAndDropBy(dropee, 160,200).perform();
		if(to.getText().equals("Dropped!"))
		{
			eventhandlerdriver.executeScript("document.getElementById('droppable').innerHTML = 'Drop here'");
		}
		
	}

}
