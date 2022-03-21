package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonDisappear {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/disapper.html");
WebElement elementdisappearingbutton = driver.findElement(By.xpath("//div[@class='disappear']/button"));
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
wait.until(ExpectedConditions.invisibilityOf(elementdisappearingbutton));

System.out.println(driver.findElement(By.xpath("//div[@class='disappear']//strong")).getText());

File screenshot = driver.getScreenshotAs(OutputType.FILE);
File image = new File ("./snaps/img001.bmp");
FileUtils.copyFile(screenshot,image);
	}

}
