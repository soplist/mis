<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'permission_set.jsp' starting page</title>
    <link rel="stylesheet" href="style/permission_set.css" type="text/css"></link>
    <link rel="stylesheet" href="style/jquery-ui.css" type="text/css"></link>
    <link rel="stylesheet" href="style/bootstrap.min.css" type="text/css"></link>
    <link rel="stylesheet" href="style/bootstrap-multiselect.css" type="text/css"></link>
    <script type="text/javascript" src="js/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
    <script type="text/javascript" src="script/permission_setting.js"></script>
    <script>
    $(document).ready(function() {
        $(".users").multiselect({
              buttonWidth: '150px',
              includeSelectAllOption: true
        });
    });
    </script>
    </head>
    <body>
    <table class="table_1" border="1">
        <tr>
            <th><spring:message code="permission.name"/></th>
            <th><spring:message code="permission.customer.create"/></th>
            <th><spring:message code="permission.customer.retrieve"/></th>
            <th><spring:message code="permission.customer.update"/></th>
            <th><spring:message code="permission.customer.delete"/></th>
            <th><spring:message code="permission.pm.setting"/></th>
            <th><spring:message code="permission.setting"/></th>
            <th><spring:message code="permission.pm.all"/>
            <th></th>
        </tr>
         <s:iterator value="#session.permissions" id="p">  
             <tr>
                 <td>
                 <s:property value="#p.pmnName"/>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},1)" id="c_${p.pid}">
                     <c:if test="${p.c==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.c==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},2)" id="r_${p.pid}">
                     <c:if test="${p.r==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.r==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},3)" id="u_${p.pid}">
                     <c:if test="${p.u==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.u==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},4)" id="d_${p.pid}">
                     <c:if test="${p.d==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.d==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},5)" id="pmsetting_${p.pid}">
                     <c:if test="${p.pmsetting==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.pmsetting==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},6)" id="psetting_${p.pid}">
                     <c:if test="${p.psetting==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.psetting==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 <td>
                 <select onchange="changePSetting(${p.pid},7)" id="viewall_${p.pid}">
                     <c:if test="${p.viewAllPm==true}">
                        <option selected="selected" value="1"><spring:message code="permission.open"/></option>
                        <option value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                     <c:if test="${p.viewAllPm==false}">
                        <option value="1"><spring:message code="permission.open"/></option>
                        <option selected="selected" value="0"><spring:message code="permission.close"/></option>
                     </c:if>
                 </select>
                 </td>
                 
                 <td>
                    <select onchange="updateUsers(${p.pid})" autocomplete="off" id="users_${p.pid}" name="users" class="users" multiple="multiple">
                    <s:if test="#session.userList!=null">
                    <s:iterator value="#session.userList" id="user"> 
                    
                        <c:set var="slct" value="0"></c:set>
                        <s:iterator value="#p.usersForPid" id="us">
                            <c:if test="${us.uid==user.uid}">
                            <c:set var="slct" value="1"></c:set>
                            </c:if>
                        </s:iterator>
                        
                        <c:if test="${slct==0}">
                            <option value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                        <c:if test="${slct==1}">
                            <option selected="selected" value="<s:property value="#user.uid"/>"><s:property value="#user.realName"/></option>
                        </c:if>
                    
                    </s:iterator>
                    </s:if>
                    </select>
                 </td>
             </tr>
         </s:iterator>
    </table>      
  </body>
</html>
