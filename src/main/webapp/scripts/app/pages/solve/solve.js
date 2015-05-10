'use strict';

angular.module('solveandshareApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('solve', {
                parent: 'pages',
                url: '/solve',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/pages/solve/solve.html',
                        controller: 'SolveController'
                    }
                },
                resolve: {
                }
            });
    });