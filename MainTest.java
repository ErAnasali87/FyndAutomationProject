package fyndAutomationProject;

public class MainTest {
	
	public static void main(String args) {
		
	Reusable use = new Reusable();
	
	use.launchApp("https://test-nf.com/english.html");
	use.closeApp();
	
}}
