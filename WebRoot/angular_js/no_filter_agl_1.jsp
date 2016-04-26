<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<html>
  <head>
  
    <title>My JSP 'no_filter_agl_1.jsp' starting page</title>
    <!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
    <div ng-app="myApp" ng-init="firstName='John';quantity=1;cost=5;person={firstName:'John',lastName:'Doe'};points=[1,15,19,2,40];price=5;names=['Jani','Hege','Kai']" ng-controller="myCtrl">
        <p>name:<input type="text" ng-model="name"></p>
        <p>Hello {{name}}</p>
        <p>my first expression:{{5+5}}</p>
        <p>name is <span ng-bind="firstName"></p>
        first name:<input type="text" ng-model="firstName"><br>
        last name:<input type="text" ng-model="lastName"><br>
        name:{{firstName +" "+lastName}}
        <p>total price:{{quantity*cost}}</p>
        <p>total price: <span ng-bind="{{quantity*cost}}"></span></p>
        <p>name: <span ng-bind="firstName+' '+lastName"></span></p>
        <p>last name:{{person.lastName}}</p>
        <p>last name:<span ng-bind="person.lastName"></span></p>
        <p>thrid value {{points[2]}}</p>
        <p>thrid value <span ng-bind="points[2]"></span></p>
        
        quantity:<input type="number" ng-model="quantity">
        price:<input type="number" ng-model="price">
        <p><b>total price:</b>{{quantity*price}}</p>
        <ul>
           <li data-ng-repeat="x in names">{{x}}</li>
        </ul>
    </div>
    <script>
     var app = angular.module('myApp',[]);
     app.controller('myCtrl',function($scope){
         $scope.firstName="John";
         $scope.lastName="Doe";
     });
    </script>
  </body>
</html>
