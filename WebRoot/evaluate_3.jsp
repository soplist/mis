<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- manager or company evaluate -->
<html>
  <head>
    <title>My JSP 'evaluate_3.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="style/evaluate_3.css" type="text/css"></link>
    <script type="text/javascript">
        function submitForm(type){
            var form = document.getElementById("eform");
            var data = "type="+type+"&data=";
            for (var i=0;i<form.elements.length;i++)
            {
                var ele=form.elements[i];
                if("INPUT"==ele.tagName&&"text"==ele.type){
                    if(ele.value==""){
                        alert("数据不能为空");
                        return;
                    }
                    if(ele.value<0||ele.value>100){
                        alert("分数大于等于0小于等于100");
                        return;
                    }
                    if(isNaN(ele.value)){
                        alert("请输入数字");
                        return;
                    }
                    data += ele.id+",";
                    data += ele.value+",";
                };
            }
            if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
                xmlhttp=new XMLHttpRequest();
            }
            else if (window.ActiveXObject){// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange=state_Change;
            xmlhttp.open("post","evaluate4");
            xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
            xmlhttp.send(data);
        }
        
        function state_Change(){
            if (xmlhttp.readyState==4){// 4 = "loaded"
                if (xmlhttp.status==200){// 200 = "OK"
                    //alert("form has been submit!");
                    window.opener.location.reload();
                    window.close();
                }
  	            else{
    	            alert("Problem retrieving data:" + xmlhttp.statusText);
                }
            }
        } 
    </script>
  </head>
  
  <body>
  <s:form id="eform" action="evaluate4" method="post">
  <table class="table_1" border="1">
      <caption>
      <s:if test="#session.managerEvaluateOrCompanyEvaluate==3">
      <spring:message code="peme.type_3"/>
      </s:if>
      <s:if test="#session.managerEvaluateOrCompanyEvaluate==4">
      <spring:message code="peme.type_4"/>
      </s:if>
      </caption>
      <tr>
          <th><spring:message code="evaluate3.no"/></th>
          <th><spring:message code="evaluate3.name"/></th>
          <th><spring:message code="evaluate3.joinedDate"/></th>
          <th><spring:message code="evaluate3.position"/></th>
          <th><spring:message code="evaluate3.evaluate"/></th>
      </tr>
      <s:if test="#session.managerEvaluateOrCompanyEvaluate==3">
          <s:iterator value="#session.managerPmTables" id="pt">
              <s:if test="#pt.statu==false">
              <tr>
                  <td>
                      <s:property value="#pt.pmTaskByTid.pid"/>
                  </td>
                  <td>
                      <s:property value="#pt.pmTaskByTid.userByUid.realName"/>
                  </td>
                  <td>
                      <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.pmTaskByTid.userByUid.joined})}"/>
                  </td>
                  <td>
                      <s:property value="#pt.pmTaskByTid.userByUid.position"/>
                  </td>
                  <td>
                      <input class="input_1" type="text" name="" id="<s:property value="#pt.pid"/>">
                  </td>
              </tr>
              </s:if>
          </s:iterator>
      </s:if>
      <s:if test="#session.managerEvaluateOrCompanyEvaluate==4">
          <s:iterator value="#session.companyPmTables" id="pt">
          <s:if test="#pt.statu==false">
              <tr>
                  <td>
                      <s:property value="#pt.pmTaskByTid.pid"/>
                  </td>
                  <td>
                      <s:property value="#pt.pmTaskByTid.userByUid.realName"/>
                  </td>
                  <td>
                      <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.pmTaskByTid.userByUid.joined})}"/>
                  </td>
                  <td>
                      <s:property value="#pt.pmTaskByTid.userByUid.position"/>
                  </td>
                  <td>
                      <input class="input_1" type="text" name="" id="<s:property value="#pt.pid"/>">
                  </td>
              </tr>
              </s:if>
          </s:iterator>
      </s:if>
  </table>
  <br/><br/>
  <s:if test="#session.managerEvaluateOrCompanyEvaluate==3">
      <input type="button" value="提交" onclick="submitForm(3)"/>
  </s:if>
  <s:if test="#session.managerEvaluateOrCompanyEvaluate==4">
      <input type="button" value="提交" onclick="submitForm(4)"/>
  </s:if>
  </s:form>
  </body>
</html>
