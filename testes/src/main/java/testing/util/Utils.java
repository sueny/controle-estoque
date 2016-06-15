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
	
	private static void createRandomIfNecessary(){
		if(random == null)
			random = new Random();
	}
	
	public static long getRandomId(){
		createRandomIfNecessary();
		return Math.abs(random.nextLong());
	}
	
	public static String getRandomNumString(int length){
		createRandomIfNecessary();
		StringBuilder buf = new StringBuilder();
		for(int i = 0; i < length; i++)
			buf.append(random.nextInt(10));
		return buf.toString();
	}
	
	public static By byText(String text){
		return By.xpath("//*[contains(text(),'" + text + "')]");
	}
	
}
