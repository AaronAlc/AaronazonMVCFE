'use strict';

angular.module('itemManagementApp').factory('ItemService', ['$http', '$q', function($http, $q){
	
	var REST_SERVICE_URI = 'http://localhost:8081/AaronazonMVCFE/item/';
	var factory = {
		fetchAllItems: fetchAllItems,
		createItem: createItem,
		updateItem: updateItem,
		deleteItem: deleteItem
	};
	
	return factory;
	
	function fetchAllItems(){
		console.log('Getting all items');
		var defer = $q.defer();
		$http.get(REST_SERVICE_URI)
			.then(
			function(response){
				defer.resolve(response.data);
			}
		);
		return defer.promise;
	}
	
	function createItem(item) {
		return $http.post(REST_SERVICE_URI, item)
	}
	
	function updateItem(item, id) {
		console.log('Updating item', item, 'with id',id);
		return $http.put(REST_SERVICE_URI+id, item);
	}
	
	function deleteItem(id){
		return $http.delete(REST_SERVICE_URI+id)
	}

}]);