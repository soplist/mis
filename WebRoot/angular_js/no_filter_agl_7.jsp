<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'no_filter_agl_7.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>

  </head>
  
  <body>
    <h2>valid demo</h2>
    <form ng-app="myApp" ng-controller="validateCtrl" name="myForm" novalidate>

    <p>username:<br>
    <input type="text" name="user" ng-model="user" required>
    <span style="color:red" ng-show="myForm.user.$dirty && myForm.user.$invalid">
        <span ng-show="myForm.user.$error.required">username is required</span>
    </span>
    </p>

    <p>email:<br>
    <input type="email" name="email" ng-model="email" required>
    <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
        <span ng-show="myForm.email.$error.required">email is required</span>
        <span ng-show="myForm.email.$error.email">invalid email.</span>
    </span>
    </p>

    <p>
    <input type="submit" ng-disabled="myForm.user.$dirty && myForm.user.$invalid || myForm.email.$dirty && myForm.email.$invalid">
    </p>

    </form>

    <script>
        var app = angular.module('myApp', []);
        app.controller('validateCtrl', function($scope) {
            $scope.user = 'WangKang';
            $scope.email = 'li.zhengm@gmail.com';
        });
    </script>
  </body>
</html>
