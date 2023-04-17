package fyndAutomationProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reusable {
    
	 WebDriver driver;
	
	public void launchApp(String url) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public void closeApp() {
		driver.close();
	
}
}