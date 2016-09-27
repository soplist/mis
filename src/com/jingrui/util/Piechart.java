package com.jingrui.util;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.User;
import com.opensymphony.xwork2.ActionContext;



public class Piechart {
	   
    private static PieDataset createDataset(String month)
    {
    	//Map mapsession = (Map)ActionContext.getContext().getSession();
    	HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		Set<NoticePeople> nps = u.getNoticePeoplesForUserId();
		int sum = 0;
		int aValue=0;
		int bValue=0;
		int cValue=0;
		for (NoticePeople noticePeople : nps) {
			if(noticePeople.getTaskByTaskId().getDate().substring(0,7).equals(month)){
			    String scoreClass = noticePeople.getTaskByTaskId().getScoreClass();
			    sum +=noticePeople.getTaskByTaskId().getValue();
			    if(scoreClass.equals("a")){
				    aValue+=noticePeople.getTaskByTaskId().getValue();
			    }
			    else if(scoreClass.equals("b")){
				    bValue+=noticePeople.getTaskByTaskId().getValue();
			    }else{
				    cValue+=noticePeople.getTaskByTaskId().getValue();
			    }
			}
		}
		
        String s1="a类";
        String s2="b类";
        String s3="产值分";
        DefaultPieDataset defaultpieDataset=new DefaultPieDataset();
       
        float a = (float)aValue/sum;
        float b = (float)bValue/sum;
        float c = 1-a-b;
        defaultpieDataset.setValue(s1,a);
        defaultpieDataset.setValue(s2,b);
        defaultpieDataset.setValue(s3,c);
        return defaultpieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset)
    {
        String name="分数类别比例饼状图";
        JFreeChart jfreechart=ChartFactory.createPieChart(name,pieDataset,true,true,false);
       
        jfreechart.setBackgroundPaint(Color.white);//Color 是paint类型的对象
        PiePlot pieplot=(PiePlot)jfreechart.getPlot();
       
        pieplot.setLabelFont(new Font("黑体", 12, 12));
          
        Font font = new Font("微软雅黑", Font.CENTER_BASELINE, 12);
        TextTitle title = new TextTitle(name); 
        title.setFont(font); 
        jfreechart.setTitle(title);
            
        jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); 
         
         
        return jfreechart;
       
    }
   
    public static String generatePieChart(String month)
    {
    	File tempFile = null;
        try{
        	File file = new File("../webapps//mis//temp");
            if(!file.exists())
        	    file.mkdir();
            String prefix = ServletUtilities.getTempFilePrefix(); 
            tempFile = File.createTempFile(prefix, ".png", file);
		 
            PieDataset categorydataset=createDataset(month);
            JFreeChart jfreechart=createChart(categorydataset);
        
            ChartUtilities.saveChartAsPNG(tempFile,jfreechart,500,300);
        }catch(Exception e){
            e.printStackTrace();
        }
        return tempFile.getName();
    }
}