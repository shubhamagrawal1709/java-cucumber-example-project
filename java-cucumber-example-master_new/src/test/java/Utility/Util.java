package Utility;

import java.io.IOException;
import java.io.Writer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util {
  public static WebDriver driver;
	public void logListenere(Writer writer, int number, WebElement textArea) throws IOException {

		writer.write("Resize Number " + number);
		writer.write("\n");
		writer.write(
				"Height - " + textArea.getSize().getHeight() + " ; width - " + textArea.getSize().getWidth() + " px");
		writer.write("\n");

	}
}
