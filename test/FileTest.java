import java.io.File;


/**
 * <p>Title: FileTest.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-12 ÉÏÎç10:00:08
 */

public class FileTest {
public static void main(String[] args) {
	File file1 = new File("D:\\wangkang\\Workspaces\\MyEclipse%2010\\.metadata\\.me_tcat\\webapps\\mis\\WEB-INF\\classes\\com\\jingrui\\xml\\user");
	File file2 = new File("D:/wangkang/Workspaces/MyEclipse 10/.metadata/.me_tcat/webapps/mis/WEB-INF/classes/com/jingrui/xml/user");
	File file3 = new File("D:\\wangkang\\Workspaces\\MyEclipse 10\\.metadata\\.me_tcat\\webapps\\mis\\WEB-INF\\classes\\com\\jingrui\\xml\\user");
	
	System.out.println(file1.isDirectory());
	System.out.println(file2.isDirectory());
	System.out.println(file3.isDirectory());
}
}
