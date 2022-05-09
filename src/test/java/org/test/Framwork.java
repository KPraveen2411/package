package org.test;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.pojo.PojoClass;

public class Framwork extends BaseClass {
	

	
	public static void main(String[] args) throws Throwable {
		
		
		launchBrowers();
		maximum();
		wait(10);
		url("https://www.asda.com/");
		iaccept();

		PojoClass r=new PojoClass();
		senttext(r.getSearchpath(), "gel");	
    	buttonclick(r.getClick());		

   	
    	driver.findElement(By.xpath("(//a[@class='co-product__anchor'])[1]")).click();
	}
}
	



