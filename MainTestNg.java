package finalProject;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MainTestNg {

	// making web driver instance 
	WebDriver driver;

	// Launching the application
	@BeforeSuite
	public void launchApp() throws Exception {

		// Using Excel Integration for launching the app

		FileInputStream f = new FileInputStream("C:\\Users\\user\\Desktop\\FyndData.xls");
		Workbook wb = Workbook.getWorkbook(f);
		Sheet sh = wb.getSheet("Sheet2");
		System.setProperty(sh.getCell(0, 0).getContents(), sh.getCell(0, 1).getContents());
		driver = new ChromeDriver();
		driver.get(sh.getCell(1, 0).getContents());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	
	// Verifying the tabs is available or not
	@Test(priority = 1)
	public void verifyTabs() {

		PomFile P = PageFactory.initElements(driver, PomFile.class);

		// use of soft assertion
		SoftAssert s = new SoftAssert();
		
		// Storing the availability in boolean variable and verifying 

		boolean H = P.home.isDisplayed();
		s.assertEquals(H, true);
		System.out.println("Home tab is available");

		boolean F = P.football.isDisplayed();
		s.assertEquals(F, true);
		System.out.println("Football tab is available");

		boolean B = P.busketball.isDisplayed();
		s.assertEquals(B, true);
		System.out.println("Basketball tab is available");

		boolean C = P.kriket.isDisplayed();
		s.assertEquals(C, true);
		System.out.println("Cricket tab is available");

		boolean Cb = P.cibersport.isDisplayed();
		s.assertEquals(Cb, true);
		System.out.println("Cybersports tab is available");

	}

	// Checking if the url contains tab name
	@Test(priority = 2)
	public void containTabname() {

		// checking for home tab
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		String url = driver.getCurrentUrl();
		if (url.contains("Home")) {
			System.out.println("Url contain Tab Name");
		} else {
			System.out.println("Url Doesn't Conatin Tab NAme");
		}

		// checking for Football tab
		driver.findElement(By.xpath("//a[text()='Football']")).click();
		String url1 = driver.getCurrentUrl();
		if (url1.contains("football")) {
			System.out.println("Url contain Tab Name");
		} else {
			System.out.println("Url Doesn't Conatin Tab NAme");
		}

		// checking for busketball tab
		driver.findElement(By.xpath("//a[text()='Busketball']")).click();
		String url2 = driver.getCurrentUrl();
		if (url2.contains("busketball")) {
			System.out.println("Url contain Tab Name");
		} else {
			System.out.println("Url Doesn't Conatin Tab NAme");
		}

		// checking for kriket tab
		driver.findElement(By.xpath("//a[text()='Kriket']")).click();
		String url3 = driver.getCurrentUrl();
		if (url3.contains("kriket")) {
			System.out.println("Url contain Tab Name");
		} else {
			System.out.println("Url Doesn't Conatin Tab NAme");
		}

		// checking for cibersport tab
		driver.findElement(By.xpath("//a[text()='Cibersport']")).click();
		String url4 = driver.getCurrentUrl();
		if (url4.contains("cibersport")) {
			System.out.println("Url contain Tab Name");
		} else {
			System.out.println("Url Doesn't Conatin Tab NAme");
		}

	}

	// Adding current urls to excel
	@Test(priority = 3)
	public void addingUrlToExcel() throws Exception {

		// excel to store the urls data
		FileOutputStream fo = new FileOutputStream("C:\\Users\\user\\Desktop\\urls.xls");
		WritableWorkbook w = Workbook.createWorkbook(fo);
		WritableSheet ws = w.createSheet("Result", 1);
		String Url;
		String TabName;

		// store url for home tab
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		Url = driver.getCurrentUrl();
		TabName = "Home";
		Label l = new Label(0, 0, TabName + "tab having the url is : -" + Url);
		ws.addCell(l);

		// store url for football tab
		driver.findElement(By.xpath("//a[text()='Football']")).click();
		Url = driver.getCurrentUrl();
		TabName = "Football";
		Label l2 = new Label(0, 1, TabName + "tab having the url is : -" + Url);
		ws.addCell(l2);

		// store url for busketball tab
		driver.findElement(By.xpath("//a[text()='Busketball']")).click();
		Url = driver.getCurrentUrl();
		TabName = "Busketball";
		Label l3 = new Label(0, 2, TabName + "tab having the url is : -" + Url);
		ws.addCell(l3);

		// store url for Kriket tab
		driver.findElement(By.xpath("//a[text()='Kriket']")).click();
		Url = driver.getCurrentUrl();
		TabName = "Kriket";
		Label l4 = new Label(0, 3, TabName + "tab having the url is : -" + Url);
		ws.addCell(l4);

		// store url for Kriket tab
		driver.findElement(By.xpath("//a[text()='Cibersport']")).click();
		Url = driver.getCurrentUrl();
		TabName = "Ciber Sports";
		Label l5 = new Label(0, 4, TabName + "tab having the url is : -" + Url);
		ws.addCell(l5);

		// writing in excel
		w.write();
		w.close();

	}

	// closing the application
	@AfterSuite
	public void closeThisApp() {
		driver.close();
	}

}
