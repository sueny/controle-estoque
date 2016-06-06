package testing.util;

import java.util.Random;

import org.openqa.selenium.By;

public class Utils {
	private static Random random;
	
	public static void sleep(long s){
		try {
			Thread.sleep(s);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static long getRandomId(){
		if(random == null)
			random = new Random();
		return Math.abs(random.nextLong());
	}
	
	public static By byText(String text){
		return By.xpath("//*[contains(text(),'" + text + "')]");
	}
}
