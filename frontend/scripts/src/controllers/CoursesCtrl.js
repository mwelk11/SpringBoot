app.controller('CoursesCtrl', function($scope, topicService, courseService, $location) {

    'use strict';

    $scope.formData = {};
    $scope.sortType = 'Course'; // default sort
    $scope.sortReverse = true;
    $scope.topicList = [];

    topicService.getTopics()
        .then(function(data) {
            $scope.topicList = data;
            $scope.selectedTopic = topicService.getTopicId();
            $scope.getCourses();
        }, function(error) {
            console.log('ERROR in getTopics(): ', error);
        });

    $scope.getCourses = function() {
        courseService.getCourses($scope.selectedTopic)
            .then(function(data) {
                $scope.courses = data;
            }, function(error) {
                console.log('ERROR in getCourses(): ', error);
            });
    };

    $scope.setCourseId = function(courseId) {
        courseService.setCourseId(courseId);
    };

    $scope.loadView = function(view) {
        $location.path(view);
    };

});
