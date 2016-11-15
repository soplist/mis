import java.text.SimpleDateFormat;
import java.util.Calendar;


public class CalendarTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar calendar1 = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		calendar1.add(Calendar.DATE, -3);
		String three_days_ago = sdf1.format(calendar1.getTime());
		System.out.println(three_days_ago);
	}

}
