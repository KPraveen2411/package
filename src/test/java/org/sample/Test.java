package org.sample;

import java.util.List;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.PojoClass;

public class Test extends BaseClass {
	
	public static void main(String[] args) {
			
		launchBrowers();
		url("https://www.asda.com/");
		maximum();
		iaccept();
		title();
		PojoClass p =new PojoClass();
		senttext(p.getSearchpath(), "baby clothes");
		buttonclick(p.getClick());
		driver.findElement(By.xpath("//button[@id='af9jbk2jbqc']")).click();
		driver.findElement(By.xpath("(//div[@class='media-container   '])[6]")).click();
		
		driver.findElement(By.xpath("(//a[(@title='Looney Tunes Tweety Print Denim Jacket and Dress Outfit')])[3]")).click();
		List<WebElement> productsize = driver.findElements(By.xpath("//div[@class='attribute-wrapper grid__list columns-number-2']//child::div"));
		
		for (int i = 0; i < productsize.size(); i++) {
			
			WebElement product = productsize.get(i);
			product.click();
			
		}
	
		
		
	}
}
