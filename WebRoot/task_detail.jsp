<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>My JSP 'task_detail.jsp' starting page</title>
    <link rel="stylesheet" href="style/task_detail.css" type="text/css"></link>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div class="div_1">
    <table class="table_1" border="1" align="center">
       <caption><spring:message code="task_detail.title"/></caption>
       <tr class="tr_1">
          <th>name</th>
          <th>value</th>
       </tr>
       <tr>
          <td><spring:message code="lst.date"/></td>
          <td>${task.date}</td>
       </tr>
       <tr>
          <td><spring:message code="lst.who"/></td>
          <td>
             <s:iterator value="#session.task.NoticePeoplesForTaskId" id="np">
                        <c:set var="reject" value="0"></c:set>
                        <s:iterator value="#np.userByUserId.OperatesForUserId" id="op">
                            <s:if test="#op.opt==3">
                                <s:if test="#np.taskByTaskId.tid==#op.taskByTaskId.tid">
                                    <c:set var="reject" value="1"></c:set>
                                </s:if>
                            </s:if>
                        </s:iterator>
                    
                        <c:if test="${reject==0}">
                        <s:if test="#np.status==1">
                            <span class="span_1">
                            <s:property value="#np.userByUserId.realName"/>,
                            </span>
                        </s:if>
                        <s:if test="#np.status==0">
                            <s:property value="#np.userByUserId.realName"/>,
                        </s:if>
                        </c:if>
                        <c:if test="${reject==1}">
                            <span class="span_2">
                            <s:property value="#np.userByUserId.realName"/>,
                            </span>
                        </c:if>
             </s:iterator>
          </td>
       </tr>
       <tr>
          <td><spring:message code="lst.reason"/></td>
          <td>${task.reason}</td>
       </tr>
       <tr>
          <td><spring:message code="lst.score_class"/></td>
          <td>${task.scoreClass}</td>
       </tr>
       <tr>
          <td><spring:message code="lst.value"/></td>
          <td>${task.value}</td>
       </tr>
    </table>
    
    <table class="table_2" border="1" align="center">
       <caption><spring:message code="task_detail.operates"/></caption>
       <tr class="tr_2">
          <th>date</th>
          <th>operation user</th>
          <th>operation</th>
       </tr>
       <s:if test="#session.task.OperatesForTaskId!=null">
          <s:iterator value="#session.task.OperatesForTaskId" id="op">
              <tr>
              <td>
                    <s:property value="#op.date"/>
              </td>
              <td><s:property value="#op.userByUserId.realName"/></td>
              <td>
                    <s:if test="#op.opt==0">
                        <spring:message code="task_detail.launch"/>
                    </s:if>
                    <s:if test="#op.opt==1">
                        <spring:message code="task_detail.agree"/>
                    </s:if>
                    <s:if test="#op.opt==2">
                        <span class="span_3">
                        <spring:message code="task_detail.approve"/>
                        </span>
                    </s:if>
                    <s:if test="#op.opt==3">
                        <span class="span_2">
                        <spring:message code="task_detail.reject"/>
                        </span>
                    </s:if>
              </td>
              </tr>
          </s:iterator>
       </s:if>
    </table>
    </div>
  </body>
</html>
