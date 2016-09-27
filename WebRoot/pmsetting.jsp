<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'pmsetting.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/pmsetting.css" type="text/css"></link>
    <link rel="stylesheet" href="style/jquery-ui.css" type="text/css"></link>
    <link rel="stylesheet" href="style/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="style/bootstrap-multiselect.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
    <script type="text/javascript" src="script/setting.js" charset="gbk"></script></head>
    <script>
    $(document).ready(function() {
        $(".dept_evaluate_staff").multiselect({
              buttonWidth: '150px',
              includeSelectAllOption: true
        });
        $(".cmy_evaluate_staff").multiselect({
              buttonWidth: '150px',
              includeSelectAllOption: true
        });
    });
    </script>
  
  <body>
    <table class="table_1" border="1">
        <tr>
            <th><spring:message code="pm.name"/></th>
            <th><spring:message code="pm.department"/></th>
            <th><spring:message code="pm.setting_time"/></th>
            <th class="th_1"><spring:message code="pm.prpercentage"/></th>
            <th class="th_1"><spring:message code="pm.dept_evaluate"/></th>
            <th class="th_1"><spring:message code="pm.manager_evaluate"/></th>
            <th class="th_1"><spring:message code="pm.company_evaluate"/></th>
            <th class="th_1"><spring:message code="pm.colleagues_evaluate"/></th>
            <th><spring:message code="pm.prompt"/></th>
            <th><spring:message code="pm.prpercentage_staff"/></th>
            <th><spring:message code="pm.dept_evaluate_staff"/></th>
            <th><spring:message code="pm.manager_evaluate_staff"/></th>
            <th><spring:message code="pm.company_evaluate_staff"/></th>
            <th><spring:message code="pm.colleagues_evaluate_staff"/></th>
            <th><spring:message code="pm.status"/></th>
            <th><spring:message code="pm.operate"/></th>
        </tr>
         <s:iterator value="#session.userList" id="u">  
            <tr>  
                <td>  
                    <s:property value="#u.realName"/>  
                </td>
                <td>  
                    <s:property value="#u.department.departmentName"/>
                </td>
                <td>  
                    <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#u.option.settingTime})}"/>  
                </td>
                <td id="prp_${u.uid}" onclick="setTextView(${u.uid},1)">  
                    <s:property value="#u.option.selfEval"/>%
                </td>
                <td id="dep_${u.uid}" onclick="setTextView(${u.uid},2)">  
                    <s:property value="#u.option.deptEval"/>%
                </td>
                <td id="mep_${u.uid}" onclick="setTextView(${u.uid},3)">  
                    <s:property value="#u.option.managerEval"/>%
                </td>
                <td id="ce1p_${u.uid}" onclick="setTextView(${u.uid},4)">  
                    <s:property value="#u.option.companyEval"/>%
                </td>
                <td id="ce2p_${u.uid}" onclick="setTextView(${u.uid},5)">
                    <s:property value="#u.option.colleaguesEval"/>%
                </td>
                <td>  
                    <c:if test="${u.option.selfEval+u.option.deptEval+u.option.managerEval+u.option.companyEval+u.option.colleaguesEval!=100}">
                        <span class="span_1">
                            <spring:message code="pm.prompt_content_1"/>
                        </span>
                    </c:if>
                    <c:if test="${u.option.selfEval+u.option.deptEval+u.option.managerEval+u.option.companyEval+u.option.colleaguesEval==100}">
                        <span class="span_2">
                            <spring:message code="pm.prompt_content_2"/>
                        </span>
                    </c:if>
                </td>
                <td> 
                    <!--<select onblur="getJoinins(${u.uid},1)" autocomplete="off" id="personal_${u.uid}" name="personal">
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                    
                        <c:set var="slct" value="0"></c:set>
                        <s:iterator value="#u.option.joininsForSid" id="ji">
                                <c:if test="${(ji.type==1)&&(user.uid==ji.userByUid.uid)}">
                                    <c:set var="slct" value="1"></c:set>
                                </c:if>
                        </s:iterator>
                        
                        <c:if test="${slct==0}">
                            <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                        <c:if test="${slct==1}">
                            <option selected="selected" value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                    </s:iterator>
                    </s:if>
                    </select>-->
                    <s:property value="#u.realName"/>
                </td>
                <td>  
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                        <c:if test="${(user.department.did==u.department.did)&&(user.uid!=u.uid)&&(user.validity!=false)}">
                             <s:property value="#user.realName"/>,       
                        </c:if>
                    </s:iterator>
                    </s:if>
                    <!--<select onchange="getJoinins(${u.uid},2)" autocomplete="off" id="dept_staff_${u.uid}" name="dept_staff" class="dept_evaluate_staff" multiple="multiple">
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                    
                        <c:set var="slct" value="0"></c:set>
                        <s:iterator value="#u.option.joininsForSid" id="ji">
                                <c:if test="${(ji.type==2)&&(user.uid==ji.userByUid.uid)}">
                                    <c:set var="slct" value="1"></c:set>
                                </c:if>
                            
                        </s:iterator>
                        
                        <c:if test="${slct==0}">
                            <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                        <c:if test="${slct==1}">
                            <option selected="selected" value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                    
                    </s:iterator>
                    </s:if>
                    </select>-->
                </td>
                <td>
                    <select onblur="getJoinins(${u.uid},3)" autocomplete="off" id="manager_${u.uid}" name="manager">
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                    
                        <c:set var="slct" value="0"></c:set>
                        <s:iterator value="#u.option.joininsForSid" id="ji">
                                <c:if test="${(ji.type==3)&&(user.uid==ji.userByUid.uid)}">
                                    <c:set var="slct" value="1"></c:set>
                                </c:if>
                        </s:iterator>
                        
                        <c:if test="${(slct==0)&&user.ismanager}">
                            <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                        <c:if test="${(slct==1)&&user.ismanager}">
                            <option selected="selected" value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                    
                    </s:iterator>
                    </s:if>
                    </select>
                </td>
                <td>
                    <!--<select onblur="getJoinins(${u.uid},4)" autocomplete="off" id="company_${u.uid}" name="company">
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                    <c:if test="${user.isboss==true}">
                    <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                    </c:if>
                    </s:iterator>
                    </s:if>
                    </select>-->
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                        <c:if test="${(user.ismanager)&&(user.uid!=u.uid)&&(user.validity!=false)}">
                             <s:property value="#user.realName"/>,       
                        </c:if>
                    </s:iterator>
                    </s:if>
                </td>
                <td>
                    <span class="span_3">
                        <spring:message code="pm.random5"/>
                    </span>
                    <!-- <select onchange="getJoinins(${u.uid},5)" autocomplete="off" id="company_staff_${u.uid}" name="company_staff" class="cmy_evaluate_staff" multiple="multiple">
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                    
                        <c:set var="slct" value="0"></c:set>
                        <s:iterator value="#u.option.joininsForSid" id="ji">
                                <c:if test="${(ji.type==5)&&(user.uid==ji.userByUid.uid)}">
                                    <c:set var="slct" value="1"></c:set>
                                </c:if>
                            
                        </s:iterator>
                        
                        <c:if test="${slct==0}">
                            <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                        <c:if test="${slct==1}">
                            <option selected="selected" value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                    
                    </s:iterator>
                    </s:if>
                    </select> -->
                </td>
                <td>
                   <c:if test="${u.validity}">
                       <spring:message code="pm.status_1"/>
                   </c:if>
                   <c:if test="${!u.validity}">
                       <span class="span_1">
                           <spring:message code="pm.status_2"/>
                       </span>
                   </c:if>
                </td>
                <td>
                    <c:if test="${u.ismanager}">
                        <input onclick="launchManagerTask(${u.uid})" type="button" value="launchManager"/>
                    </c:if>
                    <input onclick="launchTask(${u.uid})" type="button" value="launch"/>
                </td>
            </tr>
         </s:iterator>
    </table>
                
                
    <!-- <input id="text_1" type="text"/> -->
  </body>
</html>
                
