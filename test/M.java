
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class M {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Timer timer = new Timer();
		//System.out.println(timer.toString());
        //timer.schedule(new MyTask(), 20000, 5000);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(df.format(new Date()));
	}

}

class MyTask extends TimerTask {  
	  
    @Override  
    public void run() {  
        System.out.println("dddd");  
  
    }  
  
}  
