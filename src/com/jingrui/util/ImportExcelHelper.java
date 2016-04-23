package com.jingrui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Cell;
import jxl.CellType;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.read.biff.BiffException;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.Number;
import jxl.write.Boolean;
import jxl.write.biff.RowsExceededException;

public class ImportExcelHelper {

	/**
	 * @param args
	 */
	public void createExcel(OutputStream os) throws WriteException,IOException{
		//create work book
		WritableWorkbook workbook = Workbook.createWorkbook(os);
		//create sheet
		WritableSheet sheet = workbook.createSheet("First sheet", 0);
		//create content
		Label column_1 = new Label(0,0,"col_1");
		sheet.addCell(column_1);
		Label column_2 = new Label(1,0,"col_2");
		sheet.addCell(column_2);
		Label column_3 = new Label(2,0,"col_3");
		sheet.addCell(column_3);
		Label column_4 = new Label(3,0,"col_4");
		sheet.addCell(column_4);
		Label column_5 = new Label(4,0,"col_5");
		sheet.addCell(column_5);
		
		Label data = new Label(0,1,"data");
		sheet.addCell(data);
		//add float
		Number number = new Number(1,1,3.1415926);
		sheet.addCell(number);
		//add integer
		Number ints = new Number(2,1,1024);
		sheet.addCell(ints);
		//add boolean
		Boolean bools = new Boolean(3,1,true);
		sheet.addCell(bools);
		//add date
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Label date = new Label(4,1,df.format(new Date()));
		sheet.addCell(date);
		
		workbook.write();
		workbook.close();
		os.close();
	}
	public void IOOperater_1(){
		File f = new File("D:"+ File.separator + "1.xls");
        try {
			OutputStream os = new FileOutputStream(f);
			createExcel(os);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readExcel(){
		Workbook wb = null;
		try {
			InputStream instream = new FileInputStream("D:"+ File.separator + "1.xls");
			wb = Workbook.getWorkbook(instream);
			
			Sheet rsheet = wb.getSheet(0);
			
			int colNum = rsheet.getColumns();
			int rowNum = rsheet.getRows();
			
			for(int i=0;i<rowNum;i++){
				for(int j=0;j<colNum;j++){
					Cell cell = rsheet.getCell(j, i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void NewExcelAndWriteUpdate(){
		Workbook wb = null;
		try {
			InputStream instream = new FileInputStream("D:"+ File.separator + "1.xls");
			wb =Workbook.getWorkbook(instream);
			WritableWorkbook wwb = Workbook.createWorkbook(new File("D:"+ File.separator + "11.xls"),wb);
		    WritableSheet ws = wwb.getSheet(0);
		    WritableCell wc = ws.getWritableCell(0,0);
		    
		    if(wc.getType() == CellType.LABEL){
		    	Label l = (Label) wc;
		    	l.setString("new name");
		    }
		    
		    wwb.write();
		    wwb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			wb.close();
		}
	}
	
	public void readExcel(String filePath){
		try {
			InputStream is = new FileInputStream(filePath);
		    Workbook rwb = Workbook.getWorkbook(is);
		    Sheet st = rwb.getSheet(0);
		    
		    Cell c00 = st.getCell(0,0);
		    String str00 = c00.getContents();
		    
		    if(c00.getType() == CellType.LABEL){
		    	LabelCell labelc00 = (LabelCell) c00;
		    	str00 = labelc00.getString();
		    }
		    
		    System.out.println(str00);
		    Sheet rst = rwb.getSheet(0);
		    
		    int rsColumns = rst.getColumns();
		    int rsRows = rst.getRows();
		    
		    for (int i = 0; i < rsRows; i++) {
				for (int j = 0; j < rsColumns; j++) {
					Cell cell = rst.getCell(j,i);
					System.out.print(cell.getContents()+" ");
				}
				System.out.println();
			}
		    
		    rwb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeExcel(String filePath){
		File f = new File(filePath);
        try {
			OutputStream os = new FileOutputStream(f);
			WritableWorkbook wwb = Workbook.createWorkbook(os);
			
			WritableSheet ws = wwb.createSheet("Test Sheet", 0);
			
			Label label = new Label(0,0,"test");
			ws.addCell(label);
			
			WritableFont wf = new WritableFont(WritableFont.TIMES,18,WritableFont.BOLD,true);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			Label labelcf = new Label(1,0,"this is a label test",wcf);
			ws.addCell(labelcf);
			
			WritableFont wfc = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.DARK_YELLOW);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			Label labelCF = new Label(1,0,"ok",wcfFC);
			ws.addCell(labelCF);
			
			Number labelN = new Number(0,1,3.1415926);
			ws.addCell(labelN);
			NumberFormat nf = new NumberFormat("#.##");
			WritableCellFormat wcfN = new WritableCellFormat(nf);
			Number labelNF = new Number(1,1,3.1415926,wcfN);
			ws.addCell(labelNF);
			
			Boolean labelB = new Boolean(0,2,true);
			ws.addCell(labelB);
			Boolean labelB1 = new Boolean(1,2,false);
			ws.addCell(labelB1);
			
			DateTime labelDT = new DateTime(0,3,new Date());
			ws.addCell(labelDT);
			
			DateFormat df = new DateFormat("dd MM yyyy hh:mm:ss");
			WritableCellFormat wcfDF = new WritableCellFormat(df);
			DateTime labelDTF = new DateTime(1,3,new Date(),wcfDF);
			ws.addCell(labelDTF);
			
			File image = new File("D:\\asf_logo.png");
			WritableImage wimage = new WritableImage(0,4,6,17,image);
			ws.addImage(wimage);
			
			wwb.write();
			wwb.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modifyExcel(String f1p,String f2p){
		File f1 = new File(f1p);
		File f2 = new File(f2p);
		
		try {
			Workbook rwb = Workbook.getWorkbook(f1);
			WritableWorkbook wwb = Workbook.createWorkbook(f2,rwb);
			WritableFont wfc = new WritableFont(WritableFont.ARIAL,10,WritableFont.NO_BOLD,false,UnderlineStyle.NO_UNDERLINE,Colour.BLUE);
			WritableCellFormat wcfFC = new WritableCellFormat(wfc);
			WritableSheet ws = wwb.getSheet(0);
			WritableCell wc = ws.getWritableCell(0,0);
			if(wc.getType() == CellType.LABEL){
				Label labelCF = new Label(0,0,"people(new)",wcfFC);
				ws.addCell(labelCF);
			}
			wwb.write();
			wwb.close();
			rwb.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ImportExcelHelper ieh = new ImportExcelHelper();
        //ieh.IOOperater_1();
        //ieh.readExcel();
        //ieh.NewExcelAndWriteUpdate();
        //ieh.readExcel("D:"+ File.separator + "1.xls");
        ieh.writeExcel("D:"+ File.separator + "12.xls");
        //ieh.modifyExcel("D:"+ File.separator + "1.xls","D:"+ File.separator + "12.xls");
	}

}
