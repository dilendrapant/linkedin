var app = angular.module('ShoppingApp', []);

app.controller('PeopleController', function($http) {
	
	var me = this;
		
	me.mvProducts = [];
	me.mpProducts = [];
	
	me.fetchProducts = function() {
		
		
		$http.get('/linkedin/json/data/mv/peoples')
			.then(function(response) {
				me.mvProducts = response.data;
		});
			
			
		$http.get('/linkedin/json/data/mp/people')
		.then(function(response) {
			me.mpPeoples = response.data;
		});
				
	}
	
});