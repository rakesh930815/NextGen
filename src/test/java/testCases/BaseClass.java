package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public String baseURL="https://nextgen.ehospital.nic.in/";
	public String username="Aeo12345";
	public String password="Aeo@12345";
	public String captcha="123456";
	public static WebDriver driver;

	@BeforeClass
	public void setup(){
	//System.setProperty("webdriver.chrome.driver",=System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	//driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
}
