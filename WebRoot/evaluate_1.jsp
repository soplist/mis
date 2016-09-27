<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- simple evaluate -->
<html>
  <head>
    <title>My JSP 'evaluate_1.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/evaluate_1.css" type="text/css"></link>
    <script type="text/javascript">
    function submitForm(){
         var item11=document.getElementById("item11").value;
         if(item11==""){
             alert("数据不能为空");
             return;
         }
         if(item11<0||item11>100){
             alert("分数大于等于0小于等于100");
             return;
         }
         if(isNaN(item11)){
             alert("分数格式错误");
             return;
         }
         /*if(parseInt(item11)!=item11){
             alert("请输入整数");
             return;
         }*/
         document.getElementById("eform").submit();
    }
    </script>
    </head>
  
  <body>
    <s:form id="eform" action="evaluate2" method="post">
    <table class="table_1" border="1" align="center">
        <tr>
            <td>
            <s:if test="#session.table.type==1">
                <spring:message code="peme.type_1"/>
            </s:if>
            <s:if test="#session.table.type==2">
                <spring:message code="peme.type_2"/>
            </s:if>
            <s:if test="#session.table.type==3">
                <spring:message code="peme.type_3"/>
            </s:if>
            <s:if test="#session.table.type==4">
                <spring:message code="peme.type_4"/>
            </s:if>
            <s:if test="#session.table.type==5">
                <spring:message code="peme.type_5"/>
            </s:if>
            </td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.realName"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.position"/></td>
            <td><s:property value="%{getText('{0,date,yyyy-MM-dd }',{#session.table.pmTaskByTid.userByUid.joined})}"/></td>
            <td><input class="input_1" type="text" name="item11" id="item11"></input></td>
            <td><input type="button" value="提交" onclick="submitForm();"/></td>
        </tr>
     </table>
     </s:form>
     <span class="span_1">
         <spring:message code="evaluate.attention"/>
     </span>
  </body>
</html>
