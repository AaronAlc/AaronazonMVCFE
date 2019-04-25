'use strict';

angular.module('itemManagementApp').factory('ItemService', ['$http', '$q', function($http, $q){
	
	var REST_SERVICE_URI = 'http://localhost:8081/AaronazonMVCFE/item/';
//	var REST_SERVICE_URI = '<a class="vglnk" href="http://localhost:8080/Aaronazon/item/" rel="nofollow"><span>http</span><span>://</span><span>localhost</span><span>:</span><span>8080</span><span>/</span><span>Aaronazon</span><span>/</span><span>item</span><span>/</span></a>';
	var factory = {
		fetchAllItems: fetchAllItems,
		createItem: createItem,
		updateItem: updateItem,
		deleteItem: deleteItem
	};
	
	return factory;
	
	function fetchAllItems(){
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
		var defer = $q.defer();
		$http.post(REST_SERVICE_URI, item)
			.then(
			function(response){
				defer.resolve(response.data);
			}
		);
		return defer.promise;
	}
	
	function updateItem(item, id) {
		return $http.put(REST_SERVICE_URI+id, item);
	}
	
	function deleteItem(id){
		return $http.delete(REST_SERVICE_URI+id)
	}

}]);