describe('MainCtrl', function() {

    var scope;
    var getTopicsResponse = [{
        "id": 1,
        "name": "Math",
        "courses": 
        [{
            "id": 1,
            "name": "Algebra",
            "description": "The study of mathematical symbols and manipulation",
            "lessons": 
            [{
                "id": 1,
                "name": "Introduction to equations",
                "description": "Mathematical equations using symbols"
            }]
        }]
    }];

    beforeEach(module('courseSchedulerApp'));

    beforeEach(inject(function($rootScope, $controller, topicService, $q) {
        scope = $rootScope.$new();

        spyOn(topicService, 'getTopics').and.callFake(function() {
            var deferred = $q.defer();
            deferred.resolve(getTopicsResponse);
            return deferred.promise;
        });

        $controller('MainCtrl', {
            $scope: scope,
            topicService: topicService
        });

    }));

    it('should set a list of topics on the scope', function() {
        scope.getTopics();
        scope.$digest();
        expect(scope.topics).toBe(getTopicsResponse);
    });
});
