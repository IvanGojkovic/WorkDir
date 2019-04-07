package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Constant {
	
	// EXCEL DATA
	public static final String DATAPATH = "C:\\Users\\Ivan\\Desktop\\";
	public static final String SHEET_NAME = "Registracija";
	public static final String SHEET2_NAME = "Tekst";
	public static final String DATAFILE = "DataIzlet.xls";
    
    // EXCEL BUG TRACING
    public static final String BUGTRACINGFILE = "BugTracing.xlsx";
    public static final String BUGTRACINGPATH = "C:\\Users\\Ivan\\Desktop\\";
	public static final String BT_SHEET_NAME = "Sheet1";
	
	// DEFAULT USER
	public static final String NAME = "Ivan";   
	public static final String LASTNAME = "Gojkovic";
	public static final String USERNAME = "Ivan80";
	public static final String EMAIL = "ivan@hotmail.com";
	public static final String PASSWORD = "ivan1234";
	
	// KREIRANJE TEKSTA ZA headerText
	public static StringBuilder headerText (String name) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		StringBuilder sb = new StringBuilder();
		sb.append("AUTOMATSKI TEST SAJTA IZLOG");
		sb.append(System.getProperty("line.separator"));
		sb.append("radjen dana : " + dateFormat.format(date));
		sb.append(System.getProperty("line.separator"));
		sb.append("tester : " + name);
		sb.append(System.getProperty("line.separator"));
		sb.append("********************************************");
		sb.append(System.getProperty("line.separator"));
		return sb;
		
	}
	
}
