package com.jingrui.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;


import com.jingrui.domain.NoticePeople;
import com.jingrui.domain.StaffScore;
import com.jingrui.domain.Task;
import com.jingrui.domain.User;
import com.jingrui.service.OperateService;
import com.jingrui.service.ScoreService;
import com.jingrui.service.TaskService;
import com.jingrui.service.UserService;
import com.jingrui.util.StatisticsHelper;
import com.jingrui.workflow.IPipe;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ScoreAction extends ActionSupport {
	
	private static Logger logger = Logger.getLogger(ScoreAction.class);
	
	private ScoreService scoreService;
	private UserService userService;
	private TaskService taskService;
    private IPipe pipe;
	private String date;
	private String[] noticePeople;
	private String reason;
	private String scoreClass;
	private Integer value;
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
    public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}
	
	public IPipe getPipe() {
		return pipe;
	}

	public void setPipe(IPipe pipe) {
		this.pipe = pipe;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String[] getNoticePeople() {
		return noticePeople;
	}

	public void setNoticePeople(String[] noticePeople) {
		this.noticePeople = noticePeople;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getScoreClass() {
		return scoreClass;
	}

	public void setScoreClass(String scoreClass) {
		this.scoreClass = scoreClass;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public String previousLaunch(){
		logger.info("previous launch.");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			List<User> userList = userService.findAllUser();
			request.setAttribute("userList", userList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "launchScoreForm";
	}
	
	public String previousRelaunch(){
		logger.info("previous relaunch.");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			List<User> userList = userService.findAllUser();
			request.setAttribute("userList", userList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "relaunchScoreForm";
	}
	
	public String launch(){
		logger.info("launch score task.");
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session=ServletActionContext.getRequest().getSession();
			User u = (User) session.getAttribute("user");
			
			date = request.getParameter("date");
			String npStr = request.getParameter("noticePeople");
			noticePeople = npStr.split(",");
			reason = request.getParameter("reason");
			scoreClass = request.getParameter("scoreClass");
			value = new Integer(request.getParameter("value"));
		    System.out.println(this.date+","+reason+","+scoreClass+","+value);
		    for(int i=0;i < noticePeople.length;i++)
			    System.out.println(noticePeople[i]);
		    
		    Task task = new Task();
		    task.setDate(date);
		    task.setReason(reason);
		    task.setScoreClass(scoreClass);
		    task.setValue(value);
		    task.setStatus(0);
		    
		    User newUser = pipe.lunch(task,noticePeople,u);
		    session.removeAttribute("user");
		    session.setAttribute("user", newUser);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "launchSuccess";
	}
	
	public String agree(){
		logger.info("agree score task.");
		int id = new Integer(ServletActionContext.getRequest().getParameter("id").trim()) ;
		int taskId = new Integer(ServletActionContext.getRequest().getParameter("task_id").trim()) ;
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		User newUser = pipe.agre(id,taskId,u);
        session.removeAttribute("user");
		
		/*
		Set<NoticePeople> npSet = u.getNoticePeoplesForUserId();
		for (NoticePeople noticePeople : npSet) {
			if(noticePeople.getNid() == id){
				noticePeople.setStatus(true);
				if(update){
					Task t = noticePeople.getTaskByTaskId();
					t.setStatus(1);
				}
			}
		}
		u.setNoticePeoplesForUserId(npSet);
		*/
		session.setAttribute("user", newUser);
		
		List<Task> tasks = taskService.getApproveTask();
		session.removeAttribute("approveTaskList");
   	    session.setAttribute("approveTaskList", tasks);
		
		return "agreeSuccess";
	}
	
	public String reject(){
		logger.info("reject score task.");
		
		int taskId = new Integer(ServletActionContext.getRequest().getParameter("task_id").trim()) ;
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		User newUser = pipe.reject(taskId,u);
		session.removeAttribute("user");
		session.setAttribute("user", newUser);
		
		List<Task> tasks = taskService.getApproveTask();
		session.removeAttribute("approveTaskList");
   	    session.setAttribute("approveTaskList", tasks);
		
		return "rejectSuccess";
	}
	
	public String approve(){
        logger.info("approve score task.");
		
		int taskId = new Integer(ServletActionContext.getRequest().getParameter("task_id").trim()) ;
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		
		List<Task> taskList = pipe.approve(taskId,u);
		session.removeAttribute("approveTaskList");
   	    session.setAttribute("approveTaskList", taskList);
   	    
   	    User newUser = userService.findUserByName(u.getName());
   	    session.removeAttribute("user");
	    session.setAttribute("user", newUser);
	    
	    TreeMap<String,Integer> table=StatisticsHelper.getStatistics(newUser.getNoticePeoplesForUserId());
	    session.removeAttribute("statisticsTable");
   	    session.setAttribute("statisticsTable", table);
   	    
   	    DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
	    List<NoticePeople> nps = StatisticsHelper.getNoticePeoplesByMonth(date.substring(0, 7),newUser.getNoticePeoplesForUserId());
	    session.setAttribute("nps", nps);
		return "approveSuccess";
	}
	
	public String delete(){
		logger.info("delete score task.");
		
		int taskId = new Integer(ServletActionContext.getRequest().getParameter("task_id").trim()) ;
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		User newUser = pipe.delete(taskId,u);
		session.removeAttribute("user");
		session.setAttribute("user", newUser);
		
		return "deleteSuccess";
	}

	public String scoreListByRealName(){
		logger.info("score list by real Name");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		//u.getStaffScoresForNameId();
		
        if(u.getPermission().getPmnName().equals("normal")){
    	    Set<StaffScore> scoreSet = u.getStaffScoresForNameId();
    	    
    	    System.out.println("scoreListByRealName scoreSet size:"+scoreSet.size());
    	    if(!scoreSet.isEmpty()||scoreSet != null){
    	        request.setAttribute("scoreSet",scoreSet);
    	    }
		    return "listScoreByRealName";
		}else if(u.getPermission().getPmnName().equals("administrator")){
			List<StaffScore> scoreList=scoreService.listStaffScore();
			if(!scoreList.isEmpty()||scoreList != null){
				request.setAttribute("scoreSet",scoreList);
			}
		    return "listScore";
		}
		else{
			return "listScoreByRealName";
		}
	}
	
	public String loadTasks(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute("approveTaskList");
		List<Task> taskList = taskService.getApproveTask();
   	    session.setAttribute("approveTaskList", taskList);
		
		return "loadTasksSuccess";
	}
	
	public String getDetailTask(){
        logger.info("get task detail.");
		
        HttpSession session=ServletActionContext.getRequest().getSession();
		int taskId = new Integer(ServletActionContext.getRequest().getParameter("task_id").trim()) ;
		Task t = taskService.getTaskById(taskId);
		session.removeAttribute("task");
		session.setAttribute("task", t);
		
		return "getDetailTaskSuccess";
	}
	
	public String getArchiveByMonth(){
		logger.info("get archive task by month.");
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		User u = (User) session.getAttribute("user");
		String month = request.getParameter("months");
		//System.out.println(month);
		
		List<NoticePeople> nps = StatisticsHelper.getNoticePeoplesByMonth(month,u.getNoticePeoplesForUserId());
		session.removeAttribute("nps");
		session.setAttribute("nps", nps);
		return "getArchiveByMonthSuccess";
	}
}
