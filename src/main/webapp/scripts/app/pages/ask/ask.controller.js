'use strict';

angular.module('solveandshareApp')
    .controller('AskController',  function MyController($scope, $http) {
    		$scope.questionOptions = [];
    		$scope.chosenAnswer = 0; 
           
            $http.get('/getLessons').then(function(data){
            	$scope.lessons = data.data;
            });
            
            
            $scope.updateAnswerId = function(index){
            	$scope.chosenAnswer = index;
            }
            
            
            $scope.upload = function(){
            	var question = {
        			questionDef : $scope.questionDef,
        			questionValue : 0,
        			tLessonId : $scope.selectedLesson.id
            	};
            	var fd = new FormData();
                fd.append('file', $scope.uploadme);
                fd.append('question', JSON.stringify(question));
            	      
            	$http.post('/createQuestion', fd, {
        			transformRequest : angular.identity,
        			headers : {'Content-Type' : undefined}
            	}).then(function(data){
            		alert(data.data.message);
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
            
            
            
            
            
            
        
    	/*$scope.courses = [
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
      ];*/
  });
    
 
   