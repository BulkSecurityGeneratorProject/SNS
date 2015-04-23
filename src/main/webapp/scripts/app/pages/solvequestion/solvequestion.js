'use strict';

angular.module('solveandshareApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('solvequestion', {
                parent: 'pages',
                url: '/solvequestion',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/pages/solvequestion/solvequestion.html',
                        controller: 'SolveQuestionController'
                    }
                },
                resolve: {
                }
            });
    });
