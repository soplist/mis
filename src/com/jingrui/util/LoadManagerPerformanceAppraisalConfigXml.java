package com.jingrui.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * <p>Title: LoadManagerPerformanceAppraisalConfigXml.java</p>
 * <p>Description: information management software platform</p>
 * <p>Copyright: Copyright (c) 2011-2012 JinRui Information Technology Co., Ltd.</p>
 * <p>Company: JinRui Information Technology Co., Ltd.</p>
 * @author wangkang
 * @version 1.0 creation time£º2017-1-20 ÉÏÎç10:33:59
 */

public class LoadManagerPerformanceAppraisalConfigXml {
	
	private String manager_performance_appraisal_config_xml_path;
	
	private static final String TAG_NAME_EVALUATION_UNIT = "evaluation-unit";
	
	private static final String TAG_NAME_DEPARTMENT = "department";
	
	private static final String TAG_NAME_MANAGER = "manager";
	
	private HashMap<String, String> evaluationUnitMap = new HashMap<String, String>();
	
	public HashMap<String, String> getEvaluationUnitMap() {
		return evaluationUnitMap;
	}

	public void setEvaluationUnitMap(HashMap<String, String> evaluationUnitMap) {
		this.evaluationUnitMap = evaluationUnitMap;
	}

	public LoadManagerPerformanceAppraisalConfigXml(){
		try {
			manager_performance_appraisal_config_xml_path = getClass().getClassLoader().getResource("com/jingrui/xml/ManagerPerformanceAppraisalConfig.xml").toURI().getPath();
			Document doc = buildDocument();
			NodeList nodeList = getNodeList(doc);
			encapsulatesContent(nodeList);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//use dom api to build document object
    public Document buildDocument() throws ParserConfigurationException, SAXException, IOException{
    	File xmlFile = new File(manager_performance_appraisal_config_xml_path);
    	System.out.println("xml file name:"+xmlFile.getName());
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		
		return doc;
    }
    
    //get all the node list from document
    public NodeList getNodeList(Document doc){
    	NodeList nodeList = doc.getElementsByTagName(TAG_NAME_EVALUATION_UNIT);
    	
    	return nodeList;
    }

    public void encapsulatesContent(NodeList nodeList){
    	for(int i=0;i<nodeList.getLength();i++){
    		Element element = (Element)nodeList.item(i);
    		String department = "";
    		String manager = "";
    		for (Node node = element.getFirstChild(); node != null; node = node.getNextSibling())  
            {
    			if (node.getNodeType() == Node.ELEMENT_NODE)  
                {
    				String name = node.getNodeName();  
                    String value = node.getFirstChild().getNodeValue();  
                    
                    if(name.equals(TAG_NAME_DEPARTMENT)){
                    	department = value;
                    }else if(name.equals(TAG_NAME_MANAGER)){
                    	manager = value;
                    }
                }
            }
    		evaluationUnitMap.put(department, manager);
    	}
    }
    
    public static void printEvaluationUnitMap(HashMap<String, String> evaluationUnitMap){
    	Iterator iter = evaluationUnitMap.entrySet().iterator();
    	while (iter.hasNext()) {
    	   Map.Entry entry = (Map.Entry) iter.next();
    	   Object key = entry.getKey();
    	   Object val = entry.getValue();
    	   
    	   System.out.println("key:" + key + ",value:" + val);
    	}
    }
    
    public static void main(String[] args) {
    	LoadManagerPerformanceAppraisalConfigXml loadManagerPerformanceAppraisalConfigXml = new LoadManagerPerformanceAppraisalConfigXml();
    	HashMap<String, String> evaluationUnitMap = loadManagerPerformanceAppraisalConfigXml.getEvaluationUnitMap();
    	printEvaluationUnitMap(evaluationUnitMap);
	}
}
