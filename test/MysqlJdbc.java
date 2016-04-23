import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class MysqlJdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
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
			System.out.println("success connect mysql driver!");
			Statement stmt = connect.createStatement();
			ResultSet rs = stmt.executeQuery("select * from user");
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
		} catch (Exception e) {
			System.out.println("get data error!");
			e.printStackTrace();
		}
	}

}
