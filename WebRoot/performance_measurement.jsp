<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'performance_measurement.jsp' starting page</title>  
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <link rel="stylesheet" href="style/performance_measurement.css" type="text/css"></link>
    <script type="text/javascript" src="script/performance_measurement.js"></script>
    <script type="text/javascript" src="jquery/jquery-2.2.3.min.js"></script>
    <!--<script type="text/javascript" src="script/tabScript.js"></script>-->
    <link rel="stylesheet" href="style/tabStyle.css" type="text/css"></link>
    </head>
    <!-- background="img/Website-Design-Background.png" -->
    <body onload="load_performance_measurement_page()">
    <!-- <a href="getAllPmSetting"><img class="img_1" src="img/setting.png"></img><spring:message code="pm.setting"/></a> -->
    <c:if test="${user.permission.pmsetting==true}">
    <input type="button" onclick="window.open('getAllPmSetting')" id="setpm" class="button_1" name="setpm" value="绩效考核设置"/>
    </c:if>
    <c:if test="${user.permission.psetting==true}">
    <a class="a_1" onclick="window.open('previousPermissionSet')">
    <spring:message code="peme.permission"/>
    </a>
    </c:if>
    <c:if test="${user.permission.mes==true}">
    <a class="a_1" onclick="window.open('previousManagerEvaluateSetting')">
    <spring:message code="peme.manager_evaluate_setting"/>
    </a>
    </c:if>
    <s:a action="logout"><spring:message code="list.logout"/></s:a>
    <div class="div_3">
    <div class="div_1" id="div_1">
		<!-- <input name="show" type="button" onClick="showTask();" value="显示个人分配任务">
        <input name="show" type="button" onClick="hiddenTask();" value="隐藏个人分配任务"> -->
		<div class="content" id="assign_task_content">
		    <input name="show" type="button" onClick="show_assign_task_not_finished_panel();" value="未完成">
		    <input name="show" type="button" onClick="show_assign_task_finished_panel();" value="已完成">
            <div id="assign_task_not_finished_panel">
			<table border="1" class="table_1">
			<tr class="tr_3">
                <th><spring:message code="peme.no"/></th>
                <th><spring:message code="peme.time"/></th>
                <th><spring:message code="peme.type"/></th>
                <!-- <th><spring:message code="peme.statu"/></th> -->
                <th><spring:message code="peme.name"/></th>
                <th><spring:message code="peme.evaluate"/></th>
            </tr>
            <c:if test="${fn:length(managerPmTables)>0}">
                <tr>
                <td></td>
                <td></td>
                <td>
                    <span class="span_1">
                    <spring:message code="peme.type_3"/>
                    </span>
                </td>
                <td>
                    <s:iterator value="#session.managerPmTables" id="pt">
                        <s:if test="#pt.statu==false">
                        <s:property value="#pt.pmTaskByTid.userByUid.realName"/>,
                        </s:if>
                    </s:iterator>
                </td>
                <td>
                    <a class="a_1" onclick="window.open('previousManagerOrCompanyEvaluate?managerEvaluateOrCompanyEvaluate=3')">
                        <spring:message code="peme.evaluate"/>
                    </a>
                </td>
                </tr>
            </c:if>
            <c:if test="${fn:length(companyPmTables)>0}">
                <tr>
                <td></td>
                <td></td>
                <td>
                    <span class="span_3">
                    <spring:message code="peme.type_4"/>
                    </span>
                </td>
                <td>
                    <s:iterator value="#session.companyPmTables" id="pt">
                        <s:if test="#pt.statu==false">
                        <s:property value="#pt.pmTaskByTid.userByUid.realName"/>,
                        </s:if>
                    </s:iterator>
                </td>
                <td>
                    <a class="a_1" onclick="window.open('previousManagerOrCompanyEvaluate?managerEvaluateOrCompanyEvaluate=4')">
                        <spring:message code="peme.evaluate"/>
                    </a>
                </td>
                </tr>
            </c:if>
            <s:if test="#session.SelfAndDeptAndStaffPmTables!=null">
                <s:iterator value="#session.SelfAndDeptAndStaffPmTables" id="pt">
                    <s:if test="#pt.statu==false">
                    <tr>
                        <td>
                            <s:property value="#pt.pmTaskByTid.pid"/>
                        </td>
                        <td>
                            <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.pmTaskByTid.launchTime})}"/>
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
                            <s:if test="#pt.type==6">
                                <spring:message code="peme.type_6"/>
                            </s:if>
                        </td>
                        <!-- <td>
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.statu_1"/>
                            </s:if>
                            <s:if test="#pt.statu==true">
                                <spring:message code="peme.statu_2"/>
                            </s:if>
                        </td> -->
                        <td>
                            <s:property value="#pt.pmTaskByTid.userByUid.realName"/>
                        </td>
                        <td>
                            <s:if test="#pt.type!=6">
                            <s:if test="#pt.simple==false">
                            <a href="#" class="a_1" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}&&type=1')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                            </s:if>
                            <s:if test="#pt.simple==true">
                            <a href="#" class="a_1" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}&&type=2')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                            </s:if>
                            </s:if>
                            <s:if test="#pt.type==6">
                            <a href="#" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}&&type=3')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                            </s:if>
                        </td>
                    </tr>
                    </s:if>
                </s:iterator>
                
            </s:if>
            </table>
			</div>
			<div id="assign_task_finished_panel">
			<!-- assign task finished page -->
			<s:if test="#session.current_user_finished_pmtable_page!=null">
                <s:if test="#session.current_user_finished_pmtable_page.hasPrePage==true">
                    <a class="a_1" onclick="save_layout_on_change_finished_pmtable_page();" href="getPmTableByPage?finished_pmtable_page_index=${current_user_finished_pmtable_page.currentPage-1}">
                        <spring:message code="peme.previous_page"/>
                    </a>
                </s:if>
                <s:if test="#session.current_user_finished_pmtable_page.hasPrePage==false">
                    <span class="span_2">
                        <spring:message code="peme.previous_page"/>
                    </span>
                </s:if>
                
                <c:forEach  begin="1" end="${current_user_finished_pmtable_page.totalPage}" var="pageIndex"> 
                <c:if test="${pageIndex==current_user_finished_pmtable_page.currentPage}">
                ${pageIndex}
                </c:if>
                <c:if test="${pageIndex!=current_user_finished_pmtable_page.currentPage}">
                <a onclick="save_layout_on_change_finished_pmtable_page();" href="getPmTableByPage?finished_pmtable_page_index=${pageIndex}">${pageIndex}</a> 
                </c:if>
                </c:forEach>
                
                <s:if test="#session.current_user_finished_pmtable_page.hasNextPage==true">
                    <a class="a_1" onclick="save_layout_on_change_finished_pmtable_page();" href="getPmTableByPage?finished_pmtable_page_index=${current_user_finished_pmtable_page.currentPage+1}">
                        <spring:message code="peme.next_page"/>
                    </a>
                </s:if>
                <s:if test="#session.current_user_finished_pmtable_page.hasNextPage==false">
                    <span class="span_2">
                        <spring:message code="peme.next_page"/>
                    </span>
                </s:if>
            </s:if>
			
			<table border="1" class="table_1">
            <tr class="tr_3">
                <th><spring:message code="peme.no"/></th>
                <th><spring:message code="peme.time"/></th>
                <th><spring:message code="peme.type"/></th>
                <!-- <th><spring:message code="peme.statu"/></th> -->
                <th><spring:message code="peme.name"/></th>
                <th><spring:message code="peme.score"/></th>
                
            </tr>
        
            <s:if test="#session.current_user_finished_pmtables!=null">
                <s:iterator value="#session.current_user_finished_pmtables" id="pt">
                    <s:if test="#pt.statu==true">
                    <tr>
                        <td>
                            <s:property value="#pt.pmTaskByTid.pid"/>
                        </td>
                        <td>
                            <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.pmTaskByTid.launchTime})}"/>
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
                            <s:if test="#pt.type==6">
                                    <spring:message code="peme.type_6"/>
                                </s:if>
                        </td>
                        <!-- <td>
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.statu_1"/>
                            </s:if>
                            <s:if test="#pt.statu==true">
                                <spring:message code="peme.statu_2"/>
                            </s:if>
                        </td> -->
                        <td>
                            <s:property value="#pt.pmTaskByTid.userByUid.realName"/>
                        </td>
                        <td>
                            <!--<s:if test="#pt.type!=6">
                            <s:if test="#pt.simple==false">
                            <a class="a_1" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}&&type=1')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                            </s:if>
                            <s:if test="#pt.simple==true">
                            <a class="a_1" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}&&type=2')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                            </s:if>
                            </s:if>
                            <s:if test="#pt.type==6">
                            <a class="a_1" onclick="window.open('previousEvaluate?pm_table_id=${pt.pid}&&type=3')">
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.evaluate"/>
                            </s:if>
                            </a>
                            </s:if> -->
                            <s:if test="#pt.type==1||#pt.type==2||#pt.type==5">
                            ${pt.item1+pt.item2+pt.item3+pt.item4+pt.item5+pt.item6+pt.item7+pt.item8+pt.item9+pt.item10}
                            </s:if>
                            <s:if test="#pt.type==3||#pt.type==4">
                            ${pt.item11}
                            </s:if>
                            <s:if test="#pt.type==6">
                            ${pt.item1+pt.item2+pt.item3+pt.item4+pt.item5},${pt.item6+pt.item7+pt.item8+pt.item9},${pt.item10+pt.item11},${pt.item12+pt.item13}
                            </s:if>
                        </td>
                    </tr>
                    </s:if>
                </s:iterator>
            </s:if>
            </table>
			</div>
		</div>
        
    </div>
    <div class="div_2">
    
            <c:if test="${user.permission.viewAllPm==true}">
            
            <input name="show" type="button" onClick="show_personal_task_panel();" value="显示个人列表">
            <input name="show" type="button" onClick="show_all_task_panel();" value="显示总体列表">
            
            <div id="all_task_panel">
            <s:if test="#session.pmtask_page!=null">
                <s:if test="#session.pmtask_page.hasPrePage==true">
                    <a class="a_1" onclick="save_layout_on_change_all_pmtask_page();" href="summaryGetPage?pageIndex=${pmtask_page.currentPage-1}">
                        <spring:message code="peme.previous_page"/>
                    </a>
                </s:if>
                <s:if test="#session.pmtask_page.hasPrePage==false">
                    <span class="span_2">
                        <spring:message code="peme.previous_page"/>
                    </span>
                </s:if>
                
                <c:forEach  begin="1" end="${pmtask_page.totalPage}" var="pageIndex"> 
                <c:if test="${pageIndex==pmtask_page.currentPage}">
                ${pageIndex}
                </c:if>
                <c:if test="${pageIndex!=pmtask_page.currentPage}">
                <a onclick="save_layout_on_change_all_pmtask_page();" href="summaryGetPage?pageIndex=${pageIndex}">${pageIndex}</a> 
                </c:if>
                </c:forEach>
                
                <s:if test="#session.pmtask_page.hasNextPage==true">
                    <a class="a_1" onclick="save_layout_on_change_all_pmtask_page();" href="summaryGetPage?pageIndex=${pmtask_page.currentPage+1}">
                        <spring:message code="peme.next_page"/>
                    </a>
                </s:if>
                <s:if test="#session.pmtask_page.hasNextPage==false">
                    <span class="span_2">
                        <spring:message code="peme.next_page"/>
                    </span>
                </s:if>
            </s:if>
            
            <table border="1" class="table_1">
            <tr class="tr_3">
                <th><spring:message code="peme.task.no"/></th>
                <th><spring:message code="peme.time"/></th>
                <th><spring:message code="peme.task.name"/></th>
                <th><spring:message code="peme.task.detail"/></th>
                <th><spring:message code="peme.task.statu"/></th>
            </tr>
        
            <s:if test="#session.allPmTask!=null">
                <s:iterator value="#session.allPmTask" id="pt">
                    <s:if test="#pt.managerEvaluate==false">
                    <tr>
                        <td>
                            <s:property value="#pt.pid"/>
                        </td>
                        <td>
                            <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.launchTime})}"/>
                        </td>
                        <td>
                            <s:property value="#pt.userByUid.realName"/>
                        </td>
                        <td class="td_1">
                            <span class="span_1">
                                <spring:message code="peme.task.statu_1"/>:
                            </span>
                            <s:iterator value="#pt.pmTablesForTid" id="table">
                                <s:if test="#table.statu==true">
                                    <span class="span_2">
                                    <s:property value="#table.userByUid.realName"/>,
                                    </span>
                                    <span class="span_1">(
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
                                    )</span>:
                                    <s:if test="#table.simple==false">
                                    <span class="span_4">
                                    ${table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10}
                                    </span>
                                    </s:if>
                                    <s:if test="#table.simple==true">
                                    <span class="span_4">
                                    ${table.item11}
                                    </span>
                                    </s:if>;
                                    </s:if>
                            </s:iterator>
                            <br>
                            <span class="span_3">
                                <spring:message code="peme.task.statu_2"/>:
                            </span>
                            <s:iterator value="#pt.pmTablesForTid" id="table">
                                <s:if test="#table.statu==false">
                                    <span class="span_3">
                                    <s:property value="#table.userByUid.realName"/>,
                                    </span>
                                    <span class="span_1">(
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
                                    )</span>;
                                </s:if>
                            </s:iterator>
                            <br>
                            
                            <!-- <s:iterator value="#pt.pmTablesForTid" id="table">
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
                                <s:if test="#table.statu==true&&#table.simple==false">
                                <span class="span_4">
                                    ${table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10}
                                </span>
                                </s:if>
                                <s:if test="#table.statu==true&&#table.simple==true">
                                <span class="span_4">
                                    ${table.item11}
                                </span>
                                </s:if>
                            </s:iterator>-->
                            
                            <s:if test="#pt.statu==true">
                                <c:set var="score" value="${session.user.option.selfEval/100}"></c:set>
                                <c:set var="score_1" value="0"></c:set>
                                <c:set var="score_2" value="0"></c:set>
                                <c:set var="score_3" value="0"></c:set>
                                <c:set var="score_4" value="0"></c:set>
                                <c:set var="score_5" value="0"></c:set>
                                <c:set var="score_2_num" value="0"></c:set>
                                <c:set var="score_4_num" value="0"></c:set>
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
                                        <s:if test="#table.simple==true">
                                        <c:set var="score_3" value="${score_3+(table.item11)}"></c:set>
                                        </s:if>
                                        <s:if test="#table.simple==false">
                                        <c:set var="score_3" value="${score_3+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                        </s:if>
                                    </s:if>
                                    <s:if test="#table.type==4">
                                        <c:set var="score_4_num" value="${score_4_num+1}"></c:set>
                                        <s:if test="#table.simple==true">
                                        <c:set var="score_4" value="${score_4+(table.item11)}"></c:set>
                                        </s:if>
                                        <s:if test="#table.simple==false">
                                        <c:set var="score_4" value="${score_4+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                        </s:if>
                                    </s:if>
                                    <s:if test="#table.type==5">
                                        <c:set var="score_5_num" value="${score_5_num+1}"></c:set>
                                        <c:set var="score_5" value="${score_5+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                    </s:if>
                                </s:iterator>
                                
                                <!--<c:set var="max_without_score_1" value="${score_2/score_2_num}"></c:set>
                                <c:if test="${score_3>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_3}"></c:set>
                                </c:if>
                                <c:if test="${(score_4/score_4_num)>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_4/score_4_num}"></c:set>
                                </c:if>
                                <c:if test="${(score_5/score_5_num)>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_5/score_5_num}"></c:set>
                                </c:if>-->
                                
                                <c:set var="min_without_score_1" value="${score_2/score_2_num}"></c:set>
                                <c:if test="${score_3<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_3}"></c:set>
                                </c:if>
                                <c:if test="${(score_4/score_4_num)<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_4/score_4_num}"></c:set>
                                </c:if>
                                <c:if test="${(score_5/score_5_num)<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_5/score_5_num}"></c:set>
                                </c:if>
                                
                                <c:set var="exception" value="0"></c:set>
                                <!--<c:if test="${score_1>(max_without_score_1+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>-->
                                <c:if test="${score_1>(score_2/score_2_num+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>
                                <c:if test="${score_1>(score_3+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>
                                <c:if test="${score_1>(score_4/score_4_num+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>
                                <c:if test="${score_1>(score_5/score_5_num+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>
                                
                                
                                <c:if test="${exception==0}">
                                <span class="span_5">
                                <br>
                                <spring:message code="peme.task.total_score"/>:
                                    <fmt:formatNumber type="number" value="${score_1}" maxFractionDigits="2"/>*${pt.optionsBySid.selfEval}%+
                                    <fmt:formatNumber type="number" value="${score_2/score_2_num}" maxFractionDigits="2"/>*${pt.optionsBySid.deptEval}%+
                                    <fmt:formatNumber type="number" value="${score_3}" maxFractionDigits="2"/>*${pt.optionsBySid.managerEval}%+
                                    <fmt:formatNumber type="number" value="${score_4/score_4_num}" maxFractionDigits="2"/>*${pt.optionsBySid.companyEval}%+
                                    <fmt:formatNumber type="number" value="${score_5/score_5_num}" maxFractionDigits="2"/>*${pt.optionsBySid.colleaguesEval}%
                                    =<fmt:formatNumber type="number" value="${(score_1*pt.optionsBySid.selfEval/100)+((score_2/score_2_num)*pt.optionsBySid.deptEval/100)+(score_3*pt.optionsBySid.managerEval/100)+((score_4/score_4_num)*pt.optionsBySid.companyEval/100)+((score_5/score_5_num)*pt.optionsBySid.colleaguesEval/100)}" maxFractionDigits="2"/>
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
                    </s:if>
                    
                    <s:if test="#pt.managerEvaluate==true">
                    <tr>
                        <td><s:property value="#pt.pid"/></td>
                        <td>
                            <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.launchTime})}"/>
                        </td>
                        <td><s:property value="#pt.userByUid.realName"/></td>
                        <td>
                            <!--<s:if test="#pt.statu==false">
                                <s:iterator value="#pt.pmTablesForTid" id="table">
                                    <spring:message code="peme.type_6"/>:
                                    <s:property value="#table.userByUid.realName"/>,
                                </s:iterator>
                            </s:if>
                            
                            <s:if test="#pt.statu==true">
                                <s:iterator value="#pt.pmTablesForTid" id="table">
                                    <spring:message code="peme.type_6"/>:
                                    <s:property value="#table.userByUid.realName"/>,
                                    <spring:message code="peme.items_score"/>
                                    ${table.item1},${table.item2},${table.item3},${table.item4},${table.item5},
                                    <span class="span_1">
                                    ${table.item1+table.item2+table.item3+table.item4+table.item5},
                                    </span>
                                    ${table.item6},${table.item7},${table.item8},${table.item9},
                                    <span class="span_1">
                                    ${table.item6+table.item7+table.item8+table.item9},
                                    </span>
                                    ${table.item10},${table.item11},
                                    <span class="span_1">
                                    ${table.item10+table.item11},
                                    </span>
                                    ${table.item12},${table.item13},
                                    <span class="span_1">
                                    ${table.item12+table.item13},
                                    </span>
                                    <spring:message code="peme.task.total_score"/>:
                                    <fmt:formatNumber type="number" value="${(table.item1+table.item2+table.item3+table.item4+table.item5)*0.4+(table.item6+table.item7+table.item8+table.item9)*0.3+(table.item10+table.item11)*0.15+(table.item12+table.item13)*0.15}" maxFractionDigits="2"/>
                                </s:iterator>
                            </s:if>-->
                            
                            <s:iterator value="#pt.pmTablesForTid" id="table">
                                <spring:message code="peme.type_6"/>:
                                <s:property value="#table.userByUid.realName"/>,
                                <s:if test="#table.statu==true">
                                <spring:message code="peme.items_score"/>
                                ${table.item1},${table.item2},${table.item3},${table.item4},${table.item5},
                                <span class="span_1">
                                ${table.item1+table.item2+table.item3+table.item4+table.item5},
                                </span>
                                ${table.item6},${table.item7},${table.item8},${table.item9},
                                <span class="span_1">
                                ${table.item6+table.item7+table.item8+table.item9},
                                </span>
                                ${table.item10},${table.item11},
                                <span class="span_1">
                                ${table.item10+table.item11},
                                </span>
                                ${table.item12},${table.item13},
                                <span class="span_1">
                                ${table.item12+table.item13},
                                </span>
                                <spring:message code="peme.task.total_score"/>:
                                <fmt:formatNumber type="number" value="${(table.item1+table.item2+table.item3+table.item4+table.item5)*0.4+(table.item6+table.item7+table.item8+table.item9)*0.3+(table.item10+table.item11)*0.15+(table.item12+table.item13)*0.15}" maxFractionDigits="2"/>
                                </s:if>
                                <br>
                            </s:iterator>
                        </td>
                        <td>
                            <s:if test="#pt.statu==true">
                                <spring:message code="peme.task.statu_1"/>
                            </s:if>
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.task.statu_2"/>
                            </s:if>
                        </td>
                    </tr>
                    </s:if>
                </s:iterator>
            </s:if>
            </table>
            </div>
            </c:if>
            
            <div id="personal_task_panel">
            <table border="1" class="table_1">
            <tr class="tr_3">
                <th><spring:message code="peme.task.no"/></th>
                <th><spring:message code="peme.time"/></th>
                <th><spring:message code="peme.task.name"/></th>
                <th><spring:message code="peme.task.detail"/></th>
                <th><spring:message code="peme.task.statu"/></th>
            </tr>
        
            <s:if test="#session.current_user_pmtask!=null">
                <s:iterator value="#session.current_user_pmtask" id="pt">
                    <s:if test="#pt.managerEvaluate==false">
                    <tr>
                        <td>
                            <s:property value="#pt.pid"/>
                        </td>
                        <td>
                            <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.launchTime})}"/>
                        </td>
                        <td>
                            <s:property value="#pt.userByUid.realName"/>
                        </td>
                        <td class="td_1">
                            
                            <!--<s:iterator value="#pt.pmTablesForTid" id="table">
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
                                <s:if test="#table.statu==true&&#table.simple==false">
                                <span class="span_4">
                                    ${table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10}
                                </span>
                                </s:if>
                                <s:if test="#table.statu==true&&#table.simple==true">
                                <span class="span_4">
                                    ${table.item11}
                                </span>
                                </s:if>
                            </s:iterator>-->
                            <s:if test="#pt.statu==false">
                            <span class="span_1">
                                <spring:message code="peme.type_1_score"/>
                            </span>
                            <br>
                            <span class="span_2">
                                <spring:message code="peme.type_2_score"/>
                            </span>
                            <br>
                            <span class="span_3">
                                <spring:message code="peme.type_3_score"/>
                            </span>
                            <br>
                            <span class="span_4">
                                <spring:message code="peme.type_4_score"/>
                            </span>
                            <br>
                            <span class="span_5">
                                <spring:message code="peme.type_5_score"/>
                            </span>
                            <br>
                            </s:if>
                            
                            <s:if test="#pt.statu==true">
                                <c:set var="score" value="${session.user.option.selfEval/100}"></c:set>
                                <c:set var="score_1" value="0"></c:set>
                                <c:set var="score_2" value="0"></c:set>
                                <c:set var="score_3" value="0"></c:set>
                                <c:set var="score_4" value="0"></c:set>
                                <c:set var="score_5" value="0"></c:set>
                                <c:set var="score_2_num" value="0"></c:set>
                                <c:set var="score_4_num" value="0"></c:set>
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
                                        <s:if test="#table.simple==true">
                                        <c:set var="score_3" value="${score_3+(table.item11)}"></c:set>
                                        </s:if>
                                        <s:if test="#table.simple==false">
                                        <c:set var="score_3" value="${score_3+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                        </s:if>
                                        <!--<c:set var="score_3" value="${score_3+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>-->
                                    </s:if>
                                    <s:if test="#table.type==4">
                                        <c:set var="score_4_num" value="${score_4_num+1}"></c:set>
                                        <s:if test="#table.simple==true">
                                        <c:set var="score_4" value="${score_4+(table.item11)}"></c:set>
                                        </s:if>
                                        <s:if test="#table.simple==false">
                                        <c:set var="score_4" value="${score_4+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>
                                        </s:if>
                                        <!--<c:set var="score_4" value="${score_4+(table.item1+table.item2+table.item3+table.item4+table.item5+table.item6+table.item7+table.item8+table.item9+table.item10)}"></c:set>-->
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
                                <c:if test="${(score_4/score_4_num)>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_4/score_4_num}"></c:set>
                                </c:if>
                                <c:if test="${(score_5/score_5_num)>max_without_score_1}">
                                    <c:set var="max_without_score_1" value="${score_5/score_5_num}"></c:set>
                                </c:if>
                                
                                <c:set var="min_without_score_1" value="${score_2/score_2_num}"></c:set>
                                <c:if test="${score_3<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_3}"></c:set>
                                </c:if>
                                <c:if test="${(score_4/score_4_num)<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_4/score_4_num}"></c:set>
                                </c:if>
                                <c:if test="${(score_5/score_5_num)<min_without_score_1}">
                                    <c:set var="min_without_score_1" value="${score_5/score_5_num}"></c:set>
                                </c:if>
                                
                                <c:set var="exception" value="0"></c:set>
                                <c:if test="${score_1>(max_without_score_1+15)}">
                                    <c:set var="exception" value="1"></c:set>
                                </c:if>
                                
                                <span class="span_1">
                                    <!-- ${score_1} -->
                                    <spring:message code="peme.type_1_score"/><fmt:formatNumber type="number" value="${(score_1*pt.optionsBySid.selfEval/100)}" maxFractionDigits="2"/>
                                </span>
                                <br>
                                <span class="span_2">
                                    <!-- ${score_2/score_2_num} -->
                                    <spring:message code="peme.type_2_score"/><fmt:formatNumber type="number" value="${((score_2/score_2_num)*pt.optionsBySid.deptEval/100)}" maxFractionDigits="2"/>
                                </span>
                                <br>
                                <span class="span_3">
                                    <!-- ${score_3} -->
                                    <spring:message code="peme.type_3_score"/><fmt:formatNumber type="number" value="${(score_3*pt.optionsBySid.managerEval/100)}" maxFractionDigits="2"/>
                                </span>
                                <br>
                                <span class="span_4">
                                    <!-- ${score_4} -->
                                    <spring:message code="peme.type_4_score"/><fmt:formatNumber type="number" value="${((score_4/score_4_num)*pt.optionsBySid.companyEval/100)}" maxFractionDigits="2"/>
                                </span>
                                <br>
                                <span class="span_5">
                                    <!-- ${score_5/score_5_num} -->
                                    <spring:message code="peme.type_5_score"/><fmt:formatNumber type="number" value="${((score_5/score_5_num)*pt.optionsBySid.colleaguesEval/100)}" maxFractionDigits="2"/>
                                </span>
                                <br>
                                <c:if test="${exception==0}">
                                <span class="span_5">
                                <spring:message code="peme.task.total_score"/>:
                                    <fmt:formatNumber type="number" value="${(score_1*pt.optionsBySid.selfEval/100)+((score_2/score_2_num)*pt.optionsBySid.deptEval/100)+(score_3*pt.optionsBySid.managerEval/100)+((score_4/score_4_num)*pt.optionsBySid.companyEval/100)+((score_5/score_5_num)*pt.optionsBySid.colleaguesEval/100)}" maxFractionDigits="2"/>
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
                    </s:if>
                    <s:if test="#pt.managerEvaluate==true">
                    <tr>
                        <td><s:property value="#pt.pid"/></td>
                        <td>
                            <s:property value="%{getText('{0,date,yyyy-MM-dd }',{#pt.launchTime})}"/>
                        </td>
                        <td><s:property value="#pt.userByUid.realName"/></td>
                        <td>
                            <!--<s:if test="#pt.statu==false">
                                <s:iterator value="#pt.pmTablesForTid" id="table">
                                    <spring:message code="peme.type_6"/>:
                                    <s:property value="#table.userByUid.realName"/>,
                                </s:iterator>
                            </s:if>
                            
                            <s:if test="#pt.statu==true">
                                <s:iterator value="#pt.pmTablesForTid" id="table">
                                    <spring:message code="peme.type_6"/>:
                                    <s:property value="#table.userByUid.realName"/>,
                                    <spring:message code="peme.items_score"/>
                                    ${table.item1},${table.item2},${table.item3},${table.item4},${table.item5},${table.item6},${table.item7},${table.item8},${table.item9},${table.item10},${table.item11},${table.item12},${table.item13}
                                    <spring:message code="peme.task.total_score"/>:
                                    ${(table.item1+table.item2+table.item3+table.item4+table.item5)*0.4+(table.item6+table.item7+table.item8+table.item9)*0.3+(table.item10+table.item11)*0.15+(table.item12+table.item13)*0.15}
                                </s:iterator>
                            </s:if>-->
                            
                            <s:iterator value="#pt.pmTablesForTid" id="table">
                                <spring:message code="peme.type_6"/>:
                                <s:property value="#table.userByUid.realName"/>,
                                <s:if test="#table.statu==true">
                                <spring:message code="peme.items_score"/>
                                ${table.item1},${table.item2},${table.item3},${table.item4},${table.item5},
                                <span class="span_1">
                                ${table.item1+table.item2+table.item3+table.item4+table.item5},
                                </span>
                                ${table.item6},${table.item7},${table.item8},${table.item9},
                                <span class="span_1">
                                ${table.item6+table.item7+table.item8+table.item9},
                                </span>
                                ${table.item10},${table.item11},
                                <span class="span_1">
                                ${table.item10+table.item11},
                                </span>
                                ${table.item12},${table.item13},
                                <span class="span_1">
                                ${table.item12+table.item13},
                                </span>
                                <spring:message code="peme.task.total_score"/>:
                                <fmt:formatNumber type="number" value="${(table.item1+table.item2+table.item3+table.item4+table.item5)*0.4+(table.item6+table.item7+table.item8+table.item9)*0.3+(table.item10+table.item11)*0.15+(table.item12+table.item13)*0.15}" maxFractionDigits="2"/>
                                </s:if>
                                <br>
                            </s:iterator>
                        </td>
                        <td>-
                            <s:if test="#pt.statu==true">
                                <spring:message code="peme.task.statu_1"/>
                            </s:if>
                            <s:if test="#pt.statu==false">
                                <spring:message code="peme.task.statu_2"/>
                            </s:if>
                        </td>
                    </tr>
                    </s:if>
                </s:iterator>
            </s:if>
            </table>
            </div>
    </div>
    </div>
    
  </body>
</html>
