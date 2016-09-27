<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- team manage evaluate -->
<html>
  <head>
    <title>My JSP 'evaluate_2.jsp' starting page</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="style/evaluate_2.css" type="text/css"></link>
	<script type="text/javascript">
        
        function submitForm(){
            //var item1=document.getElementById("item1").value;
            var item2=document.getElementById("item2").value;
            var item3=document.getElementById("item3").value;
            var item4=document.getElementById("item4").value;
            var item5=document.getElementById("item5").value;
            //var item6=document.getElementById("item6").value;
            var item7=document.getElementById("item7").value;
            var item8=document.getElementById("item8").value;
            var item9=document.getElementById("item9").value;
            var item10=document.getElementById("item10").value;
            var item11=document.getElementById("item11").value;
            //var item12=document.getElementById("item12").value;
            //var item13=document.getElementById("item13").value;
            if(item2==""||item3==""||item4==""||item5==""||item7==""||item8==""||item9==""||item10==""||item11==""){
                alert("数据不能为空");
                return;
            }
            if(item2<0||item3<0||item4<0||item5<0||item7<0||item8<0||item9<0||item10<0||item11<0
            ||item2>35||item3>15||item4>25||item5>10||item7>12||item8>25||item9>23||item10>65||item11>35){
                alert("分数大于等于0小于等于10");
                return;
            }
            if(isNaN(item2)||isNaN(item3)||isNaN(item4)||isNaN(item5)||isNaN(item7)||isNaN(item8)||isNaN(item9)||isNaN(item10)||isNaN(item11)){
                alert("分数格式错误");
                return;
            }
            /*if(parseInt(item1)!=item1||parseInt(item2)!=item2||parseInt(item3)!=item3||parseInt(item4)!=item4||parseInt(item5)!=item5||parseInt(item6)!=item6||parseInt(item7)!=item7||
            parseInt(item8)!=item8||parseInt(item9)!=item9||parseInt(item10)!=item10){
                alert("请输入整数");
                return;
            }*/
            
            document.getElementById("eform").submit();
        }
    </script>

  </head>
  
  <body>
    <s:form id="eform" action="evaluate3" method="post">
    <table class="table_1" border="1" align="center">
        <caption>
            <s:if test="#session.table.type==1">
                <spring:message code="peme.type_1"/>
            </s:if>
            <s:if test="#session.table.type==2">
                <spring:message code="peme.type_2"/>
            </s:if>
            <s:if test="#session.table.type==3">
                <spring:message code="peme.type_3"/>
            </s:if>
            <s:if test="#session.table.type==4">
                <spring:message code="peme.type_4"/>
            </s:if>
            <s:if test="#session.table.type==5">
                <spring:message code="peme.type_5"/>
            </s:if>
            <s:if test="#session.table.type==6">
                <spring:message code="peme.type_6"/>
            </s:if>
        </caption>
        <tr>
            <td><spring:message code="evaluate.department"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.department.departmentName"/></td>
            <td><spring:message code="evaluate.name"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.realName"/></td>
            <td></td>
        </tr>
        <tr>
            <th><spring:message code="evaluate.class"/></th>
            <th><spring:message code="evaluate.item"/></th>
            <th><spring:message code="evaluate.standard"/></th>
            <th><spring:message code="evaluate.score_standard"/></th>
            <th><spring:message code="evaluate.score"/></th>
        </tr>
        <tr>
            <td rowspan="16"><spring:message code="manager_evaluate.content_1"/></td>
            <td rowspan="3"><spring:message code="manager_evaluate.content_1_2_1"/></td>
            <td><spring:message code="manager_evaluate.content_1_3_1"/></td>
            <td>15-13</td>
            <td rowspan="3"><s:property value="#session.table.pmTaskByTid.userByUid.managerEvaluateSetting.item1"/></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_2"/></td>
            <td>12-9</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_3"/></td>
            <td>8-0</td>
        </tr>
        <tr>
            <td rowspan="4"><spring:message code="manager_evaluate.content_1_2_2"/></td>
            <td><spring:message code="manager_evaluate.content_1_3_4"/></td>
            <td>35-30</td>
            <td rowspan="4"><input class="input_1" type="text" name="item2" id="item2"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_5"/></td>
            <td>29-21</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_6"/></td>
            <td>20-14</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_7"/></td>
            <td>13-0</td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_1_2_3"/></td>
            <td><spring:message code="manager_evaluate.content_1_3_8"/></td>
            <td>15-13</td>
            <td rowspan="3"><input class="input_1" type="text" name="item3" id="item3"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_9"/></td>
            <td>12-9</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_10"/></td>
            <td>8-0</td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_1_2_4"/></td>
            <td><spring:message code="manager_evaluate.content_1_3_11"/></td>
            <td>25-20</td>
            <td rowspan="3"><input class="input_1" type="text" name="item4" id="item4"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_12"/></td>
            <td>19-12</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_13"/></td>
            <td>11-0</td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_1_2_5"/></td>
            <td><spring:message code="manager_evaluate.content_1_3_14"/></td>
            <td>10-8</td>
            <td rowspan="3"><input class="input_1" type="text" name="item5" id="item5"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_15"/></td>
            <td>7-5</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_1_3_16"/></td>
            <td>5-0</td>
        </tr>
        <tr>
            <td colspan="3"><spring:message code="manager_evaluate.content_2"/></td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td rowspan="14"><spring:message code="manager_evaluate.content_3"/></td>
            <td rowspan="4"><spring:message code="manager_evaluate.content_3_2_1"/></td>
            <td><spring:message code="manager_evaluate.content_3_3_1"/></td>
            <td>40-35</td>
            <td rowspan="4"><s:property value="#session.table.pmTaskByTid.userByUid.managerEvaluateSetting.item6"/></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_2"/></td>
            <td>34-28</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_3"/></td>
            <td>27-20</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_4"/></td>
            <td>19-0</td>
        </tr>
        <tr>
            <td rowspan="4"><spring:message code="manager_evaluate.content_3_2_2"/></td>
            <td><spring:message code="manager_evaluate.content_3_3_5"/></td>
            <td>12-10</td>
            <td rowspan="4"><input class="input_1" type="text" name="item7" id="item7"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_6"/></td>
            <td>9-7</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_7"/></td>
            <td>6-3</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_8"/></td>
            <td>3-0</td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_3_2_3"/></td>
            <td><spring:message code="manager_evaluate.content_3_3_9"/></td>
            <td>25-21</td>
            <td rowspan="3"><input class="input_1" type="text" name="item8" id="item8"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_10"/></td>
            <td>20-15</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_11"/></td>
            <td>0</td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_3_2_4"/></td>
            <td><spring:message code="manager_evaluate.content_3_3_12"/></td>
            <td>23-20</td>
            <td rowspan="3"><input class="input_1" type="text" name="item9" id="item9"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_13"/></td>
            <td>20-15</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_3_3_14"/></td>
            <td>0</td>
        </tr>
        <tr>
            <td colspan="3"><spring:message code="manager_evaluate.content_4"/></td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td rowspan="7"><spring:message code="manager_evaluate.content_5"/></td>
            <td rowspan="4"><spring:message code="manager_evaluate.content_5_2_1"/></td>
            <td><spring:message code="manager_evaluate.content_5_3_1"/></td>
            <td>65-58</td>
            <td rowspan="4"><input class="input_1" type="text" name="item10" id="item10"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_5_3_2"/></td>
            <td>57-35</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_5_3_3"/></td>
            <td>34-18</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_5_3_4"/></td>
            <td>0</td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_5_2_2"/></td>
            <td><spring:message code="manager_evaluate.content_5_3_5"/></td>
            <td>35-28</td>
            <td rowspan="3"><input class="input_1" type="text" name="item11" id="item11"></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_5_3_6"/></td>
            <td>27-18</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_5_3_7"/></td>
            <td>0</td>
        </tr>
        <tr>
            <td colspan="3"><spring:message code="manager_evaluate.content_6"/></td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td rowspan="4"><spring:message code="manager_evaluate.content_7"/></td>
            <td><spring:message code="manager_evaluate.content_7_2_1"/></td>
            <td colspan="2"><spring:message code="manager_evaluate.content_7_3_1"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.managerEvaluateSetting.item12"/></td>
        </tr>
        <tr>
            <td rowspan="3"><spring:message code="manager_evaluate.content_7_2_2"/></td>
            <td><spring:message code="manager_evaluate.content_7_3_2"/></td>
            <td>70-62</td>
            <td rowspan="3"><s:property value="#session.table.pmTaskByTid.userByUid.managerEvaluateSetting.item13"/></td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_7_3_3"/></td>
            <td>61-50</td>
        </tr>
        <tr>
            <td><spring:message code="manager_evaluate.content_7_3_4"/></td>
            <td>0</td>
        </tr>
        <tr>
            <td colspan="3"><spring:message code="manager_evaluate.content_8"/></td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="5"><spring:message code="manager_evaluate.content_9"/></td>
        </tr>
        </table>
        <br/><br/>
        <input type="button" value="提交" onclick="submitForm()"/>
        </s:form>
  </body>
</html>
