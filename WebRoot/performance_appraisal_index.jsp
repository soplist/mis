<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
      <title>My JSP 'performance_appraisal_index.jsp' starting page</title>
      <link rel="stylesheet" href="style/performance_appraisal_index.css" type="text/css"></link>
      <script type="text/javascript" src="script/performance_appraisal_index.js"></script>
    </head>
  <body onload="load_performance_appraisal_index_page()">
    <c:if test="${userPermission.updatePassword}">
      <a class="a_1" onclick="window.open('beforeUpdatePassword')">
        <spring:message code="update_password"/>
      </a>
    </c:if>
    
    <c:if test="${userPermission.performanceAppraisalSetting}">
      <a class="a_1" onclick="window.open('beforeRedirectToPerformanceAppraisalSettingPage')">
        <spring:message code="performance_appraisal_setting"/>
      </a>
    </c:if>
    
    <s:a action="logout"><spring:message code="list.logout"/></s:a>
    
    <div class="div_1" id="div_1">
    <div class="content" id="assign_task_content">
      <s:if test="#session.userPermission.viewFinishedPerformanceAppraisalTask&&#session.userPermission.viewNotFinishedPerformanceAppraisalTask">
	    <input name="show" type="button" onClick="show_assign_task_not_finished_panel();" value="未完成">
	    <input name="show" type="button" onClick="show_assign_task_finished_panel();" value="已完成">
	  </s:if>
	  <c:if test="${userPermission.viewNotFinishedPerformanceAppraisalTask}">
      <div id="assign_task_not_finished_panel">
	    <table border="1" class="table_1">
		  <tr class="tr_3">
            <th><spring:message code="peme.no"/></th>
            <th><spring:message code="peme.time"/></th>
            <th><spring:message code="peme.type"/></th>
            <th><spring:message code="peme.name"/></th>
          </tr>
          <s:iterator value="#session.notFinishedEvaluationForm" id="ef">
              <tr>
                <td>
                  <s:property value="#ef.id"/>
                </td>
                <td>
                  <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#ef.finishTime})}"/>
                </td>
                <td>
                  <s:property value="#ef.evaluationType"/>
                </td>
                <td>
                  <s:property value="#ef.performanceAppraisalTaskByEvaluationTaskId.userId"/>
                </td>
              </tr>
          </s:iterator>
        </table>
      </div>
      </c:if>
      
      <c:if test="${userPermission.viewFinishedPerformanceAppraisalTask}">
      <div id="assign_task_finished_panel">
		<table border="1" class="table_1">
		  <tr class="tr_3">
            <th><spring:message code="peme.no"/></th>
            <th><spring:message code="peme.time"/></th>
            <th><spring:message code="peme.type"/></th>
            <th><spring:message code="peme.name"/></th>
            <th><spring:message code="peme.evaluate"/></th>
          </tr>
        </table>
	  </div>
	  </c:if>
	  
	</div>
	</div>
  </body>
</html>
