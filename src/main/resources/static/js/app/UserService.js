'use strict'

angular.module('desafio.services', []).factory('UserService',
		[ "$http", "CONSTANTS", function($http, CONSTANTS) {
			var service = {};
			service.reset = function(userId) {
				var url = CONSTANTS.reset + userId;
				return $http.put(url, null);
			}
			service.checkLetter = function(userId, letter) {
				var url = CONSTANTS.checkLetter + userId + '/' + letter;
				return $http.put(url, null);
			}
			service.getAllUsers = function() {
				return $http.get(CONSTANTS.getAllUsers);
			}
			return service;
		} ]);