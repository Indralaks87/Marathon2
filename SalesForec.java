package marathon.session2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class SalesForec {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		Thread.sleep(2000);
		
		WebElement learnMore = driver.findElement(By.xpath("//span[text()='Learn More']"));
		
		driver.executeScript("arguments[0].click();",learnMore); 
		Set<String> oldPage = driver.getWindowHandles();
		List<String> newPage = new ArrayList<String>(oldPage);
		driver.switchTo().window(newPage.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Shadow dom = new Shadow(driver);
		dom.findElementByXPath("//span[text()='Learning']").click();
		WebElement mouseHover = dom.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions act = new Actions(driver);
		act.moveToElement(mouseHover).perform();
		act.scrollToElement(mouseHover).perform();
		
		Thread.sleep(2000);
		WebElement salesForce = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click();",salesForce); 
		Thread.sleep(2000);
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement webElement : findElements) {
			
			String text = webElement.getText();
			System.out.println(text);
		}
		String title = driver.getTitle();
		System.out.println("Title of the current page :"+title);
		

	}

}
