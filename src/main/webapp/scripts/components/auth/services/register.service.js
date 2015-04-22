'use strict';

angular.module('solveandshareApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


