package data;

import utilities.Xls_Reader;

public class DataFile {

	Xls_Reader d = new Xls_Reader("E:\\eclipse\\testng\\NikulTest.xlsx") ;
	public String incorrectemail= d.getCellData("Data1",1, 2);
	public String incorrectpassword=  d.getCellData("Data1",2,1 );
	public String invalidEmail= d.getCellData("Data1",1, 3);
	
	public String globalError =  d.getCellData("Data1",5, 2);
	public String invalidEmailerr=  d.getCellData("Data1",3, 3);
	public String emptyemailerr =  d.getCellData("Data1",3, 4);
	public String emptypasswrderr =  d.getCellData("Data1",4, 5);
}
