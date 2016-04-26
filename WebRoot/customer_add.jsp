<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'customer_add.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="style/customer_add.css" type="text/css"></link>
    
    <script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js"></script>
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
                var a = trim(document.getElementById("start_date").value);
                var b = trim(document.getElementById("company").value);
                var c = trim(document.getElementById("cost").value);
                var d = trim(document.getElementById("legal_representative").value);
                var e = trim(document.getElementById("office_staff").value);
                var f = trim(document.getElementById("detailed_address").value);
                var g = trim(document.getElementById("office_telephone").value);
                var h = trim(document.getElementById("cellphone").value);
                var i = trim(document.getElementById("qq").value);
                var j = trim(document.getElementById("micromsg").value);
                var k = trim(document.getElementById("introduction").value);
                var l = trim(document.getElementById("cooperation_project").value);
                var m = trim(document.getElementById("possible_business").value);
                var n = trim(document.getElementById("client_evaluation").value);
                var o = trim(document.getElementById("comment").value);
                var p = trim(document.getElementById("department").value);
                var q = trim(document.getElementById("area").value);
                
                
                if(a==null||b==null||c==null||d==null||e==null
                    ||f==null||g==null||h==null||i==null||j==null
                    ||k==null||l==null||m==null||n==null||o==null||p==null||q==null
                    ||a==""||b==""||c==""||d==""||e==""
                    ||f==""||g==""||h==""||i==""||j==""
                    ||k==""||l==""||m==""||n==""||o==""||p==""||q==""){
                        document.getElementById("error").innerHTML="请填写完整信息"; 
                }else{
                
                    var regBox = {
                        regEmail : /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/,//邮箱
                        regName : /^[a-z0-9_-]{3,16}$/,
                        regMobile : /^0?1[3|4|5|8][0-9]\d{8}$/,
                        regTel : /^0[\d]{2,3}-[\d]{7,8}$/,
                        regDate : /^\d{4}-\d{2}-\d{2}$/
                    };
                    var aflag = regBox.regDate.test(a);
                    var gflag = regBox.regTel.test(g);
                    var hflag = regBox.regMobile.test(h);
                    
                    if(!aflag){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="日期格式:yyyy-MM-dd!";
                    }
                    else if(isNaN(c)){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="费用格式不正确!";
                    }
                    else if(g!="无"&&!gflag){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="电话号码格式不正确!";
                    }
                    else if(h!="无"&&!hflag){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="手机号码格式不正确!";
                    }
                    else if(i!="无"&&isNaN(i)){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="qq格式不正确!";
                    }
                    else if(b.length>25){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="公司名称过长!";
                    }
                    else if(d.length>10){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="法人代表内容过长!";
                    }
                    else if(e.length>10){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="办公室人员内容过长!";
                    }
                    else if(f.length>100){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="详细地址内容过长!";
                    }
                    else if(j.length>25){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="微信内容过长!";
                    }
                    else if(k.length>250){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="简介内容过长!";
                    }
                    else if(l.length>200){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="合作项目内容过长!";
                    }
                    else if(m.length>200){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="可能合作项目内容过长!";
                    }
                    else if(n.length>150){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="客户评价内容过长!";
                    }
                    else if(o.length>200){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="备注内容过长!";
                    }else if(q.length>10){
                        document.getElementById("error").innerHTML="";
                        document.getElementById("error").innerHTML="区域内容过长!";
                    }
                    else{
                        document.getElementById("error").innerHTML="";
                        var data = "startDate="+a+"&company="+b+"&cost="+c+"&legalRepresentative="+d+"&officeStaff="+e
                        +"&detailedAddress="+f+"&officeTelephone="+g+"&cellphone="+h+"&qq="+i+"&micromsg="+j
                        +"&introduction="+k+"&cooperationProject="+l+"&possibleBusiness="+m+"&clientEvaluation="+n+"&comment="+o+"&department="+p+"&area="+q;
                
                        xmlhttp.onreadystatechange=state_Change;
                        xmlhttp.open("post","addCustomer");
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
    <center>
    <c:if test="${departlist==null}">
            <jsp:forward page="/login.jsp"></jsp:forward>
    </c:if>
    <s:form id="cform" action="addCustomer" method="post">
       <table class="table_1">
           <caption><spring:message code="add.title"/></caption>
           <tr>
               <td><spring:message code="add.department"/></td>
               <td><s:select id="department" list="%{#request.departlist}" listValue="departmentName" listKey="did"></s:select></td>
           </tr>
           <tr>
               <td><spring:message code="add.area"/></td>
               <td><s:select id="area" name="area" list="%{#session.areaList}" listValue="key" listKey="value"></s:select></td>
           </tr>
           <tr>
               <td><spring:message code="add.start_date"/></td>
               <td><s:textfield id="start_date" name="startDate"/></td>
           </tr>
           <tr>
               <td><spring:message code="add.company"/></td>
               <td><s:textfield id="company" name="company"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.cost"/></td>
               <td><s:textfield id="cost" name="cost"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.legal_representative"/></td>
               <td><s:textfield id="legal_representative" name="legalRepresentative"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.office_staff"/></td>
               <td><s:textfield id="office_staff" name="officeStaff"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.detailed_address"/></td>
               <td><s:textfield id="detailed_address" name="detailedAddress"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.office_telephone"/></td>
               <td><s:textfield id="office_telephone" name="officeTelephone"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.cellphone"/></td>
               <td><s:textfield id="cellphone" name="cellphone"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.qq"/></td>
               <td><s:textfield id="qq" name="qq"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.micromsg"/></td>
               <td><s:textfield id="micromsg" name="micromsg"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.introduction"/></td>
               <td><s:textarea id="introduction" name="introduction" cssStyle="width: 150px"></s:textarea></td>
           </tr>
           <tr>
               <td><spring:message code="add.cooperation_project"/></td>
               <td><s:textfield id="cooperation_project" name="cooperationProject"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.possible_business"/></td>
               <td><s:textfield id="possible_business" name="possibleBusiness"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="add.client_evaluation"/></td>
               <td><s:textfield id="client_evaluation" name="clientEvaluation"></s:textfield></td>
           </tr>
           <tr>
               <td><spring:message code="list.comment"/></td>
               <td><s:textarea id="comment" name="comment" cssStyle="width: 150px"></s:textarea></td>
           </tr>
           <tr>
               <td><div id="error" style="color:#FF0000"></div></td>
           </tr>
       </table>
       <!-- <s:submit label="submit"></s:submit> -->
       <!-- <input type="button" onclick="validate()" value="submit"></input> -->
       <input id="subbtn" type="button" onclick="submitForm()" value="submit"></input> 
    </s:form>
    </center>
  </body>
</html>
