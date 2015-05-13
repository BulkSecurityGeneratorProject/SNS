'use strict';

angular.module('solveandshareApp')
    .controller('AskController',  function MyController($scope, $http) {
    		$scope.questionOptions = [];
    		$scope.chosenAnswer = 0;
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
            
            $scope.updateAnswerId = function(index){
            	$scope.chosenAnswer = index;
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
            
            $scope.pushOption = function(option){
            	var opt = {
            			id : $scope.questionOptions.length,
            			text : option
            	}
            	$scope.optionId++;
            	
            	$scope.questionOptions.push(opt);
            	$scope.option = null;
            }
            
            $scope.updateOption = function(option, index){
            	$scope.questionOptions[index].text = option;
            }
            
            $scope.removeOption = function(option){
            	$scope.questionOptions.splice(option.id, 1);
            	angular.forEach($scope.questionOptions, function(option, i){
            		option.id = i;
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
          "courseName": "Felsefe"
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
          "courseName": "Geometri"
        }
      ];
  });
    
 
   