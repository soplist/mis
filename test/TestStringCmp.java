
public class TestStringCmp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String date_1="2016-05";
        String date_2="2016-04-01";
        String date_3="2016-05-11";
        String date_4="2016-05-12";
        String date_5="2016-05-11";
        System.out.println(date_3.compareToIgnoreCase(date_1));
        System.out.println(date_4.compareToIgnoreCase(date_1));
        System.out.println(date_1.compareToIgnoreCase(date_3));
        System.out.println(date_3.compareToIgnoreCase(date_5));
        System.out.println(date_2.compareToIgnoreCase(date_1));
	}

}
