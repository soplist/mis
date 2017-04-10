import java.util.Date;


/**
 * <p>Title: TimePoint.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-3-18 ÉÏÎç10:45:17
 */

public class TimePoint {
    private Date date;
    private String event;
    
    public TimePoint(){
    	date = new Date();
    }
    
    public TimePoint(Date date){
        this.date = date;
    }

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	public static void main(String[] args) {
		TimePoint tp = new TimePoint();
		tp.getDate();
	}
    
}
