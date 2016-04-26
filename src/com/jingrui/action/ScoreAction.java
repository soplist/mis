package com.jingrui.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;


import com.jingrui.domain.StaffScore;
import com.jingrui.domain.User;
import com.jingrui.service.ScoreService;
import com.opensymphony.xwork2.ActionContext;

public class ScoreAction {
	
	private static Logger logger = Logger.getLogger(ScoreAction.class);
	
	private ScoreService scoreService;
    
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}

	public String scoreListByRealName(){
		logger.info("score list by real Name");
		Map request = (Map)ActionContext.getContext().get("request");
		Map session = (Map)ActionContext.getContext().getSession();
		User u = (User) session.get("user");
		//u.getStaffScoresForNameId();
		if(u.getPermission().getPmnName().equals("normal")){
    	    Set<StaffScore> scoreSet = u.getStaffScoresForNameId();
    	    System.out.println("scoreListByRealName scoreSet size:"+scoreSet.size());
    	    if(!scoreSet.isEmpty()||scoreSet != null){
    	        request.put("scoreSet",scoreSet);
    	    }
		    return "listScoreByRealName";
		}else if(u.getPermission().getPmnName().equals("administrator")){
			List<StaffScore> scoreList=scoreService.listStaffScore();
			if(!scoreList.isEmpty()||scoreList != null){
				request.put("scoreSet",scoreList);
			}
		    return "listScore";
		}
		else{
			return "listScoreByRealName";
		}
	}
}
