app.service('courseService', function($http, $q) {

    'use strict';
    var currentCourseId;

    this.getCourses = function(id) {
        return $http.get('http://localhost:8080/topics/' + id + '/courses')
            .then(function(response) {
            return handleResponse(response);
        }, function(response) {
            return $q.reject(response.data);
        });
    };

    this.setCourseId = function(courseId) {
        currentCourseId = courseId;
    };

    this.getCourseId = function() {
        return currentCourseId;
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
