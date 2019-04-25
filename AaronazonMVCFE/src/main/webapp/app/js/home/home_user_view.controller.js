(function(){
	'use strict';
	
	angular.module('homeApp')
		.controller('HomeController', HomeController);
	
	HomeController.$inject = ['HomeService'];
	
	function HomeController(HomeService){

		var self = this;
		
		self.items = [];
		self.item = {};
		
		function getAllItems(){
			HomeService.getAllItems()
				.then(
					function(d){
					self.items = d.data;
					console.log("Getting items", d.data);
					},
					function(){
						console.error('Error getting items');
					}
				);
		}

		getAllItems();

	}
	
	
})();