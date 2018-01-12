app.service('lessonService', function($http, $q) {

    'use strict';

    this.getLessons = function(topicId, courseId) {
        return $http.get('http://localhost:8080/topics/' + topicId + '/courses/' + courseId + '/lessons')
            .then(function(response) {
            return handleResponse(response);
        }, function(response) {
            return $q.reject(response.data);
        });
    };

    var handleResponse = function(response) {
        if(response.status == 200) {
            return response.data;
        } else {
            console.log(">>>>> Invalid response from service");
            return $q.reject(response.data);
        }
    };

});
