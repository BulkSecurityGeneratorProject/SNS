'use strict';

angular.module('solveandshareApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('myprofile', {
                parent: 'pages',
                url: '/myprofile',
                data: {
                    roles: ['ROLE_USER']
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/pages/myprofile/myprofile.html',
                        controller: 'MyprofileController'
                    }
                },
                resolve: {
                }
            });
    });