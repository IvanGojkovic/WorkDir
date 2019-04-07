package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import Tests.HomePageTest;

public class WriteBug {
	
	

	
	public static void write (int bug, String name) throws Exception {
		
		ExcelUtils.setExcelFile(Constant.BUGTRACINGPATH + Constant.BUGTRACINGFILE, Constant.BT_SHEET_NAME);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
			
		String cell1 = "Value " + bug;
		String cell2 = String.valueOf(bug);
		String cell3 = "Greska";
		String cell4 = name;
		String cell5 = date.toString();
		String cell6 = "";
		String cell7 = "";
		String cell8 = "Java";
		String cell9 = "Windows";
		String cell10 = "Chrome";
		String cell11 = "";
		String cell12 = "";
		String cell13 = "";
		String cell14 = "";
        String cell15 = "";
        String cell16 = "";
        String cell17 = "";
        String cell18= "";
        
        int column = 2 + HomePageTest.bugNo;
        
        ExcelUtils.setCellData(cell1, 0, column);
        ExcelUtils.setCellData(cell2, 1, column);
        ExcelUtils.setCellData(cell3, 2, column);
        ExcelUtils.setCellData(cell4, 3, column);
        ExcelUtils.setCellData(cell5, 4, column);
        ExcelUtils.setCellData(cell6, 5, column);
        ExcelUtils.setCellData(cell7, 6, column);
        ExcelUtils.setCellData(cell8, 7, column);
        ExcelUtils.setCellData(cell9, 8, column);
        ExcelUtils.setCellData(cell10, 9, column);
        ExcelUtils.setCellData(cell11, 10, column);
        ExcelUtils.setCellData(cell12, 11, column);
        ExcelUtils.setCellData(cell13, 12, column);
        ExcelUtils.setCellData(cell14, 13, column);
        ExcelUtils.setCellData(cell15, 14, column);
        ExcelUtils.setCellData(cell16, 15, column);
        ExcelUtils.setCellData(cell17, 16, column);
        ExcelUtils.setCellData(cell18, 17, column);
        
        
        
        
        
        
        
        JFrame f=new JFrame("Greska");  
        JButton b=new JButton("Dodaj Bug");  
        b.setBounds(50,200,95,30);  
        f.add(b);  
        f.setSize(400,400);  
        f.setLayout(null);  
        f.setVisible(true);   
        
    //    ExcelUtils.setCellData(cell1, 0, bugID);
      //  ExcelUtils.setCellData(cell2, 1, bugID);
        
        
        
    	

		
		
		
		
		System.out.println("Pronadjena greska!!!");
		
	}
}
