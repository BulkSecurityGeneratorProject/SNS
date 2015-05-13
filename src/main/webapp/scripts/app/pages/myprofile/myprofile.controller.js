'use strict';
	 
	angular.module('solveandshareApp')
	  .controller('MyprofileController', function ($scope, $http) {
	 
		$http.get('/assets/data/questions.json').then(function(data){
			$scope.questions = data.data;
			$scope.currentQuestion = $scope.questions[0];
		});
	 
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
	    };
	 
	    // show next image
	    $scope.showNext = function () {
	        $scope._Index = ($scope._Index < $scope.questions.length - 1) ? ++$scope._Index : 0;
	        $scope.currentQuestion = $scope.questions[$scope._Index];
	    };
	 
	    // show a certain image
	    $scope.showPhoto = function (index) {
	        $scope._Index = index;
	    };
	});
// See more at: http://www.script-tutorials.com/photo-gallery-with-angularjs-and-css3/#sthash.z7byjLto.dpuf