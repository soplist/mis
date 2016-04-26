<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'no_filter_jquery_2.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery-2.2.3.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#id_2").click(function(){
               $("#id_1").fadeToggle("slow");
            });
            $("#id_3").click(function(){
               $("#id_1").fadeTo("slow",0.1);
            });
            $("#id_5").click(function(){
               $("#id_4").slideUp(5000);
            });
            $("#id_6").click(function(){
               $("#id_4").slideDown();
            });
            $("#id_9").click(function(){
               $("#id_4").stop();
            });
            $("#id_8").click(function(){
               $("#id_7").animate({
                   left:'250px',
                   opacity:'0.5',
                   height:'150px',
                   width:'150px'
                });
            });
            $("#id_11").click(function(){
               $("#id_10").hide(1000,function(){
                   alert("p id_11 is now hidden");
               });
            });
            $("#id_13").click(function(){
               $("#id_12").css("color","red").slideUp(2000).slideDown(2000);
            });
            $("#id_14").click(function(){
               $("#id_15").load("no_filter_demo_test.txt",function(responseTxt,statusTxt,xhr){
                   if(statusTxt=="success")
                       alert("load success!");
                   if(statusTxt=="error")
                       alert("Error: "+xhr.status+": "+xhr.statusText);
               });
            });
            $("#id_17").click(function(){
               alert("Text:"+$("#id_16").text());
               alert("HTML:"+$("#id_16").html());
            });
            $("#id_18").click(function(){
               $("#id_19").val("wang kang");
            });
        });
    </script>
  </head>
  
  <body>
    <p id="id_1">1.Charlotte Hornets guard Jeremy Lin was on fire again in Game 5.</p>
    <input id="id_2" type="button" value="click_1"></input>
    <input id="id_3" type="button" value="click_2"></input>
    <p id="id_4">2.Charlotte Hornets guard Jeremy Lin was on fire again in Game 5.</p>
    <input id="id_5" type="button" value="click_3"></input>
    <input id="id_6" type="button" value="click_4"></input>
    <input id="id_9" type="button" value="click_6"></input>
    <p id="id_7" style="position: relative;background: red">3.Charlotte Hornets guard Jeremy Lin was on fire again in Game 5.</p>
    <input id="id_8" type="button" value="click_5"></input>
    <p id="id_10">4.Charlotte Hornets guard Jeremy Lin was on fire again in Game 5.</p>
    <input id="id_11" type="button" value="click_7"></input>
    <p id="id_12" style="position: relative">5.Charlotte Hornets guard Jeremy Lin was on fire again in Game 5.</p>
    <input id="id_13" type="button" value="click_8"></input><br>
    <p id="id_15">2.Charlotte Hornets guard Jeremy Lin was on fire again in Game 5.</p>
    <input id="id_14" type="button" value="click_9"></input><br>
    <input id="id_19" type="text"></input>
    <div id="id_16"><p></p></div>
    <input id="id_17" type="button" value="click_10"></input>
    <input id="id_18" type="button" value="click_11"></input>
  </body>
</html>
