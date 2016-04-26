<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'no_filter_agl_5.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>

  </head>
  
  <body>
    <div ng-app="myApp" ng-controller="myCtrl">
        <button ng-click="count = count+1">click!</button>
        <p>{{count}}</p>
    </div>
    <script>
        var app = angular.module('myApp',[]);
        app.controller('myCtrl',function($scope){
            $scope.count=0;
        });
    </script>
  </body>
</html>
