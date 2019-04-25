(function (){
	'use strict';
	
	angular.module('homeApp')
		.factory("HomeService", HomeService);
	
	HomeService.$inject = ['$http'];
	
	function HomeService($http){
		var ITEM_SERVICE_URI = 'http://localhost:8081/AaronazonMVCFE/item/';
		
		var factory = {
				getAllItems: getAllItems
		};
		
		return factory;
		
		function getAllItems(){
			console.log('Service', $http.get(ITEM_SERVICE_URI));
			return $http.get(ITEM_SERVICE_URI);
		}

	}

	
})();