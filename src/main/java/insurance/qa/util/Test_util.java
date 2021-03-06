package insurance.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import insurance.qa.base.Testbase;

public class Test_util extends Testbase {
	
//	public static long PAGE_LONG_TIMEOUT =20;
//	public static long IMPLICIT_Wait = 30;

public static String TEST_DATA_SHEET="C:\\Users\\Hammad\\eclipse-workspace\\insurance\\src\\main\\java\\insurance"
		+ "\\qa\\testdata\\copy\\FreeCRM_Testdat.xlsx";
static Workbook book;
static Sheet sheet;


//public void switchToFrame() {
//driver.switchTo().frame("mainpanel");
//}

public static Object[][]getTestData(String sheetname){
	FileInputStream file= null;
	try {
		file = new FileInputStream (TEST_DATA_SHEET);
	}catch(FileNotFoundException e) {
		e.printStackTrace();		
	}
	try {
		book = WorkbookFactory.create(file);
	}catch (InvalidFormatException e) {
		e.printStackTrace();
	}catch(IOException e) {
		e.printStackTrace();
	}
	sheet = book.getSheet(sheetname);
	Object [][] data= new Object [sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	
	for(int i=0;i<sheet.getLastRowNum();i++) {
		for (int k=0; k<sheet.getRow(0).getLastCellNum();k++) {
			data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			
		}
	}
	
		return data;

}
public static void takeScreenshotAtEndOfTest()throws IOException {
	File Screenfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(Screenfile, new File(currentDir +"/screenshot/"+System.currentTimeMillis()+".png"));
	
	
}






}






