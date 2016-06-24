<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'performance_measurement.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/performance_measurement.css" type="text/css"></link></head>
  
  <body>
    <!-- <a href="getAllPmSetting"><img class="img_1" src="img/setting.png"></img><spring:message code="pm.setting"/></a> -->
    <input type="button" onclick="window.open('getAllPmSetting')" id="setpm" class="button_1" name="setpm" value="setpm"/>
    <div class="div_3">
    <div class="div_1">
        <table border="1" class="table_1">
            <tr class="tr_3">
                <th><spring:message code="peme.no"/></th>
                <th><spring:message code="peme.type"/></th>
                <th><spring:message code="peme.name"/></th>
                <th><spring:message code="peme.evaluate"/></th>
                <th><spring:message code="peme.statu"/></th>
            </tr>
        
            <s:if test="#session.user.pmTablesForUid!=null">
                <s:iterator value="#session.user.pmTablesForUid" id="pt">
                    <tr>
                        <td>
                            <s:property value="#pt.pmTaskByTid.pid"/>
                        </td>
                        <td>
                            <s:if test="#pt.type==1">
                                <spring:message code="peme.type_1"/>
                            </s:if>
                            <s:if test="#pt.type==2">
                                <spring:message code="peme.type_2"/>
                            </s:if>
                            <s:if test="#pt.type==3">
                                <spring:message code="peme.type_3"/>
                            </s:if>
                            <s:if test="#pt.type==4">
                                <spring:message code="peme.type_4"/>
                            </s:if>
                            <s:if test="#pt.type==5">
                                <spring:message code="peme.type_5"/>
                            </s:if>
                        </td>
                        <td>
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.statu_1"/>
                            </s:if>
                            <s:if test="#pt.statu==true">
                                <spring:message code="peme.statu_2"/>
                            </s:if>
                        </td>
                        <td>
                            <s:property value="#pt.pmTaskByTid.userByUid.realName"/>
                        </td>
                        <td>
                            <a class="a_1" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                        </td>
                    </tr>
                </s:iterator>
            </s:if>
        
        </table>
    </div>
    <div class="div_2">
            <table border="1" class="table_1">
            <tr class="tr_3">
                <th><spring:message code="peme.task.no"/></th>
                <th><spring:message code="peme.task.name"/></th>
                <th><spring:message code="peme.task.statu"/></th>
                <th><spring:message code="peme.task.detail"/></th>
            </tr>
        
            <s:if test="#session.user.pmTasksForUid!=null">
                <s:iterator value="#session.user.pmTasksForUid" id="pt">
                    <tr>
                        <td>
                            <s:property value="#pt.pid"/>
                        </td>
                        <td>
                            <s:property value="#pt.userByUid.realName"/>
                        </td>
                        <td class="td_1">
                            <s:iterator value="#pt.pmTablesForTid" id="table">
                                <span class="span_1">
                                <s:if test="#table.type==1">
                                    <spring:message code="peme.type_1"/>
                                </s:if>
                                <s:if test="#table.type==2">
                                    <spring:message code="peme.type_2"/>
                                </s:if>
                                <s:if test="#table.type==3">
                                    <spring:message code="peme.type_3"/>
                                </s:if>
                                <s:if test="#table.type==4">
                                    <spring:message code="peme.type_4"/>
                                </s:if>
                                <s:if test="#table.type==5">
                                    <spring:message code="peme.type_5"/>
                                </s:if>
                                </span>
                                :<s:property value="#table.userByUid.realName"/>,
                                <s:if test="#table.statu==true">
                                    <span class="span_2">
                                    <spring:message code="peme.task.statu_1"/>
                                    </span>
                                </s:if>
                                <s:if test="#table.statu==false">
                                    <span class="span_3">
                                    <spring:message code="peme.task.statu_2"/>
                                    </span>
                                </s:if>
                                <s:if test="#table.statu==true">
                                <span class="span_4">
                                    ${table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10}
                                </span>
                                </s:if>
                            </s:iterator>
                            
                            <s:if test="#pt.statu==true">
                                <c:set var="score" value="${session.user.option.selfEval/100}"></c:set>
                                <c:set var="score_1" value="0"></c:set>
                                <c:set var="score_2" value="0"></c:set>
                                <c:set var="score_3" value="0"></c:set>
                                <c:set var="score_4" value="0"></c:set>
                                <c:set var="score_5" value="0"></c:set>
                                <c:set var="score_2_num" value="0"></c:set>
                                <c:set var="score_5_num" value="0"></c:set>
                                
                                <s:iterator value="#pt.pmTablesForTid" id="table">
                                    <s:if test="#table.type==1">
                                        <c:set var="score_1" value="${score_1+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                    </s:if>
                                    <s:if test="#table.type==2">
                                        <c:set var="score_2_num" value="${score_2_num+1}"></c:set>
                                        <c:set var="score_2" value="${score_2+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                    </s:if>
                                    <s:if test="#table.type==3">
                                        <c:set var="score_3" value="${score_3+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                    </s:if>
                                    <s:if test="#table.type==4">
                                        <c:set var="score_4" value="${score_4+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                    </s:if>
                                    <s:if test="#table.type==5">
                                        <c:set var="score_5_num" value="${score_5_num+1}"></c:set>
                                        <c:set var="score_5" value="${score_5+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                    </s:if>
                                </s:iterator>
                                
                                <c:set var="max_without_score_1" value="${score_2/score_2_num}"></c:set>
                                <c:if test="${score_3>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_3}"></c:set>
                                </c:if>
                                <c:if test="${score_4>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_4}"></c:set>
                                </c:if>
                                <c:if test="${(score_5/score_5_num)>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_5/score_5_num}"></c:set>
                                </c:if>
                                
                                <c:set var="min_without_score_1" value="${score_2/score_2_num}"></c:set>
                                <c:if test="${score_3<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_3}"></c:set>
                                </c:if>
                                <c:if test="${score_4<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_4}"></c:set>
                                </c:if>
                                <c:if test="${(score_5/score_5_num)<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_5/score_5_num}"></c:set>
                                </c:if>
                                
                                <c:set var="exception" value="0"></c:set>
                                <c:if test="${score_1>(max_without_score_1+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>
                                
                                <c:if test="${exception==0}">
                                <span class="span_5">
                                <spring:message code="peme.task.total_score"/>:
                                    ${(score_1*pt.optionsBySid.selfEval/100)}+
                                    ${((score_2/score_2_num)*pt.optionsBySid.deptEval/100)}+
                                    ${(score_3*pt.optionsBySid.managerEval/100)}+
                                    ${(score_4*pt.optionsBySid.companyEval/100)}+
                                    ${((score_5/score_5_num)*pt.optionsBySid.colleaguesEval/100)}
                                    =${(score_1*pt.optionsBySid.selfEval/100)+((score_2/score_2_num)*pt.optionsBySid.deptEval/100)+(score_3*pt.optionsBySid.managerEval/100)+(score_4*pt.optionsBySid.companyEval/100)+((score_5/score_5_num)*pt.optionsBySid.colleaguesEval/100)}
                                    <!-- ${(score_1*pt.optionsBySid.selfEval/100)+((score_2/score_2_num)*pt.optionsBySid.deptEval/100)+(score_3*pt.optionsBySid.managerEval/100)+(score_4*pt.optionsBySid.companyEval/100)+((score_5/score_5_num)*pt.optionsBySid.colleaguesEval/100)} -->
                                </span>
                                </c:if>
                                
                                <c:if test="${exception==1}">
                                <span class="span_3">
                                    <spring:message code="peme.task.exception"/>
                                    <spring:message code="peme.task.total_score"/>:
                                        ${min_without_score_1}
                                </span>
                                </c:if>
                            </s:if>
                            
                        </td>
                        <td>
                            <s:if test="#pt.statu==true">
                                <c:if test="${exception==1}">
                                <span class="span_3">
                                <spring:message code="peme.task.statu_1"/>
                                </span>
                                </c:if>
                                <c:if test="${exception==0}">
                                <spring:message code="peme.task.statu_1"/>
                                </c:if>
                            </s:if>
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.task.statu_2"/>
                            </s:if>
                        </td>
                    </tr>
                </s:iterator>
            </s:if>
            </table>
    </div>
    </div>
    
  </body>
</html>
