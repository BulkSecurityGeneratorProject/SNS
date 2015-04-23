'use strict';

angular.module('solveandshareApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('pages', {
                abstract: true,
                parent: 'site'
            });
    });
