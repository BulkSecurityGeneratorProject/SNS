'use strict';
	 
	angular.module('solveandshareApp')
	  .controller('SolveController', function ($scope, $http) {
	 
		/*$http.get('/assets/data/questions.json').then(function(data){
			$scope.questions = data.data;
			$scope.currentQuestion = $scope.questions[0];
		});
		
		$http.get('/assets/data/comments.json').then(function(data){
			$scope.comments = data.data;
		});*/
		
		$scope.changeLesson = function(selectedLesson){
			$scope.questions = null;
			$http.get('/getQuestionsByLessonId?lessonId=' + selectedLesson.id).then(function(data){
				$scope.questions = data.data;
				$scope.currentQuestion = $scope.questions[0];
				$http.get('/getCommentsByQuestionId?questionId=' + $scope.questions[0].id).then(function(data){
					$scope.currentQuestion.comments = data.data;
				});
			});
			
	    }
	 
	    // initial image index
	    $scope._Index = 0;
	 
	    // if a current image is the same as requested image
	    $scope.isActive = function (index) {
	        return $scope._Index === index;
	    };
	 
	    // show prev image
	    $scope.showPrev = function () {
	        $scope._Index = ($scope._Index > 0) ? --$scope._Index : $scope.questions.length - 1;
	        $scope.currentQuestion = $scope.questions[$scope._Index];
	        if(!$scope.currentQuestion.comments){
	        	$http.get('/getCommentsByQuestionId?questionId=' + $scope.questions[0].id).then(function(data){
					$scope.currentQuestion.comments = data.data;
				});
	        }        
	    };
	 
	    // show next image
	    $scope.showNext = function () {
	        $scope._Index = ($scope._Index < $scope.questions.length - 1) ? ++$scope._Index : 0;
	        $scope.currentQuestion = $scope.questions[$scope._Index];
	        if(!$scope.currentQuestion.comments){
	        	$http.get('/getCommentsByQuestionId?questionId=' + $scope.questions[0].id).then(function(data){
					$scope.currentQuestion.comments = data.data;
				});
	        }
	    };
	 
	    // show a certain image
	    $scope.showPhoto = function (index) {
	        $scope._Index = index;
	    };
        
	    $http.get('/getLessons').then(function(data){
	    	$scope.lessons = data.data;
	    });
	    
	    $scope.upload = function(){
	    	var comment = {
	    			commentColumn : $scope.commentColumn.text,
	    			tQuestionId : $scope.currentQuestion.id
	    	};
	    	var fd = new FormData();
	    	fd.append('file', $scope.uploadme);
	    	fd.append('comment', JSON.stringify(comment));
	      
	    	$http.post('/createComment', fd, {
	    		transformRequest : angular.identity,
	    		headers : {'Content-Type' : undefined}
	    	}).then(function(data){
	    		alert(data.data.message);
	    	});
	    }

  });
    


    