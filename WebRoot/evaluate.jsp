<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- common evaluate -->
<html>
  <head>
    <title>My JSP 'evaluate.jsp' starting page</title>
    <link rel="stylesheet" href="style/evaluate.css" type="text/css"></link>
    <script type="text/javascript">
        
        function submitForm(){
            var item1=document.getElementById("item1").value;
            var item2=document.getElementById("item2").value;
            var item3=document.getElementById("item3").value;
            var item4=document.getElementById("item4").value;
            var item5=document.getElementById("item5").value;
            var item6=document.getElementById("item6").value;
            var item7=document.getElementById("item7").value;
            var item8=document.getElementById("item8").value;
            var item9=document.getElementById("item9").value;
            var item10=document.getElementById("item10").value;
            if(item1==""||item2==""||item3==""||item4==""||item5==""||item6==""||item7==""||item8==""||item9==""||item10==""){
                alert("数据不能为空");
                return;
            }
            if(item1<0||item2<0||item3<0||item4<0||item5<0||item6<0||item7<0||item8<0||item9<0||item10<0
            ||item1>10||item2>10||item3>10||item4>10||item5>10||item6>10||item7>10||item8>10||item9>10||item10>10){
                alert("分数大于等于0小于等于10");
                return;
            }
            if(isNaN(item1)||isNaN(item2)||isNaN(item3)||isNaN(item4)||isNaN(item5)||isNaN(item6)||isNaN(item7)||isNaN(item8)||isNaN(item9)||isNaN(item10)){
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
    <s:form id="eform" action="evaluate1" method="post">
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
        </caption>
        <tr>
            <td><spring:message code="evaluate.name"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.realName"/></td>
            <td><spring:message code="evaluate.department"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.department.departmentName"/></td>
            <td><spring:message code="evaluate.position"/></td>
            <td><s:property value="#session.table.pmTaskByTid.userByUid.position"/></td>
            <td><spring:message code="evaluate.joined"/></td>
            <td  colspan="2"><s:property value="%{getText('{0,date,yyyy-MM-dd }',{#session.table.pmTaskByTid.userByUid.joined})}"/></td>
        </tr>
        <tr>
            <th><spring:message code="evaluate.item"/></th>
            <th  colspan="5"><spring:message code="evaluate.content"/></th>
            <th><spring:message code="evaluate.class"/></th>
            <th><spring:message code="evaluate.score_class"/></th>
            <th><spring:message code="evaluate.score"/></th>
        </tr>
        <tr>
            <td  rowspan="4" class="td_2" ><spring:message code="evaluate.item_1"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_1_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td class="td_1"  rowspan="4"><input class="input_1" type="text" name="item1" id="item1"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_1_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_1_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_1_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_2"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_2_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item2" id="item2"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_2_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_2_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_2_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_3"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_3_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item3" id="item3"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_3_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_3_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_3_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_4"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_4_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text"  name="item4" id="item4"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_4_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_4_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_4_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_5"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_5_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text"  name="item5" id="item5"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_5_2"/>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_5_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_5_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_6"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_6_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item6" id="item6"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_6_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_6_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_6_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_7"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_7_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item7" id="item7"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_7_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_7_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_7_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_8"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_8_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item8" id="item8"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_8_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_8_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_8_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_9"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_9_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item9" id="item9"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_9_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_9_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_9_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
        <tr>
            <td  rowspan="4" class="td_2"><spring:message code="evaluate.item_10"/></td>
            <td  colspan="5"><spring:message code="evaluate.content_10_1"/></td>
            <td><spring:message code="evaluate.class_1"/></td>
            <td><spring:message code="evaluate.score_class_1"/></td>
            <td  rowspan="4"><input class="input_1" type="text" name="item10" id="item10"></input></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_10_2"/></td>
            <td><spring:message code="evaluate.class_2"/></td>
            <td><spring:message code="evaluate.score_class_2"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_10_3"/></td>
            <td><spring:message code="evaluate.class_3"/></td>
            <td><spring:message code="evaluate.score_class_3"/></td>
        </tr>
        <tr>
            <td  colspan="5"><spring:message code="evaluate.content_10_4"/></td>
            <td><spring:message code="evaluate.class_4"/></td>
            <td><spring:message code="evaluate.score_class_4"/></td>
        </tr>
        
    </table>
    <br/><br/>
    <input type="button" value="提交" onclick="submitForm()"/>
    <br>
    <span class="span_1">
         <spring:message code="evaluate.attention"/>
     </span>
    </s:form>
  </body>
</html>
