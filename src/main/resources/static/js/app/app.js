'use strict'

var appDesafio = angular.module('desafio', [ 'ui.bootstrap', 'desafio.controllers', 'desafio.services' ]);
appDesafio.constant("CONSTANTS", {
	reset : "/user/reset/",
	checkLetter : "/user/checkLetter/"
});

appDesafio.filter('in', function() {
  return function(letter, text) {
	  return text&&letter?text.toUpperCase().includes(letter.toUpperCase()):false;
  }
});