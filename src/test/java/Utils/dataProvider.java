package Utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProvider {

	@DataProvider(name="Logindata")
	public String [][]getdata() throws IOException{
		
		String path="//.testdata/logindata.csv";
		XlUtils excel= new XlUtils(path);
		int totalrows=	excel.getrowcount("Sheet1");
		int totalcols =excel.getcolcount("Sheet1", 1);
		
		
		String logindata[][]= new String[totalrows][totalcols];
		
		
		for(int i=1;i<totalrows;i++) {
			
			for(int j=0;j<totalcols;j++) {
				
				 logindata[i-1][j]= excel.getCellvalue("sheet1", i, j);
				
			}
		}
		
		return logindata;
		
		
		
		
		
		
		
	}
	
	
}
