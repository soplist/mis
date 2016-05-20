package com.jingrui.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.User;
import com.jingrui.service.ScoreService;
import com.opensymphony.xwork2.ActionContext;

public class ChartAction {
	private static Logger logger = Logger.getLogger(ChartAction.class);
	private ScoreService scoreService;
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	public String pieChartForabcPerMonth(){
		logger.info("pie chart for abc per month.");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String month = request.getParameter("month");
		System.out.println("month:"+month);
		
		return "showPieChart";
	}
	public String barChartForYear(){
		logger.info("pie chart for abc per month.");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String year = request.getParameter("year");
		System.out.println("year:"+year);
		
		return "showBarChart";
	}
}
