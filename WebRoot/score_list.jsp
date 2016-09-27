<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.*" %>    

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'score_list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="style/score_list.css" type="text/css"></link>
    <script type="text/javascript">
    
    function submitMonth(){
        var monthForm = document.getElementById("monthf");
        monthForm.action="getArchiveByMonth";
        monthForm.submit();
    }
    </script>
  </head>
  
  <body>
    <%
        String[] approveUsers={"quxiaoxia","huangshuojie","dongguiqi","chenfang","luona","wangbenjun","wangbeijun","xieandi","wangkang"};
        session.setAttribute("approveUsers",approveUsers);
     %>
    ${user.name}<nobr style="color:#4682B4">  ${user.permission.pmnName}</nobr>
    <s:a action="logout"><spring:message code="list.logout"/></s:a>
    <input type="button" onclick="window.open('previousLaunchScoreForm')" id="launchScr" name="launchScr" value="launch score"/>
    <br><br>
    <div class="div_3">
    <div class="div_1">
    <table class="table_5" border="1" align="center">
        <caption><spring:message code="score_list.statistics_title"/></caption>
        <tr class="tr_6">
            <th><spring:message code="score_list.statistics_time"/></th>
            <th><spring:message code="score_list.statistics_value"/></th>
            <th><spring:message code="score_list.statistics_chart"/></th>
        </tr>
        <s:iterator value="#session.statisticsTable" id="entry">
            <tr>
            <td><s:property value="key"/></td>   
            <td><s:property value="value"/></td>   
            <td>
                <c:if test="${fn:length(key)==7}">
                <a class="a_4" onclick="window.open('pieChartForabcPerMonth?month=${key}')">
                     <spring:message code="score_list.statistics_chart"/>
                </a>
                </c:if> 
                <c:if test="${fn:length(key)==4}">
                <a class="a_4" onclick="window.open('barChartForYear?year=${key}')">
                     <spring:message code="score_list.statistics_yearchart"/>
                </a>
                </c:if> 
            </td>
            </tr>
        </s:iterator> 
    </table>
    <table class="table_2" border="1" align="center">
        <caption><spring:message code="score_list.notice_title"/></caption>
        <tr class="tr_2">
            <th><spring:message code="score_list.notice_date"/></th>
            <th><spring:message code="score_list.notice_reason"/></th>
            <th><spring:message code="score_list.notice_score_class"/></th>
            <th><spring:message code="score_list.notice_value"/></th>
            <th><spring:message code="score_list.notice_status"/></th>
            <th><spring:message code="score_list.notice_peoples"/></th>
            <th><spring:message code="score_list.notice_operator"/></th>
        </tr>
    <s:if test="#session.user.noticePeoplesForUserId!=null">
        <s:iterator value="#session.user.noticePeoplesForUserId" id="np">
            <!-- if tasks status is 2,notice peoples do not show.-->
            <s:if test="#np.taskByTaskId.status!=2&&#np.taskByTaskId.status!=4">
            <tr>
                <td><s:property value="#np.taskByTaskId.date"/></td>
                <td>
                    <a class="a_5" onclick="window.open('getDetailTask?task_id=${np.taskByTaskId.tid}')">
                        <s:property value="#np.taskByTaskId.reason"/>
                    </a>
                </td>
                <td><s:property value="#np.taskByTaskId.scoreClass"/></td>
                <td><s:property value="#np.taskByTaskId.value"/></td>
                <td>
                    <s:if test="#np.taskByTaskId.status==0">
                        <spring:message code="score_list.status_notice"/>
                    </s:if>
                    <s:if test="#np.taskByTaskId.status==1">
                        <spring:message code="score_list.status_approve"/>
                    </s:if>
                    <s:if test="#np.taskByTaskId.status==2">
                        <spring:message code="score_list.status_archive"/>
                    </s:if>
                    <s:if test="#np.taskByTaskId.status==3">
                        <span class="span_2">
                        <spring:message code="score_list.status_reject"/>
                        </span>
                    </s:if>
                </td>
                <td>
                    <!-- current task's all notice people -->
                    <s:iterator value="#np.taskByTaskId.NoticePeoplesForTaskId" id="np_1">
                        <c:set var="reject" value="0"></c:set>
                        <s:iterator value="#np_1.userByUserId.OperatesForUserId" id="op">
                            <s:if test="#op.opt==3">
                                <s:if test="#np.taskByTaskId.tid==#op.taskByTaskId.tid">
                                    <c:set var="reject" value="1"></c:set>
                                </s:if>
                            </s:if>
                        </s:iterator>
                    
                        <c:if test="${reject==0}">
                        <s:if test="#np_1.status==1">
                            <span class="span_1">
                            <s:property value="#np_1.userByUserId.realName"/>,
                            </span>
                        </s:if>
                        <s:if test="#np_1.status==0">
                            <s:property value="#np_1.userByUserId.realName"/>,
                        </s:if>
                        </c:if>
                        <c:if test="${reject==1}">
                            <span class="span_2">
                            <s:property value="#np_1.userByUserId.realName"/>,
                            </span>
                        </c:if>
                    </s:iterator>
                </td>
                <td>
                    <s:if test="#np.taskByTaskId.status!=3&&#np.status==false">
                    <!--<s:submit action="agreeNotice"> -->
                    <s:a cssClass="a_2" action="agreeNotice">
                        <s:param name="id">
                            <s:property value="#np.nid"/>
                        </s:param>
                        <s:param name="task_id">
                            <s:property value="#np.taskByTaskId.tid"/>
                        </s:param>
                        <spring:message code="score_list.notice_agree"/>
                    </s:a>
                    <!--</s:submit>-->
                    </s:if>
                    <s:if test="#np.taskByTaskId.status!=3&&#np.status==false">
                    
                    <s:a cssClass="a_2" action="reject">
                        <s:param name="id">
                            <s:property value="#np.nid"/>
                        </s:param>
                        <s:param name="task_id">
                            <s:property value="#np.taskByTaskId.tid"/>
                        </s:param>
                        <spring:message code="score_list.status_reject"/>
                    </s:a>
                    </s:if>
                </td>
            </tr>
            </s:if>
        </s:iterator>
    </s:if>
    </table>
    
    <table class="table_1" border="1" width="80%" align="center">  
        <caption><spring:message code="score_list.status_archive"/></caption>
        <tr class="tr_1">
            <th><spring:message code="score_list.notice_date"/></th>
            <th><spring:message code="score_list.notice_reason"/></th>
            <th><spring:message code="score_list.notice_score_class"/></th>
            <th><spring:message code="score_list.notice_value"/></th>
            <th><spring:message code="score_list.notice_status"/></th>
            <th><spring:message code="score_list.notice_peoples"/></th>
            <th><spring:message code="score_list.notice_operator"/></th>
        </tr>
        <s:iterator value="#session.nps" id="npfui">
        
            <!-- if tasks status is 2,task do not show -->
            <s:if test="#npfui.taskByTaskId.status==2">
            <!--<s:property value="#session.user.noticePeoplesForUserId.size()"/>-->
            <tr>
                <td><s:property value="#npfui.taskByTaskId.date"/></td>
                <td>
                    <a class="a_5" onclick="window.open('getDetailTask?task_id=${npfui.taskByTaskId.tid}')">
                        <s:property value="#npfui.taskByTaskId.reason"/>
                    </a>
                </td>
                <td><s:property value="#npfui.taskByTaskId.scoreClass"/></td>
                <td><s:property value="#npfui.taskByTaskId.value"/></td>
                <td>
                <s:if test="#npfui.taskByTaskId.status==2">
                        <spring:message code="score_list.status_archive"/>
                </s:if>
                </td>
                <td>
                    <s:iterator value="#npfui.taskByTaskId.NoticePeoplesForTaskId" id="np_4">
                        <c:set var="rjt_2" value="0"></c:set>
                        <s:iterator value="#np_4.userByUserId.OperatesForUserId" id="op_3">
                            <s:if test="#op_3.opt==3">
                                <s:if test="#np_4.taskByTaskId.tid==#op_3.taskByTaskId.tid">
                                    <c:set var="rjt_2" value="1"></c:set>
                                </s:if>
                            </s:if>
                        </s:iterator>
                    
                        <c:if test="${rjt_2==0}">
                        <s:if test="#np_4.status==1">
                            <span class="span_1">
                            <s:property value="#np_4.userByUserId.realName"/>,
                            </span>
                        </s:if>
                        <s:if test="#np_4.status==0">
                            <s:property value="#np_3.userByUserId.realName"/>,
                        </s:if>
                        </c:if>
                        <c:if test="${rjt_2==1}">
                            <span class="span_2">
                            <s:property value="#np_4.userByUserId.realName"/>,
                            </span>
                        </c:if>
                    </s:iterator>
                    
                </td>
                <td>
                </td>
            </tr>
            </s:if>
        </s:iterator>
     </table>
     
     <div class="div_4">
     <s:form action="#" id="monthf">
     <select class="select_1" id="months" name="months" onchange="submitMonth()">
     <s:if test="#session.months!=null">
     <option value="">--select--</option>
     <s:iterator value="#session.months" id="month"> 
     <option value="<s:property value="#month"/>"><s:property value="#month"/></option>
     </s:iterator>
     </s:if>
     </select>
     </s:form>
     </div>
     </div>
    
    <div class="div_2">
    <table class="table_3" border="1" align="center">
        <caption><spring:message code="score_list.status_reject"/></caption>
        <tr class="tr_3">
            <th><spring:message code="score_list.notice_date"/></th>
            <th><spring:message code="score_list.notice_reason"/></th>
            <th><spring:message code="score_list.notice_score_class"/></th>
            <th><spring:message code="score_list.notice_value"/></th>
            <th><spring:message code="score_list.notice_status"/></th>
            <th><spring:message code="score_list.notice_peoples"/></th>
            <th><spring:message code="score_list.notice_operator"/></th>
        </tr>
        <s:if test="#session.user.OperatesForUserId!=null">
        <s:iterator value="#session.user.OperatesForUserId" id="op">
            <!-- if tasks status is 2,operates do not show. -->
            <s:if test="#op.taskByTaskId.status!=2&&#op.taskByTaskId.status!=4">
            <s:if test="#op.opt==0">
            <s:if test="#op.taskByTaskId.status==3">
            <tr>
                <td><s:property value="#op.taskByTaskId.date"/></td>
                <td>
                    <a class="a_5" onclick="window.open('getDetailTask?task_id=${op.taskByTaskId.tid}')">
                        <s:property value="#op.taskByTaskId.reason"/>
                    </a>
                </td>
                <td><s:property value="#op.taskByTaskId.scoreClass"/></td>
                <td><s:property value="#op.taskByTaskId.value"/></td>
                <td>
                    <s:if test="#op.taskByTaskId.status==3">
                        <spring:message code="score_list.status_reject"/>
                    </s:if>
                </td>
                <td>
                    <s:iterator value="#op.taskByTaskId.NoticePeoplesForTaskId" id="np_2">
                        <c:set var="rjt" value="0"></c:set>
                        <s:iterator value="#np_2.userByUserId.OperatesForUserId" id="op_1">
                            <s:if test="#op_1.opt==3">
                                <s:if test="#np_2.taskByTaskId.tid==#op_1.taskByTaskId.tid">
                                    <c:set var="rjt" value="1"></c:set>
                                </s:if>
                            </s:if>
                        </s:iterator>
                    
                        <c:if test="${rjt==0}">
                        <s:if test="#np_2.status==1">
                            <span class="span_1">
                            <s:property value="#np_2.userByUserId.realName"/>,
                            </span>
                        </s:if>
                        <s:if test="#np_2.status==0">
                            <s:property value="#np_2.userByUserId.realName"/>,
                        </s:if>
                        </c:if>
                        <c:if test="${rjt==1}">
                            <span class="span_2">
                            <s:property value="#np_2.userByUserId.realName"/>,
                            </span>
                        </c:if>
                    </s:iterator>
                </td>
                <td>
                    <s:a cssClass="a_1" action="delete">
                        <s:param name="task_id">
                            <s:property value="#op.taskByTaskId.tid"/>
                        </s:param>
                        <spring:message code="score_list.status_delete"/>
                    </s:a>
                    
                    <a class="a_2" onclick="window.open('previousRelaunchScoreForm?task_id=${op.taskByTaskId.tid}')">
                        <spring:message code="score_list.reject_launch"/>
                    </a>
                    
                </td>
            </tr>
            </s:if>
            </s:if>
            </s:if>
        </s:iterator>
    </s:if>
    </table>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <c:set var="apprPermission" value="0"></c:set>
    <c:forEach items="${approveUsers}" var="appr">    
         <c:if test="${user.name==appr}">
             <c:set var="apprPermission" value="1"></c:set>
         </c:if>
    </c:forEach> 
    <c:if test="${apprPermission==1}">
    <table class="table_4" border="1" align="center">
        <caption><spring:message code="score_list.status_approve"/></caption>
        <tr class="tr_4">
            <th><spring:message code="score_list.notice_date"/></th>
            <th><spring:message code="score_list.notice_reason"/></th>
            <th><spring:message code="score_list.notice_score_class"/></th>
            <th><spring:message code="score_list.notice_value"/></th>
            <th><spring:message code="score_list.notice_status"/></th>
            <th><spring:message code="score_list.notice_peoples"/></th>
            <th><spring:message code="score_list.notice_operator"/></th>
        </tr>
        <s:if test="#session.approveTaskList!=null">
        <s:iterator value="#session.approveTaskList" id="task">
            <!-- if tasks status is 2,task do not show -->
            <s:if test="#task.status!=2&&#task.status!=4">
            <tr>
                <td><s:property value="#task.date"/></td>
                <td>
                    <a class="a_5" onclick="window.open('getDetailTask?task_id=${task.tid}')">
                        <s:property value="#task.reason"/>
                    </a>
                </td>
                <td><s:property value="#task.scoreClass"/></td>
                <td><s:property value="#task.value"/></td>
                <td>
                <s:if test="#task.status==1">
                        <spring:message code="score_list.status_approve"/>
                </s:if>
                </td>
                <td>
                    <s:iterator value="#task.NoticePeoplesForTaskId" id="np_3">
                        <c:set var="rjt_1" value="0"></c:set>
                        <s:iterator value="#np_3.userByUserId.OperatesForUserId" id="op_2">
                            <s:if test="#op_2.opt==3">
                                <s:if test="#np_3.taskByTaskId.tid==#op_2.taskByTaskId.tid">
                                    <c:set var="rjt_1" value="1"></c:set>
                                </s:if>
                            </s:if>
                        </s:iterator>
                    
                        <c:if test="${rjt_1==0}">
                        <s:if test="#np_3.status==1">
                            <span class="span_1">
                            <s:property value="#np_3.userByUserId.realName"/>,
                            </span>
                        </s:if>
                        <s:if test="#np_3.status==0">
                            <s:property value="#np_3.userByUserId.realName"/>,
                        </s:if>
                        </c:if>
                        <c:if test="${rjt_1==1}">
                            <span class="span_2">
                            <s:property value="#np_3.userByUserId.realName"/>,
                            </span>
                        </c:if>
                    </s:iterator>
                    
                </td>
                <td>
                    <s:a cssClass="a_4" action="approve">
                        <s:param name="task_id">
                            <s:property value="#task.tid"/>
                        </s:param>
                        <spring:message code="score_list.status_approve"/>
                    </s:a>
                    
                    <s:a cssClass="a_4" action="reject">
                        <s:param name="task_id">
                            <s:property value="#task.tid"/>
                        </s:param>
                        <spring:message code="score_list.status_reject"/>
                    </s:a>
                </td>
            </tr>
            </s:if>
        </s:iterator>
        </s:if>
        <tr class="tr_5">
            <td class="td_1" colspan="7">
            <s:form id="cform" action="loadTasks" method="post">
            <s:submit value="refresh"></s:submit>
            </s:form>
            </td>
        </tr>
    </table>
    </c:if>
    </div>
    </div>
  </body>
</html>
