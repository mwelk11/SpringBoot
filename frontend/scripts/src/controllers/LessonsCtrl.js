app.controller('LessonsCtrl', function($scope, topicService, courseService, lessonService) {

    'use strict';

    $scope.formData = {};
    $scope.sortType = 'Lesson'; // default sort
    $scope.sortReverse = true;
    $scope.courseList = [];

    courseService.getCourses(topicService.getTopicId())
        .then(function(data) {
            $scope.courseList = data;
            $scope.selectedCourse = courseService.getCourseId();
            $scope.selectedTopic = topicService.getTopicId();
            $scope.getLessons();
        }, function(error) {
            console.log('ERROR in getCourses(): ', error);
        });

    $scope.getLessons = function() {
        lessonService.getLessons($scope.selectedTopic, $scope.selectedCourse)
            .then(function(data) {
                console.log("setting lessons");
                $scope.lessons = data;
            }, function(error) {
                console.log('ERROR in getLessons(): ', error);
            });
    };

});
