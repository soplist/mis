<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
            if(isNaN(item1)||isNaN(item2)||isNaN(item3)||isNaN(item4)||isNaN(item5)||isNaN(item6)||isNaN(item7)||isNaN(item8)||isNaN(item9)||isNaN(item10)){
                alert("分数格式错误");
                return;
            }
            
            document.getElementById("eform").submit();
        }
    </script>
  </head>
  
  <body>
    <s:form id="eform" action="evaluate" method="post">
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
            <th>1</th>
            <th>2</th>
            <th>3</th>
            <th>4</th>
            <th>5</th>
        </tr>
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td class="td_1"  rowspan="4"><input class="input_1" type="text" name="item1" id="item1"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item2" id="item2"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item3" id="item3"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text"  name="item4" id="item4"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text"  name="item5" id="item5"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item6" id="item6"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item7" id="item7"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item8" id="item8"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item9" id="item9"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
        <tr>
            <td  rowspan="4">1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td  rowspan="4"><input class="input_1" type="text" name="item10" id="item10"></input></td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
        </tr>
        
    </table>
    <br/><br/>
    <input type="button" value="submit" onclick="submitForm()"/>
    </s:form>
  </body>
</html>
