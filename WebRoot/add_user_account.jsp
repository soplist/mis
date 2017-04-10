<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'add_user_account.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
        var xmlhttp=null;
        function submitForm(){
            
            if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
                xmlhttp=new XMLHttpRequest();
            }
            else if (window.ActiveXObject){// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            if (xmlhttp!=null){
                
                var a = trim(document.getElementById("username").value);
                var b = trim(document.getElementById("password").value);
                var c = trim(document.getElementById("confirm_password").value);
                var d = trim(document.getElementById("real_name").value);
                var e = trim(document.getElementById("permission").value);
                var f = trim(document.getElementById("department").value);
                var g = document.getElementsByName("manager")[0].checked;
                var h = document.getElementsByName("boss")[0].checked;
                var i = trim(document.getElementById("position").value);
                var j = trim(document.getElementById("joined_time").value);
                var k = document.getElementsByName("validity")[0].checked;
                
                //alert("a:"+a+",b:"+b+",c:"+c+",d:"+d+",e:"+e+",f:"+f+",g:"+g+",h:"+h+",i:"+i+",j:"+j+",k:"+k);
                
                //alert("a==null:"+(a==null)+",b==null:"+(b==null)+",c==null:"+(c==null)+",d==null:"+(d==null)+",e==null:"+(e==null)+",f==null:"+(f==null)+",g==null:"+(g==null)+",h==null:"+(h==null)+",i==null:"+(i==null)+",j==null:"+(j==null)+",k==null:"+(k==null));
                //alert("a:"+(a=="")+",b:"+(b=="")+",c:"+(c=="")+",d:"+(d=="")+",e:"+(e=="")+",f:"+(f=="")+",g:"+(g=="")+",h:"+(h=="")+",i:"+(i=="")+",j:"+(j=="")+",k:"+(k==""));
                if(a==null||b==null||c==null||d==null||e==null
                    ||f==null||g==null||h==null||i==null||j==null
                    ||k==null
                    ||a==""||b==""||c==""||d==""||e==""
                    ||f==""||i==""||j==""){
                        //alert("hehe");
                        document.getElementById("error").innerHTML="请填写完整信息"; 
                }else{
                
                    var regBox = {
                        regName : /^[a-z0-9_-]{3,16}$/,
                        regDate : /^\d{4}-\d{2}-\d{2}$/
                    };
                    var aflag = regBox.regDate.test(j);
                    
                    if(!aflag){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="日期格式:yyyy-MM-dd!";
                    }
                    else if(b!=c){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="密码与确认密码不一致";
                    }
                    else{
                        alert(a+b+c+d+e+f+g+h+i+j+k);
                        document.getElementById("error").innerHTML="";
                        var data = "username="+a+"&password="+b+"&real_name="+d+"&permission="+e
                        +"&department="+f+"&manager="+g+"&boss="+h+"&position="+i+"&joined_time="+j
                        +"&validity="+k;
                
                        xmlhttp.onreadystatechange=state_Change;
                        xmlhttp.open("post","addUserAccount");
                        xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
                        xmlhttp.send(data);
                    }
                }
            }
            else{
                alert("Your browser does not support XMLHTTP.");
            }
        }
        
        function state_Change(){
            if (xmlhttp.readyState==4){// 4 = "loaded"
                if (xmlhttp.status==200){// 200 = "OK"
                    alert("add success");
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
    <s:form action="addUserAccount" method="post">
       <table>
           <caption><spring:message code="add_user_account.title"/></caption>
           <tr>
               <td><spring:message code="add_user_account.username"/></td>
               <td><s:textfield id="username" name="username"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.password"/></td>
               <td><s:password id="password" name="password"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.confirm_password"/></td>
               <td><s:password id="confirm_password" name="confirm_password"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.real_name"/></td>
               <td><s:textfield id="real_name" name="real_name"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.permission"/></td>
               <td><s:select id="permission" list="%{#request.allPermission}" listValue="pmnName" listKey="pid"></s:select></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.department"/></td>
               <td><s:select id="department" list="%{#request.departmentList}" listValue="departmentName" listKey="did"></s:select></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.manager"/></td>
               <td><s:radio name="manager" id="manager" list="#{true:'是',false:'否'}" listKey="key" listValue="value" value="false"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.boss"/></td>
               <td><s:radio name="boss" id="boss" list="#{true:'是',false:'否'}" listKey="key" listValue="value" value="false"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.position"/></td>
               <td><s:textfield id="position" name="position"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.joined_time"/></td>
               <td><s:textfield id="joined_time" name="joined_time"/></td>
           </tr>
           <tr>
               <td><spring:message code="add_user_account.validity"/></td>
               <td><s:radio name="validity" id="validity" list="#{true:'是',false:'否'}" listKey="key" listValue="value" value="false"/></td>
           </tr>
           
           <tr>
               <td><div id="error" style="color:#FF0000"></div></td>
           </tr>
       </table>
       <!-- <s:submit label="submit"></s:submit> -->
       <!-- <input type="button" onclick="validate()" value="submit"></input> -->
       <input id="subbtn" type="button" onclick="submitForm()" value="submit"></input> 
    </s:form>
  </body>
</html>
