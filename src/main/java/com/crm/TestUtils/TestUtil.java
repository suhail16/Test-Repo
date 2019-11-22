package com.crm.TestUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.excel.utility.Xls_Reader;



public class TestUtil {
	
	static Xls_Reader reader;
	static WebDriver driver;	
	
	public static long PAGELOAD_TIMEOUT = 20;
public static long IMPLICITWAIT = 10;
	
	public static ArrayList<Object[]> getDataFromExcel(){
		ArrayList<Object[]> data = new ArrayList<Object[]>();
	
		reader = new Xls_Reader("D:\\Auto self\\Seleniumworkspace\\TestCRM\\src\\main\\java\\com\\TestData\\EbayTest.xlsx");
		
		for(int rowNum=2;rowNum<=reader.getRowCount("EbayTest");rowNum++)
		{
	
			String firstName = reader.getCellData("EbayTest", "FirstName", rowNum);
			String lastName = reader.getCellData("EbayTest", "LastName", rowNum);
			String email = reader.getCellData("EbayTest", "Email", rowNum);
			String password = reader.getCellData("EbayTest", "Password", rowNum);
			
		
		
		Object ob[] = {firstName,lastName,email,password};
		
		data.add(ob);
		}
		return data;
	}
	

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File ScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(ScrFile, new File(currentDir + "//screenshots//" + System.currentTimeMillis() + ".png"));
		
	}
}

