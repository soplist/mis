import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TestRegularExpressions {
    public static void main(String[] args) {
    	  //Pattern pattern = Pattern.compile("\\d{4}-\\d{2}");
    	  //Matcher matcher = pattern.matcher("2016-04");
    	  //boolean b= matcher.matches();
    	  //System.out.println(b);
    	  //Pattern pattern = Pattern.compile("\\d{4}/\\d{2}|\\d{4}/\\d");
    	  Pattern pattern = Pattern.compile("\\d{4}/\\d{1,2}/\\d{1,2}");
    	  
  	      Matcher matcher = pattern.matcher("2016/04/1");
  	      Matcher matcher_1 = pattern.matcher("2016/3/30");
  	      boolean b= matcher.matches();
  	      boolean c= matcher_1.matches();
  	      System.out.println(b);
  	      System.out.println(c);
    	  //String str = "2016-4";
    	  //String s1 = str.substring(0, 5)+"0"+str.substring(5, 6)+"-01";
    	  //System.out.println(s1);
    	  /*try {
			  Date d = new SimpleDateFormat("yyyy-MM-dd").parse("2016-04-01");
			  SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			  String s = format1.format(d);
			  System.out.println(s);
		  } catch (ParseException e) {
			// TODO Auto-generated catch block
			  e.printStackTrace();
		  }*/
    }
}
