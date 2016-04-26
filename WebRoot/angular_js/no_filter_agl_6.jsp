<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
  </head>
  
  <body>
    <div ng-app="myApp" ng-controller="formCtrl">
       <form novalidate>
          First Name:<br>
          <input type="text" ng-model="user.firstName"><br>
          Last Name:<br>
          <input type="text" ng-model="user.lastName"><br><br>
          <button ng-click="reset()">RESET</button>
       </form>
       <p>form={{user}}</p>
       <p>form={{master}}</p>
    </div>
    
    <script>
       var app=angular.module('myApp', []);
       app.controller('formCtrl', function($scope) {
           $scope.master = {firstName:"John", lastName:"Doe"};
           $scope.reset = function() {
               $scope.user = angular.copy($scope.master);
           };
           $scope.reset();
       });
    </script>
  </body>
</html>
