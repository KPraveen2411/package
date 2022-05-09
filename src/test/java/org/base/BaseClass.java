package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.EvaluationWorkbook;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.BeforeClass;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Alert a;
	
	public static void launchBrowers() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	}
	
	public static void url(String name) {
		driver.get(name);
		
	}
	public static void maximum() {
		driver.manage().window().maximize();
	}
	public static void wait(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);

	}
	public static void currenturl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);

	}
	public static void senttext(WebElement loc,String name) {
		loc.sendKeys(name);

	}
	public static void buttonclick(WebElement clc) {
		clc.click();
	}
	public static void screenshot(String name) throws IOException {
		TakesScreenshot t=(TakesScreenshot)driver;
		File screenshotAs = t.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\praveen\\eclipse-workspace\\Demo\\ScreenShot\\"+name+".png");
		FileUtils.copyDirectory(screenshotAs, des);
    }
	public static void accept() {
		a= driver.switchTo().alert();
		
	}
	public static void dimiss() {
		a=driver.switchTo().alert();
		a.dismiss();
	}
	public static void sendkey(String name) {
		a=driver.switchTo().alert();
		a.sendKeys(name);
	}
	public static void gettext() {
		a=driver.switchTo().alert();
		a.getText();
	}
	public static void movetoElemt(WebElement name ) {
		Actions b=new Actions(driver);
		b.moveToElement(name).perform();
			
	}	
	public static void draganddrop( WebElement source ,WebElement target) {
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target);
		
	}
	public static void doubleclick() {
		Actions a=new Actions(driver);
		a.doubleClick().perform();
	}
	
	public static void dclickelement(WebElement name) {
		Actions a=new Actions(driver);
		a.doubleClick(name).perform();
	}
	public static void findxpath(String location) {
		driver.findElement(By.name(location));

	}
	public static String readexcel(String Sheetname, int rowno, int cellno) throws IOException {
		File f=new File("C:\\Users\\praveen\\eclipse-workspace\\Demo\\File\\Sheet.xlsx");
		FileInputStream fi=new FileInputStream(f);
		Workbook book=new XSSFWorkbook(fi);
		Sheet sheet = book.getSheet(Sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
	 int type = cell.getCellType();
		String name="";
		
		if (type==1) {
			 name = cell.getStringCellValue();
			
		}else if (DateUtil.isCellDateFormatted(cell)) {
			 Date d = cell.getDateCellValue();
			 
			 SimpleDateFormat s=new SimpleDateFormat("dd MMM YYY");
			  name = s.format(d);
		}
		else {
			double d = cell.getNumericCellValue();
			long l=(long)d;
		     name = String.valueOf(0);
		}
		return name; 	
	    }
	public static void quit (WebDriver q) {
		q.quit();
	}
	public static void close() {
		driver.close();
	}
	public static void context(WebElement name) {
		Actions a=new Actions(driver);
		a.contextClick(name);
	}
	public static void contextelement(WebElement name) {
		Actions a=new Actions(driver);
		a.contextClick(name);
	}
	
	public static void javascript(String key,WebElement args) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript(key, args);
	}
	public static void javascriptsendkey(WebElement args ) {
		JavascriptExecutor j= (JavascriptExecutor)driver;
		j.executeScript( "arguments[0].setAttribute('value','name')", args);
	}
	public static void javascriptgettext(WebElement args) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].get Attribute('value')", args);
	}
	public static void toclick(WebElement args) {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("arguments[0].click()", args);
	}
	public static void scrolltop() {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		WebElement top = driver.findElement(By.xpath("//a[text()='ASDA Strawberry and Raspberry Shower Gel']"));
		j.executeScript("arguments[0].scrollIntoView(true)", top);
	}
	public static void scrollbottom() {
		JavascriptExecutor j=(JavascriptExecutor)driver;
		WebElement buttom = driver.findElement(By.xpath("//a[text()='Accessibility']"));
		j.executeScript("arguments[0].scrollIntoView(false)", buttom);
	}
	public static void key(WebElement robo) throws AWTException {
		Robot r = new Robot();
		for (int i = 0; i <=4; i++) {
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
			}
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
	}
	public static void byvalue(WebElement name ,String value ) {
		Select s=new Select(name);
		s.selectByValue(value);
		
	}
	public static void byvisibletext(WebElement name , String text) {
		Select s=new Select(name);
		s.selectByVisibleText(text);
	}
	public static void byindex(WebElement name,int index) {
		Select s=new Select(name);
		s.selectByIndex(index); 
	}
	public static void deselectindex(WebElement name,int index) {
		Select s=new Select(name);
		s.deselectByIndex(index); 
	}
	public static void deselectvalue(WebElement name,String value) {
		Select s=new Select(name);
		s.deselectByValue(value);
	}
	public static void deselectvisible(WebElement name,String text) {
		Select s=new Select(name);
		s.deselectByVisibleText(text);
	}
	public static void deselectAll(WebElement name) {
		Select s=new Select(name);
		s.deselectAll();
	}
	public static void windowhandle() {
		driver.getWindowHandle();
	}
	public static void windowhandles() {
		driver.getWindowHandles();
	}
	public static void dateandtime() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
	}
	public static void closebrowser() {
		driver.close();
	}
	public static void iaccept() {
		driver.findElement(By.xpath("//button[text()='I Accept']")).click();

	}
	public static void sleep() throws InterruptedException {
		Thread.sleep(1000);
	}
	public static void currentUrl() {
		driver.getCurrentUrl();
	}
	public static void quit() {
		driver.quit();
	}
	
}
		
		
		
		
		
		
		
		
		
		
		
		
		
	

