package sampleproject;

	import java.util.ArrayList;
	import java.util.List;
	import org.junit.After;
	import org.junit.Assert;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class tradrev {
		
		WebDriver driver;

		@Before
		public void setupMethod() {
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\masteruser\\Desktop\\SeleniumSampleCodes\\sampleproject\\resources\\browserdrivers\\chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();
		}
			
		@Test 
		public void  checkDisplay_TradeRev_Canada_CareerPage() {
			
			driver.get("https://www.traderev.com/en-ca/");
			driver.findElement(By.linkText("Careers")).click();
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));
			driver.findElement(By.linkText("Canadian Opportunities")).click();
			WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Jobs powered by ')]"));
			WebDriverWait waitForElement = new WebDriverWait(driver, 15);
			waitForElement.until(ExpectedConditions.visibilityOf(element));
       }
		
		@Test
		public void checkDisplay_CityFilter_ValidateResults() {
			driver.get("https://jobs.lever.co/traderev");
		    driver.findElement(By.xpath("//div[contains(text(),'Location')]")).click();
		    WebElement toronto = driver.findElement(By.xpath("//a[contains(text(),'Toronto, Ontario, Canada')]"));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(toronto));
			toronto.click();
			List<WebElement> lstItems = driver.findElements(By.xpath("//span[contains(text(),'Toronto, Ontario, Canada')]"));
			for(WebElement eleItem: lstItems){
			   Assert.assertEquals(eleItem.getText(),"Toronto, Ontario, Canada");
			 }
	  }
		
		@Test 
		    public void checkDisplay_CityFilter_TeamFilter_LogTotalOptions() {
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
		}
		
         @After
         public void afterEach(){
			driver.quit();
	}
		

	}