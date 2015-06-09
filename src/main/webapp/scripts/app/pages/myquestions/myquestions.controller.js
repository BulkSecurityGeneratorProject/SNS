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
	    
	    $scope.showDetails = function(question){
	    	question.showDetails = !question.showDetails;
	    	if(!question.comments){
	    		$http.get('/getCommentsByQuestionId?questionId=' + question.id).then(function(data){
					console.log(data.data);
					question.comments = data.data;
				});
	    	}    	
	    }
	    
	    $scope.updateComment = function(comment){
	    	console.log(comment);
	    }
	    
	    
	});
