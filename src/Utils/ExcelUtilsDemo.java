package Utils;

import java.io.IOException;

public class ExcelUtilsDemo {
public static void main(String[] args) throws IOException   {
	String projectpath=System.getProperty("user.dir");
	ExcelUtils ex=new ExcelUtils(projectpath+"\\excel\\data.xlsx.xlsx", "Sheet1");
	ex.getRowCount();
	ex.getCellData(0, 0);
	ex.getCellDataNumber(1, 1);
	
}
}
