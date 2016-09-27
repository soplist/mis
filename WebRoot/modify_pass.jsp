<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'modify_pass.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/modify_pass.css" type="text/css"></link>
  </head>
  
  <body>
    <center>
    <fieldset style="width: 250px">
       <legend><spring:message code="list.modify_password"/></legend> 
       <s:form action="modifyPassDel" method="post">
          ${user.name}<br></br>
          <s:password id="pass_1" name="password"></s:password><br></br>
          <s:password id="pass_2" name="confirmPass"></s:password><br></br>
          <s:submit label="submit"></s:submit>
          <c:if test="${!empty error}"><div id="error" style="color:#FF0000"><c:out value="${error}"/></div></c:if>
       </s:form>
    </fieldset>
    </center>
  </body>
</html>
