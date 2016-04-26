<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'no_filter_agl_3.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
  </head>
  
  <body>
    <div ng-app="myApp" ng-controller="costCtrl" ng-init="firstName='WANG';lastName='kang'">
       <p>first name:{{firstName|lowercase}}</p>
       <p>last name:{{lastName|uppercase}}</p>
       
       
       count:<input type="number" ng-model="quantity">
       price:<input type="number" ng-model="price">
       
       <p>total price={{(quantity*price)|currency}}</p>
       
       
    </div>
    <script>
       var app = angular.module('myApp',[]);
       app.controller('costCtrl',function($scope){
          $scope.quantity=1;
          $scope.price=9.99;
       });
    </script>
  </body>
</html>
