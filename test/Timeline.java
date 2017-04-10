import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;


/**
 * <p>Title: Timeline.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-3-18 ÉÏÎç10:43:50
 */

public class Timeline extends LinkedList<TimePoint> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5833304565576188185L;
	

	@Override
	public boolean add(TimePoint timePoint){
		try{
		    this.add(findInsertPosition(timePoint), timePoint);
		    return true;
		}catch(Exception ex){
			ex.printStackTrace();
		    return false;
		}
	}
	
	//find position match parameter time point's date
	public int findInsertPosition(TimePoint timePoint){
		Iterator<TimePoint> it = this.iterator();
		int position = 0;
		while(it.hasNext()){
			TimePoint tp = it.next();
			if(compareDate(timePoint,tp)==-1){
				break;
			}
			position++;
		}
		return position;
	}
	
	//compare two time point by it's date
	public int compareDate(TimePoint timePoint1,TimePoint timePoint2){
		//extract date
		Date date1 = timePoint1.getDate();
		Date date2 = timePoint2.getDate();
		
		//compare
		if (date1.getTime() < date2.getTime()) {
            //System.out.println("date1 < date2");
            return 1;
        } else if (date1.getTime() > date2.getTime()) {
            //System.out.println("date1 > date2");
            return -1;
        } else {
        	//System.out.println("date1 = date2");
            return 0;
        }
        
    }
	
	public void printTimelineInformation(){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Iterator<TimePoint> it = this.iterator();
		while(it.hasNext()){
			TimePoint tp = it.next();
			System.out.println(df.format(tp.getDate())+":"+tp.getEvent());
		}
	}
	
	public static void main(String[] args) {
		//testCompareDate();
		testAdd();
	}
	
	public static void testAdd(){
        Timeline timeline = new Timeline();
		
		TimePoint tp1 = new TimePoint();
		TimePoint tp2 = new TimePoint();
		TimePoint tp3 = new TimePoint();
		
		tp1.setDate(new Date());
		tp1.setEvent("go to work");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp2.setDate(new Date());
		tp2.setEvent("go home");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp3.setDate(new Date());
		tp3.setEvent("sleep");
		
		timeline.add(tp1);
		timeline.add(tp3);
		timeline.add(tp2);
		
		timeline.printTimelineInformation();
	}
	
	public static void testCompareDate(){
        Timeline timeline = new Timeline();
		
		TimePoint tp1 = new TimePoint();
		TimePoint tp2 = new TimePoint();
		
		tp1.setDate(new Date());
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tp2.setDate(new Date());
		
		System.out.println(timeline.compareDate(tp1, tp2));
	}
}
