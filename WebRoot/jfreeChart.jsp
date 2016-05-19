<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.jingrui.util.Piechart,java.io.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String filename=Piechart.generateBarChart(session,new PrintWriter(out));
String graphURL=path+"/temp/"+"jfreechart-8319037685388366006.png";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   
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
    This is my JSP page. <br>
    <img src="<%=graphURL%>" width="500" height="300" border="0">
  </body>
</html>