import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TeatDate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		DateFormat format1 = new SimpleDateFormat("yyyy-MM");
        String s = format1.format(new Date());
        System.out.println(s);
	}

}
