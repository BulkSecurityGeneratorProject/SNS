'use strict';

angular.module('solveandshareApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
