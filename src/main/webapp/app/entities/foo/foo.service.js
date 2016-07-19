(function() {
    'use strict';
    angular
        .module('notransApp')
        .factory('Foo', Foo);

    Foo.$inject = ['$resource'];

    function Foo ($resource) {
        var resourceUrl =  'api/foos/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
