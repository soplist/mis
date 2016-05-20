import java.io.File;
import java.io.IOException;


public class TestNewFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
		File f = new File("C:\\temp");
        if(!f.exists())
        	f.mkdir();
		}catch(Exception e){
            e.printStackTrace();
        }
	}

}
