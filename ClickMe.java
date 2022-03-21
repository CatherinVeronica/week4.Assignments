package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickMe {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/TextChange.html");
WebElement textchangebutton = driver.findElement(By.xpath("//button[@class='btn']"));
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("btn"), "Click ME!"));
textchangebutton.click();
Alert alert = driver.switchTo().alert();
System.out.println(alert.getText());
alert.accept();
File screenshot = driver.getScreenshotAs(OutputType.FILE);
File image = new File("./snaps/img003.bmp");
FileUtils.copyFile(screenshot, image);


	}

}
