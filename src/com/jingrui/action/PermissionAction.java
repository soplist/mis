package com.jingrui.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.jingrui.domain.Joinin;
import com.jingrui.domain.Permission;
import com.jingrui.domain.User;
import com.jingrui.service.PermissionService;
import com.jingrui.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class PermissionAction {
    private PermissionService permissionService;
    private UserService userService;
	
	public PermissionService getPermissionService() {
		return permissionService;
	}
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String previousPermissionSet(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Permission> permissionList = permissionService.getAll();
		List<User> users = userService.findAllUser();
   	    session.setAttribute("userList", users);
		session.setAttribute("permissions", permissionList);
		return "set";
	}
	
	public String updateUsers(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String users = request.getParameter("users");
		String permission_id = request.getParameter("id");
		Integer int_permission_id = Integer.parseInt(permission_id);
		List<Permission> permissions = (List<Permission>) session.getAttribute("permissions");
		List<User> userList = (List<User>) session.getAttribute("userList");
		Integer normal_permission_id = permissionService.getNormalPermissionId();
		Permission permission = null;
		for (Permission p : permissions) {
			if(p.getPid().equals(int_permission_id)){
				permission = p;
			}
		}
		
		String[] foreground_user = users.split(",");
		Set<User> background_user = permission.getUsersForPid();
		
		for (User user : background_user) {
			boolean exist_in_foreground = false;
			if(!users.equals(""))
			for (String u : foreground_user) {
				if((user.getUid().equals(Integer.parseInt(u)))){
					exist_in_foreground = true;
					break;
				}
			}
			
			if(!exist_in_foreground){
				Permission p = new Permission();
				p.setPid(normal_permission_id);
				user.setPermission(p);
				userService.update(user);
			}
		}
		
		if(!users.equals(""))
		for (String u : foreground_user) {
			boolean exist_in_background = false;
			for (User user : background_user) {
				if((user.getUid().equals(Integer.parseInt(u)))){
					exist_in_background = true;
					break;
				}
			}
			if(!exist_in_background){
				User u1 = getUserByUid(userList,Integer.parseInt(u));
				if(u1!=null){
				    u1.setPermission(permission);
				    userService.update(u1);
				}
			}
		}
		
		return "set";
	}
	
	private User getUserByUid(List<User> users,Integer user_id){
		for (User user : users) {
			if(user.getUid().equals(user_id)){
				return user;
			}
		}
		return null;
	}
	
	public String updatePermissionSetting(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String value = request.getParameter("value");
		String type = request.getParameter("type");
		String permission_id = request.getParameter("permission_id");
		Integer int_permission_id = Integer.parseInt(permission_id);
		
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		List<Permission> permissions = (List<Permission>) session.getAttribute("permissions");
		
		Permission current_permission = null;
		for (Permission permission : permissions) {
			if(permission.getPid().equals(int_permission_id)){
				current_permission = permission;
			}
		}
		
		if(type.equals("1")){
			if(value.equals("1")){
				current_permission.setC(true);
			}
			if(value.equals("0")){
				current_permission.setC(false);
			}
		}else if(type.equals("2")){
			if(value.equals("1")){
				current_permission.setR(true);
			}
			if(value.equals("0")){
				current_permission.setR(false);
			}
		}else if(type.equals("3")){
			if(value.equals("1")){
				current_permission.setU(true);
			}
			if(value.equals("0")){
				current_permission.setU(false);
			}
		}else if(type.equals("4")){
			if(value.equals("1")){
				current_permission.setD(true);
			}
			if(value.equals("0")){
				current_permission.setD(false);
			}
		}else if(type.equals("5")){
			if(value.equals("1")){
				current_permission.setPmsetting(true);
			}
			if(value.equals("0")){
				current_permission.setPmsetting(false);
			}
		}else if(type.equals("6")){
			if(value.equals("1")){
				current_permission.setPsetting(true);
			}
			if(value.equals("0")){
				current_permission.setPsetting(false);
			}
		}else if(type.equals("7")){
			if(value.equals("1")){
				current_permission.setViewAllPm(true);
			}
			if(value.equals("0")){
				current_permission.setViewAllPm(false);
			}
		}
		
		permissionService.update(current_permission);
		
		return "set";
	}
}
