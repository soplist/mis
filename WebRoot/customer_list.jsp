<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'customer_list.jsp' starting page</title>
    
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/customer_list.css" type="text/css"></link>
    <link rel="icon" href="img/64556.gif" type="image/gif">
    <script type="text/javascript">
        window.onload=function(){ 
            if ((navigator.userAgent.indexOf('MSIE') >= 0) && (navigator.userAgent.indexOf('Opera') < 0)){
                var box = document.getElementById('div_2');
                box.style.marginTop = '110px';
            }
        };
    
        var xmlhttp=null;
        function search(){
            
            if (window.XMLHttpRequest){// code for Firefox, Mozilla, IE7, etc.
                xmlhttp=new XMLHttpRequest();
            }
            else if (window.ActiveXObject){// code for IE6, IE5
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
            }
            if (xmlhttp!=null){
                var cpy = document.getElementById("search_company").value;
                var data = "company="+cpy;
                
                xmlhttp.onreadystatechange=state_Change;
                xmlhttp.open("post","listCustomerByCompany");
                xmlhttp.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" ) ;
                xmlhttp.send(data);
            }
        }
        
        function state_Change(){
            if (xmlhttp.readyState==4){// 4 = "loaded"
                if (xmlhttp.status==200){// 200 = "OK"
                    //alert("form has been submit!");
                    //window.location.reload();
                    //document.execCommand('Refresh');
                    //window.navigate(location);
                }
  	            else{
  	                alert("xmlhttp.status:" + xmlhttp.status);
    	            alert("Problem retrieving data:" + xmlhttp.statusText);
                }
            }
        }
    </script>
  </head>
  
  <body>
  <c:if test="${user.permission.c==true}">
  <input type="button" onclick="window.open('addCustomerPrevious')" id="addCtm" class="button_1" name="addCtm" value="add customer"/>
  </c:if>
  ${user.name}<nobr style="color:#4682B4">  ${user.permission.pmnName}</nobr>
  <s:a action="modifyPass"><spring:message code="list.modify_password"/></s:a>
  <s:a action="logout"><spring:message code="list.logout"/></s:a>
  <!-- <input type="button" onclick="window.open('listScoreByRelName')" id="score" class="" name="scoreSys" value="score"/>  -->
  <br></br>
  <s:form id="sform" action="listCustomerByCompanyAndLegalRepr" method="post">
      <spring:message code="list.company"/>:<s:textfield id="search_company" name="company"/>
      <spring:message code="list.legal_representative"/>:<s:textfield name="legalRepresentative"/>
      <!-- <input id="subbtn" type="button" onclick="search()" value="submit"></input>  -->
      <s:submit></s:submit>
  </s:form>
    <div class="div_1">
    <div id="div_2" class="div_2">
       <div class="div_3">
           <s:iterator value="#session.dptmlist" id="dpt"> 
               <s:a cssClass="a_1" action="listCustomerByDepartment">
                   <s:param name="dept">
                        <s:property value="#dpt.did"/>
                   </s:param>
                   <s:property value="#dpt.departmentName"/>
               </s:a><br></br>
           </s:iterator>
       </div>
       <div class="div_4">
           <%request.setCharacterEncoding("utf-8"); %>
           <s:iterator value="#session.areaList" id="arl"> 
               <s:a cssClass="a_1" action="listCustomerByArea">
                   <s:param name="area">
                        <s:property value="#arl.value"/>
                   </s:param>
                   <s:property value="#arl.value"/>
               </s:a><br></br>
           </s:iterator>
       </div>
    </div>
    <div  class="div_5">
    <s:if test="#session.customer_page!=null">
        <s:if test="#session.customer_page.hasPrePage==true">
            <a class="a_2" href="listCustomersByPage?pageIndex=${customer_page.currentPage-1}">
                <spring:message code="peme.previous_page"/>
            </a>
        </s:if>
        <s:if test="#session.customer_page.hasPrePage==false">
            <span class="span_2">
                <spring:message code="peme.previous_page"/>
            </span>
        </s:if>
                
        <c:forEach  begin="1" end="${customer_page.totalPage}" var="pageIndex"> 
            <c:if test="${pageIndex==customer_page.currentPage}">
                ${pageIndex}
            </c:if>
            <c:if test="${pageIndex!=customer_page.currentPage}">
                <a href="listCustomersByPage?pageIndex=${pageIndex}">${pageIndex}</a> 
            </c:if>
        </c:forEach>
                
        <s:if test="#session.customer_page.hasNextPage==true">
            <a class="a_2" href="listCustomersByPage?pageIndex=${customer_page.currentPage+1}">
                <spring:message code="peme.next_page"/>
            </a>
        </s:if>
        <s:if test="#session.customer_page.hasNextPage==false">
            <span class="span_2">
                <spring:message code="peme.next_page"/>
            </span>
        </s:if>
    </s:if>
    <table class="table_1" border="1" width="80%" align="center">  
        <tr class="tr_1">
            <th><spring:message code="list.id"/></th>  
            <th><spring:message code="list.department"/></th>
            <th><spring:message code="list.area"/></th>
            <th><spring:message code="list.start_date"/></th>  
            <th><spring:message code="list.company"/></th>  
            <th><spring:message code="list.cost"/></th>  
            <th><spring:message code="list.legal_representative"/></th>  
            <th><spring:message code="list.office_staff"/></th>
            <th><spring:message code="list.detailed_address"/></th>  
            <th><spring:message code="list.office_telephone"/></th>  
            <th><spring:message code="list.cellphone"/></th>  
            <th><spring:message code="list.qq"/></th>  
            <th><spring:message code="list.micromsg"/></th>
            <th><spring:message code="list.introduction"/></th>  
            <th><spring:message code="list.cooperation_project"/></th>  
            <th><spring:message code="list.possible_business"/></th>  
            <th><spring:message code="list.client_evaluation"/></th>  
            <th><spring:message code="list.comment"/></th> 
            <th><spring:message code="list.add_date"/></th>
            <th><spring:message code="list.add_user"/></th>
            <th><spring:message code="list.operation"/></th> 
            
        </tr>  
        <s:if test="#request.list==null">
            <jsp:forward page="/login.jsp"></jsp:forward>
        </s:if>
        <s:iterator value="#request.list" id="cus">  
            <tr>  
                <td>  
                    <s:property value="#cus.cid"/>  
                </td>  
                <td>  
                    <s:property value="#cus.department.departmentName"/>  
                </td>  
                <td>  
                    <s:property value="#cus.area"/>  
                </td>  
                <td>  
                    <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#cus.startDate})}"/>
                </td>  
                <td>  
                    <s:property value="#cus.company"/>  
                </td>  
                <td>  
                    <s:property value="#cus.cost"/>  
                </td>  
                <td>  
                    <s:property value="#cus.legalRepresentative"/>  
                </td>  
                <td>  
                    <s:property value="#cus.officeStaff"/>  
                </td>  
                <td>  
                    <s:property value="#cus.detailedAddress"/>  
                </td>  
                <td>  
                    <s:property value="#cus.officeTelephone"/>  
                </td>
                <td>  
                    <s:property value="#cus.cellphone"/>  
                </td>  
                <td>  
                    <s:property value="#cus.qq"/>  
                </td>  
                <td>  
                    <s:property value="#cus.micromsg"/>  
                </td>  
                <td>  
                    <s:property value="#cus.introduction"/>  
                </td>  
                <td>  
                    <s:property value="#cus.cooperationProject"/>  
                </td>  
                <td>  
                    <s:property value="#cus.possibleBusiness"/>  
                </td>
                <td>  
                    <s:property value="#cus.clientEvaluation"/>  
                </td>  
                <td>  
                    <s:property value="#cus.comment"/>  
                </td>
                <td>  
                    <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#cus.addDate})}"/>  
                </td>
                <td>  
                    <s:property value="#cus.addUser.realName"/>  
                </td>
                <td>
                    <c:if test="${user.permission.d==true}">
                    <s:a action="deleteCustomer" cssClass="a_1">
                        <s:param name="id">
                            <s:property value="#cus.cid"/>
                        </s:param>
                        <spring:message code="list.delete"/>
                    </s:a>
                    </c:if>
                    <c:if test="${user.permission.u==true}">
                    <a href="#" onclick="window.open('updateCustomerPrevious?id=<s:property value='#cus.cid' />')"  class="a_1">
                        <spring:message code="list.update"/>
                    </a>
                    </c:if>
                    
                </td>
            </tr>  
        </s:iterator>  
    </table>  
    </div>
    </div>
  </body>
</html>
