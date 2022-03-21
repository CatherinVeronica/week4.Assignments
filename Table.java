package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Table {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		WebElement eachrow = rows.get(2);
		List<WebElement> cols = eachrow.findElements(By.tagName("td"));
		System.out.println(cols.size());

		WebElement columndata = eachrow.findElements(By.tagName("td")).get(1);
		System.out.println("Progress value of Learn to Interact with Elements" + columndata.getText());
		List<String> list = new ArrayList<String>();
		for (int i = 1; i < rows.size(); i++) {
			
			 eachrow = rows.get(i);
			 List<WebElement> coldata = eachrow.findElements(By.tagName("td"));
	String  cdata = coldata.get(1).getText();
	list.add(i-1,cdata);
		//System.out.println(list);
		}
		
		Collections.sort(list);
		System.out.println(list);
		if (list.get(1).contains("30%")) {
			eachrow.findElements(By.xpath("//input[@type='checkbox']")).get(2).click();
		}
						
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img001.bmp");
		FileUtils.copyFile(screenshot, image);
		
	
		
		
	
}
}

