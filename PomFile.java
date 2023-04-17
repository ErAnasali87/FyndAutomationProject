package finalProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PomFile {
	
	// Creating page object model of web element 

	@FindBy(xpath="//a[text()='Home']")WebElement home;
	@FindBy(xpath="//a[text()='Football']")WebElement football;
	@FindBy(xpath="//a[text()='Busketball']")WebElement busketball;
	@FindBy(xpath="//a[text()='Kriket']")WebElement kriket;
	@FindBy(xpath="//a[text()='Cibersport']")WebElement cibersport;
}
