angular.module('appModule')
.component('login',{
	templateUrl: 'app/appModule/login/login.component.html',
	controller: function(loginService, $window){
		var vm = this;
		
		vm.logValue = 'Log Inn';
		vm.loggedIn = false;
		vm.message = '';
		
		vm.checkLog = function(log){
			if(!vm.loggedIn){
				loginService.login(log)
				.then(function(res){
					vm.loggedIn = true;
					vm.logValue = 'Log off';
					vm.message = 'Hello ' + res.data.firstName;
					$window.localStorage.setItem("jwt",res.headers().authorization);
					$window.localStorage.setItem("user",res.data.id);
				})
				.catch(function(err){
					console.log(err);
					vm.errorMessage = "Your Information is incorrect";
				});
			} else {
				vm.loggedIn = false;
				vm.logValue = 'Log in';
				vm.message = '';
				$window.localStorage.removeItem('jwt');
				$window.localStorage.removeItem('user');
			}
		}
	},
	controllerAs: 'vm'
});