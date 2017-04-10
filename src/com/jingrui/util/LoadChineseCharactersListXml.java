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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LoadChineseCharactersListXml {
	
	private static final String CHINESE_CHARACTERS_XML_PAT = "src/com/jingrui/xml/ChineseCharactersList.xml";
	private static final String TAG_NAME_STRING = "string";
	private static final String ATTRIBUTE_KEY = "key";
	
	private String chinese_characters_xml_path;
	
	private HashMap<String, String> nodeListMap;
	
	//load xml file in constructor
    public LoadChineseCharactersListXml(){
    	
    	try {
    		chinese_characters_xml_path = getClass().getClassLoader().getResource("com/jingrui/xml/ChineseCharactersList.xml").toURI().getPath();
    		Document doc = buildDocument();
    		NodeList nodeList = getNodeList(doc);
			
			//loopThroughNodeListAndShow(nodeList);
    		nodeListMap = loadNodeList(nodeList);
    		
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
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
    
    //use dom api to build document object
    public Document buildDocument() throws ParserConfigurationException, SAXException, IOException{
    	File xmlFile = new File(chinese_characters_xml_path);
    	System.out.println("xml file name:"+xmlFile.getName());
    	
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(xmlFile);
		
		return doc;
    }
    
    //get all the node list from document
    public NodeList getNodeList(Document doc){
    	NodeList nodeList = doc.getElementsByTagName(TAG_NAME_STRING);
    	
    	return nodeList;
    }
    
    //loop node list and show them
    public void loopThroughNodeListAndShow(NodeList nodeList){
    	for(int i=0;i<nodeList.getLength();i++){
			Element element = (Element)nodeList.item(i);
			String key = element.getAttribute(ATTRIBUTE_KEY);
			System.out.print("key:" + key+ ",");
			
			String value = element.getTextContent();
			System.out.println("value:" + value);
		}
    }
    
    //load node list into hashmap
    public HashMap<String, String> loadNodeList(NodeList nodeList){
    	HashMap<String, String> nodeListMap = new HashMap<String, String>();
    	
    	if(null != nodeList){
    		for(int i=0;i<nodeList.getLength();i++){
			    Element element = (Element)nodeList.item(i);
			    String key = element.getAttribute(ATTRIBUTE_KEY);
			    String value = element.getTextContent();
			    
			    nodeListMap.put(key, value);
		    }
    	}
    	
    	return nodeListMap;
    }
    
    //use the method to loop hashmap more efficient
    public void loopAndShowNodeListMap(){
    	Iterator iter = nodeListMap.entrySet().iterator();
    	while (iter.hasNext()) {
    	   Map.Entry entry = (Map.Entry) iter.next();
    	   Object key = entry.getKey();
    	   Object val = entry.getValue();
    	   
    	   System.out.println("key:" + key + ",value:" + val);
    	}
    }
    
    public HashMap<String, String> getNodeListMap() {
		return nodeListMap;
	}

	public void setNodeListMap(HashMap<String, String> nodeListMap) {
		this.nodeListMap = nodeListMap;
	}
    
    public static void main(String[] args) {
    	LoadChineseCharactersListXml obj = new LoadChineseCharactersListXml();
    	obj.loopAndShowNodeListMap();
	}
}
