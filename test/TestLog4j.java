import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog4j {
	/**
	 * @param args
	 */
	private static Logger logger = Logger.getLogger(TestLog4j.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure( "D://wangkang//Workspaces//MyEclipse 10//mis//src//log4j.properties " );
		
		// TODO Auto-generated method stub
        logger.debug("this is debug message.");
        logger.info("This is info message.");
        logger.error("this is error message");
        logger.fatal("this is fanal message");
        logger.warn("this is warn message");
	}

}
