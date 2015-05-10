'use strict';

angular.module('solveandshareApp')
    .controller('AskController',  function MyController($scope, $http) {
    	
            $scope.vari = "ask html";
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
            	var fd = new FormData();
                fd.append('file', $scope.uploadme);
            	$http.post('/pages/question/upload', fd, {
                    transformRequest: angular.identity,
                    headers: {'Content-Type': 'image/jpg'}
            	}).then(function(data){
            		$scope.isUploadedSuccessfully = data.data;
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
    
 
   