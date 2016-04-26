<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'no_filter_agl_2.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
    
  </head>
  
  <body>
    <div ng-app="myApp" ng-controller="personCtrl" ng-init="names=[{name:'Jani',country:'Norway'},{name:'Hege',country:'Sweden'},{name:'Kai',country:'Denmark'}]">
       <p>loop object</p>
       <ul>
          <li ng-repeat="x in names">{{x.name+','+x.country}}</li>
       </ul>
       first name:<input type="text" ng-model="firstName"><br>
       last name:<input type="text" ng-model="lastName"><br>
       full name:{{fullName()}}
       <p>loop object</p>
       <ul>
          <li ng-repeat="x in names|orderBy:'country'">{{x.name+','+x.country}}</li>
       </ul>
       
       <p>input filter</p>
       <p><input type="text" ng-model="test"></p>
       <ul>
          <li ng-repeat="x in names|filter:test|orderBy:'country'">{{x.name+','+x.country}}</li>
       </ul>
    </div>
    <script>
       var app=angular.module('myApp',[]);
       app.controller('personCtrl',function($scope){
          $scope.firstName="John";
          $scope.lastName="Doe";
          $scope.fullName=function(){
             return $scope.firstName+" "+$scope.lastName;
          }
       });
    </script>
  </body>
</html>
