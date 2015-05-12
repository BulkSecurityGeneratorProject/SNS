'use strict';

angular.module('solveandshareApp')
        .controller('SolveController',  function MyController($scope, $http) {           
        $scope.getUsers = function(){
        	
        $http.get('/assets/data/countries.json').then(function(data){
        $scope.user = data.data;
        });
        }    
        
    	$scope.courses = [
        {
          "courseId": 0,
          "courseName": "Matematik"
        },
        {
          "courseId": 1,
          "courseName": "Fizik"
        },
        {
          "courseId": 2,
          "courseName": "Geometri"
        },
        {
          "courseId": 3,
          "courseName": "Kimya"
        },
        {
          "courseId": 4,
          "courseName": "Türkçe"
        },
        {
          "courseId": 5,
          "courseName": "Tarih"
        },
        {
          "courseId": 6,
          "courseName": "Biyoloji"
        },
        {
          "courseId": 7,
          "courseName": "Coğrafya"
        },
        {
          "courseId": 8,
          "courseName": "Felsefe"
        }
      ];
  });
    