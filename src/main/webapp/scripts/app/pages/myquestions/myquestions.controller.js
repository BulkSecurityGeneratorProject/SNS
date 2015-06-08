'use strict';
	 
	angular.module('solveandshareApp')
	  .controller('MyQuestionsController', function ($scope, $http) {
	 
		$http.get('/getLessons').then(function(data){
	    	$scope.lessons = data.data;
	    });
		
	    $scope.init = false;
	    
	    $scope.changeLesson = function(selectedLesson){
			if(!$scope.init){
				$scope.init = true;
			}
			
			$scope.questions = null;
			$http.get('/getQuestionsByUserId?lessonId=' + selectedLesson.id).then(function(data){
				$scope.questions = data.data;
			});
			
	    }
	});
