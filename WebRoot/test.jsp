<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'test.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    This is my test page. <br>
    <c:set var="a" value="1"></c:set>
    <c:set var="a" value="2"></c:set>
    <c:if test="${a==1}">1</c:if>
    <c:if test="${a==2}">2</c:if>
    <div>
    <div style="width: 30px;background-color: red;float:left">aa</div>
    <div style="width: 30px;background-color: blue;float: left">bb</div>
    </div>
  </body>
</html>
