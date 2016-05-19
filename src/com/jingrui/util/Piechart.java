package com.jingrui.util;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;



public class Piechart {
   
    private static PieDataset createDataset()
    {
        String s1="棉花";
        String s2="小麦";
        String s3="大豆";
        String s4="花生";
        String s5="玉米";
        DefaultPieDataset defaultpieDataset=new DefaultPieDataset();
       
        defaultpieDataset.setValue(s1,0.25);
        defaultpieDataset.setValue(s2,0.30);
        defaultpieDataset.setValue(s3,0.05);
        defaultpieDataset.setValue(s4,0.15);
        defaultpieDataset.setValue(s5,0.25);
        return defaultpieDataset;
    }

    private static JFreeChart createChart(PieDataset pieDataset)
    {
        String name="某地区主要农作物比例饼状图";
        String x_name="省份";
        String y_name="数量";
        JFreeChart jfreechart=ChartFactory.createPieChart(name,pieDataset,true,true,false);
       
        jfreechart.setBackgroundPaint(Color.white);//Color 是paint类型的对象
        PiePlot pieplot=(PiePlot)jfreechart.getPlot();
       
       
        pieplot.setLabelFont(new Font("黑体", 12, 12));
          
          //定义字体格式 
          Font font = new Font("微软雅黑", Font.CENTER_BASELINE, 12);
          TextTitle title = new TextTitle(name); 
          //设置标题的格式 
          title.setFont(font); 
          //把标题设置到图片里面 
          jfreechart.setTitle(title);
            
         jfreechart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); 
         
         
        return jfreechart;
       
    }
   
    public static String generateBarChart(HttpSession session,PrintWriter pw)
    {
    	String tempDirName = System.getProperty("java.io.tmpdir");
    	System.out.println("tempDirName:"+tempDirName);
    	String prefix = ServletUtilities.getTempFilePrefix();
    	System.out.println("getTempFilePrefix:"+prefix);
        String userdir = System.getProperty("user.dir");
        System.out.println("userdir:"+userdir);
        String filename="";
        
        
        File file = new File("\\新建文件夹");
        file.mkdirs();
       
        PieDataset categorydataset=createDataset();
        JFreeChart jfreechart=createChart(categorydataset);
       
        ChartRenderingInfo info=new ChartRenderingInfo(new StandardEntityCollection());
       
        try{
            filename=ServletUtilities.saveChartAsPNG(jfreechart,500,300,info,session);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        try{
            ChartUtilities.writeImageMap(pw,filename,info,false);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        pw.flush();
        return filename;
   
    }
}