package testCases;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
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
			
			while (itr.hasNext()) {
			    String window = itr.next();
			    driver.switchTo().window(window);  // Switch to the current window
			    try {
			        // Assuming that the frame is nested within the window, switch to the frame by its name or index
			        driver.switchTo().frame(window);  // Replace with the actual frame name or index
			        System.out.println(driver.findElement(By.id("swal2-title")).getText());

			        // Uncomment and modify the code below as needed
			        // if (driver.findElement(By.id("swal2-title")).getText().equals("User already logged IN. Do you Want to login again")) {
			        //     // driver.close();  // Close the window if needed
			        //     System.out.println("done");
			        // }

			    } catch (NoSuchElementException e) {
			        System.out.println("Element not found in window: " + window);
			    } catch (NoSuchFrameException e) {
			        System.out.println("Frame not found in window: " + window);
			    } finally {
			        // You can switch back to the main content (default content) if needed
			        driver.switchTo().defaultContent();
			    }
			}
			
			//System.out.println(driver.findElement(By.id("#swal2-title")).getText());
//			if(driver.findElement(By.cssSelector("span[style='color: rgb(218, 4, 77);']")).getText().equals("Demo Hospital ")){
//			Assert.assertTrue(true);}
//			else{
//			Assert.assertTrue(false);
//			}
		}
}
