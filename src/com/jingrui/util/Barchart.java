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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.User;
import com.opensymphony.xwork2.ActionContext;



public class Barchart {
	   
    private static CategoryDataset createDataset(String year)
    {
    	HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		Set<NoticePeople> nps = u.getNoticePeoplesForUserId();
		System.out.println("size:"+nps.size());
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;
		int g = 0;
		int h = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int l = 0;
		for (NoticePeople noticePeople : nps) {
			String y = noticePeople.getTaskByTaskId().getDate().substring(0,4);
			System.out.println("y="+y);
			if(y.equals(year)){
			    String m = noticePeople.getTaskByTaskId().getDate().substring(0,7);
			    if(m.equals(y+"-01")){
			    	a += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-02")){
			    	b += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-03")){
			    	c += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-04")){
			    	d += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-05")){
			    	e += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-06")){
			    	f += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-07")){
			    	g += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-08")){
			    	h += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-09")){
			    	i += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-10")){
			    	j += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-11")){
			    	k += noticePeople.getTaskByTaskId().getValue();
			    }else if(m.equals(y+"-12")){
			    	l += noticePeople.getTaskByTaskId().getValue();
			    }
			}
		}
		
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
       
        String s1="1";
        String s2="2";
        String s3="3";
        String s4="4";
        String s5="5";
        String s6="6";
        String s7="7";
        String s8="8";
        String s9="9";
        String s10="10";
        String s11="11";
        String s12="12";
        
        dataset.setValue(a,"a",s1);
        dataset.setValue(b,"b",s2);
        dataset.setValue(c,"c",s3);
        dataset.setValue(d,"d",s4);
        dataset.setValue(e,"e",s5);
        dataset.setValue(f,"f",s6);
        dataset.setValue(g,"g",s7);
        dataset.setValue(h,"h",s8);
        dataset.setValue(i,"i",s9);
        dataset.setValue(j,"j",s10);
        dataset.setValue(k,"k",s11);
        dataset.setValue(l,"l",s12);
        
        return dataset;
    }

    private static JFreeChart createChart(CategoryDataset dataset)
    {
        String name="分数年分布";
        JFreeChart jfreechart=ChartFactory.createBarChart("hi", "分数月分布","", dataset, PlotOrientation.VERTICAL, true, true, false);
       
        jfreechart.setBackgroundPaint(Color.white);//Color 是paint类型的对象
        CategoryPlot barplot=(CategoryPlot)jfreechart.getPlot();
        CategoryAxis categoryAxis=barplot.getDomainAxis();
        categoryAxis.setLabelFont(new Font("黑体", 12, 12));
          
        Font font = new Font("微软雅黑", Font.CENTER_BASELINE, 12);
        TextTitle title = new TextTitle(name); 
        title.setFont(font); 
        jfreechart.setTitle(title);
            
        jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); 
         
         
        return jfreechart;
       
    }
   
    public static String generateBarChart(String year)
    {
    	File tempFile = null;
        try{
        	File file = new File("../webapps/mis/temp");
            if(!file.exists())
        	    file.mkdir();
            String prefix = ServletUtilities.getTempFilePrefix(); 
            tempFile = File.createTempFile(prefix, ".png", file);
		    
            CategoryDataset categorydataset=createDataset(year);
            JFreeChart jfreechart=createChart(categorydataset);
        
            ChartUtilities.saveChartAsPNG(tempFile,jfreechart,500,300);
        }catch(Exception e){
            e.printStackTrace();
        }
        return tempFile.getName();
   
    }
}