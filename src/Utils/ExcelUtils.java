package Utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projectpath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelpath, String sheetname) throws IOException {
		try {
			
		workbook=new XSSFWorkbook(excelpath);
	    sheet=workbook.getSheet(sheetname);
	    
	}catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	
public static void getRowCount() throws IOException {
	try {
	int rowcount=sheet.getPhysicalNumberOfRows();
	System.out.println("row count "+rowcount);
	
}catch (Exception e) {
	e.printStackTrace();
}
}
public static void getCellData(int RowNum,int ColNum) throws IOException {
	try {
    double cellData=sheet.getRow(RowNum).getCell(ColNum).getNumericCellValue();
    System.out.println(cellData);
}catch(IllegalStateException e) {
	e.printStackTrace();
}
}
public static void getCellDataNumber(int RowNum, int ColNum) throws IOException {
	try {
    String cellData=sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
    System.out.println(cellData);
}catch(IllegalStateException e) {
	e.printStackTrace();
}
	
}
}
