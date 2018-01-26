angular.module('appModule')
.factory('loginService', function($http){
	var service = {}
	
	service.login = function(log){
		return $http({
		      method : 'POST',
		      url : 'api/auth/login',
		      headers : {
		          'Content-Type' : 'application/json'
		        },
		      data : log
		    });
	}
	
	return service;
});