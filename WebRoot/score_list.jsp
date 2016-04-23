<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'score_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="style/score_list.css" type="text/css"></link>

  </head>
  
  <body>
    ${user.name}<nobr style="color:#4682B4">  ${user.permission.pmnName}</nobr>
    <table class="table_1" border="1" width="80%" align="center">  
        <tr class="tr_1">
            <th><spring:message code="score_list.id"/></th>  
            <th><spring:message code="score_list.department"/></th>  
            <th><spring:message code="score_list.name"/></th>  
            <th><spring:message code="score_list.occur_time"/></th>  
            <th><spring:message code="score_list.score"/></th>  
            <th><spring:message code="score_list.category"/></th>
            <th><spring:message code="score_list.event"/></th>  
            <th><spring:message code="score_list.who_fill_paper"/></th>  
            <th><spring:message code="score_list.comment"/></th>  
            <th><spring:message code="score_list.operator"/></th>
        </tr>
        <s:if test="#request.scoreSet!=null">
        <s:iterator value="#request.scoreSet" id="scs">  
            <tr>  
                <td>  
                    <s:property value="#scs.sid"/>  
                </td>  
                <td>  
                    <s:property value="#scs.department.departmentName"/>  
                </td>
                    
                <td>  
                    <s:property value="#scs.userByNameId.realName"/>  
                </td>  
                <td>  
                    <s:property value="#scs.occurTime"/>  
                </td> 
                <td>  
                    <s:property value="#scs.score"/>  
                </td>  
                <td>  
                    <s:property value="#scs.category"/>  
                </td>
                <td>  
                    <s:property value="#scs.event"/>  
                </td>
                <td>  
                    <s:property value="#scs.userByWhoFillPaperId.realName"/>  
                </td> 
                <td>  
                    <s:property value="#scs.comment"/>  
                </td> 
                <td>  
                    <s:property value="#scs.userByOperatorId.realName"/>  
                </td> 
            </tr>
        </s:iterator>
        </s:if>
     </table>
  </body>
</html>
