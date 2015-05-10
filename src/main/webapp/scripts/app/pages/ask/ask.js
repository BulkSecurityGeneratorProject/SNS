'use strict';

angular.module('solveandshareApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('ask', {
                parent: 'pages',
                url: '/ask',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/pages/ask/ask.html',
                        controller: 'AskController'
                    }
                },
                resolve: {
                }
            });
    });

