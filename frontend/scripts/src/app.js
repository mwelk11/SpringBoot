/**
 * @ngdoc overview
 * @name courseScheduler
 * @description
 * # courseSchedulerApp
 *
 * Main module of the application.
 */
var app = angular.module('courseSchedulerApp', ['ngRoute']);

app.config(function($routeProvider, $locationProvider) {
    'use strict';

    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'MainCtrl'
        })
        .when('/courses', {
            templateUrl: 'views/courses.html',
            controller: 'CoursesCtrl'
        })
        .when('/lessons', {
            templateUrl: 'views/lessons.html',
            controller: 'LessonsCtrl'
        })
        .otherwise({
            redirectTo: '/'
        });

        $locationProvider.html5Mode(true);
});

