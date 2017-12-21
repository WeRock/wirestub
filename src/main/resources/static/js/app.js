// create the module and name it scotchApp
var wireApp = angular.module('wireApp', ['ngRoute']);

// configure our routes
wireApp.config(function ($routeProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl: 'pages/home.html',
            controller: 'mainController'
        })

        // route for the about page
        .when('/list', {
            templateUrl: 'pages/list.html',
            controller: 'listController'
        });
});

// create the controller and inject Angular's $scope
wireApp.controller('mainController', function ($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

wireApp.controller('listController', function ($scope) {
    $scope.message = 'Look! I am a list page.';
});
