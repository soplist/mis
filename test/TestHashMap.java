import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class TestHashMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String,Integer> table=new TreeMap<String,Integer>();
		table.put("2016-05-10", 10);
		table.put("2016-05-16", 20);
		table.put("2016-05-12", 10);
		table.put("2016-05", 10);
		table.put("2016-05-12", 50);
		
		for(String key : table.keySet()) {
		    System.out.println(key.substring(0, 4)+","+table.get(key));
			//System.out.println(key+","+table.get(key));
		}
		
	}

}
