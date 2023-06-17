package report_to;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_MyInfo_037_report_to {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\ExcelR Project\\Report-to.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_MyInfo_037");

			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();
			// login
			driver.findElement(By.xpath(s.getCell(1, 3).getContents())).sendKeys(s.getCell(1, 10).getContents());
			driver.findElement(By.xpath(s.getCell(1, 4).getContents())).sendKeys(s.getCell(1, 11).getContents());
			driver.findElement(By.xpath(s.getCell(1, 5).getContents())).click();
			Thread.sleep(2000);
			// my info
			driver.findElement(By.linkText(s.getCell(1, 6).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// report-to
			driver.findElement(By.linkText(s.getCell(1, 7).getContents())).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(s.getCell(1, 8).getContents())).isEnabled();
		} catch (Exception e) {
			System.out.println("Try with other locator");
		} finally {
			if (driver.getPageSource().contains("Successfully Saved")) {
				System.out.println("File is uploaded");
			} else {
				System.out.println("File is not uploaded");
			}
			driver.close();
		}

	}

}
