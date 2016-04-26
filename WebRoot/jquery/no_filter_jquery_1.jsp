<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <script type="text/javascript" src="jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
       $(document).ready(function(){
           $("p").click(function(){
           $(this).hide();
           });
           $("#id_1").click(function(){
           $("#id_1").hide();
           });
           $(".class_1").click(function(){
           $(".class_1").hide();
           });
           $("h5#id_2").click(function(){
           $("h5#id_2").hide();
           });
           $("h5.class_2").click(function(){
           $("h5.class_2").hide();
           });
           $("[href]").click(function(){
               alert("[href]");
           });
           $("[href='#']").click(function(){
               alert("[href='#']");
           });
           $("[href!='#']").click(function(){
               alert("[href!='#']");
           });
           $("[href$='.html']").click(function(){
               alert("[href$='.html']");
           });
           $("p").css("background-color","blue");
           $("button").click(function(){
               $("#id_1").toggle();
           });
           $("button").click(function(){
               $("#id_2").hide(1000);
           });
           
       });
    </script>
  </head>
  
  <body>
    <p>1.if you click on me,I will disappear.</p>
    <h5 id="id_1">2.if you click on me,I will disappear.</h5>
    <h5 class="class_1">3.if you click on me,I will disappear.</h5>
    <h5 id="id_2">4.if you click on me,I will disappear.</h5>
    <h5 class="class_2">5.if you click on me,I will disappear.</h5>
    <a href="">6.if you click on me,I will disappear.</a><br>
    <a href="#">7.if you click on me,I will disappear.</a><br>
    <a href="*">8.if you click on me,I will disappear.</a><br>
    <a href="no_filter_jquery_html_1.html">9.if you click on me,I will disappear.</a><br>
    <p style="background-color: red">10.if you click on me,I will disappear.</p>
    <button value="toggle">toggle</button>
    <input type="button"></input>
  </body>
</html>
