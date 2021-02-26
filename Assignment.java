package package1;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {
	
	WebDriver driver;

	@Before
	public void setupMethod() {
		 System.setProperty("webdriver.chrome.driver","C:\\jar files\\chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
	}
		
	@Test 
	public void scenario2() {
		
		driver.get("https://www.traderev.com/en-ca/");
		driver.findElement(By.linkText("Careers")).click();
		ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.findElement(By.linkText("Canadian Opportunities")).click();
	}
	
	@Test
	public void scenario3() {
		driver.get("https://jobs.lever.co/traderev");
	    driver.findElement(By.xpath("//div[contains(text(),'Location')]")).click();
	    WebElement toronto = driver.findElement(By.xpath("//a[contains(text(),'Toronto, Ontario, Canada')]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(toronto));
		toronto.click();
  }
	
	@Test 
	public void scenario4() throws Throwable {
		driver.get("https://jobs.lever.co/traderev");
		driver.findElement(By.xpath("//div[contains(text(),'Location')]")).click();
	    WebElement toronto = driver.findElement(By.xpath("//a[contains(text(),'Toronto, Ontario, Canada')]"));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(toronto));
		toronto.click();
		driver.findElement(By.xpath("//div[contains(text(),'Team')]")).click();
		WebElement engineering = driver.findElement(By.xpath("//a[contains(text(),'Engineering')]"));
		WebDriverWait Wait = new WebDriverWait(driver,30);
		Wait.until(ExpectedConditions.elementToBeClickable(engineering));
		engineering.click();
		List<WebElement> optionCount = driver.findElements(By.xpath("//span[contains(text(),'Toronto, Ontario, Canada')]"));
		System.out.println(optionCount.size());
		Thread.sleep(1000);
	}
	
	@After
	public void scenario5(){
		driver.quit();
	}
	

}
