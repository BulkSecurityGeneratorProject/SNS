'use strict';

angular.module('solveandshareApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('myquestions', {
                parent: 'pages',
                url: '/myquestions',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/pages/myquestions/myquestions.html',
                        controller: 'MyQuestionsController'
                    }
                },
                resolve: {
                }
            });
    });