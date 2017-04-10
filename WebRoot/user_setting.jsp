<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'user_setting.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/user_setting.css" type="text/css"></link>
  </head>
  
  <body>
    <input type="button" onclick="window.open('beforeAddUserAccount')" value="新增用户"/>
    <table border="1" class="table_1">
    <s:iterator value="#session.allUserList" id="user">
        <tr>
            <td>
                <s:property value="#user.realName"/>
            </td>
            <td>
                <s:property value="#user.name"/>
            </td>
            <td>
                <s:property value="#user.position"/>
            </td>
            <td>
                <s:if test="#user.validity==true">
                    <a href="userSwitch?value=true&&userId=<s:property value="#user.uid"/>">
                    <spring:message code="user_account.open"/>
                    </a>
                </s:if>
                <s:if test="#user.validity==false">
                    <a href="userSwitch?value=false&&userId=<s:property value="#user.uid"/>">
                    <spring:message code="user_account.close"/>
                    </a>
                </s:if>
            </td>
        </tr>
    </s:iterator>
    </table>
  </body>
</html>
