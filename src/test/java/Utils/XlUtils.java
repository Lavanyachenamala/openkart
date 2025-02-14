package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils {
	
	
	public static FileInputStream fi;
	public static Workbook wb;
	public static Sheet sheet;
	public static CellStyle style;
	public static  FileOutputStream fo;
	public static Cell cell;
	public static Row row;
	String path;
	public  XlUtils(String path) {
		
		this.path=path;
		
	}
	public  int getrowcount(String filename ) throws IOException {
		
		
		 fi = new FileInputStream(path);
		 wb = new XSSFWorkbook(fi);
		 sheet  = wb.getSheet(filename);
		int rowcount =sheet.getLastRowNum();
		wb.close();
		return rowcount;
			
	}
	public  Short getcolcount(String Filename,int rownum) throws IOException {
	
	 fi = new FileInputStream(path);
	 wb = new XSSFWorkbook(fi);
	 sheet  = wb.getSheet(Filename);
	
	Row row =sheet.getRow(rownum);
	Short colcount=row.getLastCellNum();
	
	 wb.close();
	 return colcount;
			
	}
	
	public String getCellvalue(String Filename,int rownum,int colnum) throws IOException {
		
		
		 fi = new FileInputStream(path);
		 wb = new XSSFWorkbook(fi);
		 sheet  = wb.getSheet(Filename);
			Row row = sheet.getRow(rownum);
			Cell cell= row.getCell(colnum);
			String cellvalue;
			DataFormatter formatter= new DataFormatter();
		try {
			cellvalue =formatter.formatCellValue(cell);//This returns the formatted value of a cell as a string regardless(it is a string or numeric or boolean)
			
		} catch (Exception e) {
			cellvalue=" ";	
		}
	
		
		wb.close();
		fi.close();
		return cellvalue;
		
		}
	
	/*	public static double getnumericvalue(String File,String Filename,int rownum,int colnum) throws IOException {
			
			
			 fi = new FileInputStream(File);
			 wb = new XSSFWorkbook(fi);
			 sheet= wb.getSheet(Filename);
			Row row=sheet.getRow(rownum);
			Cell cell=row.getCell(colnum);
			double celldata;
			try {
				 celldata=cell.getNumericCellValue();
			} catch (Exception e) {
              celldata = 0.0;	
              }
			
			wb.close();
			return celldata;
			}
			
		
			
			public static boolean getbooleanvalue(String File,String Filename,int rownum,int colnum) throws IOException {
				
				
				 fi = new FileInputStream(File);
				 wb = new XSSFWorkbook(fi);
				 sheet  = wb.getSheet(Filename);
				Row row= sheet.getRow(rownum);
				Cell cell=row.getCell(colnum);
				boolean celldata;
				try {
					 celldata =cell.getBooleanCellValue();
				} catch (Exception e) {
					celldata = false;
				}
					
				wb.close();
				return celldata;
			}
*/			
	public  void setgreencolor(String Filename,int rownum,int colnum) throws IOException  {
		
		 fi = new FileInputStream(path);
		 wb = new XSSFWorkbook(fi);
		 sheet  = wb.getSheet(Filename);
		 
		 row= sheet.getRow(rownum);
		 cell=row.getCell(colnum);
		 
		 style = wb.createCellStyle();
		 
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
	    fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
	}
	public  void setRedcolor(String Filename,int rownum,int colnum) throws IOException{
		
		
		 fi= new FileInputStream(path);
		 wb = new XSSFWorkbook(fi);
		 sheet =wb.getSheet(Filename);
		 row=sheet.getRow(rownum);
		 cell=row.getCell(colnum);
		
	 style= wb.createCellStyle();
	 style.setFillForegroundColor(IndexedColors.RED.getIndex());
     style.setFillPattern(FillPatternType.SOLID_FOREGROUND);	
    
     cell.setCellStyle(style);
    
     fo = new FileOutputStream(path);
     wb.write(fo);
     wb.close();
    
		
	}
	
	public  void setCelldata(String Filename,int rownum,int colnum,String data) throws IOException{
		
		File xlfile=new File(path);
		if(!(xlfile.exists())) {
			wb = new XSSFWorkbook(fi);	
			fo = new FileOutputStream(path);
			wb.write(fo);
		}
		
		
		
		fi= new FileInputStream(path);
		  wb = new XSSFWorkbook(fi);
		  
		  if(wb.getSheetIndex(Filename)==-1)
			  wb.createSheet(Filename);
		   sheet =wb.getSheet(Filename);
		   if(sheet.getRow(rownum)==null)
			sheet.createRow(rownum);
		    row=  sheet.getRow(rownum);
		   cell= row.createCell(colnum);
		cell.setCellValue(data);
		wb = new XSSFWorkbook(fi);	
		fo = new FileOutputStream(path);
		wb.write(fo);
		 
		wb.close();
		
		
	}

}
