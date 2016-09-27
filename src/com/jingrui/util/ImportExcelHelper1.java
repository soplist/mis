package com.jingrui.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jingrui.domain.Customer1;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ImportExcelHelper1 {
	
	public ArrayList<Customer1> readExcel(String path){
		Workbook wb = null;
		ArrayList<Customer1> customers = new ArrayList<Customer1>();
		try {
			InputStream instream = new FileInputStream(path);
			wb = Workbook.getWorkbook(instream);
			
			Sheet rsheet = wb.getSheet(0);
			
			int colNum = rsheet.getColumns();
			System.out.println("colNum:"+colNum);
			int rowNum = rsheet.getRows();
			System.out.println("rowNum:"+rowNum);
			
			for(int i=1;i<rowNum;i++){
				Customer1 c = new Customer1();
				for(int j=0;j<colNum;j++){
					Cell cell = rsheet.getCell(j, i);
					if(j == 0 && (cell.getContents().equals("")||cell.getContents()==null)){
						return customers;
					}
					System.out.print(cell.getContents()+" ");
					switch(j){
					    case 0:
					    	String content = cell.getContents().trim();
					    	if(content.equals("家友家居")){
					    		c.setDepartment(2);
					    	}
					    	if(content.equals("科技事业部")){
					    		c.setDepartment(4);
					    	}
					    	if(content.equals("新传媒事业部")){
					    		c.setDepartment(1);
					    	}
					    	break;
					    case 1:
					    	c.setCompany(cell.getContents().trim());
					    	break;
					    case 2:
					    	String cstr = cell.getContents().trim();
					    	
					    	Pattern pattern_1 = Pattern.compile("\\d{4}-\\d");
					    	Matcher matcher_1 = pattern_1.matcher(cstr);
					    	boolean b= matcher_1.matches();
					    	
					    	Pattern pattern_2 = Pattern.compile("\\d{4}-\\d{2}");
					    	Matcher matcher_2 = pattern_2.matcher(cstr);
					    	boolean d= matcher_2.matches();
					    	
					    	Pattern pattern_3 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
					    	Matcher matcher_3 = pattern_3.matcher(cstr);
					    	boolean f= matcher_3.matches();
					    	
					    	Pattern pattern_4 = Pattern.compile("\\d{2}-\\d{1,2}-\\d{1,2}");
					    	Matcher matcher_4 = pattern_4.matcher(cstr);
					    	boolean g= matcher_4.matches();
					    	
					    	
					    	Pattern pattern_5 = Pattern.compile("\\d{4}—\\d{1,2}—\\d{1,2}");
					    	Matcher matcher_5 = pattern_5.matcher(cstr);
					    	boolean h= matcher_5.matches();
					    	System.out.println("cstr:"+cstr+",h:"+g);
					    	try {
					    	    if(b){
					    		    String s1 = cstr.substring(0, 5)+"0"+cstr.substring(5, 6)+"-01";
					    		    c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(s1));
					    		    //System.out.println(c.getStartDate());
							    }
					    	    if(d){
					    	    	String s1 = cstr+"-01";
					    		    c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(s1));
					    		    //System.out.println(c.getStartDate());
					    	    }
					    	    if(f){
					    	    	c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(cstr));
					    	    	//System.out.println(c.getStartDate());
					    	    }
					    	    if(g){
					    	    	String s1 = cstr.replace('/', '-');
					    	    	System.out.println("s1:"+s1);
					    	    	c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(s1));
					    	    }
					    	    if(h){
					    	    	String s1 = cstr.replace('—', '-');
					    	    	System.out.println("s1:"+s1);
					    	    	c.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(s1));
					    	    }
					    	} catch (ParseException e) {
								// TODO Auto-generated catch block
								    e.printStackTrace();
							}
						    
					    	break;
					    case 3:
					    	c.setLegalRepresentative(cell.getContents().trim());
					    	break;
					    case 4:
					    	c.setOfficeStaff(cell.getContents().trim());
					    	break;
					    case 5:
					    	c.setOfficeTelephone(cell.getContents().trim());
					    	break;
					    case 6:
					    	c.setCellphone(cell.getContents().trim());
					    	break;
					    case 7:
					    	c.setQq(cell.getContents().trim());
					    	break;
					    case 8:
					    	c.setMicromsg(cell.getContents().trim());
					    	break;
					    case 9:
					    	c.setDetailedAddress(cell.getContents().trim());
					    	break;
					    case 10:
					    	c.setIntroduction(cell.getContents().trim());
					    	break;
					    case 11:
					    	c.setCooperationProject(cell.getContents().trim());
					    	break;
					    case 12:
					    	c.setPossibleBusiness(cell.getContents().trim());
					    	break;
					    case 13:
					    	c.setClientEvaluation(cell.getContents().trim());
					    	break;
					    case 14:
					    	//System.out.println(cell.getContents().trim());
					    	String cost = cell.getContents().trim();
					    	if(cost == null || cost.equals("")){
					    		cost = "0";
					    	}
					    	c.setCost(new Float(cost));
					    	break;
					    case 15:
					    	c.setComment(cell.getContents().trim());	
					    	break;
					    	
					}
				}
				customers.add(c);
				//System.out.println();
				System.out.println("customers.size:"+customers.size());
			}
			//System.out.println("customers.size:"+customers.size());
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
		return customers;
	}
	
	public void insertIntoDB(ArrayList<Customer1> customers){
		Connection connect = null;
		Statement stmt = null;
		try {
        	Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("success loading mysql driver!");
		
			connect = DriverManager.getConnection("jdbc:mysql://61.150.109.162:3306/misdb?characterEncoding=utf8","root","root");
        	//connect = DriverManager.getConnection(
			          //"jdbc:mysql://localhost:3306/misdb?characterEncoding=utf8","root","root");
			System.out.println("success connect mysql driver!");
			stmt = connect.createStatement();
			
			for (Customer1 customer : customers) {
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("customer.getStartDate:"+customer.getStartDate());
				String sd = format1.format(customer.getStartDate());
				
				String sql = "insert into customer(start_date,company,cost,legal_representative,office_staff,detailed_address,office_telephone,cellphone,qq,micromsg,introduction,cooperation_project,possible_business,client_evaluation,comment,depid,area) "
						+"values('"+sd+"','"+customer.getCompany()+"',"+customer.getCost()+",'"+customer.getLegalRepresentative()+"','"+customer.getOfficeStaff()
						+"','"+customer.getDetailedAddress()+"','"+customer.getOfficeTelephone()+"','"+customer.getCellphone()+"','"+customer.getQq()+"','"+customer.getMicromsg()+"','"+customer.getIntroduction()
						+"','"+customer.getCooperationProject()+"','"+customer.getPossibleBusiness()+"','"+customer.getClientEvaluation()+"','"+customer.getComment()+"',"+customer.getDepartment()+",'无');";
				stmt.executeUpdate(sql);
			}
			
		} catch (Exception e) {
			System.out.println("get data error!");
			e.printStackTrace();
		} finally{
			try{
				connect.close();
				stmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
    public static void main(String[] args) {
    	ImportExcelHelper1 ieh1 = new ImportExcelHelper1();
	    //String excelPath = "D:"+ File.separator + "wangkang"+ File.separator+"doc"+ File.separator+"companydoc"+File.separator+"客户信息标准版、4.12家居.xls";
    	//String excelPath = "D:"+ File.separator + "wangkang"+ File.separator+"doc"+ File.separator+"companydoc"+File.separator+"客户信息标准版、(1).xls";
    	String excelPath = "D:"+ File.separator + "wangkang"+ File.separator+"doc"+ File.separator+"companydoc"+File.separator+"在安康传媒客户信息标准版.xls";
    	ArrayList<Customer1> customers = ieh1.readExcel(excelPath);
	    ieh1.insertIntoDB(customers);
	    
    }
}
