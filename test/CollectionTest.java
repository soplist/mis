import java.util.Vector;


/**
 * <p>Title: CollectionTest.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-3-18 ÉÏÎç10:42:48
 */

public class CollectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vector v = new Vector();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(0, 5);
        for (Object object : v) {
			System.out.print((Integer)object+" ");
		}
        
	}

}
