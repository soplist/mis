<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'login.jsp' starting page</title>
    <style type="text/css">
       
    </style>
       <link rel="stylesheet" href="style/login.css" type="text/css"></link>
       <link rel="icon" href="img/64556.gif" type="image/gif">
  </head>
  
  <body>
    <center>
    <fieldset style="width: 250px">
       <legend><spring:message code="login.login"/></legend> 
       <s:form action="login" method="post">
          <spring:message code="login.username"/>:<s:textfield name="username" cssClass="text_1" label="username"></s:textfield><br></br>
          <spring:message code="login.password"/>:<s:password name="password"  cssClass="text_1" label="password"></s:password><br></br>
          <s:radio list="#{'1':'客户信息管理系统','0':'积分系统'}" name="sys" value="1"></s:radio><br></br>
          <s:submit label="submit"></s:submit>
       </s:form>
    </fieldset>
    </center>
  </body>
</html>
