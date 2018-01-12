app.service('topicService', function($http, $q) {

    'use strict';
    var currentTopicId;

    this.getTopics = function() {
        return $http.get('http://localhost:8080/topics')
            .then(function(response) {
            return handleResponse(response);
        }, function(response) {
            return $q.reject(response.data);
        });
    };

    this.setTopicId = function(topicId) {
        currentTopicId = topicId;
    };

    this.getTopicId = function() {
        return currentTopicId;
    };

    var handleResponse = function(response) {
        if(response.status == 200) {
            return response.data;
        } else {
            console.log(">>>>> Invalid response from service");
            return $q.reject(response.data);
        }
    };

/*    this.insertGame = function(formData) {
        console.log('formData = ', formData);
        return $http.post('http://localhost:8081/insertGame', formData)
        .then(function(response) {
            return handleResponse(response);
        }, function(response) {
            return $q.reject(response.data);
        });
    };

    this.deleteGame = function(formData) {
        return $http({
            method : 'POST',
            url : 'http://localhost:8081/deleteGame',
            data : game,
            headers : {'Content-Type': 'application/json'}
        })
        .then(function(response) {
            return handleResponse(response);
        }, function(response) {
            return $q.reject(response.data);
        });
    };

    this.makeJavaCall = function() {
        return $http.get('http://localhost:8080/greeting')
        .then(function(response) {
            return handleResponse(response);
        }, function(response) {
            return $q.reject(response.data);
        });
    };*/

});
