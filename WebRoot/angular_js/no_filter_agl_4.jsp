<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'no_filter_agl_4.jsp' starting page</title>
    <script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <div ng-app="myApp" ng-controller="customersCtrl" ng-init="mySwitch=true">
       
       <ul>
           <li ng-repeat="x in names">{{x.Name+','+x.Country}}</li>
       </ul>
       
       <table>
           <tr ng-repeat="x in names|orderBy:'Country'">
               <td>{{ $index + 1 }}</td>
               <td>{{x.Name}}</td>
               <td>{{x.Country|uppercase}}</td>
           </tr>
       </table><br>
       
       <table>
           <tr ng-repeat="x in names">
               <td ng-if="$odd" style="background-color:#f1f1f1">
               {{ x.Name }}</td>
               <td ng-if="$even">
               {{ x.Name }}</td>
               <td ng-if="$odd" style="background-color:#f1f1f1">
               {{ x.Country }}</td>
               <td ng-if="$even">
               {{ x.Country }}</td>
           </tr>
       </table>
       
       <p>
           <button ng-disabled="mySwitch">click me.</button>
           <input type="checkbox" ng-model="mySwitch">
           {{mySwitch}}
       </p><br>
       
       <p ng-show="true">visible</p>
       <p ng-show="false">invisible</p><br>
       <p ng-hide="true">invisible</p>
       <p ng-hide="false">visible</p><br>
       
       
       <p></p>
    </div>
    <script>
       var app = angular.module('myApp',[]);
       app.controller('customersCtrl', function($scope, $http) {
           $http.get("http://localhost:8080/mis/angular_js/no_filter_customers_json.php")
           .success(function(response) {$scope.names = response.records;});
       });
    </script>
  </body>
</html>
