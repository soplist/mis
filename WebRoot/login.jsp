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
    <div style="display:none">
    <a style="font-size: 10px" href="angular_js/no_filter_agl_1.jsp">angular 1</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_2.jsp">angular 2</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_3.jsp">angular 3</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_4.jsp">angular 4</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_5.jsp">angular 5</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_6.jsp">angular 6</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_7.jsp">angular 7</a><br>
    <a style="font-size: 10px" href="angular_js/no_filter_agl_8.jsp">angular 8</a><br>
    </div>
    <div>
    <a style="font-size: 10px" href="jquery/no_filter_jquery_1.jsp">jquery 1</a><br>
    <a style="font-size: 10px" href="jquery/no_filter_jquery_2.jsp">jquery 2</a><br>
    </div>
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
