'use strict';
	 
	angular.module('solveandshareApp')
	  .controller('MyQuestionsController', function ($scope, $http) {
	 
		$http.get('/getLessons').then(function(data){
	    	$scope.lessons = data.data;
	    });
		
		$http.get('/getQuestionsByUserIdGroupByLesson').then(function(data){
			var data = data.data;
			
			var ctx = document.getElementById("donutChart").getContext("2d");

			var myPieChart = new Chart(ctx).Pie(data);

	    });

	    $http.get('/getQuestionsByUserIdForYear').then(function(data){
	    	var data = {
	    	    labels:data.data.labels,
	    	    datasets: [
	    	        {
	    	            label: "1 yıl içinde sorulan soru sayısı",
	    	            fillColor: "rgba(151,187,205,0.2)",
	    	            strokeColor: "rgba(151,187,205,1)",
	    	            pointColor: "rgba(151,187,205,1)",
	    	            pointStrokeColor: "#fff",
	    	            pointHighlightFill: "#fff",
	    	            pointHighlightStroke: "rgba(151,187,205,1)",
	    	            data: data.data.data
	    	        }
	    	    ]
	    	};
			
			
			var ctx = document.getElementById("lineChart").getContext("2d");

			var myLineChart = new Chart(ctx).Line(data);;

	    });
//		var data = [
//		    {
//		        value: 300,
//		        color:"#F7464A",
//		        highlight: "#FF5A5E",
//		        label: "Red"
//		    },
//		    {
//		        value: 50,
//		        color: "#46BFBD",
//		        highlight: "#5AD3D1",
//		        label: "Green"
//		    },
//		    {
//		        value: 100,
//		        color: "#FDB45C",
//		        highlight: "#FFC870",
//		        label: "Yellow"
//		    }
//		];

		
		


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
	    	var commentValue = comment.comment.value ? 1 : 0;
	    	$http.get('/updateCommentById?commentValue=' + commentValue + '&id=' + comment.comment.id + '&questionId=' + comment.comment.tQuestionId).then(function(data){
				console.log(data.data);
			});
	    }
	    
	    
	});
