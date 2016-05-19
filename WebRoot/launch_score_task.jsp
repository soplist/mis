<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'launch_score_task.jsp' starting page</title>
    <link rel="stylesheet" href="style/launch_score_task.css" type="text/css"></link>
    <link rel="stylesheet" href="style/jquery-ui.css" type="text/css"></link>
    <link rel="stylesheet" href="style/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="style/bootstrap-multiselect.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
    <script>
    
    $(document).ready(function() {
        $(".multiselect").multiselect({
              buttonWidth: '400px',
              includeSelectAllOption: true
        });
    });
    $(function() {
        $( "#datepicker" ).datepicker({dateFormat: "yy-mm-dd",changeMonth: true});
    });
    
    var xmlhttp=null;
    function submitForm(){
        var a = trim(document.getElementById("datepicker").value);
        var noticePeopleCtl = document.getElementById("noticePeople");
        var b="";
        for(var i=0;i<noticePeopleCtl.length;i++)
        {
            if(noticePeopleCtl.options[i].selected)
                b+=noticePeopleCtl.options[i].value+",";
        }
        var c = trim(document.getElementById("reason").value);
        var scoreClassCtl=document.getElementsByName("scoreClass");
        var d;
        for(var i=0;i<scoreClassCtl.length;i++)
        {
            if(scoreClassCtl.item(i).checked)
                d=scoreClassCtl.item(i).getAttribute("value");  
        }
        var e = trim(document.getElementById("value").value);
        
        var regBox = {
            regDate : /^\d{4}-\d{2}-\d{2}$/
        };
        var aflag = regBox.regDate.test(a);
        
        if(a!=""&&b!=""&&c!=""&&d!=""&&e!=""){
             if(isNaN(e)){
                  alert("分数格式不正确");
                  return;
             }
             if(!aflag){
                  alert("日期格式不正确");
                  return;
             }
             if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
                  xmlhttp=new XMLHttpRequest();
             }
             else if (window.ActiveXObject){// code for IE6, IE5
                  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
             }
             var data = "date="+a+"&noticePeople="+b+"&reason="+c+"&scoreClass="+d+"&value="+e;
             xmlhttp.onreadystatechange=state_Change;
             xmlhttp.open("post","launchScoreForm");
             xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
             xmlhttp.send(data);
        }else{
             alert("请填写完整信息.");
        }
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
    
    function trim(str){ 

        return str.replace(/(^\s*)|(\s*$)/g, ""); 

    }
    
    
  </script>
  </head>
  
  <body>
    <div class="div_5">
        <fieldset class="fieldset_1">
        <legend><span class="span_1"><spring:message code="lst.title"/></span></legend> 
        <br>
        <s:form id="sform" action="launchScoreForm" method="post">
            <div><div class="div_1"><spring:message code="lst.date"/></div><div class="div_2"><input name="date" type="text" id="datepicker"/></div></div><br><br>
            <div>
                <div class="div_1"><spring:message code="lst.who"/></div>
                    <select id="noticePeople" name="noticePeople" class="multiselect" multiple="multiple">
                    <s:if test="#request.userList!=null">
                    <s:iterator value="#request.userList" id="user"> 
                    <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                    </s:iterator>
                    </s:if>
                    </select>
                <div class="div_2">
                </div>
            </div><br/>
            <div><div class="div_1"><spring:message code="lst.reason"/></div><div class="div_2"><s:textarea id="reason" name="reason" cssClass="textarea_1" label=""></s:textarea></div></div>
            <br/><br/><br/><br/>
            <div>
                <div class="div_1"><spring:message code="lst.score_class"/></div>
                <div class="div_3" style="width: 120px"><spring:message code="lst.a"/><input type="radio" value="a" name="scoreClass" checked></input>&nbsp;&nbsp;</div>
                <div class="div_3" style="width: 120px"><spring:message code="lst.b"/><input type="radio" value="b" name="scoreClass"></input>&nbsp;&nbsp;</div>
                <div class="div_3" style="width: 120px"><spring:message code="lst.c"/><input type="radio" value="c" name="scoreClass"></input></div>
            </div>
            <br/><br/>
            <div><div class="div_1"><spring:message code="lst.value"/></div><div class="div_2"><s:textfield id="value" name="value" cssClass="text_2" label=""></s:textfield></div></div><br/><br/>
            <div class="div_4">
                <!-- <s:submit value="launch"></s:submit>  -->
            <input id="subbtn" type="button" onclick="submitForm()" value="submit"></input></div>
        </s:form>
        </fieldset>
    </div>
  </body>
  
</html>
