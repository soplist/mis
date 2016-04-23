import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Myjproject {

	/**
	 * @param args
	 */
	private void insertUsers(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("success loading mysql driver!");
		} catch (Exception e) {
			System.out.println("error loading mysql driver!");
			e.printStackTrace();
		}
        
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/misdb","root","root");
			
			int num=100;
			PreparedStatement statement = connect.prepareStatement(
					"insert into user values(?,?)");
			for (int i = 0; i < num; i++) {
				statement.setString(1, "wangkang"+i);
				statement.setString(2, "bo"+i);
				statement.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void insertCustormers(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("success loading mysql driver!");
		} catch (Exception e) {
			System.out.println("error loading mysql driver!");
			e.printStackTrace();
		}
        
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/misdb","root","root");
			
			int num=100;
			PreparedStatement statement = connect.prepareStatement(
					"insert into customer(start_date,company,cost,legal_representative," +
					                     "office_staff,detailed_address,office_telephone,"+
							             "cellphone,qq,micromsg,introduction,cooperation_project,"+
					                     "possible_business,client_evaluation,comment)"+
							             " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			for (int i = 0; i < num; i++) {
				statement.setString(1, "2016-03-29");
				statement.setString(2, "安康金瑞可以有限公司"+i);
				statement.setString(3, "200000");
				statement.setString(4, "陈旭楠");
				statement.setString(5, "董贵琦");
				statement.setString(6, "陕西省安康市高新区世纪大道1号");
				statement.setString(7, "0915-3838968");
				statement.setString(8, "15029345605");
				statement.setString(9, "371189005");
				statement.setString(10, "LV2326061314");
				statement.setString(11, "安康金瑞可以有限公司");
				statement.setString(12, "车载GPS定位系统");
				statement.setString(13, "车载GPS定位系统");
				statement.setString(14, "优良");
				statement.setString(15, "无");
				statement.executeUpdate();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	
	
	public static void main(String[] args) {
		Myjproject myproj = new Myjproject();
		//myproj.insertUsers();
		myproj.insertCustormers();
	}

}
