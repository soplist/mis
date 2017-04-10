package com.jingrui.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.jingrui.domain.UserConfigInformation;
import com.jingrui.domain.UserInformation;
import com.jingrui.domain.UserResumeInformation;

/**
 * <p>Title: LoadAllUserInformationXml.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-11 ÉÏÎç9:25:05
 */

public class LoadAllUserInformationXml {

	private static final String USER_INFORMATION_DIRECTORY_PATH = "src/com/jingrui/xml/user";
	private static final String USER_INFORMATION_DIRECTORY_DEPLOYMENT_ENVIRONMENT_PATH = "WEB-INF/classes/com/jingrui/xml/user";
	private String user_information_directory_path;
	private static final String XML_FILE_EXTENSION_NAME = ".xml";
	private static final String TAG_NAME_ID = "id";
	private static final String TAG_NAME_WORK_STATUS = "work-status";
	private static final String TAG_NAME_USERNAME = "username";
	private static final String TAG_NAME_USER_CONFIG_INFORMATION = "user-config-information";
	private static final String TAG_NAME_USER_RESUME_INFORMATION = "user-resume-information";
	
	private static final String TAG_NAME_NAME = "name";
	private static final String TAG_NAME_DEPARTMENT = "department";
	private static final String TAG_NAME_MANAGER_STATUS = "manager-status";
	private static final String TAG_NAME_BOSS_STATUS = "boss-status";
	private static final String TAG_NAME_position = "position";
	private static final String TAG_NAME_JOIN_TIME = "join-time";
	
	private static final String TAG_NAME_PERMISSION = "permission";
	
	private ArrayList<UserInformation> userInformationList;
	
