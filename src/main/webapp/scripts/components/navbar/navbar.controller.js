'use strict';

angular.module('solveandshareApp')
    .controller('NavbarController', function ($scope, $location, $state, Auth, Principal) {
        $scope.isAuthenticated = Principal.isAuthenticated;
        $scope.isInRole = Principal.isInRole;
        $scope.$state = $state;

        $scope.logout = function () {
            Auth.logout();
            $state.go('home');
        };
        
        $scope.links = [{
        		url : 'http://www.facebook.com',
        		name : 'Facebook'
        	},{ 
        		url :'http://www.google.com',
        		name : 'Google'
        	}];
    });
