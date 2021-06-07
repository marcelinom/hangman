'use strict'

var module = angular.module('desafio.controllers', []);
module.controller("UserController", [ "$scope", "UserService",
		function($scope, UserService) {

			$scope.userDto = {
				userId : -1,
				userFailures : null,
			    userFinished : null,
			    wordIdxs : []
			};

			$scope.reset = function(letter) {
				UserService.reset($scope.userDto.userId).then(function(value) {
					$scope.userDto = value.data;
				}, function(reason) {
					console.log("error: "+reason);
				});
			}
			
			$scope.reset();
			
			$scope.checkLetter = function(letter) {
				if (!$scope.userDto.userFinished) {
					UserService.checkLetter($scope.userDto.userId, letter).then(function(value) {
						$scope.userDto = value.data;
					}, function(reason) {
						console.log("error: "+reason);
					});
				} else {
					if (confirm("Game Over! Do you want to start over?")) {
						$scope.reset();
					}
				}
			}
						
		} ]);