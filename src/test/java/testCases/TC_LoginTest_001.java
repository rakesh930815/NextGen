package testCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException
		{
			driver.get(baseURL);
			LoginPage lp=new LoginPage(driver);
			lp.clickLoginLink();
			
			lp.setUserName(username);
			lp.setPassword(password);
			Thread.sleep(5000);
			lp.setCaptcha(captcha);
			Thread.sleep(5000);
			lp.clickLoginButton();
			
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			
			while(itr.hasNext()) {
				String window = itr.next();
				driver.switchTo().window(window);
				System.out.println(driver.findElement(By.id("#swal2-title")).getText());
//				if(driver.findElement(By.id("#swal2-title")).getText().equals("User already logged IN. Do you Want to login again ")) {
//					//driver.close();
//					System.out.println("done");
//				}
			}
			
			//System.out.println(driver.findElement(By.id("#swal2-title")).getText());
//			if(driver.findElement(By.cssSelector("span[style='color: rgb(218, 4, 77);']")).getText().equals("Demo Hospital ")){
//			Assert.assertTrue(true);}
//			else{
//			Assert.assertTrue(false);
//			}
		}
}
