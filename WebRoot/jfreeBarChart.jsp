<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jingrui.util.Barchart,java.io.*,org.apache.struts2.ServletActionContext,javax.servlet.http.HttpServletRequest" %>
<%
HttpServletRequest req  = ServletActionContext.getRequest();
String year = req.getParameter("year");
String filename=Barchart.generateBarChart(year);
String graphURL=request.getContextPath()+"/temp/"+filename;
out.print(year);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '2D.jsp' starting page</title>
   
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">   
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

  </head>
 
  <body>
    <img src="<%=graphURL%>" width="500" height="300" border="0" usemap="#map0">
  </body>
</html>