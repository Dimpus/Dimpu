package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutility {

	private static XSSFWorkbook wBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static void setExcelPath(String sheetName,String path) throws IOException{
		
		FileInputStream fis=new FileInputStream(path);
		wBook=new XSSFWorkbook();
		sheet=wBook.getSheet(sheetName);
		
	}
	public static String getCellData(int rownum,int colnum) {
		String stringCellData;
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		stringCellData=cell.getStringCellValue();
		return stringCellData;
	}
	public static String[][] getExcelTable(){
		int numOfRows=sheet.getLastRowNum();
		int numOfCols=2;
		String[][] excelData=new String[numOfRows][numOfCols];
		int ci=1;
		int cj=1;
		for(int i=0;i<numOfRows;i++,ci++){
			cj=1;
			for(int j=0;j<numOfCols;j++,cj++)
				excelData[i][j]=getCellData(ci,cj);
		}
		return excelData;
	}
	public static void setexcelData(int rownum,int col,String data) throws Exception{
		
		 row=sheet.getRow(rownum);
		 cell=row.getCell(col, MissingCellPolicy.RETURN_BLANK_AS_NULL);
		 if(cell==null) {
			 cell=row.createCell(col);
			 cell.setCellValue(data);
			 
		 }
		 else {
			 cell.setCellValue(data);
		 }
	FileOutputStream fos=new FileOutputStream("C:\\\\Users\\\\A06438_P5.Training\\\\Desktop\\test.xlsx");
	wBook.write(fos);
	fos.flush();
	fos.close();
	
	}
}
