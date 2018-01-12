app.controller('MainCtrl', function($scope, topicService, $location) {

    'use strict';

    $scope.sortType = 'Topic'; // default sort
    $scope.sortReverse = true;

    $scope.getTopics = function() {
        topicService.getTopics()
            .then(function(data) {
                $scope.topics = data;
            }, function(error) {
                console.log('ERROR in getTopics(): ', error);
            });
    };

    $scope.loadView = function(view) {
        $location.path(view);
    };

    $scope.setTopicId = function(topicId) {
        topicService.setTopicId(topicId);
    };

});
