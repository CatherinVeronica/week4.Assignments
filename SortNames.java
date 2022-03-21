package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortNames {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/sorttable.html");
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		List<String> list1 = new ArrayList<String>();
		for (int i = 1; i < rows.size(); i++) {
			WebElement eachrow = rows.get(i);
			WebElement eachrowdata = eachrow.findElements(By.tagName("td")).get(1);
			list1.add(i - 1, eachrowdata.getText());

		}
		Collections.sort(list1);
		System.out.println(list1);

		// Click name header
		WebElement rowheader = rows.get(0);
		rowheader.findElements(By.tagName("th")).get(1).click();
		List<String> list2 = new ArrayList<String>();
		for (int i = 1; i < rows.size(); i++) {
			WebElement eachrow = rows.get(i);
			WebElement eachrowdata = eachrow.findElements(By.tagName("td")).get(1);
			list2.add(i - 1, eachrowdata.getText());
		}
		int count = 0;
		for (int i = 0; i < list1.size(); i++) {

			for (int j = 0; j < list2.size(); j++) {
				if (list1.get(i).equalsIgnoreCase(list2.get(j))) {
					count = count + 1;
				}

			}

		}
		if (count == 6) {
			System.out.println("Both List Matches");
		}
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File image = new File("./snaps/img001.bmp");
		FileUtils.copyFile(screenshot, image);

	}

}
