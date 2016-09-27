<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'manager_evaluate_setting.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/manager_evaluate_setting.css" type="text/css"></link>
    <script type="text/javascript">
    function setScoreView(id,kind){
	    var xmlhttp=null;
		if(kind=="1"){
			var td = document.getElementById('item1_'+id);
		}
		if(kind=="2"){
			var td = document.getElementById('item6_'+id);
		}
		if(kind=="3"){
			var td = document.getElementById('item12_'+id);
		}
		if(kind=="4"){
			var td = document.getElementById('item13_'+id);
		}
	    var content = td.innerText;
	    td.innerHTML=""; 
	    var input = document.createElement('input');
	    input.id = 'prp';
	    input.type = 'text';
	    input.value = content;
	    input.style.width = "30px";
	    input.onblur=function(){
	    	//alert("heihei");
	    	var val = input.value;
	    	if(isNaN(val)){
	    	    alert("比例需为数字");
	    	    return false;
	    	}
	    	var floatval = parseFloat(val);
	    	if(kind=="1"){
	    	    if(floatval>15||floatval<0){
	    		    alert("团队稳定度范围在0-15之间");
	    		    return false;
	    	    }
	    	}
	    	else if(kind=="2"){
	    	    if(floatval>40||floatval<0){
	    		    alert("业务完成情况范围在0-40之间");
	    		    return false;
	    	    }
	    	}
	    	else if(kind=="3"){
	    	    if(floatval>30||floatval<0){
	    		    alert("个人积分管理任务完成情况范围在0-30之间");
	    		    return false;
	    	    }
	    	}
	    	else if(kind=="4"){
	    	    if(floatval>70||floatval<0){
	    		    alert("团队个人积分完成情况范围在0-70之间");
	    		    return false;
	    	    }
	    	}
	    	//submit data
	    	//clear input
	    	if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
                xmlhttp=new XMLHttpRequest();
            }
            else if (window.ActiveXObject){// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            var data = "score="+val+"&mid="+id+"&kind="+kind;
            xmlhttp.onreadystatechange=function(){
            	if (xmlhttp.readyState==4){// 4 = "loaded"
                    if (xmlhttp.status==200){// 200 = "OK"
                        //alert("form has been submit!");
                    	location.reload();
                    }
          	        else{
            	        alert("Problem retrieving data:" + xmlhttp.statusText);
                    }
                }
            };
            xmlhttp.open("post","updateManagerEvaluateFixedScore");
            xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
            xmlhttp.send(data);
	    };
	    td.appendChild(input);
	    input.focus();
	    //document.getElementById('text_1').focus();
	}
    </script>
  </head>
  
  <body>
    <table class="table_1" border="1">
      <caption>
      <spring:message code="mes.title"/>
      </caption>
      <tr>
          <th><spring:message code="mes.no"/></th>
          <th><spring:message code="mes.name"/></th>
          <th><spring:message code="mes.item1"/></th>
          <th><spring:message code="mes.item6"/></th>
          <th><spring:message code="mes.item12"/></th>
          <th><spring:message code="mes.item13"/></th>
      </tr>
          <s:iterator value="#session.managers" id="u">
              <tr>
                  <td>
                      <s:property value="#u.managerEvaluateSetting.mid"/>
                  </td>
                  <td>
                      <s:property value="#u.realName"/>
                  </td>
                  <td id="item1_${u.managerEvaluateSetting.mid}" onclick="setScoreView(${u.managerEvaluateSetting.mid},1)">
                      <s:property value="#u.managerEvaluateSetting.item1"/>
                  </td>
                  <td id="item6_${u.managerEvaluateSetting.mid}" onclick="setScoreView(${u.managerEvaluateSetting.mid},2)">
                      <s:property value="#u.managerEvaluateSetting.item6"/>
                  </td>
                  <td id="item12_${u.managerEvaluateSetting.mid}" onclick="setScoreView(${u.managerEvaluateSetting.mid},3)">
                      <s:property value="#u.managerEvaluateSetting.item12"/>
                  </td>
                  <td id="item13_${u.managerEvaluateSetting.mid}" onclick="setScoreView(${u.managerEvaluateSetting.mid},4)">
                      <s:property value="#u.managerEvaluateSetting.item13"/>
                  </td>
              </tr>
          </s:iterator>
      </table>
  </body>
</html>
