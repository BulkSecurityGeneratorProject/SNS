'use strict';

angular.module('solveandshareApp')
    .controller('SolveController',  function MyController($scope) {
    	
            $scope.vari = "solve html";
            $scope.user = {
            		firstName : 'Bünyamin',
            		lastName : 'Coşkuner'
            };
            
            var input = 3;
            $scope.getUsers = function(){
            	console.log("tıkladım");
            	$http.get('/pages/getUsers?userId=' + input).then(function(data){
            		$scope.user = data.data;
            	});
            }
            
            $scope.upload = function(){
            	console.log($scope.questionPic);
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
    