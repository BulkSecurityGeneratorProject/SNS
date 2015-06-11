'use strict';
	 
	angular.module('solveandshareApp')
	  .controller('SolveController', function ($scope, $http) {
	 
		$http.get('/getLessons').then(function(data){
	    	$scope.lessons = data.data;
	    });
		
		$scope.trueVal = true;
		$scope.falseVal = false;
		
		$scope.init = false;
		$scope._Index = 0;

		$scope.changeLesson = function(selectedLesson){
			if(!$scope.init){
				$scope.init = true;
			}
			
			$scope.questions = null;
			var url = '/getQuestionsByLessonId?lessonId=' + selectedLesson.id;
			if($scope.unsolvedQuestions){
				url = '/getQuestionsByLessonIdUnsolved?lessonId=' + selectedLesson.id + '&unsolvedQuestions=true';
			}
			$http.get(url).then(function(data){
				$scope.questions = data.data;
				$scope.currentQuestion = $scope.questions[0];
				$http.get('/getCommentsByQuestionId?questionId=' + $scope.currentQuestion.question.id).then(function(data){
					console.log(data.data);
					$scope.currentQuestion.comments = data.data;
				});
			});
			
	    }
		
	     // if a current image is the same as requested image
	    $scope.isActive = function (index) {
	        return $scope._Index === index;
	    };
	 
	    // show prev image
	    $scope.showPrev = function () {
	        $scope._Index = ($scope._Index > 0) ? --$scope._Index : $scope.questions.length - 1;
	        $scope.currentQuestion = {};
	        $scope.currentQuestion = $scope.questions[$scope._Index];
	        if(!$scope.currentQuestion.comments || $scope.currentQuestion.comments.length == 0){
	        	$http.get('/getCommentsByQuestionId?questionId=' + $scope.currentQuestion.question.id).then(function(data){
	        		if(data.data.length > 0){
	        			$scope.currentQuestion.comments = data.data;
	        		}
				});
	        }        
	    };
	 
	    // show next image
	    $scope.showNext = function () {
	        $scope._Index = ($scope._Index < $scope.questions.length - 1) ? ++$scope._Index : 0;
	        $scope.currentQuestion = {};
	        $scope.currentQuestion = $scope.questions[$scope._Index];
	        if(!$scope.currentQuestion.comments || $scope.currentQuestion.comments.length == 0){
	        	$http.get('/getCommentsByQuestionId?questionId=' + $scope.currentQuestion.question.id).then(function(data){
	        		if(data.data.length > 0){
	        			$scope.currentQuestion.comments = data.data;
	        		}
				});
	        }
	    };
	 
	    // show a certain image
	    $scope.showPhoto = function (index) {
	        $scope._Index = index;
	    };
	 
	    $scope.upload = function(){
	    	var comment = {
    			commentColumn : $scope.commentColumn,
    			tQuestionId : $scope.currentQuestion.question.id
	    	};
	    	var fd = new FormData();
	    	fd.append('file', $scope.uploadme);
	    	fd.append('comment', JSON.stringify(comment));
	      
	    	$http.post('/createComment', fd, {
	    		transformRequest : angular.identity,
	    		headers : {'Content-Type': undefined}
	    	}).then(function(data){
	    		if(data.data){
	    			$scope.currentQuestion.comments = null;
	    			$scope.currentQuestion.comments = data.data;
	    		}
	    	});
	    	
	    	$scope.commentColumn = null;
	    	$scope.uploadme = null;
	    	$scope.questionPic = null;
	    	
	    }

  });
    


    