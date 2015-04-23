'use strict';

angular.module('solveandshareApp')
    .controller('SolveQuestionController', function ($scope, $http) {
        $scope.vari = "solve question html";
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
        
    });
