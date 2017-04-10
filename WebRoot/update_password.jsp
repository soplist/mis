<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'update_password.jsp' starting page</title>
  </head>
  
  <body>
    update password<br>
    ${userInformation.username}<br>
    <s:form action="updatePassword" method="post">
    <s:password name="password" label="password"></s:password>
    <s:if test="#session.message!=null">
    ${session.message.content}<br>
    </s:if>
    <s:submit label="submit" value="update"></s:submit>
    </s:form>
  </body>
</html>