	public LoadAllUserInformationXml(){
		try {
			user_information_directory_path = getClass().getClassLoader().getResource("com/jingrui/xml/user").toURI().getPath();
			userInformationList = readAllUserInformationXml(user_information_directory_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<UserInformation> readAllUserInformationXml(String filePath) throws FileNotFoundException, IOException{
		ArrayList<UserInformation> userInformationList = new ArrayList<UserInformation>();
		File file = new File(filePath);
		if(file.isDirectory()){
			String[] fileList = file.list();
			for (int i = 0; i < fileList.length; i++) {
				//System.out.println(fileList[i]);
				if(fileList[i].endsWith(XML_FILE_EXTENSION_NAME)){
					UserInformation userInformation = encapsulatesUserInformationFromXml(user_information_directory_path+fileList[i]);
					userInformationList.add(userInformation);
				}
			}
		} 
		
		return userInformationList;
	}
	
	public UserInformation encapsulatesUserInformationFromXml(String filePath){
		UserInformation userInformation = new UserInformation();
		
		try {
			File xmlFile = new File(filePath);
	    	
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder;
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(xmlFile);
			
			String id = getOneLevelNodeValue(doc,TAG_NAME_ID);
			//System.out.println("id:" + id);
			userInformation.setId(Integer.valueOf(id));
			
			String workStatus = getOneLevelNodeValue(doc,TAG_NAME_WORK_STATUS);
			//System.out.println("id:" + workStatus);
			userInformation.setWorkStatus(Boolean.valueOf(workStatus));
			
			String username = getOneLevelNodeValue(doc,TAG_NAME_USERNAME);
			//System.out.println("id:" + username);
			userInformation.setUsername(username);
			
			UserConfigInformation userConfigInformation = encapsulatesUserConfigInformation(doc);
			userInformation.setUserConfigInformation(userConfigInformation);
			
			UserResumeInformation userResumeInformation = encapsulatesUserResumeInformation(doc);
			userInformation.setUserResumeInformation(userResumeInformation);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return userInformation;
	}
	
	public String getOneLevelNodeValue(Document doc,String TagName){
		String value = "";
		NodeList nodeList = doc.getElementsByTagName(TagName);
		for(int i=0;i<nodeList.getLength();i++){
			Element element = (Element)nodeList.item(i);
			value = element.getTextContent();
		}
		return value;
	}
	
	public UserConfigInformation encapsulatesUserConfigInformation(Document doc){
		UserConfigInformation userConfigInformation = new UserConfigInformation();
		NodeList userResumeInformation_nodeList = doc.getElementsByTagName(TAG_NAME_USER_CONFIG_INFORMATION);
		for(int i=0;i<userResumeInformation_nodeList.getLength();i++){
			Element element = (Element)userResumeInformation_nodeList.item(i);
			for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling())  
            {  
                if (node.getNodeType() == Node.ELEMENT_NODE)  
                {  
                    String name = node.getNodeName();  
                    String value = node.getFirstChild().getNodeValue();  
                    //System.out.print(name + ":" + value + "\t");
                    
                    if(name.equals(TAG_NAME_PERMISSION)){
                    	try{
                    	    Integer permission = Integer.parseInt(value);
                    	    userConfigInformation.setPermission(permission);
                    	}catch (NumberFormatException e) {
                    	    e.printStackTrace();
                    	}
                    }
                    
                }  
            }  
		}
		return userConfigInformation;
	}
	
	public UserResumeInformation encapsulatesUserResumeInformation(Document doc){
		UserResumeInformation userResumeInformation = new UserResumeInformation();
		NodeList userResumeInformation_nodeList = doc.getElementsByTagName(TAG_NAME_USER_RESUME_INFORMATION);
		for(int i=0;i<userResumeInformation_nodeList.getLength();i++){
			Element element = (Element)userResumeInformation_nodeList.item(i);
			for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling())  
            {  
                if (node.getNodeType() == Node.ELEMENT_NODE)  
                {  
                    String name = node.getNodeName();  
                    String value = node.getFirstChild().getNodeValue();  
                    //System.out.print(name + ":" + value + "\t");
                    
                    if(name.equals(TAG_NAME_NAME)){
                    	userResumeInformation.setName(value);
                    }
                    else if(name.equals(TAG_NAME_DEPARTMENT)){
                    	userResumeInformation.setDepartment(value);
                    }
                    else if(name.equals(TAG_NAME_MANAGER_STATUS)){
                    	Boolean Bl = new Boolean(value);
                		boolean bl = Bl.booleanValue();
                		userResumeInformation.setManagerStatus(bl);
                    }
                    else if(name.equals(TAG_NAME_BOSS_STATUS)){
                    	Boolean Bl = new Boolean(value);
                		boolean bl = Bl.booleanValue();
                		userResumeInformation.setBossStatus(bl);
                    }
                    else if(name.equals(TAG_NAME_position)){
                    	userResumeInformation.setPosition(value);
                    }
                    else if(name.equals(TAG_NAME_JOIN_TIME)){
                    	try {
                    		SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
							Date date =  formatter.parse(value);
							userResumeInformation.setJoinTime(date);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                }  
            }  
		}
		return userResumeInformation;
	}
	
	public ArrayList<UserInformation> getUserInformationList() {
		return userInformationList;
	}

	public void setUserInformationList(
			ArrayList<UserInformation> userInformationList) {
		this.userInformationList = userInformationList;
	}
	
	public static void printUserInformationList(ArrayList<UserInformation> userInformationList){
		for (UserInformation userInformation : userInformationList) {
			System.out.println("id:"+userInformation.getId()+",work status:"+userInformation.isWorkStatus()+",username:"+userInformation.getUsername());
			UserResumeInformation userResumeInformation = userInformation.getUserResumeInformation();
			System.out.println("name:"+userResumeInformation.getName()+",department:"+userResumeInformation.getDepartment()+",manager status:"+userResumeInformation.isManagerStatus()+",boss status:"+userResumeInformation.isBossStatus()+",position:"+userResumeInformation.getPosition()+",join time:"+userResumeInformation.getJoinTime());
			System.out.println("----------------------------");
		}
	}
	
	public static void main(String[] args) {
		LoadAllUserInformationXml testLoadAllUserInformationXml = new LoadAllUserInformationXml();
		ArrayList<UserInformation> userInformationList = testLoadAllUserInformationXml.getUserInformationList();
		printUserInformationList(userInformationList);
		/*try {
			ArrayList<UserInformation> userInformationList = testLoadAllUserInformationXml.readAllUserInformationXml(USER_INFORMATION_DIRECTORY_PATH);
			printUserInformationList(userInformationList);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
